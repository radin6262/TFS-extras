package radin.mcmods.tfs.extras.tfsExtras.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import radin.mcmods.tfs.extras.tfsExtras.TfsExtras;
import radin.mcmods.tfs.extras.tfsExtras.block.MobRepellerBlock;
import radin.mcmods.tfs.extras.tfsExtras.item.MobPusherFanItem;

public final class ModBlocks {

    public static Block MOB_REPELLER;  // Made public

    private ModBlocks() {}

    public static Block getMobRepeller() {
        if (MOB_REPELLER == null) {
            MOB_REPELLER = register(
                    "mob_pusher_fan",
                    new MobRepellerBlock(createBlockKey(TfsExtras.MOD_ID, "mob_pusher_fan"))
            );
        }
        return MOB_REPELLER;
    }

    private static ResourceKey<Block> createBlockKey(String modId, String id) {
        return ResourceKey.create(
                BuiltInRegistries.BLOCK.key(),
                Identifier.fromNamespaceAndPath(modId, id)
        );
    }

    private static Block register(String id, Block block) {
        Identifier location = Identifier.fromNamespaceAndPath(TfsExtras.MOD_ID, id);

        // Register the block
        Registry.register(
                BuiltInRegistries.BLOCK,
                location,
                block
        );

        // Register the BlockItem using the same ID
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(
                ResourceKey.create(BuiltInRegistries.ITEM.key(), location)
        ));
        Registry.register(
                BuiltInRegistries.ITEM,
                location,
                blockItem
        );

        return block;
    }

    public static void initialize() {
        getMobRepeller();
        TfsExtras.LOGGER.info("Registering Blocks...");
    }
}