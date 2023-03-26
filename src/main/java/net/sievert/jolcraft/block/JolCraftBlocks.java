package net.sievert.jolcraft.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sievert.jolcraft.JolCraft;
import net.sievert.jolcraft.block.custom.AlchemistWorkbenchBlock;
import net.sievert.jolcraft.block.custom.CoinPressBlock;
import net.sievert.jolcraft.item.JolCraftItems;

import java.util.function.Supplier;

public class JolCraftBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, JolCraft.MOD_ID);


    //Blocks
    public static final RegistryObject<Block> COIN_BLOCK = registerBlock("coin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COIN_PRESS = registerBlock("coin_press",
            () -> new CoinPressBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE_TILES).strength(4f).noOcclusion()));
    public static final RegistryObject<Block> ALCHEMIST_WORKBENCH = registerBlock("alchemist_workbench",
            () -> new AlchemistWorkbenchBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f).noOcclusion()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return JolCraftItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
