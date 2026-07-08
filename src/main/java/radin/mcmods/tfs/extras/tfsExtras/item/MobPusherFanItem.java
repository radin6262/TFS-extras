package radin.mcmods.tfs.extras.tfsExtras.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class MobPusherFanItem extends Item {

    public MobPusherFanItem(ResourceKey<Item> key) {
        super(new Item.Properties()
                .stacksTo(64)
                .fireResistant()
                .setId(key)  // This sets the item's ID!
        );
    }
}