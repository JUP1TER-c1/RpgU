package me.udnek.rpgu.item.equipment.flint;

import me.udnek.itemscoreu.customitem.ConstructableCustomItem;
import me.udnek.rpgu.item.Items;
import me.udnek.rpgu.item.RpgUCustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class FlintHoe extends ConstructableCustomItem implements RpgUCustomItem {
    @Override
    public @Nullable Integer getCustomModelData() {return 1000;}
    @Override
    public @NotNull String getRawId() {return "flint_hoe";}
    @Override
    public @NotNull Material getMaterial() {return Material.STONE_HOE;}
    @Override
    public ItemFlag[] getTooltipHides() {return new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES};}
    @Override
    public boolean getAddDefaultAttributes() {return true;}
    @Override
    protected void generateRecipes(@NotNull Consumer<@NotNull Recipe> consumer) {
        ShapedRecipe recipe = new ShapedRecipe(getNewRecipeKey(), getItem());
        recipe.shape(
                "FF ",
                "KS ",
                " S ");

        RecipeChoice.MaterialChoice flint = new RecipeChoice.MaterialChoice(Material.FLINT);
        RecipeChoice.MaterialChoice stick = new RecipeChoice.MaterialChoice(Material.STICK);
        RecipeChoice.ExactChoice fabric = new RecipeChoice.ExactChoice(Items.FABRIC.getItem());
        recipe.setIngredient('K', fabric);
        recipe.setIngredient('F', flint);
        recipe.setIngredient('S', stick);

        consumer.accept(recipe);
    }
}
