package net.sievert.jolcraft.world.features;

        import net.minecraft.core.registries.Registries;
        import net.minecraft.data.worldgen.BootstapContext;
        import net.minecraft.resources.ResourceKey;
        import net.minecraft.resources.ResourceLocation;

        import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
        import net.minecraft.world.level.levelgen.feature.Feature;
        import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
        import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
        import net.sievert.jolcraft.JolCraft;

public class JolCraftConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GEM_TREE = registerKey("gem_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        context.register(GEM_TREE, new ConfiguredFeature<>(JolCraftFeatures.GEM_TREE.get(), NoneFeatureConfiguration.NONE));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(JolCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}