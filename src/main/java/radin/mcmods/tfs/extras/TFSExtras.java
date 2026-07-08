package radin.mcmods.tfs.extras;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import radin.mcmods.tfs.extras.registry.ModBlocks;
import radin.mcmods.tfs.extras.registry.ModItems;

public class TFSExtras implements ModInitializer {

    public static final String MOD_ID = "tfsextras";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final CreativeModeTab TFS_TAB = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.literal("TFS Extras"))
            .icon(() -> new ItemStack(ModBlocks.getMobRepeller()))
            .displayItems((displayParameters, output) -> {
                // Mob Pusher Fan
                output.accept(ModBlocks.getMobRepeller());

                // Mythril Ingot
                output.accept(ModItems.MYTHRIL_INGOT);

                // Mythril Tools
                output.accept(ModItems.MYTHRIL_SWORD);
                output.accept(ModItems.MYTHRIL_PICKAXE);
                output.accept(ModItems.MYTHRIL_AXE);

                // Mythril Armor
                output.accept(ModItems.MYTHRIL_HELMET);
                output.accept(ModItems.MYTHRIL_CHESTPLATE);
                output.accept(ModItems.MYTHRIL_LEGGINGS);
                output.accept(ModItems.MYTHRIL_BOOTS);
            })
            .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing TFS Extras...");

        ModBlocks.initialize();
        ModItems.initialize();

        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                Identifier.fromNamespaceAndPath(MOD_ID, "tfs_tab"),
                TFS_TAB
        );

        LOGGER.info("TFS Extras initialized successfully.");
    }
}