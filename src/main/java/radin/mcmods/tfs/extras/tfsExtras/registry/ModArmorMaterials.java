package radin.mcmods.tfs.extras.tfsExtras.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

import radin.mcmods.tfs.extras.tfsExtras.TfsExtras;

public final class ModArmorMaterials {

    private ModArmorMaterials() {}

    public static final int BASE_DURABILITY = 35;

    public static final TagKey<Item> REPAIRS_MYTHRIL_ARMOR =
            TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TfsExtras.MOD_ID, "repairs_mythril_armor"));

    public static final ResourceKey<EquipmentAsset> MYTHRIL_ARMOR_ASSET =
            ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(TfsExtras.MOD_ID, "mythril"));

    public static final ArmorMaterial MYTHRIL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            15,
            SoundEvents.ARMOR_EQUIP_IRON,
            3.5F,
            0.0F,
            REPAIRS_MYTHRIL_ARMOR,
            MYTHRIL_ARMOR_ASSET
    );
}