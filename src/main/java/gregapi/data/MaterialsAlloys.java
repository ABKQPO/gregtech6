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
 * The Alloys and every Metal that is produced by smelting something else.
 * <p>
 * Loaded as the "Alloys" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsAlloys implements IMaterialCategory {

    @Override
    public String getName() {
        return "Alloys";
    }

    @Override
    public void load() {
        MT.WroughtIron = MT
            .metalmachnd(
                8643,
                "Wrought Iron",
                SET_METALLIC,
                200,
                180,
                180,
                RAILS,
                MORTAR,
                MAGNETIC_PASSIVE,
                MOLTEN,
                NEVER_FURNACE,
                "WrougtIron")
            .uumAloy(0, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1)
            .setPulver(MT.Fe, U)
            .steal(MT.Fe)
            .heat(MT.Fe.mMeltingPoint + 200, MT.Fe.mBoilingPoint)
            .setGenerifying(MT.Fe)
            .qual(3, 6.0, 384, 2)
            .setRGBaLiquid(255, 80, 40, 255);
        MT.AnnealedCopper = MT
            .metalmachnd(
                8640,
                "Annealed Copper",
                SET_COPPER,
                255,
                100,
                0,
                MOLTEN,
                FURNACE,
                EXTRUDER_SIMPLE,
                MORTAR,
                WIRES,
                RAILS,
                SOFT)
            .uumAloy(0, MT.Cu, 1 * U)
            .aspects(TC.METALLUM, 2, TC.PERMUTATIO, 1)
            .setPulver(MT.Cu, U)
            .steal(MT.Cu)
            .heat(2800, MT.Cu.mBoilingPoint)
            .setGenerifying(MT.Cu);
        MT.Alduorite = MT.setalore(8760, "Alduorite", 159, 180, 180, "Adluorite")
            .steal(MT.Al)
            .aspects(TC.METALLUM, 2, TC.PERMUTATIO, 1)
            .qual(3, 5.0, 256, 2)
            .heat(1567);
        MT.Infuscolium = MT.metalore(8761, "Infuscolium", 146, 33, 86)
            .steal(MT.Cu)
            .aspects(TC.METALLUM, 2, TC.PRAECANTIO, 1)
            .qual(3, 5.0, 256, 2)
            .heat(1828);
        MT.Rubracium = MT.metalore(8762, "Rubracium", 151, 45, 45)
            .steal(MT.W)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 1)
            .qual(3, 5.0, 256, 2)
            .heat(1847);
        MT.Meutoite = MT.metalore(8763, "Meutoite", 95, 82, 105)
            .steal(MT.Ni)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 1)
            .qual(3, 5.0, 256, 2)
            .heat(1837);
        MT.Lemurite = MT.metalore(8764, "Lemurite", 219, 219, 219)
            .steal(MT.Mg)
            .aspects(TC.METALLUM, 2, TC.MOTUS, 1)
            .qual(3, 5.0, 256, 2)
            .heat(1179);
        MT.Aredrite = MT.metalore(8701, "Aredrite", 255, 255, 0, "Ardaite")
            .steal(MT.Pb)
            .aspects(TC.METALLUM, 2, TC.STRONTIO, 1)
            .qual(3, 6.0, 1440, 3)
            .heat(2240);
        // Pb19Sb13S35Cl7
        MT.Ceruclase = MT.metalore(8765, "Ceruclase", 140, 189, 208)
            .steal(MT.Sb)
            .aspects(TC.METALLUM, 2, TC.TEMPESTAS, 1)
            .qual(3, 6.0, 1280, 2)
            .heat(1867);
        MT.Oureclase = MT.metalore(8767, "Oureclase", 183, 98, 21)
            .steal(MT.Ni)
            .aspects(TC.METALLUM, 2, TC.AER, 1)
            .qual(3, 6.0, 1920, 3)
            .heat(2789);
        MT.Kalendrite = MT.metalore(8768, "Kalendrite", 170, 91, 189)
            .steal(MT.Pt)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1)
            .qual(3, 5.0, 2560, 3)
            .heat(2679);
        MT.Carmot = MT.metalore(8770, "Carmot", 217, 205, 140, SOFT)
            .steal(MT.Zn)
            .aspects(TC.METALLUM, 2, TC.NEBRISUM, 1)
            .qual(3, 16.0, 128, 1)
            .heat(1178);
        MT.Sanguinite = MT.metalore(8771, "Sanguinite", 185, 0, 0, "Fettelite")
            .steal(MT.Hg)
            .aspects(TC.METALLUM, 2, TC.SANO, 1)
            .qual(3, 3.0, 4480, 4)
            .heat(3104);
        // Ag16HgAs4S15
        MT.Vyroxeres = MT.metalore(8772, "Vyroxeres", 85, 224, 1)
            .steal(MT.Cu)
            .aspects(TC.METALLUM, 2, TC.VENEMUM, 1)
            .qual(3, 9.0, 768, 3)
            .heat(2348);
        MT.Eximite = MT.metalore(8773, "Eximite", 124, 90, 150)
            .steal(MT.Mn)
            .aspects(TC.METALLUM, 2, TC.ITER, 1)
            .qual(3, 5.0, 2560, 3)
            .heat(2758);
        MT.Ignatius = MT.metalore(8775, "Ignatius", 255, 169, 83)
            .steal(MT.Sn)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 1)
            .qual(3, 12.0, 512, 2)
            .heat(1978);
        MT.DeepIron = MT.metalore(8641, "Deep Iron", 73, 91, 105, MAGNETIC_PASSIVE)
            .steal(MT.Fe)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1)
            .qual(3, 6.0, 384, 2)
            .heat(MT.Fe);
        MT.ShadowIron = MT.metalore(8670, "Shadow Iron", 95, 76, 63, MAGNETIC_PASSIVE)
            .steal(MT.Fe)
            .aspects(TC.METALLUM, 2, TC.TENEBRAE, 1)
            .qual(3, 6.0, 384, 2)
            .heat(MT.WroughtIron);
        MT.Adamantine = MT
            .metalore(8784, "Adamantine", 255, 0, 64, MAGNETIC_PASSIVE, DECOMPOSABLE, WITHER_PROOF, ENDER_DRAGON_PROOF)
            .uumMcfg(0, MT.Ad, 3 * U, MT.O, 4 * U)
            .aspects(TC.METALLUM, 5, TC.PRAECANTIO, 5)
            .qual(3, 10.0, 4500, 5)
            .heat(MT.Ad)
            .addSourceOf(MT.Ad);
        MT.Prometheum = MT.metalore(8774, "Prometheum", 90, 129, 86, CENTRIFUGE, DECOMPOSABLE, SOFT)
            .setMcfg(0, MT.Pm, 3 * U, MT.O, 4 * U)
            .aspects(TC.METALLUM, 2, TC.POTENTIA, 1)
            .qual(3, 8.0, 512, 1)
            .heat(MT.Pm);
        MT.Vulcanite = MT.metalore(8776, "Vulcanite", 255, 132, 72, CENTRIFUGE, DECOMPOSABLE)
            .uumMcfg(0, MT.Cu, 1 * U, MT.Te, 1 * U)
            .aspects(TC.METALLUM, 2, TC.VITREUS, 1)
            .qual(3, 5.0, 3840, 3);
        MT.Orichalcum = MT
            .alloymachore(8769, "Orichalcum", 84, 122, 56, MAGICAL, MOLTEN, WASHING_MERCURY, VALUABLE, CENTRIFUGE)
            .setMcfg(4, MT.Cu, 3 * U, MT.Zn, 1 * U, MT.Ma, 2 * U)
            .aspects(TC.METALLUM, 2, TC.PERMUTATIO, 2, TC.PRAECANTIO, 1)
            .qual(3, 4.5, 3456, 3)
            .heat(MT.Cu);
        MT.AstralSilver = MT
            .slloymachore(
                8676,
                "Astral Silver",
                230,
                230,
                255,
                MAGICAL,
                MOLTEN,
                WASHING_MERCURY,
                VALUABLE,
                CENTRIFUGE,
                ENDER_DRAGON_PROOF)
            .setMcfg(2, MT.Ag, 2 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 1, TC.PRAECANTIO, 1)
            .qual(3, 10.0, 64, 2)
            .heat(MT.Ag)
            .setGenerifying(MT.Ag);
        MT.Midasium = MT
            .slloymachore(8677, "Midasium", 255, 200, 40, MAGICAL, MOLTEN, WASHING_MERCURY, VALUABLE, WITHER_PROOF)
            .setMcfg(2, MT.Au, 2 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 2, TC.PRAECANTIO, 1)
            .qual(3, 12.0, 64, 2)
            .heat(MT.Au)
            .setGenerifying(MT.Au);
        MT.Mithril = MT
            .slloymachore(
                8678,
                "Mithril",
                100,
                140,
                250,
                MAGICAL,
                MOLTEN,
                WASHING_MERCURY,
                VALUABLE,
                CENTRIFUGE,
                "Mythril")
            .setMcfg(2, MT.Pt, 2 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 3, TC.PRAECANTIO, 1)
            .qual(3, 14.0, 64, 3)
            .heat(MT.Pt)
            .setGenerifying(MT.Pt);
        MT.Celenegil = MT
            .alloymachore(8779, "Celenegil", 148, 204, 72, MAGICAL, MOLTEN, WASHING_MERCURY, VALUABLE, CENTRIFUGE)
            .setAloy(0, MT.Pt, 1 * U, MT.Orichalcum, 1 * U)
            .aspects(TC.METALLUM, 2, TC.NEBRISUM, 1, TC.VITREUS, 1)
            .qual(3, 10.0, 4096, 3);
        MT.ShadowSteel = MT.alloy(8671, "Shadow Steel", 136, 115, 98, MAGNETIC_PASSIVE)
            .setAloy(0, MT.ShadowIron, 1 * U, MT.Lemurite, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TENEBRAE, 1, TC.TELUM, 1)
            .qual(3, 6.0, 768, 2)
            .visDefault(MT.ShadowIron, MT.Lemurite);
        MT.Inolashite = MT.alloy(8777, "Inolashite", 148, 216, 187)
            .setAloy(0, MT.Alduorite, 1 * U, MT.Ceruclase, 1 * U)
            .aspects(TC.METALLUM, 2, TC.AER, 1, TC.AQUA, 1)
            .qual(3, 8.0, 2304, 3)
            .visDefault(MT.Alduorite, MT.Ceruclase);
        MT.Haderoth = MT.alloy(8778, "Haderoth", 119, 52, 30, MAGICAL)
            .setAloy(0, MT.Mithril, 1 * U, MT.Rubracium, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 1, TC.PRAECANTIO, 1)
            .qual(3, 10.0, 3200, 3)
            .visDefault(MT.Rubracium);
        MT.Desichalkos = MT.alloy(8781, "Desichalkos", 114, 47, 168)
            .setAloy(0, MT.Eximite, 1 * U, MT.Meutoite, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ITER, 1, TC.ALIENIS, 1)
            .qual(3, 11.0, 4608, 4)
            .visDefault(MT.Eximite, MT.Meutoite);
        MT.Tartarite = MT.alloy(8782, "Tartarite", 255, 118, 60, MAGNETIC_PASSIVE, WITHER_PROOF, ENDER_DRAGON_PROOF)
            .uumAloy(0, MT.Adamantine, 1 * U, MT.Atl, 1 * U)
            .aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1, TC.COGNITIO, 1)
            .qual(3, 20.0, 7680, 5);
        MT.Amordrine = MT.alloy(8783, "Amordrine", 169, 141, 177)
            .setAloy(0, MT.Prometheum, 1 * U, MT.Kalendrite, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.POTENTIA, 1)
            .qual(3, 7.0, 3328, 3)
            .visDefault(MT.Prometheum, MT.Kalendrite);
        MT.Electrum = MT
            .slloymachore(
                8600,
                "Electrum",
                255,
                255,
                100,
                MORTAR,
                MOLTEN,
                VALUABLE,
                SOFT,
                ENDER_DRAGON_PROOF,
                RAILS,
                WASHING_MERCURY,
                WITHER_PROOF)
            .qual(3, 12.0, 64, 2)
            .uumAloy(0, MT.Ag, 1 * U, MT.Au, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 2);
        MT.SterlingSilver = MT
            .slloymachine(8601, "Sterling Silver", 250, 220, 225, MORTAR, MOLTEN, VALUABLE, SOFT, ENDER_DRAGON_PROOF)
            .qual(3, 13.0, 128, 2)
            .uumAloy(0, MT.Cu, 1 * U, MT.Ag, 4 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 2);
        MT.RoseGold = MT
            .slloymachine(8602, "Rose Gold", 255, 230, 30, MORTAR, MOLTEN, VALUABLE, SOFT, WITHER_PROOF, "Tumbaga")
            .qual(3, 14.0, 128, 2)
            .uumAloy(0, MT.Cu, 1 * U, MT.Au, 4 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 2);
        MT.Angmallen = MT.slloymachine(8603, "Angmallen", 215, 225, 138, MORTAR, MOLTEN, MAGNETIC_PASSIVE)
            .qual(3, 10.0, 128, 2)
            .uumAloy(0, MT.Au, 1 * U, MT.WroughtIron, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 1);
        MT.InductiveAlloy = MT.slloymachine(8604, "GoldInductive", 255, 150, 75, MORTAR, MAGNETIC_PASSIVE, MOLTEN, SOFT)
            .uumAloy(0, MT.Au, 1 * U, MT.Redstone, 1 * U)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1)
            .setLocal("Inductive Alloy");
        MT.Cd_In_Ag_Alloy = MT.alloymachine(8605, "Cd-In-Ag-Alloy", 100, 100, 128)
            .uumAloy(0, MT.Cd, 1 * U, MT.In, 1 * U, MT.Ag, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TENEBRAE, 1);
        MT.GildedIron = MT
            .slloymachine(8606, "Gilded Iron", 255, 230, 80, COATED, CENTRIFUGE, MAGNETIC_PASSIVE, WITHER_PROOF)
            .qual(3, 12.0, 256, 2)
            .setMcfg(9, MT.Fe, 9 * U, MT.Au, 1 * U)
            .aspects(TC.METALLUM, 3, TC.LUCRUM, 1)
            .setSmelting(MT.Fe, U)
            .setForging(MT.Fe, U);
        // from Flaxbeard, obviously not an Alloy, but coated in Gold. This also gives an
        // example on how to make such things as coated metals.
        MT.Brass = MT.clloymachine(8620, "Brass", 255, 180, 0, FURNACE, SOFT, EXTRUDER_SIMPLE, MORTAR, MOLTEN)
            .qual(2, 7.0, 96, 1)
            .uumAloy(0, MT.Cu, 3 * U, MT.Zn, 1 * U)
            .aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1)
            .heat(1160, MT.Cu.mBoilingPoint);
        MT.CobaltBrass = MT
            .clloymachine(8621, "Cobalt Brass", 180, 180, 160, FURNACE, SOFT, EXTRUDER_SIMPLE, MORTAR, MOLTEN)
            .qual(3, 8.0, 256, 2)
            .uumAloy(0, MT.Brass, 7 * U, MT.Al, 1 * U, MT.Co, 1 * U)
            .aspects(TC.METALLUM, 2, TC.FABRICO, 1);
        MT.AluminiumAlloy = MT.clloymachine(8622, "Aluminium Alloy", 200, 200, 180, CENTRIFUGE)
            .uumMcfg(45, MT.Al, 45 * U, MT.Si, 1 * U)
            .aspects(TC.METALLUM, 2, TC.FABRICO, 1)
            .qual(MT.Al);
        MT.Bronze = MT.clloymachine(8610, "Bronze", 210, 130, 60, RAILS, FURNACE, SOFT, EXTRUDER_SIMPLE, MORTAR, MOLTEN)
            .qual(3, 5.5, 448, 2)
            .uumAloy(0, MT.Cu, 3 * U, MT.Sn, 1 * U)
            .aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1)
            .heat(MT.Cu.mMeltingPoint, MT.Cu.mBoilingPoint);
        MT.BlackBronze = MT.clloymachine(8611, "Black Bronze", 100, 50, 125, MORTAR, MOLTEN, SOFT)
            .qual(3, 12.0, 512, 2)
            .uumAloy(0, MT.Cu, 3 * U, MT.Electrum, 2 * U)
            .aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1);
        MT.BismuthBronze = MT
            .clloymachine(8612, "Bismuth Bronze", 100, 125, 125, FURNACE, SOFT, EXTRUDER_SIMPLE, MORTAR, MOLTEN)
            .qual(3, 8.0, 512, 2)
            .setAloy(0, MT.Bi, 1 * U, MT.Brass, 4 * U)
            .aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1);
        MT.Hepatizon = MT.alloymachine(8613, "Hepatizon", 117, 94, 117, MORTAR, MOLTEN)
            .qual(3, 12.0, 256, 2)
            .uumAloy(0, MT.Au, 1 * U, MT.Bronze, 1 * U)
            .aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1);
        MT.ArsenicCopper = MT
            .clloymachine(8614, "Arsenic Copper", 210, 160, 60, FURNACE, SOFT, EXTRUDER_SIMPLE, MORTAR, MOLTEN)
            .qual(3, 5.5, 448, 2)
            .uumAloy(0, MT.Cu, 3 * U, MT.As, 1 * U)
            .aspects(TC.METALLUM, 2, TC.VENEMUM, 1)
            .heat(MT.Cu.mMeltingPoint, MT.Cu.mBoilingPoint);
        MT.ArsenicBronze = MT
            .clloymachine(8615, "Arsenic Bronze", 200, 200, 222, FURNACE, SOFT, EXTRUDER_SIMPLE, MORTAR, MOLTEN)
            .qual(3, 6.0, 480, 2)
            .uumAloy(0, MT.As, 1 * U, MT.Bronze, 4 * U)
            .aspects(TC.METALLUM, 2, TC.VENEMUM, 1)
            .heat(MT.Cu.mMeltingPoint, MT.Cu.mBoilingPoint);
        MT.Steel = MT.alloymachore(8630, "Steel", 130, 130, 130, MOLTEN, RAILS, MORTAR, MAGNETIC_PASSIVE, NEVER_FURNACE)
            .qual(3, 6.0, 512, 2)
            .uumMcfg(0, MT.WroughtIron, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1)
            .heat(2046, MT.Fe.mBoilingPoint, MT.Fe.mPlasmaPoint)
            .setRGBaLiquid(255, 20, 10, 255);
        MT.BlackSteel = MT.alloymachine(8631, "Black Steel", 90, 90, 90, MOLTEN)
            .qual(3, 6.5, 768, 2)
            .uumAloy(0, MT.Ni, 1 * U, MT.BlackBronze, 1 * U, MT.Steel, 3 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.INSTRUMENTUM, 1);
        MT.BlueSteel = MT.alloymachine(8632, "Blue Steel", 100, 100, 140, MOLTEN)
            .qual(3, 7.0, 896, 2)
            .setAloy(0, MT.SterlingSilver, 1 * U, MT.BismuthBronze, 1 * U, MT.Steel, 2 * U, MT.BlackSteel, 4 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.INSTRUMENTUM, 1);
        MT.RedSteel = MT.alloymachine(8633, "Red Steel", 140, 100, 100, MOLTEN)
            .qual(3, 7.5, 1024, 2)
            .uumAloy(0, MT.RoseGold, 1 * U, MT.Brass, 1 * U, MT.Steel, 2 * U, MT.BlackSteel, 4 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.INSTRUMENTUM, 1);
        MT.DamascusSteel = MT.alloymachine(8634, "Damascus Steel", 110, 110, 110, MOLTEN, CENTRIFUGE, MAGNETIC_PASSIVE)
            .qual(3, 8.0, 1280, 2)
            .uumMcfg(50, MT.Steel, 50 * U, MT.V, 1 * U, MT.W, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.INSTRUMENTUM, 1, TC.TELUM, 1);
        MT.VanadiumSteel = MT.alloymachine(8653, "VanadiumSteel", 100, 100, 100, MOLTEN, MAGNETIC_PASSIVE)
            .qual(3, 7.0, 512, 3)
            .uumAloy(0, MT.Steel, 4 * U, MT.V, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.INSTRUMENTUM, 1)
            .setLocal("Vanadiumsteel");
        MT.TungstenSteel = MT
            .alloymachine(
                8635,
                "Tungstensteel",
                100,
                100,
                160,
                MOLTEN,
                RAILS,
                MAGNETIC_PASSIVE,
                UNBURNABLE,
                "TungstenSteel",
                "Wolframsteel",
                "WolframSteel")
            .qual(3, 10.0, 5120, 4)
            .uumAloy(0, MT.Steel, 1 * U, MT.W, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.TUTAMEN, 1);
        MT.TungstenCarbide = MT
            .alloymachine(8638, "Tungsten Carbide", 123, 123, 123, RAILS, UNBURNABLE, "Carbide", "WolframCarbide")
            .qual(3, 10.0, 5120, 4)
            .uumAloy(0, MT.W, 1 * U, MT.C, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.TUTAMEN, 1)
            .setDensity(15.6)
            .heat(3070, 6270);
        MT.HSLA = MT
            .alloymachine(8637, "HSLA-Steel", 210, 210, 255, RAILS, CENTRIFUGE, MORTAR, MAGNETIC_PASSIVE, "HSLA")
            .uumMcfg(2, MT.WroughtIron, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1)
            .steal(MT.Steel)
            .heat(1873, MT.Fe.mBoilingPoint, MT.Fe.mPlasmaPoint)
            .setRGBaLiquid(180, 80, 30, 255);
        MT.SpringSteel = MT.alloymachine(8639, "HSLA-Spring-Steel", 220, 100, 100, CENTRIFUGE, MAGNETIC_PASSIVE)
            .uumMcfg(45, MT.HSLA, 45 * U, MT.Redstone, 2 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1)
            .steal(MT.HSLA)
            .setLocal("Spring Steel");
        MT.TungstenAlloy = MT.alloymachine(8766, "HSLA-Tungsten-Alloy", 179, 119, 190, CENTRIFUGE, MAGNETIC_PASSIVE)
            .uumMcfg(180, MT.SpringSteel, 180 * U, MT.W, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 1)
            .steal(MT.SpringSteel)
            .qual(3, 7.0, 1024, 2)
            .setLocal("Tungsten Alloy");
        MT.PigIron = MT.metalmachore(8642, "Pig Iron", 200, 180, 180, MOLTEN, MORTAR, MAGNETIC_PASSIVE)
            .uumMcfg(0, MT.WroughtIron, 1 * U)
            .aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1)
            .setPulver(MT.Fe, U)
            .setSmelting(MT.WroughtIron, U)
            .steal(MT.WroughtIron)
            .setGenerifying(MT.Fe)
            .qual(3, 6.0, 384, 2);
        MT.IronCompressed = MT
            .alloymachnd(8644, "IronCompressed", SET_METALLIC, 128, 128, 128, CENTRIFUGE, MORTAR, MAGNETIC_PASSIVE)
            .uumMcfg(0, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TERRA, 1)
            .setPulver(MT.Fe, U)
            .setSmelting(MT.Fe, U)
            .steal(MT.Fe)
            .setGenerifying(MT.Fe)
            .setLocal("Compressed Iron");
        MT.IronCast = MT.alloymachnd(8803, "Cast Iron", SET_METALLIC, 64, 64, 64, CENTRIFUGE, MORTAR, MAGNETIC_PASSIVE)
            .uumMcfg(0, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TERRA, 1)
            .setPulver(MT.Fe, U)
            .steal(MT.Fe)
            .setGenerifying(MT.Fe);
        MT.IronMagnetic = MT
            .metalmachnd(
                8645,
                "IronMagnetic",
                SET_MAGNETIC,
                200,
                200,
                200,
                LAYERED,
                MORTAR,
                MAGNETIC_ACTIVE,
                AUTO_COLLECTING)
            .uumMcfg(0, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1)
            .setBending(MT.Fe, U)
            .setCompressing(MT.Fe, U)
            .setPulver(MT.Fe, U)
            .setSmashing(MT.Fe, U)
            .setSmelting(MT.Fe, U)
            .setWorking(MT.Fe, U)
            .setForging(MT.Fe, U)
            .steal(MT.Fe)
            .setGenerifying(MT.Fe)
            .setLocal("Magnetic Iron");
        MT.SteelMagnetic = MT
            .metalmachnd(
                8646,
                "SteelMagnetic",
                SET_MAGNETIC,
                128,
                128,
                128,
                LAYERED,
                MORTAR,
                MAGNETIC_ACTIVE,
                AUTO_COLLECTING)
            .uumMcfg(0, MT.Steel, 1 * U)
            .aspects(TC.METALLUM, 1, TC.ORDO, 1, TC.MAGNETO, 1)
            .setBending(MT.Steel, U)
            .setCompressing(MT.Steel, U)
            .setPulver(MT.Steel, U)
            .setSmashing(MT.Steel, U)
            .setSmelting(MT.Steel, U)
            .setWorking(MT.Steel, U)
            .setForging(MT.Steel, U)
            .steal(MT.Steel)
            .setGenerifying(MT.Steel)
            .setLocal("Magnetic Steel");
        MT.NeodymiumMagnetic = MT
            .metalmachnd(
                8647,
                "NeodymiumMagnetic",
                SET_MAGNETIC,
                100,
                100,
                100,
                LAYERED,
                MORTAR,
                MAGNETIC_ACTIVE,
                AUTO_COLLECTING)
            .uumMcfg(0, MT.Nd, 1 * U)
            .aspects(TC.METALLUM, 1, TC.MAGNETO, 3)
            .setBending(MT.Fe, U)
            .setCompressing(MT.Nd, U)
            .setPulver(MT.Nd, U)
            .setSmashing(MT.Nd, U)
            .setSmelting(MT.Nd, U)
            .setWorking(MT.Nd, U)
            .setForging(MT.Nd, U)
            .steal(MT.Nd)
            .setGenerifying(MT.Nd)
            .setLocal("Magnetic Neodymium");
        MT.DarkIron = MT
            .metalmachore(8648, "Dark Iron", SET_DULL, 55, 40, 60, MAGNETIC_PASSIVE, "FzDarkIron", "FZDarkIron")
            .setMcfg(0, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 1)
            .steal(MT.Fe)
            .qual(3, 7.0, 384, 3)
            .heat(MT.Steel.mMeltingPoint + 200, MT.Fe.mBoilingPoint);
        MT.SteelGalvanized = MT.clloymachine(8651, "SteelGalvanized", 250, 240, 240, COATED, CENTRIFUGE)
            .qual(3, 7.0, 768, 2)
            .setMcfg(9, MT.Steel, 9 * U, MT.Zn, 1 * U)
            .aspects(TC.METALLUM, 3, TC.SANO, 1)
            .setSmelting(MT.Steel, U)
            .setForging(MT.Steel, U)
            .setLocal("Galvanized Steel");
        MT.TungstenSintered = MT.alloymachnd(8652, "TungstenSintered", SET_METALLIC, 70, 70, 70, RAILS, UNBURNABLE)
            .qual(3, 8.0, 5120, 3)
            .uumMcfg(0, MT.W, 1 * U)
            .aspects(TC.METALLUM, 3, TC.TUTAMEN, 1)
            .steal(MT.W)
            .setAllToTheOutputOf(MT.W)
            .setForging(null, U)
            .setCutting(null, U)
            .setWorking(null, U)
            .setSmashing(null, U)
            .setGenerifying(MT.W)
            .setLocal("Sintered Tungsten");
        MT.TitaniumGold = MT.alloymachine(8654, "Titanium-Gold", 222, 222, 255, MOLTEN)
            .qual(3, 12.0, 5120, 4)
            .uumAloy(0, MT.Ti, 3 * U, MT.Au, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 3, TC.LUCRUM, 1);
        MT.Ta4HfC5 = MT.alloymachine(8802, "Tantalum Hafnium Carbide", 32, 128, 32, UNBURNABLE)
            .uumAloy(0, MT.Ta, 4 * U, MT.Hf, 1 * U, MT.C, 5 * U)
            .aspects(TC.METALLUM, 2, TC.GELUM, 2)
            .qual(2)
            .heat(4263);
        MT.MeteoricIron = MT
            .metalmachore(
                8649,
                "Meteoric Iron",
                SET_SPACE,
                150,
                140,
                120,
                MOLTEN,
                MAGNETIC_ACTIVE,
                AUTO_COLLECTING,
                RAILS,
                DECOMPOSABLE)
            .uumMcfg(0, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1)
            .steal(MT.WroughtIron)
            .qual(3, 7.0, 896, 2)
            .heat(MT.Fe.mMeltingPoint + 200, MT.Fe.mBoilingPoint + 200)
            .setGenerifying(MT.Fe);
        MT.MeteoricSteel = MT
            .alloymachine(
                8650,
                "Meteoric Steel",
                SET_SPACE,
                130,
                120,
                100,
                MOLTEN,
                MAGNETIC_ACTIVE,
                AUTO_COLLECTING,
                RAILS)
            .uumMcfg(0, MT.MeteoricIron, 1 * U)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1, TC.ORDO, 1)
            .steal(MT.Steel)
            .qual(3, 8.0, 1280, 2)
            .heat(MT.Steel.mMeltingPoint + 200, MT.Steel.mBoilingPoint + 200)
            .setGenerifying(MT.Steel);
        MT.MeteoricBlackSteel = MT
            .alloymachine(8690, "Meteoric Black Steel", 85, 85, 85, MOLTEN, MAGNETIC_ACTIVE, AUTO_COLLECTING)
            .qual(3, 8.0, 1280, 2)
            .uumAloy(0, MT.Ni, 1 * U, MT.BlackBronze, 1 * U, MT.MeteoricSteel, 3 * U)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1, TC.ORDO, 1, TC.INSTRUMENTUM, 1)
            .setGenerifying(MT.BlackSteel);
        MT.MeteoricBlueSteel = MT
            .alloymachine(8691, "Meteoric Blue Steel", 95, 95, 135, MOLTEN, MAGNETIC_ACTIVE, AUTO_COLLECTING)
            .qual(3, 8.5, 1408, 2)
            .setAloy(
                0,
                MT.SterlingSilver,
                1 * U,
                MT.BismuthBronze,
                1 * U,
                MT.MeteoricSteel,
                2 * U,
                MT.MeteoricBlackSteel,
                4 * U)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1, TC.ORDO, 1, TC.INSTRUMENTUM, 1)
            .setGenerifying(MT.BlueSteel);
        MT.MeteoricRedSteel = MT
            .alloymachine(8692, "Meteoric Red Steel", 135, 95, 95, MOLTEN, MAGNETIC_ACTIVE, AUTO_COLLECTING)
            .qual(3, 9.0, 1536, 2)
            .uumAloy(0, MT.RoseGold, 1 * U, MT.Brass, 1 * U, MT.MeteoricSteel, 2 * U, MT.MeteoricBlackSteel, 4 * U)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1, TC.ORDO, 1, TC.INSTRUMENTUM, 1)
            .setGenerifying(MT.RedSteel);
        MT.RedAlloy = MT.clloy(8660, "Red Alloy", 200, 0, 0, MORTAR, WIRES, FURNACE, SOFT, EXTRUDER_SIMPLE, MOLTEN)
            .uumAloy(1, MT.Cu, 1 * U, MT.Redstone, 4 * U)
            .aspects(TC.MACHINA, 3)
            .stealStatsElement(MT.Cu)
            .heat(1400, MT.Cu.mBoilingPoint);
        MT.BlueAlloy = MT
            .clloy(8659, "Blue Alloy", 100, 180, 255, MORTAR, WIRES, FURNACE, SOFT, EXTRUDER_SIMPLE, MOLTEN)
            .uumAloy(1, MT.Ag, 1 * U, MT.Nikolite, 4 * U)
            .aspects(TC.ELECTRUM, 3)
            .stealStatsElement(MT.Ag)
            .heat(1400, MT.Ag.mBoilingPoint);
        MT.PurpleAlloy = MT
            .clloy(8657, "Purple Alloy", 255, 120, 255, MORTAR, WIRES, FURNACE, SOFT, EXTRUDER_SIMPLE, MOLTEN)
            .uumAloy(1, MT.RedAlloy, 1 * U, MT.BlueAlloy, 1 * U)
            .aspects(TC.MACHINA, 3, TC.ELECTRUM, 3)
            .heat(1400, MT.Ag.mBoilingPoint);
        MT.Mingrade = MT.clloy(8804, "Mingrade", 255, 80, 20, MORTAR, WIRES, FURNACE, SOFT, EXTRUDER_SIMPLE)
            .uumMcfg(0, MT.Cu, 1 * U, MT.Redstone, 1 * U)
            .aspects(TC.MACHINA, 2)
            .heat(1400, MT.Cu.mBoilingPoint)
            .setLocal("Red Copper");
        MT.RedstoneAlloy = MT.clloy(8733, "Redstone Alloy", 140, 50, 50, MOLTEN)
            .uumAloy(1, MT.Si, 1 * U, MT.Redstone, 1 * U)
            .aspects(TC.METALLUM, 3, TC.MACHINA, 1)
            .stealStatsElement(MT.Si)
            .setPriorityPrefix(5);
        MT.NikolineAlloy = MT.clloy(8737, "Nikoline Alloy", 50, 90, 140, MOLTEN, "TeslatineAlloy")
            .uumAloy(1, MT.Si, 1 * U, MT.Nikolite, 1 * U)
            .aspects(TC.METALLUM, 3, TC.POTENTIA, 1)
            .stealStatsElement(MT.Si)
            .setPriorityPrefix(5);
        MT.ElectrotineAlloy = MT
            .clloy(8658, "Electrotine Alloy", 100, 180, 255, MORTAR, WIRES, MOLTEN, FURNACE, EXTRUDER_SIMPLE)
            .uumAloy(1, MT.WroughtIron, 1 * U, MT.Nikolite, 8 * U)
            .aspects(TC.ELECTRUM, 3)
            .stealStatsElement(MT.Fe)
            .heat(1400, MT.Fe.mBoilingPoint);
        MT.ElectrumFlux = MT.slloy(8711, "Electrum Flux", 255, 255, 120, SOFT)
            .qual(3, 14.0, 64, 2)
            .uumAloy(1, MT.Electrum, 1 * U, MT.Redstone, 2 * U)
            .aspects(TC.METALLUM, 2, TC.PERMUTATIO, 2)
            .stealStatsElement(MT.Electrum);
        MT.ConductiveIron = MT.alloy(8727, "Conductive Iron", 170, 140, 140, MAGNETIC_PASSIVE)
            .qual(MT.WroughtIron)
            .uumAloy(1, MT.WroughtIron, 1 * U, MT.Redstone, 1 * U)
            .aspects(TC.METALLUM, 3, TC.POTENTIA, 1)
            .stealStatsElement(MT.Fe);
        MT.EnergeticSilver = MT.alloy(8808, "Energetic Silver", 93, 126, 151, SOFT)
            .uumAloy(1, MT.Ag, 1 * U, MT.Redstone, 1 * U, MT.Glowstone, 1 * U)
            .aspects(TC.METALLUM, 2, TC.POTENTIA, 1)
            .stealStatsElement(MT.Ag);
        MT.Invar = MT.alloymachine(8661, "Invar", 220, 220, 150, MORTAR, MAGNETIC_PASSIVE, MOLTEN)
            .qual(3, 6.0, 256, 2)
            .uumAloy(0, MT.WroughtIron, 2 * U, MT.Ni, 1 * U)
            .aspects(TC.METALLUM, 2, TC.GELUM, 1);
        MT.Constantan = MT
            .clloymachine(8662, "Constantan", 150, 100, 85, MORTAR, MAGNETIC_PASSIVE, MOLTEN, "Cupronickel")
            .qual(3, 6.0, 64, 1)
            .uumAloy(0, MT.Cu, 1 * U, MT.Ni, 1 * U);
        MT.Cupronickel = MT.Constantan;
        MT.Nichrome = MT.alloymachine(8663, "Nichrome", 205, 206, 246, MOLTEN)
            .qual(3, 6.0, 64, 2)
            .uumAloy(0, MT.Ni, 4 * U, MT.Cr, 1 * U);
        MT.Kanthal = MT.alloymachine(8664, "Kanthal", 194, 210, 223, MOLTEN)
            .qual(3, 6.0, 64, 2)
            .uumAloy(0, MT.WroughtIron, 1 * U, MT.Al, 1 * U, MT.Cr, 1 * U);
        MT.Magnalium = MT
            .alloymachine(8665, "Magnalium", SET_DULL, 200, 190, 255, MOLTEN, FURNACE, EXTRUDER_SIMPLE, RAILS)
            .qual(3, 6.0, 256, 2)
            .uumAloy(0, MT.Mg, 1 * U, MT.Al, 2 * U);
        MT.StainlessSteel = MT.slloymachine(8636, "Stainless Steel", 200, 200, 220, MOLTEN, RAILS)
            .qual(3, 7.0, 480, 2)
            .uumAloy(0, MT.WroughtIron, 4 * U, MT.Invar, 3 * U, MT.Cr, 1 * U, MT.Mn, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ORDO, 1, TC.VITREUS, 1);
        MT.Ultimet = MT.slloymachine(8666, "Ultimet", 180, 180, 230, MOLTEN)
            .qual(3, 8.0, 1024, 3)
            .uumAloy(0, MT.Co, 5 * U, MT.Ni, 1 * U, MT.Cr, 2 * U, MT.Mo, 1 * U);
        // 54% Co, 26% Cr, 9% Ni, 5% Mo, 3% Fe, 2% W, 0.8%
        // Mn, 0.3% Si, 0.08% Ni and 0.06% C, why the fuck
        // did i think adding some random alloy from some
        // random company was a good idea... I should've
        // done something more well known.
        MT.TinAlloy = MT.clloymachine(8667, "Tin Alloy", 200, 200, 200, MORTAR, MOLTEN, FURNACE, EXTRUDER_SIMPLE, SOFT)
            .qual(3, 6.5, 96, 2)
            .uumAloy(0, MT.Sn, 1 * U, MT.WroughtIron, 1 * U)
            .aspects(TC.METALLUM, 2, TC.FABRICO, 1);
        MT.BatteryAlloy = MT
            .alloy(8668, "Battery Alloy", SET_DULL, 156, 124, 160, MORTAR, MOLTEN, FURNACE, EXTRUDER_SIMPLE, SOFT)
            .uumAloy(0, MT.Pb, 4 * U, MT.Sb, 1 * U);
        MT.SolderingAlloy = MT
            .clloy(
                8669,
                "Soldering Alloy",
                220,
                220,
                230,
                MORTAR,
                MOLTEN,
                BRITTLE,
                EXTRUDER_SIMPLE,
                SOFT,
                SOLDERING_MATERIAL,
                SOLDERING_MATERIAL_GOOD,
                FURNACE,
                WIRES)
            .uumAloy(0, MT.Sn, 9 * U, MT.Sb, 1 * U);
        MT.IronWood = MT
            .alloymachine(
                8672,
                "Ironwood",
                SET_WOOD,
                150,
                140,
                110,
                MAGICAL,
                WOOD,
                FURNACE,
                EXTRUDER_SIMPLE,
                MORTAR,
                MAGNETIC_PASSIVE,
                MOLTEN,
                "IronWood")
            .qual(2, 6.5, 512, 2)
            .setAloy(18, MT.WroughtIron, 8 * U, MT.LiveRoot, 9 * U, MT.Angmallen, 2 * U)
            .aspects(TC.METALLUM, 2, TC.ARBOR, 1, TC.PRAECANTIO, 1);
        MT.Steeleaf = MT
            .alloymachine(
                8673,
                "Steeleaf",
                SET_LEAF,
                50,
                127,
                50,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_PASSIVE,
                WOOD,
                MORTAR,
                AUTO_COLLECTING,
                SOFT)
            .qual(2, 8.0, 144, 3)
            .setMcfg(1, MT.Steel, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.HERBA, 1, TC.PRAECANTIO, 1)
            .setSmelting(MT.Steel, U4);
        MT.Knightmetal = MT
            .alloymachine(
                8674,
                "Knightmetal",
                210,
                240,
                200,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_PASSIVE,
                MOLTEN,
                MORTAR,
                "KnightMetal")
            .qual(3, 8.0, 512, 3)
            .setMcfg(2, MT.Steel, 2 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TELUM, 1, TC.PRAECANTIO, 1)
            .heat(MT.Steel.mMeltingPoint + 100, MT.Steel.mBoilingPoint + 100)
            .setGenerifying(MT.Steel);
        MT.FierySteel = MT
            .alloymachine(
                8675,
                "Fiery Steel",
                SET_FIERY,
                64,
                0,
                0,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_PASSIVE,
                MOLTEN,
                WITHER_PROOF,
                UNBURNABLE,
                BURNING,
                GLOWING,
                "Fiery")
            .qual(3, 9.0, 1024, 4)
            .setMcfg(1, MT.Steel, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 3, TC.PRAECANTIO, 1)
            .heat(MT.Steel.mBoilingPoint - 200, MT.Steel.mBoilingPoint + 500)
            .setGenerifying(MT.Steel);
        MT.Fireleaf = MT
            .alloymachine(
                8698,
                "Fireleaf",
                SET_LEAF,
                127,
                50,
                50,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_PASSIVE,
                WOOD,
                WITHER_PROOF,
                UNBURNABLE,
                BURNING,
                GLOWING,
                AUTO_COLLECTING,
                SOFT)
            .qual(2, 12.0, 288, 4)
            .setMcfg(1, MT.Steel, 1 * U, MT.Ma, 2 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 3, TC.PRAECANTIO, 1, TC.HERBA, 1)
            .setSmelting(MT.FierySteel, U4)
            .heat(MT.Steel.mBoilingPoint - 200, MT.Steel.mBoilingPoint + 500)
            .setGenerifying(MT.Steel)
            .setGenerifying(MT.Steeleaf);
        MT.MeteoflameSteel = MT
            .alloymachine(
                8693,
                "Meteoflame Steel",
                SET_FIERY,
                130,
                120,
                100,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_ACTIVE,
                MOLTEN,
                WITHER_PROOF,
                UNBURNABLE,
                BURNING,
                GLOWING,
                AUTO_COLLECTING)
            .qual(3, 12.0, 1280, 4)
            .setMcfg(1, MT.MeteoricSteel, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 3, TC.PRAECANTIO, 1, TC.MAGNETO, 1, TC.ORDO, 1)
            .heat(MT.MeteoricSteel.mBoilingPoint - 200, MT.MeteoricSteel.mBoilingPoint + 500)
            .setGenerifying(MT.MeteoricSteel);
        MT.MeteoflameBlackSteel = MT
            .alloymachine(
                8694,
                "Meteoflame Black Steel",
                SET_FIERY,
                85,
                85,
                85,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_ACTIVE,
                MOLTEN,
                WITHER_PROOF,
                UNBURNABLE,
                BURNING,
                GLOWING,
                AUTO_COLLECTING)
            .qual(3, 12.0, 1280, 4)
            .setMcfg(1, MT.MeteoricBlackSteel, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 3, TC.PRAECANTIO, 1, TC.MAGNETO, 1, TC.ORDO, 1, TC.INSTRUMENTUM, 1)
            .heat(MT.MeteoricBlackSteel.mBoilingPoint - 200, MT.MeteoricBlackSteel.mBoilingPoint + 500)
            .setGenerifying(MT.MeteoricBlackSteel);
        MT.MeteoflameBlueSteel = MT
            .alloymachine(
                8695,
                "Meteoflame Blue Steel",
                SET_FIERY,
                95,
                95,
                135,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_ACTIVE,
                MOLTEN,
                WITHER_PROOF,
                UNBURNABLE,
                BURNING,
                GLOWING,
                AUTO_COLLECTING)
            .qual(3, 13.0, 1408, 4)
            .setMcfg(1, MT.MeteoricBlueSteel, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 3, TC.PRAECANTIO, 1, TC.MAGNETO, 1, TC.ORDO, 1, TC.INSTRUMENTUM, 1)
            .heat(MT.MeteoricBlueSteel.mBoilingPoint - 200, MT.MeteoricBlueSteel.mBoilingPoint + 500)
            .setGenerifying(MT.MeteoricBlueSteel);
        MT.MeteoflameRedSteel = MT
            .alloymachine(
                8696,
                "Meteoflame Red Steel",
                SET_FIERY,
                135,
                95,
                95,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_ACTIVE,
                MOLTEN,
                WITHER_PROOF,
                UNBURNABLE,
                BURNING,
                GLOWING,
                AUTO_COLLECTING)
            .qual(3, 14.0, 1536, 4)
            .setMcfg(1, MT.MeteoricRedSteel, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 3, TC.PRAECANTIO, 1, TC.MAGNETO, 1, TC.ORDO, 1, TC.INSTRUMENTUM, 1)
            .heat(MT.MeteoricRedSteel.mBoilingPoint - 200, MT.MeteoricRedSteel.mBoilingPoint + 500)
            .setGenerifying(MT.MeteoricRedSteel);
        MT.FlamascusSteel = MT
            .alloymachine(
                8697,
                "Flamascus Steel",
                SET_FIERY,
                110,
                110,
                110,
                MAGICAL,
                CENTRIFUGE,
                MAGNETIC_PASSIVE,
                MOLTEN,
                WITHER_PROOF,
                UNBURNABLE,
                BURNING,
                GLOWING)
            .qual(3, 12.0, 1280, 4)
            .setMcfg(1, MT.DamascusSteel, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 3, TC.PRAECANTIO, 1, TC.ORDO, 1, TC.INSTRUMENTUM, 1, TC.TELUM, 1)
            .heat(MT.DamascusSteel.mBoilingPoint - 200, MT.DamascusSteel.mBoilingPoint + 500)
            .setGenerifying(MT.DamascusSteel);
        MT.Thaumium = MT.alloymachore(8679, "Thaumium", 150, 100, 200, MAGICAL, CENTRIFUGE, MAGNETIC_PASSIVE, MOLTEN)
            .qual(3, 12.0, 256, 3)
            .setMcfg(1, MT.Fe, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.PRAECANTIO, 1)
            .heat(MT.Fe.mMeltingPoint + 500, MT.Fe.mBoilingPoint + 1000)
            .setGenerifying(MT.Fe);
        MT.DarkThaumium = MT
            .alloymachine(8680, "Dark Thaumium", 100, 75, 75, MAGICAL, CENTRIFUGE, MAGNETIC_PASSIVE, MOLTEN, WARPING)
            .qual(3, 12.0, 512, 3)
            .aspects(TC.METALLUM, 2, TC.TENEBRAE, 1)
            .heat(MT.Thaumium)
            .setGenerifying(MT.Thaumium);
        MT.VoidMetal = MT.alloymachine(8681, "Void Metal", 30, 10, 30, MAGICAL, CENTRIFUGE, "Void", MOLTEN, WARPING)
            .qual(3, 12.0, 2048, 4)
            .aspects(TC.METALLUM, 7, TC.TENEBRAE, 8, TC.VACUOS, 8, TC.ALIENIS, 2, TC.HERBA, 1)
            .heat(3000, 5000);
        MT.Osmiridium = MT.alloymachine(8682, "Osmiridium", 100, 100, 255, VALUABLE, MOLTEN)
            .qual(3, 11.0, 3840, 4)
            .uumAloy(0, MT.Os, 1 * U, MT.Ir, 1 * U)
            .aspects(TC.METALLUM, 2, TC.MACHINA, 2, TC.NEBRISUM, 1);
        MT.Sunnarium = MT.slloymachine(8683, "Sunnarium", 255, 255, 0, GLOWING, LIGHTING);
        MT.ChromiumDioxide = MT.alloy(8685, "Chromium Dioxide", SET_DULL, 10, 20, 10, ELECTROLYSER, MAGNETIC_PASSIVE)
            .uumMcfg(1, MT.Cr, 1 * U, MT.O, 2 * U)
            .aspects(TC.METALLUM, 2, TC.FABRICO, 1)
            .qual(3, 11.0, 256, 3)
            .heat(650);
        MT.CrO2 = MT.ChromiumDioxide;
        MT.VanadiumGallium = MT.slloy(8686, "Vanadium-Gallium", 128, 128, 140, BRITTLE)
            .uumAloy(0, MT.V, 3 * U, MT.Ga, 1 * U);
        MT.YttriumBariumCuprate = MT.alloy(8687, "Yttrium-Barium-Cuprate", 80, 64, 70, BRITTLE, ELECTROLYSER, LAYERED)
            .uumMcfg(6, MT.Y, 1 * U, MT.Ba, 2 * U, MT.Cu, 3 * U, MT.O, 7 * U)
            .heat(1200);
        MT.NiobiumNitride = MT.alloy(8688, "Niobium Nitride", SET_DULL, 29, 41, 29, BRITTLE, ELECTROLYSER)
            .uumMcfg(0, MT.Nb, 1 * U, MT.N, 1 * U)
            .heat(2573);
        // Anti-Reflective Material
        MT.NiobiumTitanium = MT.alloy(8689, "Niobium Titanium", SET_DULL, 29, 29, 41, BRITTLE)
            .uumAloy(0, MT.Nb, 1 * U, MT.Ti, 1 * U);
        MT.AluminiumBrass = MT
            .clloymachine(
                8700,
                "Aluminium Brass",
                220,
                220,
                130,
                FURNACE,
                EXTRUDER_SIMPLE,
                MORTAR,
                MOLTEN,
                "AluminumBrass")
            .qual(2, 6.0, 64, 2)
            .uumAloy(0, MT.Al, 3 * U, MT.Cu, 1 * U)
            .aspects(TC.STRONTIO, 1);
        MT.Ardite = MT.cetalore(8707, "Ardite", 200, 120, 20, MOLTEN)
            .qual(2, 6.0, 64, 3)
            .aspects(TC.STRONTIO, 1);
        MT.Alumite = MT.clloymachine(8702, "Alumite", 230, 100, 230, MOLTEN)
            .qual(2, 1.5, 64, 3)
            .setAloy(9, MT.Al2O3, 5 * U, MT.WroughtIron, 2 * U, MT.Obsidian, 18 * U)
            .aspects(TC.STRONTIO, 2);
        MT.Manyullyn = MT.clloymachine(8703, "Manyullyn", 175, 100, 175, MOLTEN)
            .qual(2, 2.0, 96, 3)
            .setAloy(0, MT.Co, 1 * U, MT.Ardite, 1 * U)
            .aspects(TC.STRONTIO, 2);
        MT.VibraniumSteel = MT
            .slloymachine(8704, "Vibranium Steel", 40, 24, 50, CENTRIFUGE, UNBURNABLE, MAGNETIC_PASSIVE)
            .qual(3, 50.0, 2048, 10)
            .uumAloy(0, MT.Vb, 1 * U, MT.Steel, 3 * U)
            .aspects(TC.SENSUS, 1, TC.VITREUS, 1, TC.METALLUM, 1);
        MT.VibraniumSilver = MT
            .slloy(8705, "Vibranium Silver", 240, 240, 255, CENTRIFUGE, UNBURNABLE, ENDER_DRAGON_PROOF)
            .qual(3, 100.0, 512, 9)
            .uumAloy(0, MT.Vb, 1 * U, MT.Ag, 3 * U)
            .aspects(TC.SENSUS, 1, TC.VITREUS, 1, TC.LUCRUM, 1);
        MT.Vibramantium = MT.slloymachine(8706, "Vibramantium", 250, 250, 250, CENTRIFUGE, UNBURNABLE, MAGNETIC_PASSIVE)
            .qual(3, 1000.0, 5120, 15)
            .uumAloy(0, MT.Vb, 1 * U, MT.Ad, 3 * U)
            .aspects(TC.SENSUS, 1, TC.VITREUS, 1, TC.PRAECANTIO, 1, TC.METALLUM, 1);
        MT.Signalum = MT.clloymachine(8708, "Signalum", 255, 64, 0, MOLTEN, FURNACE, EXTRUDER_SIMPLE, SOFT)
            .uumAloy(8, MT.Cu, 1 * U, MT.Ag, 2 * U, MT.RedAlloy, 5 * U)
            .aspects(TC.METALLUM, 3, TC.POTENTIA, 1);
        MT.Lumium = MT
            .clloymachine(8709, "Lumium", 255, 255, 80, MOLTEN, FURNACE, EXTRUDER_SIMPLE, SOFT, LIGHTING, GLOWING)
            .uumAloy(4, MT.Sn, 3 * U, MT.Ag, 1 * U, MT.Glowstone, 4 * U)
            .aspects(TC.METALLUM, 3, TC.LUX, 1);
        MT.EnderiumBase = MT.clloymachine(8729, "Enderium Base", 53, 85, 108, MOLTEN)
            .uumAloy(4, MT.Sn, 2 * U, MT.Ag, 1 * U, MT.Pt, 1 * U)
            .aspects(TC.METALLUM, 3);
        MT.Enderium = MT.clloymachine(8710, "Enderium", 60, 125, 115, MAGICAL, MOLTEN)
            .qual(3, 8.0, 256, 3)
            .setAloy(1, MT.EnderiumBase, 1 * U, MT.EnderPearl, 1 * U)
            .aspects(TC.METALLUM, 3, TC.ALIENIS, 1);
        // InfusedGold = slloymachore ( 8712, "Infused Gold" , 255, 200, 60 , SOFT).qual(2, 12.0, 64, 3) ,
        MT.RefinedGlowstone = MT.alloynd(8713, "GlowstoneRefined", SET_REDSTONE, 255, 240, 100, GLOWING)
            .setLocal("Refined Glowstone")
            .qual(2, 8.0, 256, 2)
            .setMcfg(1, MT.Glowstone, 1 * U, MT.Ge, 1 * U)
            .aspects(TC.METALLUM, 4, TC.LUX, 4)
            .setAllToTheOutputOf(MT.Glowstone);
        MT.RefinedObsidian = MT.alloy(8714, "ObsidianRefined", SET_REDSTONE, 120, 90, 140)
            .setLocal("Refined Obsidian")
            .qual(2, 8.0, 512, 3)
            .setMcfg(1, MT.Obsidian, 1 * U, MT.Diamond, 1 * U)
            .aspects(TC.VITREUS, 4, TC.IGNIS, 4)
            .setAllToTheOutputOf(MT.Obsidian);
        MT.Yellorium = MT.setalore(8715, "Yellorium", 140, 130, 20)
            .aspects(TC.RADIO, 2);
        MT.Blutonium = MT.setalore(8716, "Blutonium", 60, 60, 180)
            .aspects(TC.RADIO, 3);
        MT.Cyanite = MT.setalore(8717, "Cyanite", 50, 110, 150)
            .aspects(TC.RADIO, 1);
        MT.Ludicrite = MT.setalore(8723, "Ludicrite", 180, 120, 150)
            .aspects(TC.RADIO, 5);
        MT.Yellorite = MT.oredustelec(8724, "Yellorite", SET_METALLIC, 150, 140, 40, 255, BLACKLISTED_SMELTER)
            .setSmelting(MT.Yellorium, U3)
            .setMcfg(1, MT.Yellorium, 1 * U, MT.O, 2 * U)
            .aspects(TC.RADIO, 1);
        MT.Bedrock_HSLA_Alloy = MT
            .alloy(8718, "Bedrock-HSLA-Alloy", SET_BRICK, 64, 64, 64, CENTRIFUGE, MAGNETIC_PASSIVE)
            .setMcfg(1, MT.Bedrock, 4 * U, MT.HSLA, 1 * U)
            .aspects(TC.TERRA, 5)
            .qual(3, 10.0, 2560, 5)
            .heat(4000);
        MT.ObsidianSteel = MT
            .alloy(8731, "Obsidian Steel", 60, 60, 60, MAGNETIC_PASSIVE, RAILS, UNBURNABLE, "DarkSteel", MD.TG)
            .qual(MT.Steel)
            .setAloy(1, MT.Steel, 1 * U, MT.Obsidian, 9 * U)
            .aspects(TC.METALLUM, 3, TC.TENEBRAE, 1);
        MT.PulsatingIron = MT.alloy(8725, "Pulsating Iron", 100, 160, 110, MAGNETIC_PASSIVE, "PhasedIron")
            .qual(MT.WroughtIron)
            .setAloy(1, MT.WroughtIron, 1 * U, MT.EnderPearl, 1 * U)
            .aspects(TC.METALLUM, 3, TC.ALIENIS, 1);
        MT.EnergeticAlloy = MT.alloy(8728, "Energetic Alloy", SET_DULL, 200, 120, 50)
            .qual(MT.Au)
            .uumAloy(1, MT.InductiveAlloy, 2 * U, MT.Glowstone, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 1, TC.LUX, 1);
        MT.VibrantAlloy = MT.slloy(8726, "Vibrant Alloy", 160, 170, 70, "PhasedGold", "Vibrant")
            .qual(MT.EnergeticAlloy)
            .setAloy(1, MT.EnergeticAlloy, 1 * U, MT.EnderPearl, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 1, TC.LUX, 1, TC.ALIENIS, 1);
        MT.ElectricalSteel = MT.alloy(8730, "Electrical Steel", 140, 140, 140, MAGNETIC_PASSIVE)
            .qual(MT.Steel)
            .uumAloy(1, MT.Steel, 1 * U, MT.Si, 1 * U)
            .aspects(TC.METALLUM, 3, TC.ELECTRUM, 1);
        MT.Soularium = MT.alloy(8732, "Soularium", SET_DULL, 90, 70, 50)
            .qual(3, 15.0, 128, 2)
            .setAloy(1, MT.SoulSand, 9 * U, MT.Au, 1 * U)
            .aspects(TC.METALLUM, 3, TC.SPIRITUS, 1);
        MT.CrudeSteel = MT.alloy(8806, "Clay Compound", SET_BRICK, 132, 127, 123, "CrudeSteel")
            .setAloy(1, MT.Stone, 2 * U, MT.Ceramic, 1 * U)
            .aspects(TC.TERRA, 4);
        MT.EndSteel = MT.alloy(8807, "End Steel", 164, 157, 116)
            .setAloy(1, MT.Endstone, 1 * U, MT.ObsidianSteel, 1 * U, MT.Obsidian, 9 * U)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 1);
        MT.MelodicAlloy = MT.alloy(8809, "Melodic Alloy", 138, 92, 138)
            .setAloy(1, MT.EndSteel, 1 * U, MT.EnderEye, 1 * U)
            .aspects(TC.METALLUM, 2, TC.SENSUS, 1);
        MT.StellarAlloy = MT.alloy(8810, "Stellar Alloy", 170, 181, 164)
            .setAloy(2, MT.MelodicAlloy, 1 * U, MT.NetherStar, 1 * U, MT.Clay, 4 * U)
            .aspects(TC.METALLUM, 2, TC.AURAM, 1);
        MT.VividAlloy = MT.alloy(8811, "Vivid Alloy", 60, 139, 160)
            .setAloy(1, MT.EnergeticSilver, 1 * U, MT.EnderPearl, 1 * U)
            .aspects(TC.METALLUM, 2, TC.LUX, 1);
        MT.CrystallineAlloy = MT.slloy(8812, "Crystalline Alloy", 109, 169, 169)
            .aspects(TC.METALLUM, 2, TC.VITREUS, 1);
        MT.CrystallinePinkSlime = MT.slloy(8813, "Crystalline Pink Slime", 176, 112, 166)
            .aspects(TC.METALLUM, 2, TC.VITREUS, 1, TC.LIMUS, 1);
        MT.SpectreIron = MT
            .clloymachine_(8734, "Spectre Iron", 150, 200, 200, 200, MAGNETIC_PASSIVE, MAGICAL, MOLTEN, GLOWING)
            .qual(3, 8.5, 768, 2)
            .setAloy(1, MT.WroughtIron, 1 * U, MT.Ectoplasm, 1 * U)
            .aspects(TC.METALLUM, 3, TC.SPIRITUS, 3)
            .heat(MT.Fe)
            .setGenerifying(MT.Fe);
        MT.Manasteel = MT.slloymachine(8720, "Manasteel", 110, 200, 250, MAGICAL)
            .setMcfg(1, MT.Fe, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.METALLUM, 2, TC.PRAECANTIO, 2)
            .steal(MT.Steel)
            .qual(3, 12.0, 256, 3)
            .heat(MT.Fe.mMeltingPoint + 500, MT.Fe.mBoilingPoint + 1000)
            .setGenerifying(MT.Fe);
        MT.Terrasteel = MT.slloymachine(8721, "Terrasteel", 110, 200, 50, MAGICAL, UNBURNABLE)
            .aspects(TC.METALLUM, 2, TC.PRAECANTIO, 2)
            .steal(MT.Steel)
            .qual(3, 16.0, 2048, 4)
            .heat(MT.Fe.mMeltingPoint + 750, MT.Fe.mBoilingPoint + 1500);
        MT.ElvenElementium = MT.slloymachore(8722, "Elven Elementium", 250, 120, 250, MAGICAL, UNBURNABLE, "Elementium")
            .aspects(TC.METALLUM, 2, TC.PRAECANTIO, 2)
            .steal(MT.Steel)
            .qual(3, 14.0, 512, 3)
            .heat(MT.Fe.mMeltingPoint + 1000, MT.Fe.mBoilingPoint + 2000)
            .setLocal("Elementium");
        MT.GaiaSpirit = MT.slloymachine(8735, "Gaia Spirit", 250, 250, 250, MAGICAL, UNBURNABLE, GLOWING)
            .qual(3, 20.0, 2048, 4)
            .aspects(TC.AURAM, 4, TC.SPIRITUS, 4, TC.PRAECANTIO, 4)
            .heat(MT.W.mMeltingPoint + 250, MT.W.mBoilingPoint + 500);
        MT.Endium = MT.metalore(8736, "Endium", SET_SHINY, 169, 215, 254, MAGICAL, "HeeEndium")
            .qual(3, 12.0, 256, 3)
            .aspects(TC.METALLUM, 1, TC.ALIENIS, 3);
        MT.Mauftrium = MT.slloymachore(8739, "Mauftrium", 250, 225, 121, MAGICAL)
            .qual(3, 12.0, 1024, 3)
            .aspects(TC.METALLUM, 2, TC.PRAECANTIO, 1)
            .heat(MT.Fe.mMeltingPoint, MT.Fe.mBoilingPoint);
        MT.Elvorium = MT.slloymachore(8740, "Elvorium", 235, 164, 77, MAGICAL)
            .qual(3, 14.0, 2048, 3)
            .setMcfg(1, MT.ElvenElementium, 1 * U, MT.ElvenDragonstone, 1 * U)
            .aspects(TC.METALLUM, 2, TC.PRAECANTIO, 4)
            .heat(MT.Fe.mMeltingPoint + 1000, MT.Fe.mBoilingPoint + 2000);
        MT.NiflheimPower = MT.slloy(8741, "Niflheim Power", 94, 94, 174, MAGICAL, GLOWING, UNBURNABLE)
            .qual(3, 18.0, 2048, 3)
            .setMcfg(1, MT.Elvorium, 1 * U)
            .aspects(TC.METALLUM, 2, TC.GELUM, 2, TC.POTENTIA, 2);
        MT.MuspelheimPower = MT.slloy(8742, "Muspelheim Power", 174, 94, 94, MAGICAL, GLOWING, UNBURNABLE, BURNING)
            .qual(3, 18.0, 2048, 3)
            .setMcfg(1, MT.Elvorium, 1 * U)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 2, TC.POTENTIA, 2);
        MT.Iffesal = MT.oredust(8743, "Iffesal", SET_SHINY, 14, 25, 171, 255, MAGICAL)
            .aspects(TC.METALLUM, 2, TC.PRAECANTIO, 4);
        MT.AncientDebris = MT
            .metalore(
                8744,
                "Ancient Debris",
                SET_SPACE,
                110,
                80,
                90,
                "Ancient",
                UNBURNABLE,
                MAGNETIC_PASSIVE,
                WITHER_PROOF,
                MOLTEN,
                VALUABLE,
                WASHING_MERCURY)
            .qual(0, 1.0, 16, 3)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 2)
            .heat(MT.MeteoricIron);
        MT.Netherite = MT
            .alloymachine(
                8745,
                "Netherite",
                80,
                70,
                80,
                UNBURNABLE,
                MAGNETIC_ACTIVE,
                WITHER_PROOF,
                MOLTEN,
                VALUABLE,
                AUTO_COLLECTING)
            .qual(2, 10.0, 500, 4)
            .setAloy(1, MT.Au, 4 * U, MT.AncientDebris, 4 * U)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 2, TC.LUCRUM, 2)
            .heat(MT.MeteoricSteel);
        MT.NetherizedDiamond = MT
            .alloymachine(
                8746,
                "Netherized Diamond",
                SET_DIAMOND,
                90,
                80,
                90,
                G_GEM,
                UNBURNABLE,
                MAGNETIC_ACTIVE,
                WITHER_PROOF,
                COATED,
                VALUABLE,
                AUTO_COLLECTING)
            .qual(3, 12.0, 2560, 4)
            .setMcfg(4, MT.Netherite, 1 * U, MT.Diamond, 4 * U)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 2, TC.LUCRUM, 2, TC.VITREUS, 2)
            .heat(MT.MeteoricSteel);
        MT.Efrine = MT
            .metalore(8747, "Efrine", 80, 107, 72, UNBURNABLE, MAGNETIC_PASSIVE, WITHER_PROOF, MOLTEN, WASHING_MERCURY)
            .qual(3, 9.0, 500, 3)
            .aspects(TC.METALLUM, 2, TC.GELUM, 2)
            .heat(MT.MeteoricSteel);
        MT.Desh = MT.alloymachore(8750, "Desh", SET_DULL, 40, 40, 40, MOLTEN)
            .qual(3, 4.0, 1280, 3)
            .uumAloy(0, MT.B, 2 * U, MT.La, 2 * U, MT.Nd, 1 * U, MT.Nb, 1 * U, MT.Co, 1 * U, MT.Ce, 1 * U, MT.Li, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 1, TC.TELUM, 1);
        MT.DeshAlloy = MT.alloymachine(8780, "Workers Alloy", 216, 42, 42, MOLTEN)
            .qual(3, 7.0, 2560, 2)
            .uumMcfg(4, MT.Desh, 4 * U, MT.Hg, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 1, TC.TELUM, 1);
        MT.DuraniumAlloy = MT.alloymachine(8751, "Duranium", 75, 175, 175)
            .qual(3, 8.0, 1280, 4)
            .uumAloy(0, MT.Dn, 7 * U, MT.Mg, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 2)
            .setLocal("Duranium Alloy");
        // That Info with Magnesium/Magnesite was pretty hard to find, but I found it!
        MT.TritaniumAlloy = MT.alloymachine(8752, "Tritanium", 55, 155, 155)
            .qual(3, 12.0, 2560, 5)
            .uumAloy(0, MT.Tn, 3 * U, MT.Dn, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 3, TC.VITREUS, 1)
            .setLocal("Tritanium Alloy");
        MT.Dolamide = MT.oredust(8753, "Dolamide", SET_METALLIC, 188, 100, 122, 255)
            .aspects(TC.POTENTIA, 3, TC.RADIO, 2);
        MT.Oriharukon = MT.metalmachore(8754, "Oriharukon", 220, 220, 240)
            .qual(3, 8.0, 2560, 2)
            .aspects(TC.METALLUM, 2, TC.MACHINA, 2);
        MT.Adamantite = MT.metalmachore(8755, "Adamantite", 255, 255, 190)
            .qual(3, 6.0, 2560, 3)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 2);
        MT.Duralumin = MT.alloymachine(8756, "Duralumin", SET_DULL, 255, 255, 220)
            .qual(3, 10.0, 512, 2)
            .uumMcfg(0, MT.Al, 1 * U, MT.Cu, 1 * U)
            .aspects(TC.METALLUM, 2, TC.PERMUTATIO, 1, TC.VOLATUS, 1);
        MT.Meteorite = MT
            .metalmachore(
                8757,
                "Meteorite",
                SET_SPACE,
                222,
                100,
                222,
                MOLTEN,
                MAGNETIC_ACTIVE,
                AUTO_COLLECTING,
                RAILS,
                DECOMPOSABLE)
            .uumMcfg(0, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1, TC.ALIENIS, 1)
            .steal(MT.MeteoricIron)
            .qual(3, 8.0, 1200, 3)
            .setGenerifying(MT.Fe);
        MT.FrozenIron = MT.metalmachore(8758, "Frozen Iron", SET_DULL, 235, 235, 255, DECOMPOSABLE, MAGNETIC_PASSIVE)
            .uumMcfg(0, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 2, TC.GELUM, 2)
            .steal(MT.Fe)
            .setSmelting(MT.Fe, U)
            .setForging(MT.Fe, U);
        MT.Kreknorite = MT.metalmachore(8759, "Kreknorite", SET_SPACE, 128, 0, 0, MOLTEN, TICKS_PER_SMELT * 18)
            .aspects(TC.METALLUM, 2, TC.IGNIS, 2)
            .qual(3, 8.0, 1200, 3)
            .heat(MT.MeteoricSteel.mMeltingPoint + 200, MT.MeteoricSteel.mBoilingPoint + 200);
        MT.Syrmorite = MT.metalmachore(8785, "Syrmorite", SET_DULL, 80, 80, 199, MOLTEN, SOFT)
            .aspects(TC.METALLUM, 2, TC.MORTUUS, 1)
            .qual(2, 6.0, 500, 1)
            .heat(MT.Au);
        MT.Octine = MT.metalmachore(8786, "Octine", 255, 128, 32, MOLTEN, MAGICAL, GLOWING, UNBURNABLE, BURNING)
            .aspects(TC.METALLUM, 2, TC.MORTUUS, 1)
            .qual(3, 8.0, 900, 2)
            .heat(MT.Steel.mBoilingPoint - 200, MT.Steel.mBoilingPoint + 500);
        MT.HSSG = MT.alloymachine(8796, "HSS-G", 153, 153, 0, RAILS, MOLTEN, UNBURNABLE)
            .qual(3, 10.0, 4000, 3)
            .uumAloy(0, MT.TungstenSteel, 5 * U, MT.Cr, 1 * U, MT.Mo, 2 * U, MT.V, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 1, TC.MACHINA, 1);
        MT.HSSE = MT.alloymachine(8797, "HSS-E", 51, 102, 0, RAILS, MOLTEN, UNBURNABLE)
            .qual(3, 10.0, 5120, 4)
            .uumAloy(0, MT.HSSG, 6 * U, MT.Co, 1 * U, MT.Mn, 1 * U, MT.Si, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 2, TC.MACHINA, 2);
        MT.HSSS = MT.alloymachine(8798, "HSS-S", 102, 0, 51, RAILS, MOLTEN, UNBURNABLE)
            .qual(3, 14.0, 3000, 4)
            .uumAloy(0, MT.HSSG, 6 * U, MT.Osmiridium, 2 * U, MT.Ir, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 2, TC.MACHINA, 2, TC.NEBRISUM, 1);
        MT.Bedrockium = MT
            .metalmachore(8795, "Bedrockium", SET_ROUGH, 88, 88, 88, UNBURNABLE, WITHER_PROOF, ENDER_DRAGON_PROOF)
            .aspects(TC.METALLUM, 1, TC.TERRA, 10)
            .heat(2000);
        MT.Draconium = MT
            .metalmachore(
                8791,
                "Draconium",
                150,
                50,
                250,
                UNBURNABLE,
                WITHER_PROOF,
                ENDER_DRAGON_PROOF,
                VALUABLE,
                MOLTEN)
            .qual(3, 16.0, 5000, 4)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 1)
            .heat(4500);
        MT.DraconiumAwakened = MT
            .alloymachine(
                8792,
                "DraconiumAwakened",
                250,
                150,
                50,
                UNBURNABLE,
                WITHER_PROOF,
                ENDER_DRAGON_PROOF,
                VALUABLE,
                MOLTEN,
                GLOWING)
            .qual(3, 24.0, 10000, 5)
            .setMcfg(1, MT.Draconium, 1 * U)
            .aspects(TC.METALLUM, 2, TC.ALIENIS, 4)
            .heat(5500)
            .setLocal("Awakened Draconium");
        MT.CrystalMatrix = MT
            .slloymachine(
                8799,
                "Crystal Matrix",
                83,
                231,
                234,
                UNBURNABLE,
                WITHER_PROOF,
                ENDER_DRAGON_PROOF,
                VALUABLE,
                MAGICAL)
            .qual(3, 20.0, 25600, 4)
            .setMcfg(1, MT.Diamond, 20 * U, MT.NetherStar, 2 * U)
            .aspects(TC.VITREUS, 8, TC.PRAECANTIO, 4, TC.NEBRISUM, 4)
            .heat(3896, 5127);
        MT.CosmicNeutronium = MT
            .setalmachine(
                8800,
                "Cosmic Neutronium",
                30,
                10,
                40,
                UNBURNABLE,
                WITHER_PROOF,
                ENDER_DRAGON_PROOF,
                VALUABLE,
                MAGICAL)
            .qual(3, 50.0, 100000, 10)
            .aspects(TC.POTENTIA, 10, TC.NEBRISUM, 10, TC.RADIO, 10, TC.TENEBRAE, 10, TC.TERRA, 10)
            .heat(100000);
        MT.Infinity = MT
            .setalmachine(
                8801,
                "Infinity",
                250,
                250,
                250,
                UNBURNABLE,
                WITHER_PROOF,
                ENDER_DRAGON_PROOF,
                VALUABLE,
                MAGICAL,
                GLOWING,
                LIGHTING,
                MAGNETIC_ACTIVE,
                AUTO_COLLECTING)
            .qual(3, 1000000000.0, 1000000000, 15)
            .aspects(
                TC.POTENTIA,
                10,
                TC.NEBRISUM,
                10,
                TC.PERMUTATIO,
                10,
                TC.MAGNETO,
                10,
                TC.PRAECANTIO,
                10,
                TC.AURAM,
                10)
            .heat(100000);
        MT.Unstable = MT
            .setal(
                8805,
                "Unstable",
                255,
                255,
                255,
                128,
                AUTO_BLACKLIST,
                EXPLODES_IN_NONVANILLA_CRAFTING_GRID,
                "Unstableingot")
            .aspects(TC.PERDITIO, 4);
        MT.Trinaquadalloy = MT.alloymachine(8684, "Trinaquadalloy", 146, 186, 146, CENTRIFUGE, "NaquadahAlloy")
            .qual(3, 14.0, 20480, 5)
            .uumAloy(0, MT.Ke, 6 * U, MT.Nq, 2 * U, MT.C, 1 * U)
            .aspects(TC.METALLUM, 3, TC.TUTAMEN, 3, TC.NEBRISUM, 1);
        MT.Trinitanium = MT.clloymachine(8790, "Trinitanium", 235, 175, 255)
            .qual(3, 16.0, 5120, 4)
            .uumAloy(0, MT.Ke, 2 * U, MT.Ti, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 2, TC.VITREUS, 2);
        MT.Iritanium = MT.alloymachine(8793, "Titanium Iridium", 220, 220, 255, "Iritanium")
            .qual(3, 8.0, 7680, 4)
            .uumAloy(0, MT.Ir, 1 * U, MT.Ti, 1 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 1, TC.MACHINA, 1)
            .setLocal("Iritanium");
        MT.TitaniumAluminide = MT.alloymachine(8794, "Titanium Aluminide", 200, 200, 255)
            .qual(3, 12.0, 3840, 3)
            .uumAloy(3, MT.Ti, 3 * U, MT.Al, 7 * U)
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 1, TC.VOLATUS, 1);
    }
}
