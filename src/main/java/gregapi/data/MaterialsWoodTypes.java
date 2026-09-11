/**
 * Copyright (c) 2025 GregTech-6 Team
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

package gregapi.data;

import static gregapi.data.CS.*;
import static gregapi.data.TD.Atomic.*;
import static gregapi.data.TD.Compounds.*;
import static gregapi.data.TD.ItemGenerator.*;
import static gregapi.data.TD.Processing.*;
import static gregapi.data.TD.Properties.*;
import static gregapi.render.TextureSet.*;

import gregapi.data.materials.IMaterialCategory;

/**
 * The Materials of the various Woods.
 * <p>
 * Loaded as the "Wood Types" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsWoodTypes implements IMaterialCategory {

    @Override
    public String getName() {
        return "Wood Types";
    }

    @Override
    public void load() {
        MT.WOODS.Oak = MT.woodnormal(9300, "Oak", "Oak", 180, 144, 90, 3.0, 32, MD.MC);
        MT.WOODS.Birch = MT.woodnormal(9301, "Birch", "Birch", 215, 204, 142, 2.5, 24, MD.MC);
        MT.WOODS.Spruce = MT.woodnormal(9302, "Spruce", "Spruce", 102, 79, 47, 3.0, 24, MD.MC);
        MT.WOODS.Jungle = MT.woodnormal(9303, "Junglewood", "Junglewood", 177, 128, 92, 2.0, 16, MD.MC);
        MT.WOODS.Acacia = MT.woodnormal(9304, "Acacia", "Acacia", 186, 104, 59, 2.5, 24, MD.MC);
        MT.WOODS.DarkOak = MT.woodnormal(9305, "DarkOak", "Dark Oak", 70, 45, 21, 3.5, 32, MD.MC);
        MT.WOODS.Crimson = MT
            .woodnormal(9306, "Crimsonwood", "Crimsonwood", 180, 90, 106, 2.5, 24, MD.NeLi, UNBURNABLE);
        MT.WOODS.Warped = MT.woodnormal(9307, "Warpedwood", "Warped Wood", 42, 141, 133, 3.5, 32, MD.NeLi, UNBURNABLE);
        MT.WOODS.Foxfire = MT.woodnormal(9408, "Foxfirewood", "Foxfire", 51, 51, 101, 4.0, 24, MD.NeLi, UNBURNABLE);
        MT.WOODS.Compressed = MT.woodnormal(9308, "WoodCompressed", "Compressed Wood", 94, 60, 25, 1.5, 8, MD.GT)

            .setPulver(MT.Wood, U);
        MT.WOODS.Dead = MT.woodnormal(9309, "WoodDead", "Dead Wood", 116, 108, 63, 1.5, 8, MD.BoP);
        MT.WOODS.Rotten = MT.woodnormal(9310, "WoodRotten", "Rotten Wood", 22, 44, 15, 1.0, 8, MD.GT);
        MT.WOODS.Mossy = MT.woodnormal(9311, "WoodMossy", "Mossy Wood", 29, 127, 0, 1.5, 8, MD.GT);
        MT.WOODS.Frozen = MT.woodnormal(9312, "WoodFrozen", "Frozen Wood", 84, 125, 125, 1.0, 8, MD.GT);
        MT.WOODS.Scorched = MT.woodnormal(9404, "WoodScorched", "Scorched Wood", 44, 44, 44, 1.0, 8, MD.ERE);
        MT.WOODS.Varnished = MT.woodnormal(9405, "WoodVarnished", "Varnished Wood", 73, 48, 16, 3.0, 32, MD.ERE);
        MT.WOODS.Bleached = MT.woodnormal(9407, "WoodBleached", "Bleached Wood", 255, 255, 255, 2.0, 16, MD.ERE);
        MT.WOODS.Tainted = MT.woodnormal(9406, "WoodTainted", "Tainted Wood", 90, 23, 231, 1.0, 64, MD.TCFM, MAGICAL);
        MT.WOODS.Maple = MT.woodnormal(9313, "Maple", "Maple", 151, 26, 26, 3.0, 24, MD.FR);
        MT.WOODS.Willow = MT.woodnormal(9314, "Willow", "Willow", 37, 150, 0, 2.0, 16, MD.FR);
        MT.WOODS.BlueMahoe = MT.woodnormal(9315, "BlueMahoe", "Blue Mahoe", 15, 103, 254, 3.0, 24, MD.FR);
        MT.WOODS.Hazel = MT.woodnormal(9316, "Hazel", "Hazel", 228, 175, 175, 2.5, 16, MD.BINNIE);
        MT.WOODS.Cinnamon = MT.woodnormal(9317, "Cinnamonwood", "Cinnawood", 65, 192, 192, 1.5, 16, MD.HaC);
        MT.WOODS.Coconut = MT.woodnormal(9318, "Coconutwood", "Coconut", 255, 170, 0, 3.0, 16, MD.TROPIC);
        MT.WOODS.Rainbowood = MT.woodnormal(

            9319,

            "Rainbowood",

            "Rainbowood",

            200,

            64,

            245,

            4.0,

            64,

            MD.GT,

            MAGICAL,

            UNBURNABLE);
        MT.WOODS.BlueSpruce = MT.woodnormal(9409, "BlueSpruce", "Blue Spruce", 213, 213, 217, 3.0, 24, MD.GT);
        MT.WOODS.Towerwood = MT.woodnormal(9320, "Towerwood", "Towerwood", 166, 101, 58, 4.0, 64, MD.TF);
        MT.WOODS.Witchwood = MT.woodnormal(9321, "Witchwood", "Witchwood", 118, 112, 142, 3.5, 48, MD.ARS, MAGICAL);
        MT.WOODS.Ogre = MT.woodnormal(9322, "Ogrewood", "Ogrewood", 180, 90, 106, 4.0, 48, MD.MoCr);
        MT.WOODS.Wyvern = MT.woodnormal(9323, "Wyvernwood", "Wyvernwood", 77, 159, 158, 4.0, 48, MD.MoCr);
        MT.WOODS.Aspen = MT.woodnormal(9324, "Aspen", "Aspen", 68, 65, 50, 2.0, 24, MD.TFC);
        MT.WOODS.DouglasFir = MT.woodnormal(9325, "DouglasFir", "Douglas Fir", 249, 197, 154, 2.5, 24, MD.TFC);
        MT.WOODS.Sycamore = MT.woodnormal(9326, "Sycamore", "Sycamore", 214, 155, 69, 3.0, 16, MD.TFC);
        MT.WOODS.WhiteCedar = MT.woodnormal(9327, "WhiteCedar", "White Cedar", 219, 219, 205, 2.5, 24, MD.TFC);
        MT.WOODS.WhiteElm = MT.woodnormal(9328, "WhiteElm", "White Elm", 162, 167, 103, 2.0, 32, MD.TFC);
        MT.WOODS.Thorntree = MT.woodnormal(9329, "Thorntree", "Thorntree", 180, 144, 90, 3.0, 32, MD.EB);
        MT.WOODS.SilverPine = MT.woodnormal(9330, "SilverPine", "Silver Pine", 32, 7, 70, 3.0, 32, MD.EB);
        MT.WOODS.Alder = MT.woodnormal(9331, "Alder", "Alder", 177, 95, 87, 2.5, 32, MD.WTCH);
        MT.WOODS.Hawthorn = MT.woodnormal(9332, "Hawthorn", "Hawthorn", 188, 182, 178, 3.0, 24, MD.WTCH);
        MT.WOODS.Rowan = MT.woodnormal(9333, "Rowan", "Rowan", 205, 172, 87, 3.5, 24, MD.WTCH);
        MT.WOODS.Mahogany = MT.woodnormal(9356, "Mahogany", "Mahogany", 111, 61, 55, 4.0, 48, MD.TROPIC);
        MT.WOODS.Palm = MT.woodnormal(9358, "Palm", "Palm", 201, 124, 69, 3.0, 16, MD.TROPIC);
        MT.WOODS.Autumn = MT.woodnormal(9334, "Autumnwood", "Autumn Wood", 191, 64, 35, 2.5, 24, MD.EBXL);
        MT.WOODS.Cypress = MT.woodnormal(9336, "Cypress", "Cypress", 185, 187, 181, 2.5, 16, MD.EBXL);
        MT.WOODS.Fir = MT.woodnormal(9337, "Fir", "Fir", 110, 106, 63, 2.0, 32, MD.EBXL);
        MT.WOODS.JapaneseMaple = MT.woodnormal(9338, "JapaneseMaple", "Japanese Maple", 152, 76, 86, 3.0, 24, MD.EBXL);
        MT.WOODS.RainbowEucalyptus = MT.woodnormal(

            9339,

            "RainbowEucalyptus",

            "Rainbow Eucalyptus",

            116,

            141,

            198,

            3.0,

            32,

            MD.EBXL);
        MT.WOODS.Redwood = MT.woodnormal(9340, "Redwood", "Redwood", 163, 115, 70, 3.5, 24, MD.EBXL);
        MT.WOODS.Sakura = MT.woodnormal(9341, "Sakura", "Sakura", 250, 161, 122, 3.0, 32, MD.EBXL);
        MT.WOODS.Balsa = MT.woodnormal(9342, "Balsa", "Balsa", 165, 158, 151, 2.0, 16, MD.FR);
        MT.WOODS.Baobab = MT.woodnormal(9343, "Baobab", "Baobab", 136, 145, 95, 2.0, 16, MD.FR);
        MT.WOODS.Cherry = MT.woodnormal(9344, "Cherrywood", "Cherrywood", 173, 124, 50, 2.5, 24, MD.FR);
        MT.WOODS.Chestnut = MT.woodnormal(9345, "Chestnutwood", "Chestnutwood", 179, 162, 85, 3.0, 32, MD.FR);
        MT.WOODS.Citrus = MT.woodnormal(9346, "Citruswood", "Citruswood", 152, 163, 28, 2.5, 24, MD.FR);
        MT.WOODS.Cocobolo = MT.woodnormal(9347, "Cocobolowood", "Cocobolowood", 121, 18, 2, 3.0, 16, MD.FR);
        MT.WOODS.Ebony = MT.woodnormal(9348, "Ebony", "Ebony", 58, 52, 46, 4.0, 48, MD.FR);
        MT.WOODS.Giganteum = MT.woodnormal(9349, "Giganteumwood", "Giganteumwood", 102, 47, 39, 2.0, 16, MD.FR);
        MT.WOODS.Greenheart = MT.woodnormal(9350, "Greenheart", "Greenheart", 76, 118, 88, 2.5, 16, MD.FR);
        MT.WOODS.Ipe = MT.woodnormal(9351, "Ipe", "Ipe", 101, 58, 39, 2.0, 24, MD.FR);
        MT.WOODS.Kapok = MT.woodnormal(9352, "Kapok", "Kapok", 116, 108, 52, 2.0, 24, MD.FR);
        MT.WOODS.Larch = MT.woodnormal(9353, "Larch", "Larch", 215, 151, 133, 2.5, 16, MD.FR);
        MT.WOODS.Lime = MT.woodnormal(9354, "Limewood", "Limewood", 206, 154, 104, 2.5, 24, MD.FR);
        MT.WOODS.Mahoe = MT.woodnormal(9355, "Mahoe", "Mahoe", 121, 147, 166, 3.0, 24, MD.FR);
        MT.WOODS.Padauk = MT.woodnormal(9357, "Padauk", "Padauk", 179, 99, 59, 2.0, 24, MD.FR, "Paduak");
        MT.WOODS.Papaya = MT.woodnormal(9359, "Papayawood", "Papayawood", 218, 200, 109, 3.0, 16, MD.FR);
        MT.WOODS.Plum = MT.woodnormal(9360, "Plumwood", "Plumwood", 171, 99, 123, 2.5, 16, MD.FR);
        MT.WOODS.Poplar = MT.woodnormal(9361, "Poplar", "Poplar", 204, 204, 123, 2.5, 24, MD.FR);
        MT.WOODS.Sequoia = MT.woodnormal(9362, "Sequoia", "Sequoia", 142, 87, 84, 2.0, 24, MD.FR);
        MT.WOODS.Teak = MT.woodnormal(9363, "Teak", "Teak", 123, 115, 95, 3.0, 16, MD.FR);
        MT.WOODS.Walnut = MT.woodnormal(9364, "Walnutwood", "Walnutwood", 98, 78, 64, 3.0, 32, MD.FR);
        MT.WOODS.Wenge = MT.woodnormal(9365, "Wenge", "Wenge", 88, 81, 70, 2.5, 16, MD.FR);
        MT.WOODS.Zebrawood = MT.woodnormal(9366, "Zebrawood", "Zebrawood", 172, 139, 86, 2.0, 24, MD.FR);
        MT.WOODS.Pine = MT.woodnormal(9335, "Pine", "Pine", 187, 151, 77, 3.0, 32, MD.FR);
        MT.WOODS.Darkwood = MT.woodnormal(9367, "Darkwood", "Darkwood", 51, 45, 54, 2.5, 32, MD.BoP);
        MT.WOODS.Ethereal = MT.woodnormal(9368, "Etherealwood", "Etherealwood", 76, 150, 115, 3.0, 24, MD.BoP);
        MT.WOODS.Gold = MT.woodnormal(9369, "Goldwood", "Goldwood", 210, 187, 151, 2.5, 24, MD.BoP);
        MT.WOODS.HellBark = MT.woodnormal(9370, "Hellbark", "Hellbark", 200, 150, 100, 4.0, 16, MD.BoP);
        MT.WOODS.Jacaranda = MT.woodnormal(9371, "Jacaranda", "Jacaranda", 201, 171, 162, 2.5, 16, MD.BoP);
        MT.WOODS.Mangrove = MT.woodnormal(9372, "Mangrove", "Mangrove", 236, 228, 217, 2.0, 24, MD.BoP);
        MT.WOODS.SacredOak = MT.woodnormal(9373, "SacredOak", "Sacred Oak", 159, 132, 77, 4.0, 48, MD.BoP);
        MT.WOODS.Magic = MT.woodnormal(9374, "Magicwood", "Magicwood", 90, 105, 180, 3.5, 32, MD.BoP, MAGICAL);
        MT.WOODS.Apple = MT.woodnormal(9375, "Applewood", "Applewood", 97, 49, 36, 2.0, 24, MD.BINNIE_TREE);
        MT.WOODS.Ash = MT.woodnormal(9376, "Ashwood", "Ashwood", 244, 190, 90, 3.5, 16, MD.BINNIE_TREE);
        MT.WOODS.Beech = MT.woodnormal(9377, "Beech", "Beech", 226, 144, 68, 2.0, 32, MD.BINNIE_TREE);
        MT.WOODS.Box = MT.woodnormal(9378, "Boxwood", "Boxwood", 253, 237, 192, 2.0, 24, MD.BINNIE_TREE);
        MT.WOODS.Brazilwood = MT.woodnormal(9379, "Brazilwood", "Brazilwood", 112, 55, 84, 3.0, 16, MD.BINNIE_TREE);
        MT.WOODS.Butternut = MT
            .woodnormal(9380, "Butternutwood", "Butternutwood", 237, 163, 112, 2.5, 16, MD.BINNIE_TREE);
        MT.WOODS.Cedar = MT.woodnormal(9381, "Cedar", "Cedar", 217, 88, 37, 2.0, 24, MD.BINNIE_TREE);
        MT.WOODS.Elder = MT.woodnormal(9382, "Elderwood", "Elderwood", 189, 141, 115, 2.5, 16, MD.BINNIE_TREE);
        MT.WOODS.Elm = MT.woodnormal(9383, "Elm", "Elm", 243, 163, 90, 3.0, 24, MD.BINNIE_TREE);
        MT.WOODS.Eucalyptus = MT.woodnormal(9384, "Eucalyptus", "Eucalyptus", 245, 164, 130, 2.5, 24, MD.BINNIE_TREE);
        MT.WOODS.Fig = MT.woodnormal(9385, "Figwood", "Figwood", 202, 126, 27, 2.0, 16, MD.BINNIE_TREE);
        MT.WOODS.Gingko = MT.woodnormal(9386, "Gingko", "Gingko", 243, 226, 173, 2.0, 24, MD.BINNIE_TREE);
        MT.WOODS.Hemlock = MT.woodnormal(9387, "Hemlock", "Hemlock", 196, 174, 96, 3.0, 16, MD.BINNIE_TREE);
        MT.WOODS.Hickory = MT.woodnormal(9388, "Hickory", "Hickory", 218, 174, 134, 2.5, 16, MD.BINNIE_TREE);
        MT.WOODS.Holly = MT.woodnormal(9389, "Holly", "Holly", 248, 242, 226, 2.0, 24, MD.BINNIE_TREE);
        MT.WOODS.Hornbeam = MT.woodnormal(9390, "Hornbeam", "Hornbeam", 195, 147, 87, 2.0, 16, MD.BINNIE_TREE);
        MT.WOODS.Iroko = MT.woodnormal(9391, "Iroko", "Iroko", 117, 47, 0, 3.0, 24, MD.BINNIE_TREE);
        MT.WOODS.Locust = MT.woodnormal(9392, "Locust", "Locust", 195, 140, 87, 2.0, 24, MD.BINNIE_TREE);
        MT.WOODS.Logwood = MT.woodnormal(9393, "Logwood", "Logwood", 166, 44, 34, 2.5, 24, MD.BINNIE_TREE);
        MT.WOODS.Maclura = MT.woodnormal(9394, "Maclura", "Maclura", 242, 168, 29, 2.0, 32, MD.BINNIE_TREE);
        MT.WOODS.Olive = MT.woodnormal(9395, "Olivewood", "Olivewood", 174, 169, 129, 3.0, 16, MD.BINNIE_TREE);
        MT.WOODS.Pear = MT.woodnormal(9396, "Pearwood", "Pearwood", 180, 127, 97, 2.5, 24, MD.BINNIE_TREE);
        MT.WOODS.PinkIvory = MT.woodnormal(9397, "PinkIvory", "Pink Ivory", 234, 125, 148, 2.5, 24, MD.BINNIE_TREE);
        MT.WOODS.Purpleheart = MT.woodnormal(9398, "Purpleheart", "Purpleheart", 91, 22, 45, 2.0, 16, MD.BINNIE_TREE);
        MT.WOODS.Rosewood = MT.woodnormal(9399, "Rosewood", "Rosewood", 128, 12, 0, 3.0, 16, MD.BINNIE_TREE);
        MT.WOODS.Sweetgum = MT.woodnormal(9400, "Sweetgum", "Sweetgum", 215, 140, 74, 2.5, 16, MD.BINNIE_TREE);
        MT.WOODS.Syzgium = MT.woodnormal(9401, "Syzgium", "Syzgium", 221, 184, 183, 2.5, 24, MD.BINNIE_TREE);
        MT.WOODS.Whitebeam = MT.woodnormal(9402, "Whitebeam", "Whitebeam", 192, 183, 174, 3.0, 16, MD.BINNIE_TREE);
        MT.WOODS.Yew = MT.woodnormal(9403, "Yew", "Yew", 226, 160, 114, 2.5, 32, MD.BINNIE_TREE);;
    }
}
