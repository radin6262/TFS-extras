package radin.mcmods.tfs.extras.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import radin.mcmods.tfs.extras.TFSExtras;

public final class ModItems {

    private ModItems() {}

    // Mythril Ingot
    public static final ResourceKey<Item> MYTHRIL_INGOT_KEY =
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "mythril_ingot"));

    public static final Item MYTHRIL_INGOT = register(
            MYTHRIL_INGOT_KEY,
            new Item(new Item.Properties().setId(MYTHRIL_INGOT_KEY))
    );

    // Armor Keys
    public static final ResourceKey<Item> MYTHRIL_HELMET_KEY =
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "mythril_helmet"));
    public static final ResourceKey<Item> MYTHRIL_CHESTPLATE_KEY =
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "mythril_chestplate"));
    public static final ResourceKey<Item> MYTHRIL_LEGGINGS_KEY =
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "mythril_leggings"));
    public static final ResourceKey<Item> MYTHRIL_BOOTS_KEY =
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "mythril_boots"));

    // Armor Items
    public static final Item MYTHRIL_HELMET = register(
            MYTHRIL_HELMET_KEY,
            new Item(new Item.Properties()
                    .setId(MYTHRIL_HELMET_KEY)
                    .humanoidArmor(ModArmorMaterials.MYTHRIL, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(ModArmorMaterials.BASE_DURABILITY)))
    );

    public static final Item MYTHRIL_CHESTPLATE = register(
            MYTHRIL_CHESTPLATE_KEY,
            new Item(new Item.Properties()
                    .setId(MYTHRIL_CHESTPLATE_KEY)
                    .humanoidArmor(ModArmorMaterials.MYTHRIL, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(ModArmorMaterials.BASE_DURABILITY)))
    );

    public static final Item MYTHRIL_LEGGINGS = register(
            MYTHRIL_LEGGINGS_KEY,
            new Item(new Item.Properties()
                    .setId(MYTHRIL_LEGGINGS_KEY)
                    .humanoidArmor(ModArmorMaterials.MYTHRIL, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(ModArmorMaterials.BASE_DURABILITY)))
    );

    public static final Item MYTHRIL_BOOTS = register(
            MYTHRIL_BOOTS_KEY,
            new Item(new Item.Properties()
                    .setId(MYTHRIL_BOOTS_KEY)
                    .humanoidArmor(ModArmorMaterials.MYTHRIL, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(ModArmorMaterials.BASE_DURABILITY)))
    );

    // Tool Keys
    public static final ResourceKey<Item> MYTHRIL_SWORD_KEY =
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "mythril_sword"));
    public static final ResourceKey<Item> MYTHRIL_PICKAXE_KEY =
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "mythril_pickaxe"));
    public static final ResourceKey<Item> MYTHRIL_AXE_KEY =
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TFSExtras.MOD_ID, "mythril_axe"));

    // Tool Items
    public static final Item MYTHRIL_SWORD = register(
            MYTHRIL_SWORD_KEY,
            new Item(new Item.Properties()
                    .setId(MYTHRIL_SWORD_KEY)
                    .sword(ModToolMaterials.MYTHRIL, 3.0F, -2.4F))
    );

    public static final Item MYTHRIL_PICKAXE = register(
            MYTHRIL_PICKAXE_KEY,
            new Item(new Item.Properties()
                    .setId(MYTHRIL_PICKAXE_KEY)
                    .pickaxe(ModToolMaterials.MYTHRIL, 1.0F, -2.8F))
    );

    public static final Item MYTHRIL_AXE = register(
            MYTHRIL_AXE_KEY,
            new Item(new Item.Properties()
                    .setId(MYTHRIL_AXE_KEY)
                    .axe(ModToolMaterials.MYTHRIL, 5.0F, -3.0F))
    );

    private static Item register(ResourceKey<Item> key, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                key,
                item
        );
    }

    public static void initialize() {
        TFSExtras.LOGGER.info("Registering Items...");
    }
}