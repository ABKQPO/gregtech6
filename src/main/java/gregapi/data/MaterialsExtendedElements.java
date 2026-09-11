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
 * The artificially produced and hypothetical Elements beyond the ones that occur in nature.
 * <p>
 * Loaded as the "Extended Elements" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsExtendedElements implements IMaterialCategory {

    @Override
    public String getName() {
        return "Extended Elements";
    }

    @Override
    public void load() {
        // The following Data is in no way reliable, but it is there in case someone wants to use it.
        MT.Ubu = MT.unknown(1210, 182);
        MT.Ubb = MT.unknown(1220, 184);
        MT.Ubt = MT.unknown(1230, 186);
        MT.Ubq = MT.unknown(1240, 188);
        MT.Tn = MT
            .element(
                1250,
                "TritaniumElemental",
                "Tn",
                125,
                198,
                2000,
                3138,
                25.0,
                SET_DULL,
                55,
                155,
                155,
                255,
                G_DUST_ORES,
                UUM,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                "Unbipentium")
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 2, TC.VITREUS, 1)
            .setLocal("Elemental Tritanium");
        MT.Ubp = MT.Tn;
        MT.Ke = MT
            .element(
                1260,
                "Trinium",
                "Ke",
                126,
                192,
                2645,
                4523,
                1.06874,
                SET_COPPER,
                234,
                234,
                234,
                255,
                G_INGOT_MACHINE_ORES,
                UUM,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                "Unbihexium")
            .aspects(TC.METALLUM, 3, TC.TUTAMEN, 1, TC.VITREUS, 1)
            .qual(3, 12.0, 2560, 4);
        MT.Ubh = MT.Ke;
        MT.Ubs = MT.unknown(1270, 194);
        MT.Ubo = MT.unknown(1280, 196);
        MT.Ube = MT.unknown(1290, 198);
        MT.Utn = MT.unknown(1300, 200);
        MT.Utu = MT.unknown(1310, 203);
        MT.Utb = MT.unknown(1320, 206);
        MT.Utt = MT.unknown(1330, 209);
        MT.Utq = MT.unknown(1340, 212);
        MT.Utp = MT.unknown(1350, 215);
        MT.Uth = MT.unknown(1360, 218);
        MT.Uts = MT.unknown(1370, 221);
        MT.Uto = MT.unknown(1380, 224);
        MT.Ute = MT.unknown(1390, 227);
        MT.Uqn = MT.unknown(1400, 230);
        MT.Uqu = MT.unknown(1410, 233);
        MT.Uqb = MT.unknown(1420, 236);
        MT.Uqt = MT.unknown(1430, 239);
        MT.Uqq = MT.unknown(1440, 242);
        MT.Dn = MT
            .element(
                1450,
                "DuraniumElemental",
                "Dn",
                145,
                190,
                1200,
                2491,
                20.0,
                SET_DULL,
                75,
                175,
                175,
                255,
                G_DUST_ORES,
                UUM,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                "Unquadpentium")
            .aspects(TC.METALLUM, 2, TC.TUTAMEN, 1)
            .setLocal("Elemental Duranium");
        MT.Uqp = MT.Dn;
        // material refined from dolamide ore
        MT.Uqh = MT.unknown(1460, 248);
        MT.Uqs = MT.unknown(1470, 251);
        MT.Uqo = MT.unknown(1480, 254);
        MT.Uqe = MT.unknown(1490, 257);
        MT.Upn = MT.unknown(1500, 260);
        MT.Upu = MT.unknown(1510, 263);
        MT.Vb = MT
            .element(
                1520,
                "Vibranium",
                "Vb",
                152,
                266,
                4852,
                9415,
                3.23978365,
                SET_EMERALD,
                200,
                128,
                255,
                100,
                G_GEM_ORES_TRANSPARENT,
                UUM,
                VALUABLE,
                GLOWING,
                UNBURNABLE,
                "Unpentbium")
            .aspects(TC.VITREUS, 10, TC.SENSUS, 10)
            .setPriorityPrefix(1)
            .qual(3, 1000.0, 512, 15);
        MT.Upb = MT.Vb;
        MT.Upt = MT.unknown(1530, 269);
        MT.Upq = MT.unknown(1540, 272);
        MT.Upp = MT.unknown(1550, 276);
        MT.Uph = MT.unknown(1560, 280);
        MT.Ups = MT.unknown(1570, 284);
        MT.Upo = MT.unknown(1580, 288);
        MT.Upe = MT.unknown(1590, 292);
        MT.Uhn = MT.unknown(1600, 296);
        MT.Uhu = MT.unknown(1610, 300);
        MT.Uhb = MT.unknown(1620, 304);
        MT.Uht = MT.unknown(1630, 308);
        MT.Uhq = MT.unknown(1640, 312);
        MT.Uhp = MT.unknown(1650, 316);
        MT.Uhh = MT.unknown(1660, 320);
        MT.Uhs = MT.unknown(1670, 324);
        MT.Uho = MT.unknown(1680, 328);
        MT.Uhe = MT.unknown(1690, 332);
        MT.Usn = MT.unknown(1700, 336);
        MT.Usu = MT.unknown(1710, 340);
        MT.Usb = MT.unknown(1720, 344);
        MT.Ust = MT.unknown(1730, 348);
        MT.Nq = MT
            .element(
                1740,
                "Naquadah",
                "Nq",
                174,
                352,
                1500,
                3000,
                21.0,
                SET_RAD,
                50,
                50,
                50,
                255,
                G_INGOT_MACHINE_ORES,
                UUM,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                "Unseptquadium")
            .aspects(TC.METALLUM, 3, TC.RADIO, 1, TC.NEBRISUM, 1)
            .setRGBaLiquid(0, 255, 0, 255)
            .qual(3, 6.0, 1280, 4);
        MT.Usq = MT.Nq;
        MT.Nq_528 = MT
            .element(
                1741,
                "Naquadah-Enriched",
                "Nq-528",
                174,
                354,
                1500,
                3000,
                22.0,
                SET_RAD,
                60,
                60,
                60,
                255,
                G_INGOT_ORES,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                EXPLOSIVE)
            .aspects(TC.METALLUM, 3, TC.RADIO, 2, TC.NEBRISUM, 2)
            .setRGBaLiquid(64, 255, 64, 255)
            .setLocal("Enriched Naquadah")
            .qual(3, 6.0, 1280, 4);
        MT.Nq_522 = MT
            .element(
                1742,
                "Naquadria",
                "Nq-522",
                174,
                348,
                1500,
                3000,
                20.0,
                SET_RAD,
                30,
                30,
                30,
                255,
                G_INGOT_ORES,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                EXPLOSIVE)
            .aspects(TC.METALLUM, 4, TC.RADIO, 3, TC.NEBRISUM, 3)
            .setRGBaLiquid(128, 255, 128, 255)
            .qual(3, 1.0, 512, 4);
        MT.Usp = MT.unknown(1750, 356);
        MT.Ush = MT.unknown(1760, 360);
        MT.Uss = MT.unknown(1770, 364);
        MT.Uso = MT.unknown(1780, 368);
        MT.Use = MT.unknown(1790, 372);
        MT.Uon = MT.unknown(1800, 376);
        MT.Uou = MT.unknown(1810, 380);
        MT.Uob = MT.unknown(1820, 384);
        MT.Uot = MT.unknown(1830, 388);
        MT.Uoq = MT.unknown(1840, 392);
        MT.An = MT
            .element(
                1850,
                "Abyssalnite",
                "An",
                185,
                396,
                1500,
                3000,
                15.0,
                SET_METALLIC,
                90,
                40,
                170,
                255,
                G_INGOT_MACHINE_ORES,
                UUM,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                "Unoctpentium")
            .qual(3, 8.0, 1600, 3)
            .aspects(TC.METALLUM, 3, TC.VACUOS, 2);
        MT.Uop = MT.An;
        MT.Cor = MT
            .element(
                1860,
                "Coralium",
                "Cor",
                186,
                400,
                2000,
                4000,
                20.0,
                SET_RUBY,
                20,
                160,
                110,
                255,
                G_INGOT_MACHINE_ORES,
                UUM,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                G_GEM_ORES,
                "Unocthexium",
                "LiquifiedCoralium")
            .qual(3, 12.0, 3200, 3)
            .aspects(TC.METALLUM, 3, TC.PERDITIO, 2);
        MT.Uoh = MT.Cor;
        MT.Dr = MT
            .element(
                1870,
                "Dreadium",
                "Dr",
                187,
                405,
                2500,
                5000,
                25.0,
                SET_METALLIC,
                170,
                0,
                0,
                255,
                G_INGOT_MACHINE_ORES,
                UUM,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                "Unoctseptium")
            .qual(3, 16.0, 4800, 4)
            .aspects(TC.METALLUM, 3, TC.TENEBRAE, 2);
        MT.Uos = MT.Dr;
        MT.Etx = MT
            .element(
                1880,
                "Ethaxium",
                "Etx",
                188,
                410,
                3000,
                6000,
                30.0,
                SET_METALLIC,
                160,
                170,
                150,
                255,
                G_INGOT_MACHINE_ORES,
                UUM,
                METAL,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                "Unoctoctium")
            .qual(3, 20.0, 6400, 4)
            .aspects(TC.METALLUM, 3, TC.VITIUM, 2);
        MT.Uoo = MT.Etx;
        MT.Uoe = MT.unknown(1890, 415);
        MT.Uen = MT.unknown(1900, 420);
        MT.Ueu = MT.unknown(1910, 425);
        MT.Ueb = MT.unknown(1920, 430);
        MT.Uet = MT.unknown(1930, 435);
        MT.Ueq = MT.unknown(1940, 440);
        MT.Uep = MT.unknown(1950, 445);
        MT.Ueh = MT.unknown(1960, 450);
        MT.Ues = MT.unknown(1970, 455);
        MT.Ueo = MT.unknown(1980, 460);
        MT.Uee = MT.unknown(1990, 465);
        MT.Bnn = MT.unknown(2000, 470);
        MT.Bnu = MT.unknown(2010, 475);
        MT.Bnb = MT.unknown(2020, 480);
        MT.Bnt = MT.unknown(2030, 485);
        MT.Bnq = MT.unknown(2040, 490);
        MT.Bnp = MT.unknown(2050, 495);
        MT.Bnh = MT.unknown(2060, 500);
        MT.Bns = MT.unknown(2070, 505);
        MT.Bno = MT.unknown(2080, 510);
        MT.Bne = MT.unknown(2090, 515);
        MT.Bun = MT.unknown(2100, 520);
        MT.Buu = MT.unknown(2110, 525);
        MT.Bub = MT.unknown(2120, 530);
        MT.But = MT.unknown(2130, 535);
        MT.Buq = MT.unknown(2140, 540);
        MT.Bup = MT.unknown(2150, 545);
        MT.Buh = MT.unknown(2160, 550);
        MT.Bus = MT.unknown(2170, 555);
        MT.Buo = MT.unknown(2180, 560);
        MT.Bue = MT.unknown(2190, 565);
        MT.Bbn = MT.unknown(2200, 570);
        MT.Atl = MT
            .element(
                2210,
                "Atlarus",
                "Atl",
                221,
                575,
                3276,
                11524,
                21.24625421,
                SET_METALLIC,
                204,
                179,
                0,
                255,
                G_INGOT_MACHINE_ORES,
                UUM,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                MAGICAL,
                "Bibiunium")
            .qual(3, 4.0, 4480, 4)
            .aspects(TC.METALLUM, 2, TC.COGNITIO, 1);
        MT.Bbu = MT.Atl;
        MT.Atlarus = MT.Atl;
        MT.Ad = MT
            .element(
                2220,
                "Adamantium",
                "Ad",
                222,
                580,
                5225,
                14528,
                13.35624762,
                SET_SHINY,
                255,
                255,
                255,
                255,
                G_INGOT_MACHINE_ORES,
                UUM,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                MAGICAL,
                MAGNETIC_PASSIVE,
                UNBURNABLE,
                WITHER_PROOF,
                ENDER_DRAGON_PROOF,
                RAILS,
                "Adamant",
                "Bibibium")
            .qual(3, 10.0, 5120, 5)
            .aspects(TC.METALLUM, 10, TC.PRAECANTIO, 10);
        MT.Bbb = MT.Ad;
        MT.Bbt = MT.unknown(2230, 585);
        MT.Bbq = MT.unknown(2240, 590);
        MT.Bbp = MT.unknown(2250, 595);
        MT.Bbh = MT.unknown(2260, 600);
        MT.Bbs = MT.unknown(2270, 605);
        MT.Bbo = MT.unknown(2280, 610);
        MT.Bbe = MT.unknown(2290, 615);
        MT.Btn = MT.unknown(2300, 620);
        MT.Btu = MT.unknown(2310, 625);
        MT.Btb = MT.unknown(2320, 630);
        MT.Btt = MT.unknown(2330, 635);
        MT.Btq = MT.unknown(2340, 640);
        MT.Btp = MT.unknown(2350, 645);
        MT.Bth = MT.unknown(2360, 650);
        MT.Bts = MT.unknown(2370, 655);
        MT.Bto = MT.unknown(2380, 660);
        MT.Mcg = MT
            .element(
                2390,
                "Mac-Guffium",
                "Mcg",
                239,
                665,
                200,
                1000,
                3.122,
                SET_SHINY,
                200,
                50,
                150,
                255,
                G_CONTAINERS,
                UUM,
                VALUABLE,
                GLOWING,
                LIGHTING,
                "Bitriennium")
            .aspects(
                TC.ALIENIS,
                8,
                TC.PERMUTATIO,
                8,
                TC.SPIRITUS,
                8,
                TC.AURAM,
                8,
                TC.VITIUM,
                8,
                TC.RADIO,
                8,
                TC.MAGNETO,
                8,
                TC.ELECTRUM,
                8,
                TC.NEBRISUM,
                8,
                TC.STRONTIO,
                8);
        MT.Bte = MT.Mcg;
        MT.Bqn = MT.unknown(2400, 670);
        MT.Bqu = MT.unknown(2410, 675);
        MT.Bqb = MT.unknown(2420, 680);
        MT.Bqt = MT.unknown(2430, 685);
        MT.Bqq = MT.unknown(2440, 690);
        MT.Bqp = MT.unknown(2450, 695);
        MT.Bqh = MT.unknown(2460, 700);
        MT.Bqs = MT.unknown(2470, 705);
        MT.Bqo = MT.unknown(2480, 710);
        MT.Bqe = MT.unknown(2490, 715);
        MT.Bpn = MT.unknown(2500, 720);
        MT.Bpu = MT.unknown(2510, 725);
        MT.Bpb = MT.unknown(2520, 730);
        MT.Bpt = MT.unknown(2530, 735);
        MT.Bpq = MT.unknown(2540, 740);
        MT.Bpp = MT.unknown(2550, 745);
        MT.Bph = MT.unknown(2560, 750);
        MT.Bps = MT.unknown(2570, 755);
        MT.Bpo = MT.unknown(2580, 760);
        MT.Bpe = MT.unknown(2590, 765);
        MT.Bhn = MT.unknown(2600, 770);
        MT.Bhu = MT.unknown(2610, 775);
        MT.Bhb = MT.unknown(2620, 780);
        MT.Bht = MT.unknown(2630, 785);
        MT.Bhq = MT.unknown(2640, 790);
        MT.Bhp = MT.unknown(2650, 795);
        MT.Bhh = MT.unknown(2660, 800);
        MT.Bhs = MT.unknown(2670, 805);
        MT.Bho = MT.unknown(2680, 810);
        MT.Bhe = MT.unknown(2690, 815);
        MT.Bsn = MT.unknown(2700, 820);
        MT.Bsu = MT.unknown(2710, 825);
        MT.Bsb = MT.unknown(2720, 830);
        MT.Bst = MT.unknown(2730, 835);
        MT.Bsq = MT.unknown(2740, 840);
        MT.Bsp = MT.unknown(2750, 845);
        MT.Bsh = MT.unknown(2760, 850);
        MT.Bss = MT.unknown(2770, 855);
        MT.Bso = MT.unknown(2780, 860);
        MT.Bse = MT.unknown(2790, 865);
        MT.Bon = MT.unknown(2800, 870);
        MT.Bou = MT.unknown(2810, 875);
        MT.Bob = MT.unknown(2820, 880);
        MT.Bot = MT.unknown(2830, 885);
        MT.Boq = MT.unknown(2840, 890);
        MT.Bop = MT.unknown(2850, 895);
        MT.Boh = MT.unknown(2860, 900);
        MT.Bos = MT.unknown(2870, 905);
        MT.Boo = MT.unknown(2880, 910);
        MT.Boe = MT.unknown(2890, 915);
        MT.Ben = MT.unknown(2900, 920);
        MT.Beu = MT.unknown(2910, 925);
        MT.Beb = MT.unknown(2920, 930);
        MT.Bet = MT.unknown(2930, 935);
        MT.Beq = MT.unknown(2940, 940);
        MT.Bep = MT.unknown(2950, 945);
        MT.Beh = MT.unknown(2960, 950);
        MT.Bes = MT.unknown(2970, 955);
        MT.Beo = MT.unknown(2980, 960);
        MT.Bee = MT.unknown(2990, 965);
        MT.Tnn = MT.unknown(3000, 970);
        MT.Tnu = MT.unknown(3010, 975);
        MT.Tnb = MT.unknown(3020, 980);
        MT.Tnt = MT.unknown(3030, 985);
        MT.Tnq = MT.unknown(3040, 990);
        MT.Tnp = MT.unknown(3050, 995);
        MT.Tnh = MT.unknown(3060, 1000);
        MT.Tns = MT.unknown(3070, 1005);
        MT.Tno = MT.unknown(3080, 1010);
        MT.Tne = MT.unknown(3090, 1015);
        MT.Tun = MT.unknown(3100, 1020);
        MT.Tuu = MT.unknown(3110, 1025);
        MT.Tub = MT.unknown(3120, 1030);
        MT.Tut = MT.unknown(3130, 1035);
        MT.Tuq = MT.unknown(3140, 1040);
        MT.Tup = MT.unknown(3150, 1045);
        MT.Tuh = MT.unknown(3160, 1050);
        MT.Tus = MT.unknown(3170, 1055);
        MT.Tuo = MT.unknown(3180, 1060);
        MT.Tue = MT.unknown(3190, 1065);
        MT.Tbn = MT.unknown(3200, 1070);
        MT.Tbu = MT.unknown(3210, 1075);
        MT.Tbb = MT.unknown(3220, 1080);
        MT.Tbt = MT.unknown(3230, 1085);
        MT.Tbq = MT.unknown(3240, 1090);
        MT.Tbp = MT.unknown(3250, 1095);
        MT.Tbh = MT.unknown(3260, 1100);
        MT.Tbs = MT.unknown(3270, 1105);
        MT.Tbo = MT.unknown(3280, 1110);
        MT.Tbe = MT.unknown(3290, 1115);
        MT.Ttn = MT.unknown(3300, 1120);
        MT.Ttu = MT.unknown(3310, 1125);
        MT.Ttb = MT.unknown(3320, 1130);
        MT.Ttt = MT.unknown(3330, 1135);
        MT.Ttq = MT.unknown(3340, 1140);
        MT.Ttp = MT.unknown(3350, 1145);
        MT.Tth = MT.unknown(3360, 1150);
        MT.Tts = MT.unknown(3370, 1155);
        MT.Tto = MT.unknown(3380, 1160);
        MT.Tte = MT.unknown(3390, 1165);
        MT.Tqn = MT.unknown(3400, 1170);
        MT.Tqu = MT.unknown(3410, 1175);
        MT.Tqb = MT.unknown(3420, 1180);
        MT.Tqt = MT.unknown(3430, 1185);
        MT.Tqq = MT.unknown(3440, 1190);
        MT.Tqp = MT.unknown(3450, 1195);
        MT.Tqh = MT.unknown(3460, 1200);
        MT.Tqs = MT.unknown(3470, 1205);
        MT.Tqo = MT.unknown(3480, 1210);
        MT.Tqe = MT.unknown(3490, 1215);
        MT.Tpn = MT.unknown(3500, 1220);
        MT.Tpu = MT.unknown(3510, 1225);
        MT.Tpb = MT.unknown(3520, 1230);
        MT.Tpt = MT.unknown(3530, 1235);
        MT.Tpq = MT.unknown(3540, 1240);
        MT.Tpp = MT.unknown(3550, 1245);
        MT.Tph = MT.unknown(3560, 1250);
        MT.Tps = MT.unknown(3570, 1255);
        MT.Tpo = MT.unknown(3580, 1260);
        MT.Tpe = MT.unknown(3590, 1265);
        MT.Thn = MT.unknown(3600, 1270);
        MT.Thu = MT.unknown(3610, 1275);
        MT.Thb = MT.unknown(3620, 1280);
        MT.Tht = MT.unknown(3630, 1285);
        MT.Thq = MT.unknown(3640, 1290);
        MT.Thp = MT.unknown(3650, 1295);
        MT.Thh = MT.unknown(3660, 1300);
        MT.Ths = MT.unknown(3670, 1305);
        MT.Tho = MT.unknown(3680, 1310);
        MT.The = MT.unknown(3690, 1315);
        MT.Tsn = MT.unknown(3700, 1320);
        MT.Tsu = MT.unknown(3710, 1325);
        MT.Gt = MT
            .element(
                3720,
                "Gravitonium",
                "Gt",
                372,
                1330,
                112,
                1275,
                1768.866761,
                SET_SHINY,
                0,
                50,
                0,
                255,
                G_CONTAINERS,
                UUM,
                "Triseptbium")
            .aspects(TC.TERRA, 10, TC.POTENTIA, 10);
        MT.Tsb = MT.Gt;
        MT.Tst = MT.unknown(3730, 1335);
        MT.Tsq = MT.unknown(3740, 1340);
        MT.Tsp = MT.unknown(3750, 1345);
        MT.Tsh = MT.unknown(3760, 1350);
        MT.Tss = MT.unknown(3770, 1355);
        MT.Tso = MT.unknown(3780, 1360);
        MT.Tse = MT.unknown(3790, 1365);
        MT.Ton = MT.unknown(3800, 1370);
        MT.Tou = MT.unknown(3810, 1375);
        MT.Tob = MT.unknown(3820, 1380);
        MT.Tot = MT.unknown(3830, 1385);
        MT.Toq = MT.unknown(3840, 1390);
        MT.Top = MT.unknown(3850, 1395);
        MT.Toh = MT.unknown(3860, 1400);
        MT.Tos = MT.unknown(3870, 1405);
        MT.Too = MT.unknown(3880, 1410);
        MT.Toe = MT.unknown(3890, 1415);
        MT.Ten = MT.unknown(3900, 1420);
        MT.Teu = MT.unknown(3910, 1425);
        MT.Teb = MT.unknown(3920, 1430);
        MT.Tet = MT.unknown(3930, 1435);
        MT.Teq = MT.unknown(3940, 1440);
        MT.Tep = MT.unknown(3950, 1445);
        MT.Teh = MT.unknown(3960, 1450);
        MT.Tes = MT.unknown(3970, 1455);
        MT.Teo = MT.unknown(3980, 1460);
        MT.Tee = MT.unknown(3990, 1465);
        MT.Neutronium = MT.unused("Neutronium")
            .qual(3, 6.0, 81920, 6)
            .put(IGNORE_IN_COLOR_LOG)
            .tooltip("Nt");
    }
}
