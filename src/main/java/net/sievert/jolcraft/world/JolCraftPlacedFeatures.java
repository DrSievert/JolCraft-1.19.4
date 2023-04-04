package net.sievert.jolcraft.world;

        import net.minecraft.core.Holder;
        import net.minecraft.core.HolderGetter;
        import net.minecraft.core.registries.Registries;
        import net.minecraft.data.worldgen.BootstapContext;
        import net.minecraft.data.worldgen.placement.PlacementUtils;
        import net.minecraft.data.worldgen.placement.VegetationPlacements;
        import net.minecraft.resources.ResourceKey;
        import net.minecraft.resources.ResourceLocation;
        import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
        import net.minecraft.world.level.levelgen.placement.PlacedFeature;
        import net.minecraft.world.level.levelgen.placement.PlacementModifier;
        import net.sievert.jolcraft.JolCraft;
        import net.sievert.jolcraft.block.JolCraftBlocks;

        import java.util.List;

public class JolCraftPlacedFeatures {
    public static final ResourceKey<PlacedFeature> GEM_PLACED_KEY = createKey("gem_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, GEM_PLACED_KEY, configuredFeatures.getOrThrow(JolCraftConfiguredFeatures.GEM_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), JolCraftBlocks.GEM_SAPLING.get()));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(JolCraft.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}