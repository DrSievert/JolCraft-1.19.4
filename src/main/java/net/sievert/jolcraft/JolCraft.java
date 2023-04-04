package net.sievert.jolcraft;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.sievert.jolcraft.entity.client.dwarf.artisan.DwarfArtisanRenderer;
import net.sievert.jolcraft.entity.client.dwarf.blacksmith.DwarfBlacksmithRenderer;
import net.sievert.jolcraft.entity.client.dwarf.enchanter.DwarfEnchanterRenderer;
import net.sievert.jolcraft.entity.client.dwarf.DwarfRenderer;
import net.sievert.jolcraft.entity.client.dwarf.miner.DwarfMinerRenderer;
import net.sievert.jolcraft.entity.client.dwarf.smelter.DwarfSmelterRenderer;
import net.sievert.jolcraft.entity.client.dwarf.warrior.DwarfWarriorRenderer;
import net.sievert.jolcraft.sound.JolCraftSounds;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sievert.jolcraft.block.JolCraftBlocks;
import net.sievert.jolcraft.entity.blockentites.JolCraftBlockEntities;
import net.sievert.jolcraft.entity.JolCraftEntities;
import net.minecraft.world.item.CreativeModeTabs;
import net.sievert.jolcraft.entity.client.spirit.SpiritFoxRenderer;
import net.sievert.jolcraft.entity.client.dwarf.alchemist.DwarfAlchemistRenderer;
import net.sievert.jolcraft.item.JolCraftCreativeModeTabs;
import net.sievert.jolcraft.item.JolCraftItems;
import net.sievert.jolcraft.screen.CoinPressScreen;
import net.sievert.jolcraft.screen.JolCraftMenuTypes;
import net.sievert.jolcraft.structures.JolCraftStructures;
import net.sievert.jolcraft.villager.JolCraftVillagers;
import net.sievert.jolcraft.world.processors.JolCraftProcessors;
import software.bernie.geckolib.GeckoLib;

@Mod(JolCraft.MOD_ID)
public class JolCraft

{
    public static final String MOD_ID = "jolcraft";

    public JolCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GeckoLib.initialize();

        JolCraftItems.register(modEventBus);

        JolCraftBlocks.register(modEventBus);

        JolCraftBlockEntities.register(modEventBus);

        JolCraftEntities.register(modEventBus);

        JolCraftVillagers.register(modEventBus);

        JolCraftMenuTypes.register(modEventBus);

        JolCraftSounds.register(modEventBus);

        JolCraftStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);

        JolCraftProcessors.STRUCTURE_PROCESSORS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(JolCraftCreativeModeTabs::onCreativeModeTabRegister);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    //Creative Tabs

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == JolCraftCreativeModeTabs.JOLCRAFT) {
            event.accept(JolCraftItems.COIN);
            event.accept(JolCraftItems.COIN_MOULD);
            event.accept(JolCraftBlocks.COIN_BLOCK);
            event.accept(JolCraftBlocks.COIN_PRESS);

            event.accept(JolCraftBlocks.ALCHEMIST_WORKBENCH);

            event.accept(JolCraftBlocks.DWARVEN_METAL_DEEPSLATE_ORE);
            event.accept(JolCraftItems.UNREFINED_DWARVEN_METAL);

            event.accept(JolCraftBlocks.GEM_LOG);
            event.accept(JolCraftBlocks.GEM_WOOD);
            event.accept(JolCraftBlocks.GEM_LOG_CROSS);
            event.accept(JolCraftBlocks.GEM_LOG_BRANCH);
            event.accept(JolCraftBlocks.STRIPPED_GEM_LOG);
            event.accept(JolCraftBlocks.STRIPPED_GEM_WOOD);
            event.accept(JolCraftBlocks.GEM_PLANKS);
            event.accept(JolCraftBlocks.GEM_SAPLING);
            event.accept(JolCraftBlocks.DWARVEN_GEM_BLOCK);
            event.accept(JolCraftBlocks.DWARVEN_GEM_CLUSTER);
            event.accept(JolCraftItems.DWARVEN_GEM_SHARD);

        }
        if(event.getTab() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(JolCraftItems.SPIRIT_FOX_SPAWN_EGG);
            event.accept(JolCraftItems.DWARF_SPAWN_EGG);
        }

    }

    //Entities

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(JolCraftMenuTypes.COIN_PRESS_MENU.get(), CoinPressScreen::new);
            EntityRenderers.register(JolCraftEntities.SPIRIT_FOX.get(), SpiritFoxRenderer::new);
            EntityRenderers.register(JolCraftEntities.DWARF.get(), DwarfRenderer::new);
            EntityRenderers.register(JolCraftEntities.DWARF_ALCHEMIST.get(), DwarfAlchemistRenderer::new);
            EntityRenderers.register(JolCraftEntities.DWARF_ARTISAN.get(), DwarfArtisanRenderer::new);
            EntityRenderers.register(JolCraftEntities.DWARF_BLACKSMITH.get(), DwarfBlacksmithRenderer::new);
            EntityRenderers.register(JolCraftEntities.DWARF_ENCHANTER.get(), DwarfEnchanterRenderer::new);
            EntityRenderers.register(JolCraftEntities.DWARF_SMELTER.get(), DwarfSmelterRenderer::new);
            EntityRenderers.register(JolCraftEntities.DWARF_WARRIOR.get(), DwarfWarriorRenderer::new);
            EntityRenderers.register(JolCraftEntities.DWARF_MINER.get(), DwarfMinerRenderer::new);
            ItemBlockRenderTypes.setRenderLayer(JolCraftBlocks.DWARVEN_GEM_CLUSTER.get(), RenderType.cutout());


        }
    }

}
