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
import gregapi.oredict.OreDictItemData;
import gregapi.oredict.OreDictMaterial;

/**
 * The OrePrefix based Item Data and the Tool Material lists of every Tier.
 * <p>
 * Loaded as the "Item Data" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsItemData implements IMaterialCategory {

    @Override
    public String getName() {
        return "Item Data";
    }

    @Override
    public void load() {
        MT.DATA.WIRES_01 = new OreDictItemData[] { OP.wireGt01.dat(MT.Pb), OP.wireGt01.dat(MT.Sn),

            OP.wireGt01.dat(ANY.Cu), OP.wireGt01.dat(MT.Au), OP.wireGt01.dat(MT.Al), OP.wireGt01.dat(MT.Pt),

            OP.wireGt01.dat(MT.Graphene), OP.wireGt01.dat(MT.Graphene), OP.wireGt01.dat(MT.Graphene),
            OP.wireGt01.dat(MT.Graphene),

            OP.wireGt01.dat(MT.Graphene), OP.wireGt01.dat(MT.Superconductor), OP.wireGt01.dat(MT.Superconductor),

            OP.wireGt01.dat(MT.Superconductor), OP.wireGt01.dat(MT.Superconductor),
            OP.wireGt01.dat(MT.Superconductor) };
        MT.DATA.WIRES_04 = new OreDictItemData[] { OP.wireGt04.dat(MT.Pb), OP.wireGt04.dat(MT.Sn),
            OP.wireGt04.dat(ANY.Cu), OP.wireGt04.dat(MT.Au),

            OP.wireGt04.dat(MT.Al), OP.wireGt04.dat(MT.Pt), OP.wireGt04.dat(MT.Graphene), OP.wireGt04.dat(MT.Graphene),

            OP.wireGt04.dat(MT.Graphene), OP.wireGt04.dat(MT.Graphene), OP.wireGt04.dat(MT.Graphene),

            OP.wireGt04.dat(MT.Superconductor), OP.wireGt04.dat(MT.Superconductor), OP.wireGt04.dat(MT.Superconductor),

            OP.wireGt04.dat(MT.Superconductor), OP.wireGt04.dat(MT.Superconductor) };
        MT.DATA.CABLES_01 = new OreDictItemData[] { OP.cableGt01.dat(MT.Pb), OP.cableGt01.dat(MT.Sn),
            OP.cableGt01.dat(ANY.Cu), OP.cableGt01.dat(MT.Au),

            OP.cableGt01.dat(MT.Al), OP.cableGt01.dat(MT.Pt), OP.wireGt01.dat(MT.Graphene),
            OP.wireGt01.dat(MT.Graphene),

            OP.wireGt01.dat(MT.Graphene), OP.wireGt01.dat(MT.Graphene), OP.wireGt01.dat(MT.Graphene),

            OP.wireGt01.dat(MT.Superconductor), OP.wireGt01.dat(MT.Superconductor), OP.wireGt01.dat(MT.Superconductor),

            OP.wireGt01.dat(MT.Superconductor), OP.wireGt01.dat(MT.Superconductor) };
        MT.DATA.CABLES_04 = new OreDictItemData[] { OP.cableGt04.dat(MT.Pb), OP.cableGt04.dat(MT.Sn),
            OP.cableGt04.dat(ANY.Cu), OP.cableGt04.dat(MT.Au),

            OP.cableGt04.dat(MT.Al), OP.cableGt04.dat(MT.Pt), OP.wireGt04.dat(MT.Graphene),
            OP.wireGt04.dat(MT.Graphene),

            OP.wireGt04.dat(MT.Graphene), OP.wireGt04.dat(MT.Graphene), OP.wireGt04.dat(MT.Graphene),

            OP.wireGt04.dat(MT.Superconductor), OP.wireGt04.dat(MT.Superconductor), OP.wireGt04.dat(MT.Superconductor),

            OP.wireGt04.dat(MT.Superconductor), OP.wireGt04.dat(MT.Superconductor) };
        MT.DATA.CIRCUITS = new OreDictItemData[] { OP.circuit.dat(MT.Primitive), OP.circuit.dat(MT.Basic),
            OP.circuit.dat(MT.Good),

            OP.circuit.dat(MT.Advanced), OP.circuit.dat(MT.Elite), OP.circuit.dat(MT.Master),
            OP.circuit.dat(MT.Ultimate),

            OP.circuit.dat(MT.Quantum), OP.circuit.dat(MT.Quantum), OP.circuit.dat(MT.Quantum),
            OP.circuit.dat(MT.Quantum),

            OP.circuit.dat(MT.Quantum), OP.circuit.dat(MT.Quantum), OP.circuit.dat(MT.Quantum),
            OP.circuit.dat(MT.Quantum),

            OP.circuit.dat(MT.Quantum) };;
        MT.DATA.Dye_Materials = new OreDictMaterial[] { MT.Black, MT.Red, MT.Green, MT.Brown, MT.Blue, MT.Purple,
            MT.Cyan, MT.LightGray,

            MT.Gray, MT.Pink, MT.Lime, MT.Yellow, MT.LightBlue, MT.Magenta, MT.Orange, MT.White };
        MT.DATA.Heat_T = new OreDictMaterial[] { ANY.Stone, ANY.Steel, MT.Invar, MT.Ti, MT.TungstenCarbide, ANY.W,
            ANY.W, ANY.W, ANY.W, ANY.W, ANY.W,

            ANY.W, ANY.W, ANY.W, ANY.W, ANY.W };
        MT.DATA.Kinetic_T = new OreDictMaterial[] { ANY.Wood, MT.Bronze, ANY.Steel, MT.Ti, MT.TungstenSteel, MT.Ir,
            MT.Os, MT.Os, MT.Os, MT.Os, MT.Os, MT.Os, MT.Os, MT.Os, MT.Os, MT.Os };
        MT.DATA.Electric_T = new OreDictMaterial[] { MT.TinAlloy, MT.SteelGalvanized, MT.Al, MT.StainlessSteel, MT.Cr,
            MT.Ti, MT.Ir, MT.Os, MT.Trinitanium, MT.Trinaquadalloy,

            MT.Neutronium, MT.Neutronium, MT.Neutronium, MT.Neutronium, MT.Neutronium, MT.Neutronium };
        MT.DATA.Flux_T = new OreDictMaterial[] { MT.Sn, MT.Pb, MT.Invar, MT.Electrum, MT.EnderiumBase, MT.Enderium,
            MT.TungstenCarbide, MT.TungstenCarbide,

            MT.TungstenCarbide, MT.TungstenCarbide, MT.TungstenCarbide, MT.TungstenCarbide, MT.TungstenCarbide,
            MT.TungstenCarbide,

            MT.TungstenCarbide, MT.TungstenCarbide };;
    }
}
