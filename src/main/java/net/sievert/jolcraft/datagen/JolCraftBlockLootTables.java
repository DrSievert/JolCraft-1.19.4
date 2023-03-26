package net.sievert.jolcraft.datagen;


import net.sievert.jolcraft.block.JolCraftBlocks;
import net.sievert.jolcraft.item.JolCraftItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class JolCraftBlockLootTables extends BlockLootSubProvider {
    public JolCraftBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(JolCraftBlocks.COIN_BLOCK.get());
        dropSelf(JolCraftBlocks.COIN_PRESS.get());
        dropSelf(JolCraftBlocks.ALCHEMIST_WORKBENCH.get());

        //Ore
       /* add(ModBlocks.BLACK_OPAL_ORE.get(),
                (block) -> createOreDrop(ModBlocks.BLACK_OPAL_ORE.get(), ModItems.RAW_BLACK_OPAL.get()));*/

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return JolCraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}