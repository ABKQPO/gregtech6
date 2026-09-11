/**
 * Copyright (c) 2023 GregTech-6 Team
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package gregapi.recipes;

import static gregapi.data.CS.*;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;

import gregapi.code.ArrayListNoNulls;
import gregapi.code.TagData;
import gregapi.item.IItemEnergy;
import gregapi.item.IItemGTContainerTool;
import gregapi.item.multiitem.MultiItemTool;
import gregapi.util.ST;
import gregapi.util.UT;

/**
 * @author Gregorius Techneticies
 */
public class AdvancedCraftingShaped extends ShapedOreRecipe implements ICraftingRecipeGT {

    public final boolean mDismantleable, mRemovableByGT, mAutoCraftable, mKeepingNBT;
    private final Enchantment[] mEnchantmentsAdded;
    private final int[] mEnchantmentLevelsAdded;
    /**
     * The 3x3 Grids this Recipe can occupy, as BitSets, mirroring and all Offsets included. Null when the Recipe has
     * no Shape to compare against, an empty Array when it can never fit.
     */
    private final int[] mShapeMasks;
    /** How many Slots this Recipe fills, which is the cheapest way to reject a Grid that cannot match. */
    private final int mShapeSize;

    public AdvancedCraftingShaped(ItemStack aResult, boolean aDismantleAble, boolean aRemovableByGT,
        boolean aKeepingNBT, boolean aAutoCraftable, Enchantment[] aEnchantmentsAdded, int[] aEnchantmentLevelsAdded,
        Object... aRecipe) {
        super(aResult, aRecipe);
        mEnchantmentsAdded = aEnchantmentsAdded;
        mEnchantmentLevelsAdded = aEnchantmentLevelsAdded;
        mRemovableByGT = aRemovableByGT;
        mKeepingNBT = aKeepingNBT;
        mDismantleable = aDismantleAble;
        mAutoCraftable = aAutoCraftable;
        mShapeMasks = shapeMasks(shape(aRecipe));
        mShapeSize = mShapeMasks == null || mShapeMasks.length == 0 ? -1 : Integer.bitCount(mShapeMasks[0]);
    }

    @Override
    public boolean matches(InventoryCrafting aGrid, World aWorld) {
        if (!canFit(aGrid)) return F;
        if (mKeepingNBT) {
            ItemStack tStack = null;
            for (int i = 0; i < aGrid.getSizeInventory(); i++) {
                if (aGrid.getStackInSlot(i) != null && aGrid.getStackInSlot(i)
                    .hasTagCompound()) {
                    if (tStack != null) {
                        if ((tStack.hasTagCompound() != aGrid.getStackInSlot(i)
                            .hasTagCompound()) || (tStack.hasTagCompound()
                                && !tStack.getTagCompound()
                                    .equals(
                                        aGrid.getStackInSlot(i)
                                            .getTagCompound())))
                            return F;
                    }
                    tStack = aGrid.getStackInSlot(i);
                }
            }
        }
        return super.matches(aGrid, aWorld);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting aGrid) {
        ItemStack rStack = super.getCraftingResult(aGrid);
        if (rStack != null) {
            // Update the Stack
            ST.update(rStack);

            // Keeping NBT
            if (mKeepingNBT) for (int i = 0; i < aGrid.getSizeInventory(); i++) {
                if (aGrid.getStackInSlot(i) != null && aGrid.getStackInSlot(i)
                    .hasTagCompound()) {
                    UT.NBT.set(
                        rStack,
                        (NBTTagCompound) aGrid.getStackInSlot(i)
                            .getTagCompound()
                            .copy());
                    break;
                }
            }

            // GT Charge Values
            if (rStack.getItem() instanceof IItemEnergy) {
                for (TagData tEnergyType : ((IItemEnergy) rStack.getItem()).getEnergyTypes(rStack)) {
                    long tCharge = 0;
                    for (int i = 0; i < aGrid.getSizeInventory(); i++) if (aGrid.getStackInSlot(i) != null
                        && aGrid.getStackInSlot(i)
                            .getItem() instanceof IItemEnergy
                        && !(aGrid.getStackInSlot(i)
                            .getItem() instanceof IItemGTContainerTool)) {
                                tCharge += ((IItemEnergy) aGrid.getStackInSlot(i)
                                    .getItem()).getEnergyStored(tEnergyType, aGrid.getStackInSlot(i));
                            }
                    ((IItemEnergy) rStack.getItem()).setEnergyStored(tEnergyType, rStack, tCharge);
                }
            }

            // Saving Ingredients inside the Item.
            if (mDismantleable) {
                NBTTagCompound rNBT = rStack.getTagCompound(), tNBT = UT.NBT.make();
                if (rNBT == null) rNBT = UT.NBT.make();
                for (int i = 0; i < 9; i++) {
                    ItemStack tStack = aGrid.getStackInSlot(i);
                    if (tStack != null && ST.container(tStack, T) == null
                        && !(tStack.getItem() instanceof MultiItemTool)) {
                        tStack = ST.amount(1, tStack);
                        tNBT.setTag("" + i, ST.save(tStack));
                    }
                }
                rNBT.setTag(NBT_RECYCLING_COMPS, tNBT);
                UT.NBT.set(rStack, rNBT);
            }

            // Add Enchantments
            for (int i = 0; i < mEnchantmentsAdded.length; i++) UT.NBT.addEnchantment(
                rStack,
                mEnchantmentsAdded[i],
                UT.NBT.getEnchantmentLevel(mEnchantmentsAdded[i], rStack) + mEnchantmentLevelsAdded[i]);

            // Update the Stack again
            ST.update(rStack);
        }
        return rStack;
    }

