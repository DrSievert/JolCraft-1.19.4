package net.sievert.jolcraft.datagen;

import net.sievert.jolcraft.JolCraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class JolCraftBlockStateProvider extends BlockStateProvider {
    public JolCraftBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JolCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(JolCraftBlocks.COIN_PRESS);
    }

}
