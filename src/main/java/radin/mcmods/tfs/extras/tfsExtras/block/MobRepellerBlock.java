package radin.mcmods.tfs.extras.tfsExtras.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import java.util.List;

public class MobRepellerBlock extends Block {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final int PUSH_RADIUS = 10;
    private static final double PUSH_FORCE = 0.10;
    private static final int TICK_INTERVAL = 1;

    public MobRepellerBlock(ResourceKey<Block> key) {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .strength(2.0F, 6.0F)
                .sound(SoundType.STONE)
                .setId(key)
        );

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(
            net.minecraft.world.level.block.state.StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean moved) {
        if (!level.isClientSide()) {
            level.scheduleTick(pos, this, TICK_INTERVAL);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        pushMobs(level, pos, state);
        level.scheduleTick(pos, this, TICK_INTERVAL);
    }


    private void pushMobs(Level level, BlockPos pos, BlockState state) {
        Direction facing = state.getValue(FACING);
        Vec3 center = Vec3.atCenterOf(pos);

        AABB bounds = new AABB(pos).inflate(PUSH_RADIUS);
        List<Entity> entities = level.getEntitiesOfClass(Entity.class, bounds);

        Vec3 pushDirection = new Vec3(facing.getStepX(), facing.getStepY(), facing.getStepZ());

        for (Entity entity : entities) {
            if (entity instanceof Player player) {
                if (player.isCreative() || player.isSpectator()) {
                    continue;
                }
            }

            Vec3 direction = entity.position().subtract(center);
            double distance = direction.length();

            if (distance > PUSH_RADIUS) {
                continue;
            }

            Vec3 entityDirection = entity.position().subtract(center).normalize();
            double dotProduct = entityDirection.dot(pushDirection);

            if (dotProduct < -0.5) {
                continue;
            }

            double strength = PUSH_FORCE * (1 - (distance / PUSH_RADIUS));
            strength = Math.max(0.01, strength);
            strength *= Math.max(0, dotProduct);

            Vec3 pushVector = pushDirection.scale(strength);

            entity.setDeltaMovement(entity.getDeltaMovement().add(pushVector));
            entity.hurtMarked = true;
            entity.setDeltaMovement(entity.getDeltaMovement().add(0, 0.02, 0));
        }
    }
}