    @Override
    public boolean isRemovableByGT() {
        return mRemovableByGT;
    }

    @Override
    public boolean isAutocraftableByGT() {
        return mAutoCraftable;
    }

    /**
     * Rejects a Grid that cannot possibly match this Recipe before the inherited matching walks the OreDictionary
     * Lists of every Ingredient.
     * <p>
     * This matters a lot more than it looks: anything that scans the Crafting Recipe List, most notably the Ore
     * Processing of GregTech 5, calls this for every Recipe in it, and a Grid that is probed with one single Item
     * would otherwise make every Recipe with an OreDictionary Ingredient iterate that whole List for every Slot.
     */
    private boolean canFit(InventoryCrafting aGrid) {
        if (mShapeMasks == null) return T;
        if (mShapeMasks.length == 0) return F;
        if (aGrid.getSizeInventory() != 9) return T;
        int tGrid = 0, tGridSize = 0;
        for (int i = 0; i < 9; i++) if (aGrid.getStackInSlot(i) != null) {
            tGrid |= 1 << i;
            tGridSize++;
        }
        // The Number of filled Slots alone throws out almost every Recipe, which is what makes a scan over the whole
        // Crafting Recipe List affordable.
        if (tGridSize != mShapeSize) return F;
        for (int tMask : mShapeMasks) if (tMask == tGrid) return T;
        return F;
    }

    /** The Shape Rows of this Recipe, parsed the same way the inherited Constructor parses them. */
    private static String[] shape(Object[] aRecipe) {
        int tIndex = 0;
        if (aRecipe.length > 0 && aRecipe[0] instanceof Boolean) {
            if (aRecipe.length > 1 && aRecipe[1] instanceof Object[]) {
                aRecipe = (Object[]) aRecipe[1];
            } else {
                tIndex = 1;
            }
        }
        ArrayListNoNulls<String> rRows = new ArrayListNoNulls<>();
        if (tIndex < aRecipe.length && aRecipe[tIndex] instanceof String[]) {
            for (String tRow : (String[]) aRecipe[tIndex]) rRows.add(tRow);
        } else {
            for (; tIndex < aRecipe.length && aRecipe[tIndex] instanceof String; tIndex++)
                rRows.add((String) aRecipe[tIndex]);
        }
        return rRows.toArray(ZL_STRING);
    }

    /** Every 3x3 Grid this Shape matches, or null if there is no Shape to compare against. */
    private static int[] shapeMasks(String[] aRows) {
        int tHeight = aRows.length, tWidth = 0;
        for (String tRow : aRows) tWidth = Math.max(tWidth, tRow.length());
        if (tWidth <= 0 || tHeight <= 0) return null;
        if (tWidth > 3 || tHeight > 3) return new int[0];
        ArrayListNoNulls<Integer> rMasks = new ArrayListNoNulls<>();
        for (int tOffsetY = 0; tOffsetY <= 3 - tHeight; tOffsetY++)
            for (int tOffsetX = 0; tOffsetX <= 3 - tWidth; tOffsetX++) {
                int tNormal = 0, tMirrored = 0;
                for (int tY = 0; tY < tHeight; tY++) for (int tX = 0; tX < tWidth; tX++) {
                    if (tX >= aRows[tY].length() || aRows[tY].charAt(tX) == ' ') continue;
                    tNormal |= 1 << (tOffsetX + tX + (tOffsetY + tY) * 3);
                    tMirrored |= 1 << (tOffsetX + tWidth - tX - 1 + (tOffsetY + tY) * 3);
                }
                rMasks.add(tNormal);
                rMasks.add(tMirrored);
            }
        int[] rArray = new int[rMasks.size()];
        for (int i = 0; i < rArray.length; i++) rArray[i] = rMasks.get(i);
        return rArray;
    }
}
