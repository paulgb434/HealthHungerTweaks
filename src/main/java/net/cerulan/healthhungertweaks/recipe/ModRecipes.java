package net.cerulan.healthhungertweaks.recipe;

import net.cerulan.healthhungertweaks.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {

	public static void init() {
		//GameRegistry.addShapedRecipe(output, params)
		class BasicOintmentRecipe extends ShapelessRetainingRecipe {

			public BasicOintmentRecipe(ItemStack output, ItemStack... inputList) {
				super(output, inputList);
			}

			@Override
			public ItemStack[] getRemainingItems(InventoryCrafting inv) {
				ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];

				for (int i = 0; i < aitemstack.length; ++i) {
					ItemStack itemstack = inv.getStackInSlot(i);
					if (itemstack != null && itemstack.isItemEqual(new ItemStack(Items.BOWL))) {
						aitemstack[i] = new ItemStack(Items.BOWL, 1);
					}
					else {
						aitemstack[i] = null;
					}
				}
				return aitemstack;
			}
			
		}
		
		class RefinedOintmentRecipe extends ShapelessRetainingRecipe {

			public RefinedOintmentRecipe(ItemStack output, ItemStack... inputList) {
				super(output, inputList);
			}

			@Override
			public ItemStack[] getRemainingItems(InventoryCrafting inv) {
				ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];

				for (int i = 0; i < aitemstack.length; ++i) {
					ItemStack itemstack = inv.getStackInSlot(i);
					if (itemstack != null && itemstack.isItemEqual(new ItemStack(Items.WATER_BUCKET))) {
						aitemstack[i] = new ItemStack(Items.BUCKET, 1);
					}
					else {
						aitemstack[i] = null;
					}
				}
				return aitemstack;
			}
			
		}
		
		RecipeSorter.register("BasicOintmentRecipe", BasicOintmentRecipe.class, Category.SHAPELESS, "");
		RecipeSorter.register("RefinedOintmentRecipe", RefinedOintmentRecipe.class, Category.SHAPELESS, "");
		
		GameRegistry.addRecipe(new BasicOintmentRecipe(new ItemStack(ModItems.itemOintment, 2, 0), new ItemStack(Items.WHEAT_SEEDS, 1), new ItemStack(Items.WHEAT_SEEDS, 1), new ItemStack(Items.WHEAT_SEEDS, 1), new ItemStack(Items.BOWL, 1)));
		GameRegistry.addRecipe(new BasicOintmentRecipe(new ItemStack(ModItems.itemOintment, 3, 0), new ItemStack(Blocks.CACTUS, 1), new ItemStack(Items.BOWL, 1)));
		GameRegistry.addRecipe(new BasicOintmentRecipe(new ItemStack(ModItems.itemOintment, 3, 0), new ItemStack(Blocks.RED_FLOWER, 1), new ItemStack(Items.BOWL, 1)));
		GameRegistry.addRecipe(new BasicOintmentRecipe(new ItemStack(ModItems.itemOintment, 3, 0), new ItemStack(Blocks.YELLOW_FLOWER, 1), new ItemStack(Items.BOWL, 1)));
		GameRegistry.addRecipe(new RefinedOintmentRecipe(new ItemStack(ModItems.itemOintment, 4, 1), new ItemStack(Items.DYE, 1, 2), new ItemStack(Items.WATER_BUCKET, 1)));
		
		// TODO find more oredict tags
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemMedicalTools, 1), Items.SHEARS, "ingotIron", "ingotIron"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBandage, 3, 0), "stickWood", "stickWood", "stickWood"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBandage, 3, 1), Blocks.WOOL, Items.PAPER));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemHealthKit, 3, 0), Blocks.DIRT, Blocks.DIRT, Blocks.DIRT, new ItemStack(ModItems.itemBandage, 1, 0)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemHealthKit, 3, 1), " L ", "wpw", " L ", 'L', "logWood", 'w', new ItemStack(ModItems.itemBandage, 1, 0), 'p', new ItemStack(ModItems.itemOintment, 1, 0) ));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemHealthKit, 3, 2), " M ", "bpb", " I ", 'M', ModItems.itemMedicalTools, 'I', "ingotIron", 'b', new ItemStack(ModItems.itemBandage, 1, 1), 'p', new ItemStack(ModItems.itemOintment, 1, 1) ));
	}
	
}
