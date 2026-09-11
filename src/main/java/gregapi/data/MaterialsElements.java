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
 * All the Elements and a few of their Isotopes.
 *
 * I guessed some of the Values for Melting and Boiling Points, because they were not listed in Wikipedia at that
 * time.
 * Those guessed Values are postfixed with an empty Space.
 * <p>
 * Loaded as the "Elements" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsElements implements IMaterialCategory {

    @Override
    public String getName() {
        return "Elements";
    }

    @Override
    public void load() {
        MT.H = MT.hydrogen();
        MT.D = MT.deuterium();
        MT.H_2 = MT.D;
        MT.T = MT.tritium();
        MT.H_3 = MT.T;
        MT.He = MT.helium();
        MT.He_3 = MT.helium3();
        MT.Li = MT.lithium();
        MT.Li_6 = MT.lithium6();
        MT.Be = MT.beryllium()
            .qual(2, 14.0, 64, 2);
        MT.Be_7 = MT.beryllium7();
        MT.Be_8 = MT.beryllium8();
        MT.B = MT.boron();
        MT.B_11 = MT.boron11();
        MT.C = MT.carbon();
        MT.C_13 = MT.carbon13();
        MT.C_14 = MT.carbon14();
        MT.N = MT.nitrogen();
        MT.O = MT.oxygen();
        MT.F = MT.fluorine();
        MT.Ne = MT.neon();
        MT.Na = MT.sodium();
        MT.Mg = MT.magnesium();
        MT.Al = MT.aluminium()
            .qual(2, 10.0, 128, 2);
        MT.Si = MT.silicon()
            .setPriorityPrefix(5);
        MT.P = MT.phosphor();
        MT.S = MT.sulfur()
            .setPriorityPrefix(2);
        MT.Cl = MT.chlorine();
        MT.Ar = MT.argon();
        MT.K = MT.potassium();
        MT.Ca = MT.calcium();
        MT.Sc = MT.scandium();
        MT.Ti = MT.titanium()
            .qual(3, 8.0, 2560, 3);
        MT.V = MT.vanadium();
        MT.Cr = MT.chromium()
            .qual(3, 11.0, 256, 3);
        MT.Mn = MT.manganese()
            .qual(3, 7.0, 256, 2);
        MT.Fe = MT.iron()
            .qual(3, 6.0, 256, 2)
            .setRGBaLiquid(255, 64, 32, 255);
        MT.Co = MT.cobalt()
            .qual(3, 5.0, 256, 3);
        MT.Co_60 = MT.cobalt60()
            .qual(3, 5.0, 256, 3);
        MT.Ni = MT.nickel()
            .qual(2, 6.0, 64, 2);
        MT.Cu = MT.copper()
            .qual(2, 4.0, 64, 0);
        MT.Zn = MT.zinc();
        MT.Ga = MT.gallium();
        MT.Ge = MT.germanium()
            .qual(2, 6.0, 256, 2);
        MT.As = MT.arsenic();
        MT.Se = MT.selenium();
        MT.Br = MT.bromine();
        MT.Kr = MT.krypton();
        MT.Rb = MT.rubidium();
        MT.Sr = MT.strontium();
        MT.Y = MT.yttrium();
        MT.Zr = MT.zirconium()
            .qual(3, 8.0, 1280, 3)
            .lens(DYE_INDEX_White);
        MT.Nb = MT.niobium();
        MT.Mo = MT.molybdenum()
            .qual(3, 7.0, 512, 2);
        MT.Tc = MT.technetium()
            .qual(3, 10.0, 1280, 1);
        MT.Gregorium = MT.Tc;
        MT.Ru = MT.ruthenium();
        MT.Rh = MT.rhodium();
        MT.Pd = MT.palladium()
            .qual(3, 8.0, 512, 2);
        MT.Ag = MT.silver()
            .qual(3, 10.0, 64, 2);
        MT.Cd = MT.cadmium();
        MT.In = MT.indium();
        MT.Sn = MT.tin();
        MT.Sb = MT.antimony();
        MT.Te = MT.tellurium();
        MT.I = MT.iodine();
        MT.Xe = MT.xenon();
        MT.Cs = MT.caesium();
        MT.Ba = MT.barium();
        MT.La = MT.lanthanium();
        MT.Ce = MT.cerium();
        MT.Pr = MT.praseodymium();
        MT.Nd = MT.neodymium()
            .qual(3, 6.0, 512, 3);
        MT.Pm = MT.promethium();
        MT.Sm = MT.samarium();
        MT.Eu = MT.europium();
        MT.Gd = MT.gadolinium();
        MT.Tb = MT.terbium();
        MT.Dy = MT.dysprosium();
        MT.Ho = MT.holmium();
        MT.Er = MT.erbium();
        MT.Tm = MT.thulium();
        MT.Yb = MT.ytterbium();
        MT.Lu = MT.lutetium();
        MT.Hf = MT.hafnium();
        MT.Ta = MT.tantalum();
        MT.W = MT.tungsten()
            .qual(3, 8.0, 5120, 3);
        MT.Re = MT.rhenium();
        MT.Os = MT.osmium()
            .qual(3, 16.0, 1280, 4)
            .setLocal("Osmium");
        MT.Ir = MT.iridium()
            .qual(3, 6.0, 5120, 4)
            .setRGBaLiquid(255, 128, 200, 255);
        MT.Pt = MT.platinum()
            .qual(3, 15.0, 64, 2);
        MT.Au = MT.gold()
            .qual(3, 12.5, 64, 2);
        MT.Au_198 = MT.gold198();
        MT.Hg = MT.mercury();
        MT.Tl = MT.thallium();
        MT.Pb = MT.lead()
            .qual(2, 8.0, 64, 1);
        MT.Bi = MT.bismuth()
            .qual(2, 6.0, 64, 1);
        MT.Po = MT.polonium();
        MT.At = MT.astatine();
        MT.Rn = MT.radon();
        MT.Fr = MT.francium();
        MT.Ra = MT.radium();
        MT.Ac = MT.actinium();
        MT.Th = MT.thorium()
            .qual(3, 6.0, 512, 2);
        MT.Pa = MT.protactinium();
        MT.U_238 = MT.uranium()
            .qual(3, 6.0, 512, 3);
        // No, I could
        // not make a
        // Variable
        // named "U"
        // here. That
        // would
        // collide
        // with the
        // Material
        // Unit.
        MT.U_235 = MT.uranium235()
            .qual(3, 6.0, 512, 3);
        MT.U_233 = MT.uranium233()
            .qual(3, 6.0, 512, 3);
        MT.Np = MT.neptunium();
        MT.Pu = MT.plutonium()
            .qual(3, 6.0, 512, 3);
        MT.Pu_240 = MT.plutonium240()
            .qual(3, 6.0, 512, 3);
        MT.Pu_241 = MT.plutonium241()
            .qual(3, 6.0, 512, 3);
        MT.Pu_243 = MT.plutonium243()
            .qual(3, 6.0, 512, 3);
        MT.Pu_238 = MT.plutonium238()
            .qual(3, 6.0, 512, 3);
        MT.Pu_239 = MT.plutonium239()
            .qual(3, 6.0, 512, 3);
        MT.Am = MT.americium()
            .qual(3, 4.0, 256, 2);
        MT.Am_241 = MT.americium241()
            .qual(3, 4.0, 256, 2);
        MT.Am_242 = MT.americium242()
            .qual(3, 4.0, 256, 2);
        MT.Cm = MT.curium();
        MT.Bk = MT.berkelium();
        MT.Cf = MT.californium();
        MT.Es = MT.einsteinium();
        MT.Fm = MT.fermium();
        MT.Md = MT.mendelevium();
        MT.No = MT.nobelium();
        MT.Lr = MT.lawrencium();
        MT.Rf = MT.rutherfordium();
        MT.Db = MT.dubnium();
        MT.Sg = MT.seaborgium();
        MT.Bh = MT.bohrium();
        MT.Hs = MT.hassium();
        MT.Mt = MT.meitnerium();
        MT.Ds = MT.darmstadtium();
        MT.Rg = MT.roentgenium();
        MT.Cn = MT.copernicium();
        MT.Nh = MT.nihonium();
        MT.Fl = MT.flerovium();
        MT.Fl_298 = MT.flerovium298();
        MT.Mc = MT.moscovium();
        MT.Lv = MT.livermorium();
        MT.Fa = MT.farnsium();
        MT.Ts = MT.Fa;
        MT.Og = MT.oganesson();
        MT.Uue = MT.ununennium();
        MT.Ubn = MT.unbinilium();
    }
}
