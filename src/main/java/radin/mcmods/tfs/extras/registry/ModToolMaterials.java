package radin.mcmods.tfs.extras.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

import radin.mcmods.tfs.extras.TFSExtras;

public final class ModToolMaterials {

    private ModToolMaterials() {}

    public static final TagKey<Block> INCORRECT_FOR_MYTHRIL_TOOL = TagKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "incorrect_for_mythril_tool")
    );

    public static final ToolMaterial MYTHRIL = new ToolMaterial(
            INCORRECT_FOR_MYTHRIL_TOOL,  // blocks that won't drop
            1500,                         // durability (diamond=1561, netherite=2031)
            8.5F,                         // mining speed (diamond=8.0, netherite=9.0)
            3.5F,                         // attack damage bonus (diamond=3.0, netherite=4.0)
            15,                           // enchantability (diamond=10, netherite=15)
            ModArmorMaterials.REPAIRS_MYTHRIL_ARMOR  // repair items
    );
}