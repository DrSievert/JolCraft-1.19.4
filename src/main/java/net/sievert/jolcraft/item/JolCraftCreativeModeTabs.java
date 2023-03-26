package net.sievert.jolcraft.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.common.Mod;
import net.sievert.jolcraft.JolCraft;


@Mod.EventBusSubscriber(modid = JolCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JolCraftCreativeModeTabs {
    public static CreativeModeTab JOLCRAFT;
    public static void onCreativeModeTabRegister(CreativeModeTabEvent.Register event)
    {
        JOLCRAFT = event.registerCreativeModeTab(new ResourceLocation(JolCraft.MOD_ID, "jolcraft_tab"), builder -> builder.icon(() -> new ItemStack(JolCraftItems.COIN.get()))
                .title(Component.literal("JolCraft"))
                .withLabelColor(0x00FF00)
                );


    }


}