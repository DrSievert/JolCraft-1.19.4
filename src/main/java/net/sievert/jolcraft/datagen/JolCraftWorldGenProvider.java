package net.sievert.jolcraft.datagen;

        import net.minecraft.core.HolderLookup;
        import net.minecraft.core.RegistrySetBuilder;
        import net.minecraft.core.registries.Registries;
        import net.minecraft.data.PackOutput;
        import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
        import net.sievert.jolcraft.JolCraft;
        import net.sievert.jolcraft.world.JolCraftConfiguredFeatures;
        import net.sievert.jolcraft.world.JolCraftPlacedFeatures;
        import java.util.Set;
        import java.util.concurrent.CompletableFuture;

public class JolCraftWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, JolCraftConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, JolCraftPlacedFeatures::bootstrap);

    public JolCraftWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(JolCraft.MOD_ID));
    }
}