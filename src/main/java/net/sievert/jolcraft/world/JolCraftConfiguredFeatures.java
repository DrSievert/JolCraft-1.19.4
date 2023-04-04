package net.sievert.jolcraft.world;

        import net.minecraft.core.registries.Registries;
        import net.minecraft.data.worldgen.BootstapContext;
        import net.minecraft.resources.ResourceKey;
        import net.minecraft.resources.ResourceLocation;
        import net.minecraft.util.valueproviders.ConstantInt;
        import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
        import net.minecraft.world.level.levelgen.feature.Feature;
        import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
        import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
        import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
        import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
        import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
        import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
        import net.sievert.jolcraft.JolCraft;
        import net.sievert.jolcraft.block.JolCraftBlocks;

public class JolCraftConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GEM_KEY = registerKey("gem");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, GEM_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(JolCraftBlocks.GEM_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(JolCraftBlocks.GEM_LOG_CROSS.get()),
                new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 1),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(JolCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}