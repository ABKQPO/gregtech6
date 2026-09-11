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
 * The deprecated Aliases that are kept so Mods which used the old full length Material names keep working.
 * <p>
 * Loaded as the "Deprecated Aliases" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsAliases implements IMaterialCategory {

    @Override
    public String getName() {
        return "Deprecated Aliases";
    }

    @Override
    public void load() {
        MT.Trinium = MT.Ke;
        MT.Vibranium = MT.Vb;
        MT.Naquadah = MT.Nq;
        MT.NaquadahEnriched = MT.Nq_528;
        MT.Naquadria = MT.Nq_522;
        MT.FakeOsmium = MT.Ge;
        MT.Adamantium = MT.Ad;
        MT.Silver = MT.Ag;
        MT.Aluminium = MT.Al;
        MT.Bismuth = MT.Bi;
        MT.Lead = MT.Pb;
        MT.Argon = MT.Ar;
        MT.Copper = MT.Cu;
        MT.Gold = MT.Au;
        MT.Iron = MT.Fe;
        MT.Titanium = MT.Ti;
        MT.Calcite = MT.CaCO3;
        MT.Tungsten = MT.W;
        MT.Beryllium = MT.Be;
        MT.Chromium = MT.Cr;
        MT.Manganese = MT.Mn;
        MT.Cobalt = MT.Co;
        MT.Cobalt60 = MT.Co_60;
        MT.Nickel = MT.Ni;
        MT.Arsenic = MT.As;
        MT.Zirconium = MT.Zr;
        MT.Molybdenum = MT.Mo;
        MT.Technetium = MT.Tc;
        MT.Palladium = MT.Pd;
        MT.Neodymium = MT.Nd;
        MT.Osmium = MT.Os;
        MT.Iridium = MT.Ir;
        MT.Platinum = MT.Pt;
        MT.Thorium = MT.Th;
        MT.Uranium = MT.U_238;
        MT.Uranium235 = MT.U_235;
        MT.Plutonium = MT.Pu;
        MT.Plutonium241 = MT.Pu_241;
        MT.Plutonium243 = MT.Pu_243;
        MT.Americium = MT.Am;
        MT.Americium241 = MT.Am_241;
        MT.Alumina = MT.Al2O3;
        MT.AluminiumFluoride = MT.AlF3;
        MT.AluminiumHydroxide = MT.AlO3H3;
        MT.Gibbsite = MT.AlO3H3;
        MT.Fluorite = MT.CaF2;
        MT.Soapstone = MT.Talc;
        MT.WoodSealed = MT.WoodTreated;
        MT.TeslatineAlloy = MT.NikolineAlloy;
        MT.Teslatite = MT.Nikolite;
        MT.Electrotine = MT.Nikolite;
        MT.Olivine = MT.Peridot;
        MT.SpaceRock = MT.STONES.SpaceRock;
        MT.MoonRock = MT.STONES.MoonRock;
        MT.MoonTurf = MT.STONES.MoonTurf;
        MT.MarsRock = MT.STONES.MarsRock;
        MT.MarsSand = MT.STONES.MarsSand;
        MT.Holystone = MT.STONES.Holystone;
        MT.Livingrock = MT.STONES.Livingrock;
        MT.Deadrock = MT.STONES.Deadrock;
        MT.Betweenstone = MT.STONES.Betweenstone;
        MT.Pitstone = MT.STONES.Pitstone;
        MT.Umber = MT.STONES.Umber;
        MT.Redrock = MT.STONES.Redrock;
        MT.Komatiite = MT.STONES.Komatiite;
        MT.Pumice = MT.STONES.Pumice;
        MT.Gabbro = MT.STONES.Gabbro;
        MT.Basalt = MT.STONES.Basalt;
        MT.Marble = MT.STONES.Marble;
        MT.Limestone = MT.STONES.Limestone;
        MT.Greenschist = MT.STONES.Greenschist;
        MT.Blueschist = MT.STONES.Blueschist;
        MT.Kimberlite = MT.STONES.Kimberlite;
        MT.Quartzite = MT.STONES.Quartzite;
        MT.GraniteRed = MT.STONES.GraniteRed;
        MT.GraniteBlack = MT.STONES.GraniteBlack;
        MT.Granite = MT.STONES.Granite;
        MT.Andesite = MT.STONES.Andesite;
        MT.Diorite = MT.STONES.Diorite;
        MT.Blackstone = MT.STONES.Blackstone;
        MT.Gneiss = MT.STONES.Gneiss;
        MT.Greywacke = MT.STONES.Greywacke;
        MT.Siltstone = MT.STONES.Siltstone;
        MT.Rhyolite = MT.STONES.Rhyolite;
        MT.Migmatite = MT.STONES.Migmatite;
        MT.Chert = MT.STONES.Chert;
        MT.Dacite = MT.STONES.Dacite;
        MT.Shale = MT.STONES.Shale;
        MT.Slate = MT.STONES.Slate;
        MT.Eclogite = MT.STONES.Eclogite;
    }
}
