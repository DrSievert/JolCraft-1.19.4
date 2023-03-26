package net.sievert.jolcraft.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sievert.jolcraft.entity.JolCraftEntities;
import net.sievert.jolcraft.JolCraft;

public class JolCraftItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JolCraft.MOD_ID);

    //Simple Items
    public static final RegistryObject<Item> COIN = ITEMS.register("coin",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> COIN_MOULD = ITEMS.register("coin_mould",
            () -> new Item(new Item.Properties().stacksTo(1)));

    //Spawn Eggs
    public static final RegistryObject<Item> SPIRIT_FOX_SPAWN_EGG = ITEMS.register("spirit_fox_spawn_egg",
            () -> new ForgeSpawnEggItem(JolCraftEntities.SPIRIT_FOX, 0xd1f0ff, 0xd7ffec,
                    new Item.Properties()));
    public static final RegistryObject<Item> DWARF_SPAWN_EGG = ITEMS.register("dwarf_spawn_egg",
            () -> new ForgeSpawnEggItem(JolCraftEntities.DWARF, 0x461c00, 0x9b735e,
                    new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
