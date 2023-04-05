package net.sievert.jolcraft.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.sievert.jolcraft.block.JolCraftBlocks;
public class GemTree extends Feature<NoneFeatureConfiguration> {
    public GemTree(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos blockPos = new BlockPos(context.origin());
        WorldGenLevel level = context.level();
        if(level.getBlockState(blockPos).is(Blocks.CAVE_AIR) && level.getBlockState(blockPos.below()).is(Blocks.STONE)){

            context.level().setBlock(blockPos, JolCraftBlocks.GEM_LOG.get().defaultBlockState(), 3);
            return true;
        }

        return false;
    }


}
