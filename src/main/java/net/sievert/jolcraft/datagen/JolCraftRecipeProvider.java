package net.sievert.jolcraft.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.sievert.jolcraft.JolCraft;
import net.sievert.jolcraft.block.JolCraftBlocks;
import net.sievert.jolcraft.item.JolCraftItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class JolCraftRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public JolCraftRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, JolCraftItems.COIN.get(), RecipeCategory.BUILDING_BLOCKS, JolCraftBlocks.COIN_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JolCraftBlocks.COIN_PRESS.get())
                .define('X', JolCraftItems.COIN_MOULD.get())
                .define('Y', Blocks.DEEPSLATE_TILES)
                .define('Z', Blocks.DEEPSLATE_TILE_WALL)
                .pattern("YYY")
                .pattern("ZXZ")
                .pattern("ZYZ")
                .unlockedBy("has_coin_mould", inventoryTrigger(ItemPredicate.Builder.item()
                         .of(JolCraftItems.COIN_MOULD.get()).build()))
                .save(consumer);

        // ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get())
        //         .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
        //         .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
        //                 .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
        //         .save(consumer);

    }

}