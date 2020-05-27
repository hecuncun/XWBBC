package com.aliyun.svideo.recorder.faceunity;

import java.security.MessageDigest;

public class authpack {
    public static int sha1_32(byte[] buf) {
        int ret = 0;
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(buf);
            return ((int)(digest[0] & 0xff) << 24) + ((int)(digest[1] & 0xff) << 16) + (
                       (int)(digest[2] & 0xff) << 8) + ((int)(digest[3] & 0xff) << 0);
        } catch (Exception e) {}
        return ret;
    }

    public static byte[] A() {
        byte[] buf = new byte[1127];
        int i = 0;
        for (i = 56; i < 71; i++) {
            buf[0] = (byte)i;
            if (sha1_32(buf) == 1389973886) {
                break;
            }
        }
        for (i = 8; i < 24; i++) {
            buf[1] = (byte)i;
            if (sha1_32(buf) == 1267725817) {
                break;
            }
        }
        for (i = 36; i < 49; i++) {
            buf[2] = (byte)i;
            if (sha1_32(buf) == -1144309045) {
                break;
            }
        }
        for (i = 108; i < 128; i++) {
            buf[3] = (byte)i;
            if (sha1_32(buf) == -1558030059) {
                break;
            }
        }
        for (i = -23; i < 1; i++) {
            buf[4] = (byte)i;
            if (sha1_32(buf) == -794917252) {
                break;
            }
        }
        for (i = -2; i < 22; i++) {
            buf[5] = (byte)i;
            if (sha1_32(buf) == 2069197821) {
                break;
            }
        }
        for (i = -82; i < -68; i++) {
            buf[6] = (byte)i;
            if (sha1_32(buf) == -589722235) {
                break;
            }
        }
        for (i = -107; i < -88; i++) {
            buf[7] = (byte)i;
            if (sha1_32(buf) == -777646769) {
                break;
            }
        }
        for (i = -40; i < -18; i++) {
            buf[8] = (byte)i;
            if (sha1_32(buf) == 2128354109) {
                break;
            }
        }
        for (i = -12; i < 3; i++) {
            buf[9] = (byte)i;
            if (sha1_32(buf) == 1440772290) {
                break;
            }
        }
        for (i = 64; i < 79; i++) {
            buf[10] = (byte)i;
            if (sha1_32(buf) == 1816167016) {
                break;
            }
        }
        for (i = -123; i < -107; i++) {
            buf[11] = (byte)i;
            if (sha1_32(buf) == 1844214172) {
                break;
            }
        }
        for (i = -56; i < -41; i++) {
            buf[12] = (byte)i;
            if (sha1_32(buf) == 349451011) {
                break;
            }
        }
        for (i = -117; i < -97; i++) {
            buf[13] = (byte)i;
            if (sha1_32(buf) == -1918329684) {
                break;
            }
        }
        for (i = 96; i < 102; i++) {
            buf[14] = (byte)i;
            if (sha1_32(buf) == -1604721239) {
                break;
            }
        }
        for (i = 4; i < 32; i++) {
            buf[15] = (byte)i;
            if (sha1_32(buf) == 419788520) {
                break;
            }
        }
        for (i = 25; i < 42; i++) {
            buf[16] = (byte)i;
            if (sha1_32(buf) == 1497486315) {
                break;
            }
        }
        for (i = -128; i < -110; i++) {
            buf[17] = (byte)i;
            if (sha1_32(buf) == -1822749365) {
                break;
            }
        }
        for (i = 88; i < 104; i++) {
            buf[18] = (byte)i;
            if (sha1_32(buf) == -274163493) {
                break;
            }
        }
        for (i = -100; i < -96; i++) {
            buf[19] = (byte)i;
            if (sha1_32(buf) == 1097965188) {
                break;
            }
        }
        for (i = -38; i < -22; i++) {
            buf[20] = (byte)i;
            if (sha1_32(buf) == 275908626) {
                break;
            }
        }
        for (i = -31; i < -18; i++) {
            buf[21] = (byte)i;
            if (sha1_32(buf) == 1453871479) {
                break;
            }
        }
        for (i = 67; i < 73; i++) {
            buf[22] = (byte)i;
            if (sha1_32(buf) == 866258120) {
                break;
            }
        }
        for (i = 29; i < 54; i++) {
            buf[23] = (byte)i;
            if (sha1_32(buf) == 514029613) {
                break;
            }
        }
        for (i = 11; i < 29; i++) {
            buf[24] = (byte)i;
            if (sha1_32(buf) == 283639045) {
                break;
            }
        }
        for (i = 87; i < 100; i++) {
            buf[25] = (byte)i;
            if (sha1_32(buf) == -619740124) {
                break;
            }
        }
        for (i = -107; i < -100; i++) {
            buf[26] = (byte)i;
            if (sha1_32(buf) == -1899470159) {
                break;
            }
        }
        for (i = -117; i < -92; i++) {
            buf[27] = (byte)i;
            if (sha1_32(buf) == 261671727) {
                break;
            }
        }
        for (i = -87; i < -72; i++) {
            buf[28] = (byte)i;
            if (sha1_32(buf) == -975668218) {
                break;
            }
        }
        for (i = -44; i < -28; i++) {
            buf[29] = (byte)i;
            if (sha1_32(buf) == -1508602659) {
                break;
            }
        }
        for (i = -76; i < -54; i++) {
            buf[30] = (byte)i;
            if (sha1_32(buf) == -1809026874) {
                break;
            }
        }
        for (i = 58; i < 70; i++) {
            buf[31] = (byte)i;
            if (sha1_32(buf) == -1081547888) {
                break;
            }
        }
        for (i = -91; i < -77; i++) {
            buf[32] = (byte)i;
            if (sha1_32(buf) == 432238402) {
                break;
            }
        }
        for (i = -98; i < -82; i++) {
            buf[33] = (byte)i;
            if (sha1_32(buf) == 987711073) {
                break;
            }
        }
        for (i = -42; i < -27; i++) {
            buf[34] = (byte)i;
            if (sha1_32(buf) == -1909216007) {
                break;
            }
        }
        for (i = 109; i < 128; i++) {
            buf[35] = (byte)i;
            if (sha1_32(buf) == -1273121963) {
                break;
            }
        }
        for (i = -7; i < 9; i++) {
            buf[36] = (byte)i;
            if (sha1_32(buf) == -693289898) {
                break;
            }
        }
        for (i = 35; i < 39; i++) {
            buf[37] = (byte)i;
            if (sha1_32(buf) == 673140611) {
                break;
            }
        }
        for (i = 12; i < 31; i++) {
            buf[38] = (byte)i;
            if (sha1_32(buf) == 1184066916) {
                break;
            }
        }
        for (i = -40; i < -19; i++) {
            buf[39] = (byte)i;
            if (sha1_32(buf) == 1982806569) {
                break;
            }
        }
        for (i = 16; i < 43; i++) {
            buf[40] = (byte)i;
            if (sha1_32(buf) == 695504173) {
                break;
            }
        }
        for (i = -54; i < -30; i++) {
            buf[41] = (byte)i;
            if (sha1_32(buf) == 1662703765) {
                break;
            }
        }
        for (i = -39; i < -10; i++) {
            buf[42] = (byte)i;
            if (sha1_32(buf) == -917797101) {
                break;
            }
        }
        for (i = 8; i < 24; i++) {
            buf[43] = (byte)i;
            if (sha1_32(buf) == 88313154) {
                break;
            }
        }
        for (i = 79; i < 103; i++) {
            buf[44] = (byte)i;
            if (sha1_32(buf) == -2140224205) {
                break;
            }
        }
        for (i = -55; i < -42; i++) {
            buf[45] = (byte)i;
            if (sha1_32(buf) == 1798131731) {
                break;
            }
        }
        for (i = -86; i < -74; i++) {
            buf[46] = (byte)i;
            if (sha1_32(buf) == 641181343) {
                break;
            }
        }
        for (i = 85; i < 89; i++) {
            buf[47] = (byte)i;
            if (sha1_32(buf) == 1210343564) {
                break;
            }
        }
        for (i = 70; i < 92; i++) {
            buf[48] = (byte)i;
            if (sha1_32(buf) == -1620469600) {
                break;
            }
        }
        for (i = -70; i < -62; i++) {
            buf[49] = (byte)i;
            if (sha1_32(buf) == 1957989769) {
                break;
            }
        }
        for (i = 103; i < 120; i++) {
            buf[50] = (byte)i;
            if (sha1_32(buf) == -627451696) {
                break;
            }
        }
        for (i = -128; i < -115; i++) {
            buf[51] = (byte)i;
            if (sha1_32(buf) == -1442115414) {
                break;
            }
        }
        for (i = -44; i < -32; i++) {
            buf[52] = (byte)i;
            if (sha1_32(buf) == -1251836761) {
                break;
            }
        }
        for (i = -53; i < -40; i++) {
            buf[53] = (byte)i;
            if (sha1_32(buf) == -2054014283) {
                break;
            }
        }
        for (i = -81; i < -63; i++) {
            buf[54] = (byte)i;
            if (sha1_32(buf) == -618272959) {
                break;
            }
        }
        for (i = -91; i < -71; i++) {
            buf[55] = (byte)i;
            if (sha1_32(buf) == 1493205282) {
                break;
            }
        }
        for (i = -128; i < -107; i++) {
            buf[56] = (byte)i;
            if (sha1_32(buf) == 147377877) {
                break;
            }
        }
        for (i = 56; i < 72; i++) {
            buf[57] = (byte)i;
            if (sha1_32(buf) == -532834016) {
                break;
            }
        }
        for (i = -69; i < -55; i++) {
            buf[58] = (byte)i;
            if (sha1_32(buf) == 329683745) {
                break;
            }
        }
        for (i = 0; i < 2; i++) {
            buf[59] = (byte)i;
            if (sha1_32(buf) == 329683745) {
                break;
            }
        }
        for (i = 110; i < 114; i++) {
            buf[60] = (byte)i;
            if (sha1_32(buf) == 803859805) {
                break;
            }
        }
        for (i = -128; i < -120; i++) {
            buf[61] = (byte)i;
            if (sha1_32(buf) == -1712316608) {
                break;
            }
        }
        for (i = 77; i < 91; i++) {
            buf[62] = (byte)i;
            if (sha1_32(buf) == 1300407079) {
                break;
            }
        }
        for (i = 72; i < 81; i++) {
            buf[63] = (byte)i;
            if (sha1_32(buf) == 795443820) {
                break;
            }
        }
        for (i = 5; i < 22; i++) {
            buf[64] = (byte)i;
            if (sha1_32(buf) == 1463791467) {
                break;
            }
        }
        for (i = 62; i < 82; i++) {
            buf[65] = (byte)i;
            if (sha1_32(buf) == 1900440035) {
                break;
            }
        }
        for (i = 102; i < 124; i++) {
            buf[66] = (byte)i;
            if (sha1_32(buf) == -1356165381) {
                break;
            }
        }
        for (i = 63; i < 85; i++) {
            buf[67] = (byte)i;
            if (sha1_32(buf) == -1291382956) {
                break;
            }
        }
        for (i = -80; i < -70; i++) {
            buf[68] = (byte)i;
            if (sha1_32(buf) == 1200094721) {
                break;
            }
        }
        for (i = -26; i < -9; i++) {
            buf[69] = (byte)i;
            if (sha1_32(buf) == -1478893827) {
                break;
            }
        }
        for (i = -18; i < -1; i++) {
            buf[70] = (byte)i;
            if (sha1_32(buf) == 1526962516) {
                break;
            }
        }
        for (i = -12; i < 13; i++) {
            buf[71] = (byte)i;
            if (sha1_32(buf) == 1526962516) {
                break;
            }
        }
        for (i = -80; i < -57; i++) {
            buf[72] = (byte)i;
            if (sha1_32(buf) == 298883948) {
                break;
            }
        }
        for (i = 43; i < 65; i++) {
            buf[73] = (byte)i;
            if (sha1_32(buf) == -1657152050) {
                break;
            }
        }
        for (i = -12; i < -1; i++) {
            buf[74] = (byte)i;
            if (sha1_32(buf) == 448849200) {
                break;
            }
        }
        for (i = -28; i < -22; i++) {
            buf[75] = (byte)i;
            if (sha1_32(buf) == 137588694) {
                break;
            }
        }
        for (i = -107; i < -77; i++) {
            buf[76] = (byte)i;
            if (sha1_32(buf) == 741751223) {
                break;
            }
        }
        for (i = -83; i < -63; i++) {
            buf[77] = (byte)i;
            if (sha1_32(buf) == -953308424) {
                break;
            }
        }
        for (i = -72; i < -50; i++) {
            buf[78] = (byte)i;
            if (sha1_32(buf) == -1205037340) {
                break;
            }
        }
        for (i = 38; i < 42; i++) {
            buf[79] = (byte)i;
            if (sha1_32(buf) == 1435538570) {
                break;
            }
        }
        for (i = 91; i < 112; i++) {
            buf[80] = (byte)i;
            if (sha1_32(buf) == 256289349) {
                break;
            }
        }
        for (i = -103; i < -85; i++) {
            buf[81] = (byte)i;
            if (sha1_32(buf) == 7637131) {
                break;
            }
        }
        for (i = -16; i < -11; i++) {
            buf[82] = (byte)i;
            if (sha1_32(buf) == -1084637714) {
                break;
            }
        }
        for (i = -4; i < 8; i++) {
            buf[83] = (byte)i;
            if (sha1_32(buf) == 1927344268) {
                break;
            }
        }
        for (i = 72; i < 98; i++) {
            buf[84] = (byte)i;
            if (sha1_32(buf) == -214707493) {
                break;
            }
        }
        for (i = -73; i < -70; i++) {
            buf[85] = (byte)i;
            if (sha1_32(buf) == 675588935) {
                break;
            }
        }
        for (i = 95; i < 107; i++) {
            buf[86] = (byte)i;
            if (sha1_32(buf) == 1214012696) {
                break;
            }
        }
        for (i = -97; i < -81; i++) {
            buf[87] = (byte)i;
            if (sha1_32(buf) == 654144833) {
                break;
            }
        }
        for (i = 79; i < 89; i++) {
            buf[88] = (byte)i;
            if (sha1_32(buf) == 1948396717) {
                break;
            }
        }
        for (i = -99; i < -76; i++) {
            buf[89] = (byte)i;
            if (sha1_32(buf) == -1569595612) {
                break;
            }
        }
        for (i = -29; i < -4; i++) {
            buf[90] = (byte)i;
            if (sha1_32(buf) == 815834183) {
                break;
            }
        }
        for (i = -7; i < 7; i++) {
            buf[91] = (byte)i;
            if (sha1_32(buf) == 815834183) {
                break;
            }
        }
        for (i = -93; i < -73; i++) {
            buf[92] = (byte)i;
            if (sha1_32(buf) == -205136730) {
                break;
            }
        }
        for (i = -81; i < -61; i++) {
            buf[93] = (byte)i;
            if (sha1_32(buf) == 1090139777) {
                break;
            }
        }
        for (i = -55; i < -36; i++) {
            buf[94] = (byte)i;
            if (sha1_32(buf) == -1433077695) {
                break;
            }
        }
        for (i = 52; i < 58; i++) {
            buf[95] = (byte)i;
            if (sha1_32(buf) == -1124722104) {
                break;
            }
        }
        for (i = 86; i < 107; i++) {
            buf[96] = (byte)i;
            if (sha1_32(buf) == 1865803406) {
                break;
            }
        }
        for (i = -112; i < -88; i++) {
            buf[97] = (byte)i;
            if (sha1_32(buf) == -1061586803) {
                break;
            }
        }
        for (i = -53; i < -33; i++) {
            buf[98] = (byte)i;
            if (sha1_32(buf) == -1426064943) {
                break;
            }
        }
        for (i = -47; i < -36; i++) {
            buf[99] = (byte)i;
            if (sha1_32(buf) == -1378369991) {
                break;
            }
        }
        for (i = 88; i < 89; i++) {
            buf[100] = (byte)i;
            if (sha1_32(buf) == 1956288361) {
                break;
            }
        }
        for (i = 25; i < 54; i++) {
            buf[101] = (byte)i;
            if (sha1_32(buf) == 158251348) {
                break;
            }
        }
        for (i = 109; i < 128; i++) {
            buf[102] = (byte)i;
            if (sha1_32(buf) == 262101937) {
                break;
            }
        }
        for (i = 57; i < 79; i++) {
            buf[103] = (byte)i;
            if (sha1_32(buf) == 1775839666) {
                break;
            }
        }
        for (i = -38; i < -17; i++) {
            buf[104] = (byte)i;
            if (sha1_32(buf) == 217509567) {
                break;
            }
        }
        for (i = -95; i < -80; i++) {
            buf[105] = (byte)i;
            if (sha1_32(buf) == -360243241) {
                break;
            }
        }
        for (i = -103; i < -80; i++) {
            buf[106] = (byte)i;
            if (sha1_32(buf) == -1726733568) {
                break;
            }
        }
        for (i = -63; i < -51; i++) {
            buf[107] = (byte)i;
            if (sha1_32(buf) == -1027120981) {
                break;
            }
        }
        for (i = 75; i < 102; i++) {
            buf[108] = (byte)i;
            if (sha1_32(buf) == 414646645) {
                break;
            }
        }
        for (i = -24; i < -9; i++) {
            buf[109] = (byte)i;
            if (sha1_32(buf) == -1370344216) {
                break;
            }
        }
        for (i = -74; i < -57; i++) {
            buf[110] = (byte)i;
            if (sha1_32(buf) == 551292415) {
                break;
            }
        }
        for (i = 51; i < 62; i++) {
            buf[111] = (byte)i;
            if (sha1_32(buf) == 335241401) {
                break;
            }
        }
        for (i = 39; i < 49; i++) {
            buf[112] = (byte)i;
            if (sha1_32(buf) == -232648305) {
                break;
            }
        }
        for (i = 14; i < 23; i++) {
            buf[113] = (byte)i;
            if (sha1_32(buf) == -277510705) {
                break;
            }
        }
        for (i = 66; i < 85; i++) {
            buf[114] = (byte)i;
            if (sha1_32(buf) == 1737599812) {
                break;
            }
        }
        for (i = 107; i < 117; i++) {
            buf[115] = (byte)i;
            if (sha1_32(buf) == 768729286) {
                break;
            }
        }
        for (i = 76; i < 93; i++) {
            buf[116] = (byte)i;
            if (sha1_32(buf) == -1542097027) {
                break;
            }
        }
        for (i = 66; i < 69; i++) {
            buf[117] = (byte)i;
            if (sha1_32(buf) == -974384953) {
                break;
            }
        }
        for (i = 25; i < 50; i++) {
            buf[118] = (byte)i;
            if (sha1_32(buf) == -1531166566) {
                break;
            }
        }
        for (i = -124; i < -105; i++) {
            buf[119] = (byte)i;
            if (sha1_32(buf) == 1558544045) {
                break;
            }
        }
        for (i = 17; i < 37; i++) {
            buf[120] = (byte)i;
            if (sha1_32(buf) == -1792330483) {
                break;
            }
        }
        for (i = 110; i < 128; i++) {
            buf[121] = (byte)i;
            if (sha1_32(buf) == -232146186) {
                break;
            }
        }
        for (i = -84; i < -77; i++) {
            buf[122] = (byte)i;
            if (sha1_32(buf) == 405620417) {
                break;
            }
        }
        for (i = 3; i < 24; i++) {
            buf[123] = (byte)i;
            if (sha1_32(buf) == 358113865) {
                break;
            }
        }
        for (i = 106; i < 119; i++) {
            buf[124] = (byte)i;
            if (sha1_32(buf) == -150689444) {
                break;
            }
        }
        for (i = 108; i < 120; i++) {
            buf[125] = (byte)i;
            if (sha1_32(buf) == -1505782235) {
                break;
            }
        }
        for (i = -120; i < -108; i++) {
            buf[126] = (byte)i;
            if (sha1_32(buf) == -1485189203) {
                break;
            }
        }
        for (i = -41; i < -25; i++) {
            buf[127] = (byte)i;
            if (sha1_32(buf) == 1927685310) {
                break;
            }
        }
        for (i = 9; i < 27; i++) {
            buf[128] = (byte)i;
            if (sha1_32(buf) == 2076068779) {
                break;
            }
        }
        for (i = 61; i < 68; i++) {
            buf[129] = (byte)i;
            if (sha1_32(buf) == -688196390) {
                break;
            }
        }
        for (i = 47; i < 62; i++) {
            buf[130] = (byte)i;
            if (sha1_32(buf) == 354171376) {
                break;
            }
        }
        for (i = -9; i < 7; i++) {
            buf[131] = (byte)i;
            if (sha1_32(buf) == 539907957) {
                break;
            }
        }
        for (i = -96; i < -76; i++) {
            buf[132] = (byte)i;
            if (sha1_32(buf) == -1945327063) {
                break;
            }
        }
        for (i = 67; i < 75; i++) {
            buf[133] = (byte)i;
            if (sha1_32(buf) == -1917007354) {
                break;
            }
        }
        for (i = 88; i < 115; i++) {
            buf[134] = (byte)i;
            if (sha1_32(buf) == 2068210164) {
                break;
            }
        }
        for (i = -72; i < -61; i++) {
            buf[135] = (byte)i;
            if (sha1_32(buf) == 573856232) {
                break;
            }
        }
        for (i = 80; i < 104; i++) {
            buf[136] = (byte)i;
            if (sha1_32(buf) == 75989962) {
                break;
            }
        }
        for (i = -111; i < -95; i++) {
            buf[137] = (byte)i;
            if (sha1_32(buf) == -1185516003) {
                break;
            }
        }
        for (i = 1; i < 18; i++) {
            buf[138] = (byte)i;
            if (sha1_32(buf) == -262796083) {
                break;
            }
        }
        for (i = 35; i < 51; i++) {
            buf[139] = (byte)i;
            if (sha1_32(buf) == -31201816) {
                break;
            }
        }
        for (i = 25; i < 48; i++) {
            buf[140] = (byte)i;
            if (sha1_32(buf) == -1267116540) {
                break;
            }
        }
        for (i = 15; i < 24; i++) {
            buf[141] = (byte)i;
            if (sha1_32(buf) == 264861065) {
                break;
            }
        }
        for (i = -80; i < -60; i++) {
            buf[142] = (byte)i;
            if (sha1_32(buf) == -2067410325) {
                break;
            }
        }
        for (i = 97; i < 104; i++) {
            buf[143] = (byte)i;
            if (sha1_32(buf) == -760534617) {
                break;
            }
        }
        for (i = -113; i < -95; i++) {
            buf[144] = (byte)i;
            if (sha1_32(buf) == 466160593) {
                break;
            }
        }
        for (i = 79; i < 94; i++) {
            buf[145] = (byte)i;
            if (sha1_32(buf) == 1070001465) {
                break;
            }
        }
        for (i = 60; i < 85; i++) {
            buf[146] = (byte)i;
            if (sha1_32(buf) == -1300061424) {
                break;
            }
        }
        for (i = 33; i < 57; i++) {
            buf[147] = (byte)i;
            if (sha1_32(buf) == 1444512872) {
                break;
            }
        }
        for (i = 1; i < 14; i++) {
            buf[148] = (byte)i;
            if (sha1_32(buf) == 1362862708) {
                break;
            }
        }
        for (i = 45; i < 69; i++) {
            buf[149] = (byte)i;
            if (sha1_32(buf) == 934425721) {
                break;
            }
        }
        for (i = -61; i < -50; i++) {
            buf[150] = (byte)i;
            if (sha1_32(buf) == 1033864898) {
                break;
            }
        }
        for (i = -110; i < -95; i++) {
            buf[151] = (byte)i;
            if (sha1_32(buf) == 1917832177) {
                break;
            }
        }
        for (i = -2; i < 18; i++) {
            buf[152] = (byte)i;
            if (sha1_32(buf) == -1047147718) {
                break;
            }
        }
        for (i = -111; i < -99; i++) {
            buf[153] = (byte)i;
            if (sha1_32(buf) == -2138960640) {
                break;
            }
        }
        for (i = -128; i < -121; i++) {
            buf[154] = (byte)i;
            if (sha1_32(buf) == -1087300233) {
                break;
            }
        }
        for (i = -9; i < 7; i++) {
            buf[155] = (byte)i;
            if (sha1_32(buf) == -1563993350) {
                break;
            }
        }
        for (i = -111; i < -90; i++) {
            buf[156] = (byte)i;
            if (sha1_32(buf) == 603680908) {
                break;
            }
        }
        for (i = -43; i < -22; i++) {
            buf[157] = (byte)i;
            if (sha1_32(buf) == -1037899439) {
                break;
            }
        }
        for (i = 2; i < 12; i++) {
            buf[158] = (byte)i;
            if (sha1_32(buf) == -1135886083) {
                break;
            }
        }
        for (i = 82; i < 100; i++) {
            buf[159] = (byte)i;
            if (sha1_32(buf) == 1529762347) {
                break;
            }
        }
        for (i = -5; i < 7; i++) {
            buf[160] = (byte)i;
            if (sha1_32(buf) == 1963637666) {
                break;
            }
        }
        for (i = -25; i < -6; i++) {
            buf[161] = (byte)i;
            if (sha1_32(buf) == -1481607117) {
                break;
            }
        }
        for (i = -87; i < -56; i++) {
            buf[162] = (byte)i;
            if (sha1_32(buf) == -78189313) {
                break;
            }
        }
        for (i = -44; i < -24; i++) {
            buf[163] = (byte)i;
            if (sha1_32(buf) == -1669707507) {
                break;
            }
        }
        for (i = -81; i < -71; i++) {
            buf[164] = (byte)i;
            if (sha1_32(buf) == 507711046) {
                break;
            }
        }
        for (i = -65; i < -61; i++) {
            buf[165] = (byte)i;
            if (sha1_32(buf) == 1800356979) {
                break;
            }
        }
        for (i = -128; i < -121; i++) {
            buf[166] = (byte)i;
            if (sha1_32(buf) == 520848378) {
                break;
            }
        }
        for (i = -81; i < -70; i++) {
            buf[167] = (byte)i;
            if (sha1_32(buf) == 2129704237) {
                break;
            }
        }
        for (i = -111; i < -91; i++) {
            buf[168] = (byte)i;
            if (sha1_32(buf) == -1133644503) {
                break;
            }
        }
        for (i = 96; i < 115; i++) {
            buf[169] = (byte)i;
            if (sha1_32(buf) == -535372346) {
                break;
            }
        }
        for (i = -6; i < 10; i++) {
            buf[170] = (byte)i;
            if (sha1_32(buf) == -535372346) {
                break;
            }
        }
        for (i = 118; i < 128; i++) {
            buf[171] = (byte)i;
            if (sha1_32(buf) == 1404403832) {
                break;
            }
        }
        for (i = -98; i < -82; i++) {
            buf[172] = (byte)i;
            if (sha1_32(buf) == -50874849) {
                break;
            }
        }
        for (i = -95; i < -86; i++) {
            buf[173] = (byte)i;
            if (sha1_32(buf) == -1365599258) {
                break;
            }
        }
        for (i = -41; i < -19; i++) {
            buf[174] = (byte)i;
            if (sha1_32(buf) == 2050295382) {
                break;
            }
        }
        for (i = -58; i < -41; i++) {
            buf[175] = (byte)i;
            if (sha1_32(buf) == -916901221) {
                break;
            }
        }
        for (i = -29; i < -3; i++) {
            buf[176] = (byte)i;
            if (sha1_32(buf) == 680087818) {
                break;
            }
        }
        for (i = 69; i < 91; i++) {
            buf[177] = (byte)i;
            if (sha1_32(buf) == 2004507033) {
                break;
            }
        }
        for (i = -122; i < -113; i++) {
            buf[178] = (byte)i;
            if (sha1_32(buf) == -1166983068) {
                break;
            }
        }
        for (i = 4; i < 21; i++) {
            buf[179] = (byte)i;
            if (sha1_32(buf) == -1962480040) {
                break;
            }
        }
        for (i = 91; i < 113; i++) {
            buf[180] = (byte)i;
            if (sha1_32(buf) == -700023295) {
                break;
            }
        }
        for (i = -3; i < 8; i++) {
            buf[181] = (byte)i;
            if (sha1_32(buf) == -1372910106) {
                break;
            }
        }
        for (i = 106; i < 115; i++) {
            buf[182] = (byte)i;
            if (sha1_32(buf) == -451315288) {
                break;
            }
        }
        for (i = 33; i < 44; i++) {
            buf[183] = (byte)i;
            if (sha1_32(buf) == 790933650) {
                break;
            }
        }
        for (i = 85; i < 110; i++) {
            buf[184] = (byte)i;
            if (sha1_32(buf) == -1673262650) {
                break;
            }
        }
        for (i = 0; i < 22; i++) {
            buf[185] = (byte)i;
            if (sha1_32(buf) == -1112475121) {
                break;
            }
        }
        for (i = -11; i < 10; i++) {
            buf[186] = (byte)i;
            if (sha1_32(buf) == -1785961418) {
                break;
            }
        }
        for (i = 85; i < 104; i++) {
            buf[187] = (byte)i;
            if (sha1_32(buf) == 542453286) {
                break;
            }
        }
        for (i = 61; i < 74; i++) {
            buf[188] = (byte)i;
            if (sha1_32(buf) == 1620765774) {
                break;
            }
        }
        for (i = -73; i < -70; i++) {
            buf[189] = (byte)i;
            if (sha1_32(buf) == -726083548) {
                break;
            }
        }
        for (i = 51; i < 66; i++) {
            buf[190] = (byte)i;
            if (sha1_32(buf) == 1821801975) {
                break;
            }
        }
        for (i = -61; i < -46; i++) {
            buf[191] = (byte)i;
            if (sha1_32(buf) == -1198969678) {
                break;
            }
        }
        for (i = -26; i < -13; i++) {
            buf[192] = (byte)i;
            if (sha1_32(buf) == -1550724359) {
                break;
            }
        }
        for (i = 19; i < 25; i++) {
            buf[193] = (byte)i;
            if (sha1_32(buf) == -1199347150) {
                break;
            }
        }
        for (i = 53; i < 55; i++) {
            buf[194] = (byte)i;
            if (sha1_32(buf) == 45475642) {
                break;
            }
        }
        for (i = 84; i < 96; i++) {
            buf[195] = (byte)i;
            if (sha1_32(buf) == 1733406107) {
                break;
            }
        }
        for (i = -87; i < -71; i++) {
            buf[196] = (byte)i;
            if (sha1_32(buf) == -406780312) {
                break;
            }
        }
        for (i = -85; i < -68; i++) {
            buf[197] = (byte)i;
            if (sha1_32(buf) == -1162551974) {
                break;
            }
        }
        for (i = -84; i < -69; i++) {
            buf[198] = (byte)i;
            if (sha1_32(buf) == -2047257969) {
                break;
            }
        }
        for (i = -84; i < -66; i++) {
            buf[199] = (byte)i;
            if (sha1_32(buf) == -2031195731) {
                break;
            }
        }
        for (i = -112; i < -99; i++) {
            buf[200] = (byte)i;
            if (sha1_32(buf) == 571210558) {
                break;
            }
        }
        for (i = -117; i < -109; i++) {
            buf[201] = (byte)i;
            if (sha1_32(buf) == 468125046) {
                break;
            }
        }
        for (i = -29; i < -12; i++) {
            buf[202] = (byte)i;
            if (sha1_32(buf) == 897123155) {
                break;
            }
        }
        for (i = 32; i < 46; i++) {
            buf[203] = (byte)i;
            if (sha1_32(buf) == -2145872653) {
                break;
            }
        }
        for (i = -34; i < -23; i++) {
            buf[204] = (byte)i;
            if (sha1_32(buf) == -2028079182) {
                break;
            }
        }
        for (i = 40; i < 60; i++) {
            buf[205] = (byte)i;
            if (sha1_32(buf) == -1508209140) {
                break;
            }
        }
        for (i = 78; i < 105; i++) {
            buf[206] = (byte)i;
            if (sha1_32(buf) == -1974224155) {
                break;
            }
        }
        for (i = -16; i < -3; i++) {
            buf[207] = (byte)i;
            if (sha1_32(buf) == 1260988051) {
                break;
            }
        }
        for (i = 90; i < 116; i++) {
            buf[208] = (byte)i;
            if (sha1_32(buf) == 123868365) {
                break;
            }
        }
        for (i = 68; i < 91; i++) {
            buf[209] = (byte)i;
            if (sha1_32(buf) == -745141558) {
                break;
            }
        }
        for (i = -17; i < 2; i++) {
            buf[210] = (byte)i;
            if (sha1_32(buf) == 2060824413) {
                break;
            }
        }
        for (i = -47; i < -22; i++) {
            buf[211] = (byte)i;
            if (sha1_32(buf) == 234257428) {
                break;
            }
        }
        for (i = -83; i < -68; i++) {
            buf[212] = (byte)i;
            if (sha1_32(buf) == -223421696) {
                break;
            }
        }
        for (i = -128; i < -111; i++) {
            buf[213] = (byte)i;
            if (sha1_32(buf) == 1732354315) {
                break;
            }
        }
        for (i = 40; i < 53; i++) {
            buf[214] = (byte)i;
            if (sha1_32(buf) == -1831645328) {
                break;
            }
        }
        for (i = -113; i < -95; i++) {
            buf[215] = (byte)i;
            if (sha1_32(buf) == 1992937865) {
                break;
            }
        }
        for (i = 52; i < 70; i++) {
            buf[216] = (byte)i;
            if (sha1_32(buf) == 335508744) {
                break;
            }
        }
        for (i = 2; i < 8; i++) {
            buf[217] = (byte)i;
            if (sha1_32(buf) == -710266282) {
                break;
            }
        }
        for (i = -1; i < 15; i++) {
            buf[218] = (byte)i;
            if (sha1_32(buf) == 26367872) {
                break;
            }
        }
        for (i = -127; i < -122; i++) {
            buf[219] = (byte)i;
            if (sha1_32(buf) == -1062681715) {
                break;
            }
        }
        for (i = -11; i < 4; i++) {
            buf[220] = (byte)i;
            if (sha1_32(buf) == 1400457987) {
                break;
            }
        }
        for (i = -108; i < -97; i++) {
            buf[221] = (byte)i;
            if (sha1_32(buf) == -902432786) {
                break;
            }
        }
        for (i = -92; i < -87; i++) {
            buf[222] = (byte)i;
            if (sha1_32(buf) == -1211671685) {
                break;
            }
        }
        for (i = 85; i < 104; i++) {
            buf[223] = (byte)i;
            if (sha1_32(buf) == 601328952) {
                break;
            }
        }
        for (i = -24; i < -9; i++) {
            buf[224] = (byte)i;
            if (sha1_32(buf) == -2130168113) {
                break;
            }
        }
        for (i = -44; i < -30; i++) {
            buf[225] = (byte)i;
            if (sha1_32(buf) == -503839541) {
                break;
            }
        }
        for (i = -42; i < -20; i++) {
            buf[226] = (byte)i;
            if (sha1_32(buf) == 1320740187) {
                break;
            }
        }
        for (i = -93; i < -79; i++) {
            buf[227] = (byte)i;
            if (sha1_32(buf) == -325309944) {
                break;
            }
        }
        for (i = -73; i < -57; i++) {
            buf[228] = (byte)i;
            if (sha1_32(buf) == -1576318984) {
                break;
            }
        }
        for (i = -83; i < -65; i++) {
            buf[229] = (byte)i;
            if (sha1_32(buf) == -350742605) {
                break;
            }
        }
        for (i = 70; i < 93; i++) {
            buf[230] = (byte)i;
            if (sha1_32(buf) == 287255678) {
                break;
            }
        }
        for (i = -20; i < -7; i++) {
            buf[231] = (byte)i;
            if (sha1_32(buf) == -429411864) {
                break;
            }
        }
        for (i = 108; i < 118; i++) {
            buf[232] = (byte)i;
            if (sha1_32(buf) == -52180994) {
                break;
            }
        }
        for (i = -50; i < -35; i++) {
            buf[233] = (byte)i;
            if (sha1_32(buf) == -2033335649) {
                break;
            }
        }
        for (i = -50; i < -31; i++) {
            buf[234] = (byte)i;
            if (sha1_32(buf) == -1954562831) {
                break;
            }
        }
        for (i = 81; i < 86; i++) {
            buf[235] = (byte)i;
            if (sha1_32(buf) == -266204165) {
                break;
            }
        }
        for (i = -8; i < 9; i++) {
            buf[236] = (byte)i;
            if (sha1_32(buf) == -1874408456) {
                break;
            }
        }
        for (i = 115; i < 125; i++) {
            buf[237] = (byte)i;
            if (sha1_32(buf) == -1619869194) {
                break;
            }
        }
        for (i = -67; i < -46; i++) {
            buf[238] = (byte)i;
            if (sha1_32(buf) == 963497737) {
                break;
            }
        }
        for (i = 53; i < 62; i++) {
            buf[239] = (byte)i;
            if (sha1_32(buf) == 1162606647) {
                break;
            }
        }
        for (i = 87; i < 94; i++) {
            buf[240] = (byte)i;
            if (sha1_32(buf) == 1483666056) {
                break;
            }
        }
        for (i = -113; i < -97; i++) {
            buf[241] = (byte)i;
            if (sha1_32(buf) == 1569424831) {
                break;
            }
        }
        for (i = 70; i < 78; i++) {
            buf[242] = (byte)i;
            if (sha1_32(buf) == 449306514) {
                break;
            }
        }
        for (i = 112; i < 122; i++) {
            buf[243] = (byte)i;
            if (sha1_32(buf) == 675382355) {
                break;
            }
        }
        for (i = 8; i < 24; i++) {
            buf[244] = (byte)i;
            if (sha1_32(buf) == -954186586) {
                break;
            }
        }
        for (i = -7; i < 3; i++) {
            buf[245] = (byte)i;
            if (sha1_32(buf) == -1502121698) {
                break;
            }
        }
        for (i = -9; i < -2; i++) {
            buf[246] = (byte)i;
            if (sha1_32(buf) == 1776209396) {
                break;
            }
        }
        for (i = -107; i < -98; i++) {
            buf[247] = (byte)i;
            if (sha1_32(buf) == -1694518545) {
                break;
            }
        }
        for (i = -90; i < -80; i++) {
            buf[248] = (byte)i;
            if (sha1_32(buf) == -1568442873) {
                break;
            }
        }
        for (i = -46; i < -32; i++) {
            buf[249] = (byte)i;
            if (sha1_32(buf) == 201989520) {
                break;
            }
        }
        for (i = 96; i < 109; i++) {
            buf[250] = (byte)i;
            if (sha1_32(buf) == 325252918) {
                break;
            }
        }
        for (i = -108; i < -89; i++) {
            buf[251] = (byte)i;
            if (sha1_32(buf) == 661549724) {
                break;
            }
        }
        for (i = 6; i < 22; i++) {
            buf[252] = (byte)i;
            if (sha1_32(buf) == 1111990868) {
                break;
            }
        }
        for (i = -28; i < -13; i++) {
            buf[253] = (byte)i;
            if (sha1_32(buf) == -1709388410) {
                break;
            }
        }
        for (i = -128; i < -118; i++) {
            buf[254] = (byte)i;
            if (sha1_32(buf) == 748495588) {
                break;
            }
        }
        for (i = -37; i < -11; i++) {
            buf[255] = (byte)i;
            if (sha1_32(buf) == 1696426661) {
                break;
            }
        }
        for (i = 69; i < 71; i++) {
            buf[256] = (byte)i;
            if (sha1_32(buf) == 1574183093) {
                break;
            }
        }
        for (i = 7; i < 23; i++) {
            buf[257] = (byte)i;
            if (sha1_32(buf) == 380443132) {
                break;
            }
        }
        for (i = -53; i < -30; i++) {
            buf[258] = (byte)i;
            if (sha1_32(buf) == 333340530) {
                break;
            }
        }
        for (i = 25; i < 42; i++) {
            buf[259] = (byte)i;
            if (sha1_32(buf) == 2006215338) {
                break;
            }
        }
        for (i = -52; i < -32; i++) {
            buf[260] = (byte)i;
            if (sha1_32(buf) == 217992513) {
                break;
            }
        }
        for (i = 101; i < 115; i++) {
            buf[261] = (byte)i;
            if (sha1_32(buf) == 67261463) {
                break;
            }
        }
        for (i = 103; i < 128; i++) {
            buf[262] = (byte)i;
            if (sha1_32(buf) == 1747015854) {
                break;
            }
        }
        for (i = -5; i < 22; i++) {
            buf[263] = (byte)i;
            if (sha1_32(buf) == -12835468) {
                break;
            }
        }
        for (i = 9; i < 17; i++) {
            buf[264] = (byte)i;
            if (sha1_32(buf) == -488567373) {
                break;
            }
        }
        for (i = 13; i < 34; i++) {
            buf[265] = (byte)i;
            if (sha1_32(buf) == 1306878021) {
                break;
            }
        }
        for (i = -56; i < -39; i++) {
            buf[266] = (byte)i;
            if (sha1_32(buf) == -1580190408) {
                break;
            }
        }
        for (i = -37; i < -28; i++) {
            buf[267] = (byte)i;
            if (sha1_32(buf) == -1003508345) {
                break;
            }
        }
        for (i = -64; i < -48; i++) {
            buf[268] = (byte)i;
            if (sha1_32(buf) == -675370496) {
                break;
            }
        }
        for (i = 48; i < 72; i++) {
            buf[269] = (byte)i;
            if (sha1_32(buf) == -1426051660) {
                break;
            }
        }
        for (i = -42; i < -22; i++) {
            buf[270] = (byte)i;
            if (sha1_32(buf) == 1003418310) {
                break;
            }
        }
        for (i = 79; i < 93; i++) {
            buf[271] = (byte)i;
            if (sha1_32(buf) == 1894851896) {
                break;
            }
        }
        for (i = 96; i < 112; i++) {
            buf[272] = (byte)i;
            if (sha1_32(buf) == -1301461977) {
                break;
            }
        }
        for (i = 83; i < 87; i++) {
            buf[273] = (byte)i;
            if (sha1_32(buf) == -766912227) {
                break;
            }
        }
        for (i = -117; i < -98; i++) {
            buf[274] = (byte)i;
            if (sha1_32(buf) == -1553975724) {
                break;
            }
        }
        for (i = 63; i < 89; i++) {
            buf[275] = (byte)i;
            if (sha1_32(buf) == -815857387) {
                break;
            }
        }
        for (i = 9; i < 16; i++) {
            buf[276] = (byte)i;
            if (sha1_32(buf) == -1823437791) {
                break;
            }
        }
        for (i = -116; i < -108; i++) {
            buf[277] = (byte)i;
            if (sha1_32(buf) == 1433964054) {
                break;
            }
        }
        for (i = -114; i < -100; i++) {
            buf[278] = (byte)i;
            if (sha1_32(buf) == 589872103) {
                break;
            }
        }
        for (i = -58; i < -42; i++) {
            buf[279] = (byte)i;
            if (sha1_32(buf) == -1569746672) {
                break;
            }
        }
        for (i = -33; i < -3; i++) {
            buf[280] = (byte)i;
            if (sha1_32(buf) == -1418227485) {
                break;
            }
        }
        for (i = -106; i < -96; i++) {
            buf[281] = (byte)i;
            if (sha1_32(buf) == -1513657136) {
                break;
            }
        }
        for (i = 7; i < 25; i++) {
            buf[282] = (byte)i;
            if (sha1_32(buf) == -1723278662) {
                break;
            }
        }
        for (i = -87; i < -73; i++) {
            buf[283] = (byte)i;
            if (sha1_32(buf) == -1825537728) {
                break;
            }
        }
        for (i = 100; i < 116; i++) {
            buf[284] = (byte)i;
            if (sha1_32(buf) == -1471753133) {
                break;
            }
        }
        for (i = 108; i < 112; i++) {
            buf[285] = (byte)i;
            if (sha1_32(buf) == -1892700172) {
                break;
            }
        }
        for (i = -90; i < -68; i++) {
            buf[286] = (byte)i;
            if (sha1_32(buf) == 510287426) {
                break;
            }
        }
        for (i = 39; i < 48; i++) {
            buf[287] = (byte)i;
            if (sha1_32(buf) == 96973082) {
                break;
            }
        }
        for (i = 86; i < 104; i++) {
            buf[288] = (byte)i;
            if (sha1_32(buf) == 1819146816) {
                break;
            }
        }
        for (i = 20; i < 48; i++) {
            buf[289] = (byte)i;
            if (sha1_32(buf) == 563695151) {
                break;
            }
        }
        for (i = 107; i < 124; i++) {
            buf[290] = (byte)i;
            if (sha1_32(buf) == -1642754715) {
                break;
            }
        }
        for (i = -77; i < -48; i++) {
            buf[291] = (byte)i;
            if (sha1_32(buf) == 1544055807) {
                break;
            }
        }
        for (i = -108; i < -89; i++) {
            buf[292] = (byte)i;
            if (sha1_32(buf) == -783128117) {
                break;
            }
        }
        for (i = 18; i < 29; i++) {
            buf[293] = (byte)i;
            if (sha1_32(buf) == -2072420385) {
                break;
            }
        }
        for (i = 11; i < 20; i++) {
            buf[294] = (byte)i;
            if (sha1_32(buf) == -1656228181) {
                break;
            }
        }
        for (i = 98; i < 120; i++) {
            buf[295] = (byte)i;
            if (sha1_32(buf) == 782143293) {
                break;
            }
        }
        for (i = -25; i < -18; i++) {
            buf[296] = (byte)i;
            if (sha1_32(buf) == 1352072963) {
                break;
            }
        }
        for (i = 80; i < 91; i++) {
            buf[297] = (byte)i;
            if (sha1_32(buf) == -2021069237) {
                break;
            }
        }
        for (i = 108; i < 117; i++) {
            buf[298] = (byte)i;
            if (sha1_32(buf) == -735254922) {
                break;
            }
        }
        for (i = -105; i < -93; i++) {
            buf[299] = (byte)i;
            if (sha1_32(buf) == -1771329248) {
                break;
            }
        }
        for (i = -28; i < -14; i++) {
            buf[300] = (byte)i;
            if (sha1_32(buf) == -136895461) {
                break;
            }
        }
        for (i = 64; i < 84; i++) {
            buf[301] = (byte)i;
            if (sha1_32(buf) == -725287682) {
                break;
            }
        }
        for (i = 5; i < 27; i++) {
            buf[302] = (byte)i;
            if (sha1_32(buf) == -2015720333) {
                break;
            }
        }
        for (i = 7; i < 23; i++) {
            buf[303] = (byte)i;
            if (sha1_32(buf) == -806397602) {
                break;
            }
        }
        for (i = -128; i < -119; i++) {
            buf[304] = (byte)i;
            if (sha1_32(buf) == 832049532) {
                break;
            }
        }
        for (i = -128; i < -112; i++) {
            buf[305] = (byte)i;
            if (sha1_32(buf) == -509636544) {
                break;
            }
        }
        for (i = -127; i < -111; i++) {
            buf[306] = (byte)i;
            if (sha1_32(buf) == 2035695995) {
                break;
            }
        }
        for (i = -70; i < -48; i++) {
            buf[307] = (byte)i;
            if (sha1_32(buf) == -1687873680) {
                break;
            }
        }
        for (i = 74; i < 93; i++) {
            buf[308] = (byte)i;
            if (sha1_32(buf) == 1467568431) {
                break;
            }
        }
        for (i = 100; i < 113; i++) {
            buf[309] = (byte)i;
            if (sha1_32(buf) == 635158218) {
                break;
            }
        }
        for (i = 72; i < 92; i++) {
            buf[310] = (byte)i;
            if (sha1_32(buf) == 529246) {
                break;
            }
        }
        for (i = 117; i < 128; i++) {
            buf[311] = (byte)i;
            if (sha1_32(buf) == -590798181) {
                break;
            }
        }
        for (i = -57; i < -33; i++) {
            buf[312] = (byte)i;
            if (sha1_32(buf) == -256085385) {
                break;
            }
        }
        for (i = -14; i < -8; i++) {
            buf[313] = (byte)i;
            if (sha1_32(buf) == 28484048) {
                break;
            }
        }
        for (i = 89; i < 114; i++) {
            buf[314] = (byte)i;
            if (sha1_32(buf) == -1629137688) {
                break;
            }
        }
        for (i = 23; i < 30; i++) {
            buf[315] = (byte)i;
            if (sha1_32(buf) == -591122940) {
                break;
            }
        }
        for (i = -90; i < -76; i++) {
            buf[316] = (byte)i;
            if (sha1_32(buf) == 276918326) {
                break;
            }
        }
        for (i = -34; i < -19; i++) {
            buf[317] = (byte)i;
            if (sha1_32(buf) == 1825705836) {
                break;
            }
        }
        for (i = -99; i < -84; i++) {
            buf[318] = (byte)i;
            if (sha1_32(buf) == -1090864134) {
                break;
            }
        }
        for (i = -42; i < -39; i++) {
            buf[319] = (byte)i;
            if (sha1_32(buf) == -855643325) {
                break;
            }
        }
        for (i = 33; i < 63; i++) {
            buf[320] = (byte)i;
            if (sha1_32(buf) == -927195010) {
                break;
            }
        }
        for (i = -104; i < -91; i++) {
            buf[321] = (byte)i;
            if (sha1_32(buf) == -207805576) {
                break;
            }
        }
        for (i = -60; i < -46; i++) {
            buf[322] = (byte)i;
            if (sha1_32(buf) == 347416392) {
                break;
            }
        }
        for (i = -26; i < -16; i++) {
            buf[323] = (byte)i;
            if (sha1_32(buf) == 1533238936) {
                break;
            }
        }
        for (i = 37; i < 52; i++) {
            buf[324] = (byte)i;
            if (sha1_32(buf) == -178363351) {
                break;
            }
        }
        for (i = 32; i < 42; i++) {
            buf[325] = (byte)i;
            if (sha1_32(buf) == 1327355752) {
                break;
            }
        }
        for (i = -1; i < 12; i++) {
            buf[326] = (byte)i;
            if (sha1_32(buf) == 1486016495) {
                break;
            }
        }
        for (i = -60; i < -42; i++) {
            buf[327] = (byte)i;
            if (sha1_32(buf) == -57485390) {
                break;
            }
        }
        for (i = 3; i < 19; i++) {
            buf[328] = (byte)i;
            if (sha1_32(buf) == 354267183) {
                break;
            }
        }
        for (i = -96; i < -73; i++) {
            buf[329] = (byte)i;
            if (sha1_32(buf) == 980703824) {
                break;
            }
        }
        for (i = 28; i < 45; i++) {
            buf[330] = (byte)i;
            if (sha1_32(buf) == -29764483) {
                break;
            }
        }
        for (i = -98; i < -78; i++) {
            buf[331] = (byte)i;
            if (sha1_32(buf) == -1417381008) {
                break;
            }
        }
        for (i = -72; i < -63; i++) {
            buf[332] = (byte)i;
            if (sha1_32(buf) == 1004546736) {
                break;
            }
        }
        for (i = -33; i < -12; i++) {
            buf[333] = (byte)i;
            if (sha1_32(buf) == 1826678872) {
                break;
            }
        }
        for (i = -53; i < -36; i++) {
            buf[334] = (byte)i;
            if (sha1_32(buf) == -268872953) {
                break;
            }
        }
        for (i = -86; i < -73; i++) {
            buf[335] = (byte)i;
            if (sha1_32(buf) == -1407229477) {
                break;
            }
        }
        for (i = 110; i < 118; i++) {
            buf[336] = (byte)i;
            if (sha1_32(buf) == 1490759878) {
                break;
            }
        }
        for (i = 93; i < 109; i++) {
            buf[337] = (byte)i;
            if (sha1_32(buf) == 829747897) {
                break;
            }
        }
        for (i = 50; i < 67; i++) {
            buf[338] = (byte)i;
            if (sha1_32(buf) == -1172908508) {
                break;
            }
        }
        for (i = -87; i < -79; i++) {
            buf[339] = (byte)i;
            if (sha1_32(buf) == -1786765063) {
                break;
            }
        }
        for (i = 84; i < 98; i++) {
            buf[340] = (byte)i;
            if (sha1_32(buf) == 1892954216) {
                break;
            }
        }
        for (i = -33; i < -4; i++) {
            buf[341] = (byte)i;
            if (sha1_32(buf) == -1544648311) {
                break;
            }
        }
        for (i = -13; i < 0; i++) {
            buf[342] = (byte)i;
            if (sha1_32(buf) == 1126046923) {
                break;
            }
        }
        for (i = 80; i < 96; i++) {
            buf[343] = (byte)i;
            if (sha1_32(buf) == 1468477773) {
                break;
            }
        }
        for (i = -16; i < 6; i++) {
            buf[344] = (byte)i;
            if (sha1_32(buf) == -1545510550) {
                break;
            }
        }
        for (i = 30; i < 35; i++) {
            buf[345] = (byte)i;
            if (sha1_32(buf) == -232811485) {
                break;
            }
        }
        for (i = 112; i < 128; i++) {
            buf[346] = (byte)i;
            if (sha1_32(buf) == 505835765) {
                break;
            }
        }
        for (i = 71; i < 88; i++) {
            buf[347] = (byte)i;
            if (sha1_32(buf) == 1900978147) {
                break;
            }
        }
        for (i = -53; i < -43; i++) {
            buf[348] = (byte)i;
            if (sha1_32(buf) == 1607548629) {
                break;
            }
        }
        for (i = -98; i < -92; i++) {
            buf[349] = (byte)i;
            if (sha1_32(buf) == 226429175) {
                break;
            }
        }
        for (i = -45; i < -25; i++) {
            buf[350] = (byte)i;
            if (sha1_32(buf) == 1199427051) {
                break;
            }
        }
        for (i = 116; i < 123; i++) {
            buf[351] = (byte)i;
            if (sha1_32(buf) == -1001507301) {
                break;
            }
        }
        for (i = -128; i < -108; i++) {
            buf[352] = (byte)i;
            if (sha1_32(buf) == 1136164639) {
                break;
            }
        }
        for (i = 13; i < 28; i++) {
            buf[353] = (byte)i;
            if (sha1_32(buf) == 1868512121) {
                break;
            }
        }
        for (i = -64; i < -44; i++) {
            buf[354] = (byte)i;
            if (sha1_32(buf) == -975149327) {
                break;
            }
        }
        for (i = -116; i < -106; i++) {
            buf[355] = (byte)i;
            if (sha1_32(buf) == -1197589340) {
                break;
            }
        }
        for (i = -97; i < -78; i++) {
            buf[356] = (byte)i;
            if (sha1_32(buf) == -1273436206) {
                break;
            }
        }
        for (i = -126; i < -106; i++) {
            buf[357] = (byte)i;
            if (sha1_32(buf) == -1757418509) {
                break;
            }
        }
        for (i = 80; i < 85; i++) {
            buf[358] = (byte)i;
            if (sha1_32(buf) == -1207862530) {
                break;
            }
        }
        for (i = -16; i < 8; i++) {
            buf[359] = (byte)i;
            if (sha1_32(buf) == 1627617509) {
                break;
            }
        }
        for (i = -62; i < -49; i++) {
            buf[360] = (byte)i;
            if (sha1_32(buf) == 1729666031) {
                break;
            }
        }
        for (i = 35; i < 49; i++) {
            buf[361] = (byte)i;
            if (sha1_32(buf) == -1520119287) {
                break;
            }
        }
        for (i = 92; i < 99; i++) {
            buf[362] = (byte)i;
            if (sha1_32(buf) == -196720867) {
                break;
            }
        }
        for (i = 43; i < 65; i++) {
            buf[363] = (byte)i;
            if (sha1_32(buf) == 534576065) {
                break;
            }
        }
        for (i = -102; i < -90; i++) {
            buf[364] = (byte)i;
            if (sha1_32(buf) == 1042147672) {
                break;
            }
        }
        for (i = 98; i < 109; i++) {
            buf[365] = (byte)i;
            if (sha1_32(buf) == -990685778) {
                break;
            }
        }
        for (i = -51; i < -46; i++) {
            buf[366] = (byte)i;
            if (sha1_32(buf) == -202603082) {
                break;
            }
        }
        for (i = 32; i < 58; i++) {
            buf[367] = (byte)i;
            if (sha1_32(buf) == 1898753380) {
                break;
            }
        }
        for (i = 51; i < 66; i++) {
            buf[368] = (byte)i;
            if (sha1_32(buf) == -1205723739) {
                break;
            }
        }
        for (i = -31; i < -22; i++) {
            buf[369] = (byte)i;
            if (sha1_32(buf) == 819231837) {
                break;
            }
        }
        for (i = -62; i < -43; i++) {
            buf[370] = (byte)i;
            if (sha1_32(buf) == 1022869912) {
                break;
            }
        }
        for (i = 103; i < 120; i++) {
            buf[371] = (byte)i;
            if (sha1_32(buf) == -1579684961) {
                break;
            }
        }
        for (i = -98; i < -83; i++) {
            buf[372] = (byte)i;
            if (sha1_32(buf) == -1079358131) {
                break;
            }
        }
        for (i = -50; i < -38; i++) {
            buf[373] = (byte)i;
            if (sha1_32(buf) == -1497556041) {
                break;
            }
        }
        for (i = 59; i < 73; i++) {
            buf[374] = (byte)i;
            if (sha1_32(buf) == 2010804279) {
                break;
            }
        }
        for (i = 19; i < 38; i++) {
            buf[375] = (byte)i;
            if (sha1_32(buf) == -1789340015) {
                break;
            }
        }
        for (i = 58; i < 77; i++) {
            buf[376] = (byte)i;
            if (sha1_32(buf) == 1682178843) {
                break;
            }
        }
        for (i = 16; i < 25; i++) {
            buf[377] = (byte)i;
            if (sha1_32(buf) == 1378703558) {
                break;
            }
        }
        for (i = 63; i < 86; i++) {
            buf[378] = (byte)i;
            if (sha1_32(buf) == -189526379) {
                break;
            }
        }
        for (i = -2; i < 5; i++) {
            buf[379] = (byte)i;
            if (sha1_32(buf) == -189526379) {
                break;
            }
        }
        for (i = 103; i < 119; i++) {
            buf[380] = (byte)i;
            if (sha1_32(buf) == -1493919331) {
                break;
            }
        }
        for (i = 58; i < 74; i++) {
            buf[381] = (byte)i;
            if (sha1_32(buf) == -1638085708) {
                break;
            }
        }
        for (i = 20; i < 40; i++) {
            buf[382] = (byte)i;
            if (sha1_32(buf) == -138866369) {
                break;
            }
        }
        for (i = -35; i < -21; i++) {
            buf[383] = (byte)i;
            if (sha1_32(buf) == -1214908304) {
                break;
            }
        }
        for (i = 63; i < 85; i++) {
            buf[384] = (byte)i;
            if (sha1_32(buf) == -2002596822) {
                break;
            }
        }
        for (i = 104; i < 123; i++) {
            buf[385] = (byte)i;
            if (sha1_32(buf) == -519253293) {
                break;
            }
        }
        for (i = -21; i < -8; i++) {
            buf[386] = (byte)i;
            if (sha1_32(buf) == -1426878829) {
                break;
            }
        }
        for (i = 20; i < 33; i++) {
            buf[387] = (byte)i;
            if (sha1_32(buf) == -1946672662) {
                break;
            }
        }
        for (i = -127; i < -105; i++) {
            buf[388] = (byte)i;
            if (sha1_32(buf) == -1502132273) {
                break;
            }
        }
        for (i = -68; i < -61; i++) {
            buf[389] = (byte)i;
            if (sha1_32(buf) == -120029676) {
                break;
            }
        }
        for (i = -69; i < -67; i++) {
            buf[390] = (byte)i;
            if (sha1_32(buf) == 1824281001) {
                break;
            }
        }
        for (i = 11; i < 27; i++) {
            buf[391] = (byte)i;
            if (sha1_32(buf) == 1484540690) {
                break;
            }
        }
        for (i = -110; i < -100; i++) {
            buf[392] = (byte)i;
            if (sha1_32(buf) == -1127628280) {
                break;
            }
        }
        for (i = -39; i < -27; i++) {
            buf[393] = (byte)i;
            if (sha1_32(buf) == 684640881) {
                break;
            }
        }
        for (i = 92; i < 111; i++) {
            buf[394] = (byte)i;
            if (sha1_32(buf) == -333560495) {
                break;
            }
        }
        for (i = -66; i < -53; i++) {
            buf[395] = (byte)i;
            if (sha1_32(buf) == 1339395349) {
                break;
            }
        }
        for (i = -21; i < 4; i++) {
            buf[396] = (byte)i;
            if (sha1_32(buf) == 1503409196) {
                break;
            }
        }
        for (i = 80; i < 87; i++) {
            buf[397] = (byte)i;
            if (sha1_32(buf) == -1395371918) {
                break;
            }
        }
        for (i = 66; i < 82; i++) {
            buf[398] = (byte)i;
            if (sha1_32(buf) == 1523592570) {
                break;
            }
        }
        for (i = 50; i < 63; i++) {
            buf[399] = (byte)i;
            if (sha1_32(buf) == -598052002) {
                break;
            }
        }
        for (i = 1; i < 19; i++) {
            buf[400] = (byte)i;
            if (sha1_32(buf) == -1469115169) {
                break;
            }
        }
        for (i = 23; i < 41; i++) {
            buf[401] = (byte)i;
            if (sha1_32(buf) == -1120515551) {
                break;
            }
        }
        for (i = -114; i < -102; i++) {
            buf[402] = (byte)i;
            if (sha1_32(buf) == -290080009) {
                break;
            }
        }
        for (i = 79; i < 97; i++) {
            buf[403] = (byte)i;
            if (sha1_32(buf) == 1253539812) {
                break;
            }
        }
        for (i = -112; i < -101; i++) {
            buf[404] = (byte)i;
            if (sha1_32(buf) == 917958505) {
                break;
            }
        }
        for (i = 101; i < 116; i++) {
            buf[405] = (byte)i;
            if (sha1_32(buf) == -1061099991) {
                break;
            }
        }
        for (i = -65; i < -53; i++) {
            buf[406] = (byte)i;
            if (sha1_32(buf) == 1040837610) {
                break;
            }
        }
        for (i = -81; i < -71; i++) {
            buf[407] = (byte)i;
            if (sha1_32(buf) == -1527109495) {
                break;
            }
        }
        for (i = 93; i < 106; i++) {
            buf[408] = (byte)i;
            if (sha1_32(buf) == 906720529) {
                break;
            }
        }
        for (i = -42; i < -38; i++) {
            buf[409] = (byte)i;
            if (sha1_32(buf) == 1278315651) {
                break;
            }
        }
        for (i = -5; i < -1; i++) {
            buf[410] = (byte)i;
            if (sha1_32(buf) == -1319930380) {
                break;
            }
        }
        for (i = 121; i < 128; i++) {
            buf[411] = (byte)i;
            if (sha1_32(buf) == -1833409150) {
                break;
            }
        }
        for (i = -44; i < -27; i++) {
            buf[412] = (byte)i;
            if (sha1_32(buf) == -776958785) {
                break;
            }
        }
        for (i = -98; i < -81; i++) {
            buf[413] = (byte)i;
            if (sha1_32(buf) == -1715755091) {
                break;
            }
        }
        for (i = -122; i < -108; i++) {
            buf[414] = (byte)i;
            if (sha1_32(buf) == -2023869835) {
                break;
            }
        }
        for (i = 42; i < 49; i++) {
            buf[415] = (byte)i;
            if (sha1_32(buf) == -1468318881) {
                break;
            }
        }
        for (i = 109; i < 126; i++) {
            buf[416] = (byte)i;
            if (sha1_32(buf) == -125931365) {
                break;
            }
        }
        for (i = -128; i < -121; i++) {
            buf[417] = (byte)i;
            if (sha1_32(buf) == -1265705460) {
                break;
            }
        }
        for (i = -104; i < -92; i++) {
            buf[418] = (byte)i;
            if (sha1_32(buf) == -20068425) {
                break;
            }
        }
        for (i = 63; i < 88; i++) {
            buf[419] = (byte)i;
            if (sha1_32(buf) == 589862149) {
                break;
            }
        }
        for (i = 37; i < 42; i++) {
            buf[420] = (byte)i;
            if (sha1_32(buf) == 889793423) {
                break;
            }
        }
        for (i = -87; i < -68; i++) {
            buf[421] = (byte)i;
            if (sha1_32(buf) == 190388401) {
                break;
            }
        }
        for (i = 47; i < 66; i++) {
            buf[422] = (byte)i;
            if (sha1_32(buf) == -1166211958) {
                break;
            }
        }
        for (i = 20; i < 47; i++) {
            buf[423] = (byte)i;
            if (sha1_32(buf) == 852566329) {
                break;
            }
        }
        for (i = -25; i < -15; i++) {
            buf[424] = (byte)i;
            if (sha1_32(buf) == 1401551381) {
                break;
            }
        }
        for (i = 48; i < 61; i++) {
            buf[425] = (byte)i;
            if (sha1_32(buf) == -1782147257) {
                break;
            }
        }
        for (i = 118; i < 128; i++) {
            buf[426] = (byte)i;
            if (sha1_32(buf) == -115205790) {
                break;
            }
        }
        for (i = -59; i < -36; i++) {
            buf[427] = (byte)i;
            if (sha1_32(buf) == 1323516322) {
                break;
            }
        }
        for (i = 120; i < 128; i++) {
            buf[428] = (byte)i;
            if (sha1_32(buf) == -1133013474) {
                break;
            }
        }
        for (i = -84; i < -72; i++) {
            buf[429] = (byte)i;
            if (sha1_32(buf) == 295623958) {
                break;
            }
        }
        for (i = -89; i < -75; i++) {
            buf[430] = (byte)i;
            if (sha1_32(buf) == 186215392) {
                break;
            }
        }
        for (i = 26; i < 32; i++) {
            buf[431] = (byte)i;
            if (sha1_32(buf) == 545846334) {
                break;
            }
        }
        for (i = 26; i < 44; i++) {
            buf[432] = (byte)i;
            if (sha1_32(buf) == 1266255432) {
                break;
            }
        }
        for (i = 82; i < 106; i++) {
            buf[433] = (byte)i;
            if (sha1_32(buf) == 644383321) {
                break;
            }
        }
        for (i = -124; i < -102; i++) {
            buf[434] = (byte)i;
            if (sha1_32(buf) == 1016287980) {
                break;
            }
        }
        for (i = -67; i < -48; i++) {
            buf[435] = (byte)i;
            if (sha1_32(buf) == 1291552835) {
                break;
            }
        }
        for (i = 20; i < 37; i++) {
            buf[436] = (byte)i;
            if (sha1_32(buf) == -1173388644) {
                break;
            }
        }
        for (i = 49; i < 68; i++) {
            buf[437] = (byte)i;
            if (sha1_32(buf) == -1158101474) {
                break;
            }
        }
        for (i = 103; i < 120; i++) {
            buf[438] = (byte)i;
            if (sha1_32(buf) == -1701929469) {
                break;
            }
        }
        for (i = -73; i < -56; i++) {
            buf[439] = (byte)i;
            if (sha1_32(buf) == 389650659) {
                break;
            }
        }
        for (i = -54; i < -32; i++) {
            buf[440] = (byte)i;
            if (sha1_32(buf) == -1862786664) {
                break;
            }
        }
        for (i = -128; i < -115; i++) {
            buf[441] = (byte)i;
            if (sha1_32(buf) == -1602655559) {
                break;
            }
        }
        for (i = -117; i < -105; i++) {
            buf[442] = (byte)i;
            if (sha1_32(buf) == -569224308) {
                break;
            }
        }
        for (i = 51; i < 68; i++) {
            buf[443] = (byte)i;
            if (sha1_32(buf) == -625118322) {
                break;
            }
        }
        for (i = -128; i < -114; i++) {
            buf[444] = (byte)i;
            if (sha1_32(buf) == -1140556058) {
                break;
            }
        }
        for (i = -49; i < -43; i++) {
            buf[445] = (byte)i;
            if (sha1_32(buf) == 2060435152) {
                break;
            }
        }
        for (i = -36; i < -16; i++) {
            buf[446] = (byte)i;
            if (sha1_32(buf) == 1333829037) {
                break;
            }
        }
        for (i = 59; i < 85; i++) {
            buf[447] = (byte)i;
            if (sha1_32(buf) == -202825242) {
                break;
            }
        }
        for (i = -102; i < -84; i++) {
            buf[448] = (byte)i;
            if (sha1_32(buf) == 231712328) {
                break;
            }
        }
        for (i = -118; i < -103; i++) {
            buf[449] = (byte)i;
            if (sha1_32(buf) == 380495864) {
                break;
            }
        }
        for (i = 59; i < 77; i++) {
            buf[450] = (byte)i;
            if (sha1_32(buf) == -684265352) {
                break;
            }
        }
        for (i = 74; i < 95; i++) {
            buf[451] = (byte)i;
            if (sha1_32(buf) == 1771471365) {
                break;
            }
        }
        for (i = -32; i < -28; i++) {
            buf[452] = (byte)i;
            if (sha1_32(buf) == 713220313) {
                break;
            }
        }
        for (i = 19; i < 34; i++) {
            buf[453] = (byte)i;
            if (sha1_32(buf) == 1160390101) {
                break;
            }
        }
        for (i = 58; i < 71; i++) {
            buf[454] = (byte)i;
            if (sha1_32(buf) == -1094759331) {
                break;
            }
        }
        for (i = 52; i < 64; i++) {
            buf[455] = (byte)i;
            if (sha1_32(buf) == -320257660) {
                break;
            }
        }
        for (i = 15; i < 27; i++) {
            buf[456] = (byte)i;
            if (sha1_32(buf) == 989837241) {
                break;
            }
        }
        for (i = 42; i < 64; i++) {
            buf[457] = (byte)i;
            if (sha1_32(buf) == 1256472468) {
                break;
            }
        }
        for (i = -6; i < 3; i++) {
            buf[458] = (byte)i;
            if (sha1_32(buf) == 1710113707) {
                break;
            }
        }
        for (i = 100; i < 120; i++) {
            buf[459] = (byte)i;
            if (sha1_32(buf) == -1542203080) {
                break;
            }
        }
        for (i = -57; i < -39; i++) {
            buf[460] = (byte)i;
            if (sha1_32(buf) == -1589313321) {
                break;
            }
        }
        for (i = 79; i < 103; i++) {
            buf[461] = (byte)i;
            if (sha1_32(buf) == 256200221) {
                break;
            }
        }
        for (i = 94; i < 114; i++) {
            buf[462] = (byte)i;
            if (sha1_32(buf) == -1922656103) {
                break;
            }
        }
        for (i = -40; i < -37; i++) {
            buf[463] = (byte)i;
            if (sha1_32(buf) == -1003897894) {
                break;
            }
        }
        for (i = 13; i < 31; i++) {
            buf[464] = (byte)i;
            if (sha1_32(buf) == -1698887621) {
                break;
            }
        }
        for (i = 111; i < 112; i++) {
            buf[465] = (byte)i;
            if (sha1_32(buf) == -1610386819) {
                break;
            }
        }
        for (i = -43; i < -15; i++) {
            buf[466] = (byte)i;
            if (sha1_32(buf) == -1513601644) {
                break;
            }
        }
        for (i = 17; i < 22; i++) {
            buf[467] = (byte)i;
            if (sha1_32(buf) == -1230888752) {
                break;
            }
        }
        for (i = 40; i < 64; i++) {
            buf[468] = (byte)i;
            if (sha1_32(buf) == 1727997953) {
                break;
            }
        }
        for (i = 20; i < 28; i++) {
            buf[469] = (byte)i;
            if (sha1_32(buf) == -1390668794) {
                break;
            }
        }
        for (i = -10; i < 0; i++) {
            buf[470] = (byte)i;
            if (sha1_32(buf) == 1010939591) {
                break;
            }
        }
        for (i = -48; i < -29; i++) {
            buf[471] = (byte)i;
            if (sha1_32(buf) == 1470748237) {
                break;
            }
        }
        for (i = 41; i < 55; i++) {
            buf[472] = (byte)i;
            if (sha1_32(buf) == -613390853) {
                break;
            }
        }
        for (i = 49; i < 73; i++) {
            buf[473] = (byte)i;
            if (sha1_32(buf) == 686972396) {
                break;
            }
        }
        for (i = 98; i < 120; i++) {
            buf[474] = (byte)i;
            if (sha1_32(buf) == -1589964412) {
                break;
            }
        }
        for (i = -59; i < -43; i++) {
            buf[475] = (byte)i;
            if (sha1_32(buf) == 1211298354) {
                break;
            }
        }
        for (i = 77; i < 103; i++) {
            buf[476] = (byte)i;
            if (sha1_32(buf) == -84290739) {
                break;
            }
        }
        for (i = -10; i < 12; i++) {
            buf[477] = (byte)i;
            if (sha1_32(buf) == 791134247) {
                break;
            }
        }
        for (i = 98; i < 119; i++) {
            buf[478] = (byte)i;
            if (sha1_32(buf) == 1046983253) {
                break;
            }
        }
        for (i = 49; i < 56; i++) {
            buf[479] = (byte)i;
            if (sha1_32(buf) == 1331693565) {
                break;
            }
        }
        for (i = -16; i < 0; i++) {
            buf[480] = (byte)i;
            if (sha1_32(buf) == 1731359706) {
                break;
            }
        }
        for (i = 19; i < 29; i++) {
            buf[481] = (byte)i;
            if (sha1_32(buf) == 1300583620) {
                break;
            }
        }
        for (i = -82; i < -67; i++) {
            buf[482] = (byte)i;
            if (sha1_32(buf) == -1196647282) {
                break;
            }
        }
        for (i = 3; i < 13; i++) {
            buf[483] = (byte)i;
            if (sha1_32(buf) == -1671326857) {
                break;
            }
        }
        for (i = 26; i < 52; i++) {
            buf[484] = (byte)i;
            if (sha1_32(buf) == 1465479764) {
                break;
            }
        }
        for (i = -21; i < -15; i++) {
            buf[485] = (byte)i;
            if (sha1_32(buf) == -1276384405) {
                break;
            }
        }
        for (i = 1; i < 19; i++) {
            buf[486] = (byte)i;
            if (sha1_32(buf) == 883853535) {
                break;
            }
        }
        for (i = -3; i < 24; i++) {
            buf[487] = (byte)i;
            if (sha1_32(buf) == -1448531852) {
                break;
            }
        }
        for (i = -94; i < -84; i++) {
            buf[488] = (byte)i;
            if (sha1_32(buf) == -1060569912) {
                break;
            }
        }
        for (i = -101; i < -84; i++) {
            buf[489] = (byte)i;
            if (sha1_32(buf) == -643844113) {
                break;
            }
        }
        for (i = 1; i < 26; i++) {
            buf[490] = (byte)i;
            if (sha1_32(buf) == -492006172) {
                break;
            }
        }
        for (i = -54; i < -27; i++) {
            buf[491] = (byte)i;
            if (sha1_32(buf) == 1544252443) {
                break;
            }
        }
        for (i = -22; i < 4; i++) {
            buf[492] = (byte)i;
            if (sha1_32(buf) == 1676446192) {
                break;
            }
        }
        for (i = 77; i < 108; i++) {
            buf[493] = (byte)i;
            if (sha1_32(buf) == -1914293107) {
                break;
            }
        }
        for (i = -116; i < -110; i++) {
            buf[494] = (byte)i;
            if (sha1_32(buf) == -558868687) {
                break;
            }
        }
        for (i = 46; i < 65; i++) {
            buf[495] = (byte)i;
            if (sha1_32(buf) == 239211290) {
                break;
            }
        }
        for (i = 64; i < 79; i++) {
            buf[496] = (byte)i;
            if (sha1_32(buf) == 1002072756) {
                break;
            }
        }
        for (i = 72; i < 95; i++) {
            buf[497] = (byte)i;
            if (sha1_32(buf) == -1676733061) {
                break;
            }
        }
        for (i = 84; i < 104; i++) {
            buf[498] = (byte)i;
            if (sha1_32(buf) == -1506689740) {
                break;
            }
        }
        for (i = -128; i < -109; i++) {
            buf[499] = (byte)i;
            if (sha1_32(buf) == 2068960762) {
                break;
            }
        }
        for (i = -46; i < -43; i++) {
            buf[500] = (byte)i;
            if (sha1_32(buf) == -2120075037) {
                break;
            }
        }
        for (i = -121; i < -108; i++) {
            buf[501] = (byte)i;
            if (sha1_32(buf) == 1622802686) {
                break;
            }
        }
        for (i = 87; i < 102; i++) {
            buf[502] = (byte)i;
            if (sha1_32(buf) == -26908262) {
                break;
            }
        }
        for (i = -18; i < 3; i++) {
            buf[503] = (byte)i;
            if (sha1_32(buf) == 1940241025) {
                break;
            }
        }
        for (i = -61; i < -41; i++) {
            buf[504] = (byte)i;
            if (sha1_32(buf) == 1526957284) {
                break;
            }
        }
        for (i = -79; i < -54; i++) {
            buf[505] = (byte)i;
            if (sha1_32(buf) == 1023247768) {
                break;
            }
        }
        for (i = -128; i < -122; i++) {
            buf[506] = (byte)i;
            if (sha1_32(buf) == 958592999) {
                break;
            }
        }
        for (i = -57; i < -36; i++) {
            buf[507] = (byte)i;
            if (sha1_32(buf) == -334601413) {
                break;
            }
        }
        for (i = 67; i < 86; i++) {
            buf[508] = (byte)i;
            if (sha1_32(buf) == -1623568753) {
                break;
            }
        }
        for (i = 86; i < 95; i++) {
            buf[509] = (byte)i;
            if (sha1_32(buf) == -2046698076) {
                break;
            }
        }
        for (i = 103; i < 119; i++) {
            buf[510] = (byte)i;
            if (sha1_32(buf) == -1035582704) {
                break;
            }
        }
        for (i = 58; i < 80; i++) {
            buf[511] = (byte)i;
            if (sha1_32(buf) == 529121314) {
                break;
            }
        }
        for (i = -119; i < -103; i++) {
            buf[512] = (byte)i;
            if (sha1_32(buf) == 1970929150) {
                break;
            }
        }
        for (i = 74; i < 87; i++) {
            buf[513] = (byte)i;
            if (sha1_32(buf) == 1076702103) {
                break;
            }
        }
        for (i = -75; i < -69; i++) {
            buf[514] = (byte)i;
            if (sha1_32(buf) == -2015888825) {
                break;
            }
        }
        for (i = -29; i < -10; i++) {
            buf[515] = (byte)i;
            if (sha1_32(buf) == -773307227) {
                break;
            }
        }
        for (i = -85; i < -60; i++) {
            buf[516] = (byte)i;
            if (sha1_32(buf) == 1485776878) {
                break;
            }
        }
        for (i = 8; i < 38; i++) {
            buf[517] = (byte)i;
            if (sha1_32(buf) == 1845309328) {
                break;
            }
        }
        for (i = 57; i < 78; i++) {
            buf[518] = (byte)i;
            if (sha1_32(buf) == 1847590722) {
                break;
            }
        }
        for (i = -88; i < -64; i++) {
            buf[519] = (byte)i;
            if (sha1_32(buf) == -1604168005) {
                break;
            }
        }
        for (i = -100; i < -96; i++) {
            buf[520] = (byte)i;
            if (sha1_32(buf) == -124403432) {
                break;
            }
        }
        for (i = -41; i < -22; i++) {
            buf[521] = (byte)i;
            if (sha1_32(buf) == -2097039692) {
                break;
            }
        }
        for (i = 0; i < 15; i++) {
            buf[522] = (byte)i;
            if (sha1_32(buf) == 1833030954) {
                break;
            }
        }
        for (i = 54; i < 59; i++) {
            buf[523] = (byte)i;
            if (sha1_32(buf) == 1962943237) {
                break;
            }
        }
        for (i = 11; i < 21; i++) {
            buf[524] = (byte)i;
            if (sha1_32(buf) == -1118734858) {
                break;
            }
        }
        for (i = -110; i < -96; i++) {
            buf[525] = (byte)i;
            if (sha1_32(buf) == 755959332) {
                break;
            }
        }
        for (i = -82; i < -67; i++) {
            buf[526] = (byte)i;
            if (sha1_32(buf) == -894026608) {
                break;
            }
        }
        for (i = -54; i < -39; i++) {
            buf[527] = (byte)i;
            if (sha1_32(buf) == -1555344919) {
                break;
            }
        }
        for (i = -109; i < -90; i++) {
            buf[528] = (byte)i;
            if (sha1_32(buf) == 1742704458) {
                break;
            }
        }
        for (i = -36; i < -25; i++) {
            buf[529] = (byte)i;
            if (sha1_32(buf) == 871965827) {
                break;
            }
        }
        for (i = -68; i < -49; i++) {
            buf[530] = (byte)i;
            if (sha1_32(buf) == -1623467121) {
                break;
            }
        }
        for (i = 100; i < 125; i++) {
            buf[531] = (byte)i;
            if (sha1_32(buf) == -1293302202) {
                break;
            }
        }
        for (i = 16; i < 23; i++) {
            buf[532] = (byte)i;
            if (sha1_32(buf) == 754637093) {
                break;
            }
        }
        for (i = 21; i < 35; i++) {
            buf[533] = (byte)i;
            if (sha1_32(buf) == -869802071) {
                break;
            }
        }
        for (i = -88; i < -75; i++) {
            buf[534] = (byte)i;
            if (sha1_32(buf) == -554261379) {
                break;
            }
        }
        for (i = 76; i < 86; i++) {
            buf[535] = (byte)i;
            if (sha1_32(buf) == -792669259) {
                break;
            }
        }
        for (i = -57; i < -36; i++) {
            buf[536] = (byte)i;
            if (sha1_32(buf) == -856320743) {
                break;
            }
        }
        for (i = -70; i < -63; i++) {
            buf[537] = (byte)i;
            if (sha1_32(buf) == -1895437999) {
                break;
            }
        }
        for (i = 114; i < 126; i++) {
            buf[538] = (byte)i;
            if (sha1_32(buf) == -225861796) {
                break;
            }
        }
        for (i = 113; i < 128; i++) {
            buf[539] = (byte)i;
            if (sha1_32(buf) == -307376199) {
                break;
            }
        }
        for (i = 47; i < 76; i++) {
            buf[540] = (byte)i;
            if (sha1_32(buf) == 1577217572) {
                break;
            }
        }
        for (i = -93; i < -80; i++) {
            buf[541] = (byte)i;
            if (sha1_32(buf) == -2078487745) {
                break;
            }
        }
        for (i = 54; i < 69; i++) {
            buf[542] = (byte)i;
            if (sha1_32(buf) == 1470652672) {
                break;
            }
        }
        for (i = 90; i < 97; i++) {
            buf[543] = (byte)i;
            if (sha1_32(buf) == 993022142) {
                break;
            }
        }
        for (i = -44; i < -29; i++) {
            buf[544] = (byte)i;
            if (sha1_32(buf) == 1800259639) {
                break;
            }
        }
        for (i = 62; i < 84; i++) {
            buf[545] = (byte)i;
            if (sha1_32(buf) == 379207883) {
                break;
            }
        }
        for (i = 77; i < 94; i++) {
            buf[546] = (byte)i;
            if (sha1_32(buf) == -1414923505) {
                break;
            }
        }
        for (i = -25; i < -12; i++) {
            buf[547] = (byte)i;
            if (sha1_32(buf) == -1620786916) {
                break;
            }
        }
        for (i = -65; i < -43; i++) {
            buf[548] = (byte)i;
            if (sha1_32(buf) == 2108677344) {
                break;
            }
        }
        for (i = 119; i < 128; i++) {
            buf[549] = (byte)i;
            if (sha1_32(buf) == 589682435) {
                break;
            }
        }
        for (i = -116; i < -96; i++) {
            buf[550] = (byte)i;
            if (sha1_32(buf) == 436351485) {
                break;
            }
        }
        for (i = 55; i < 68; i++) {
            buf[551] = (byte)i;
            if (sha1_32(buf) == 795009298) {
                break;
            }
        }
        for (i = 33; i < 59; i++) {
            buf[552] = (byte)i;
            if (sha1_32(buf) == -1132895259) {
                break;
            }
        }
        for (i = 37; i < 65; i++) {
            buf[553] = (byte)i;
            if (sha1_32(buf) == -520186926) {
                break;
            }
        }
        for (i = 113; i < 128; i++) {
            buf[554] = (byte)i;
            if (sha1_32(buf) == -985489569) {
                break;
            }
        }
        for (i = 80; i < 99; i++) {
            buf[555] = (byte)i;
            if (sha1_32(buf) == 343235153) {
                break;
            }
        }
        for (i = -29; i < -4; i++) {
            buf[556] = (byte)i;
            if (sha1_32(buf) == 685130335) {
                break;
            }
        }
        for (i = 1; i < 7; i++) {
            buf[557] = (byte)i;
            if (sha1_32(buf) == -225233878) {
                break;
            }
        }
        for (i = -44; i < -26; i++) {
            buf[558] = (byte)i;
            if (sha1_32(buf) == 259298039) {
                break;
            }
        }
        for (i = -5; i < 19; i++) {
            buf[559] = (byte)i;
            if (sha1_32(buf) == 186154475) {
                break;
            }
        }
        for (i = 5; i < 16; i++) {
            buf[560] = (byte)i;
            if (sha1_32(buf) == 2080122948) {
                break;
            }
        }
        for (i = 75; i < 86; i++) {
            buf[561] = (byte)i;
            if (sha1_32(buf) == -1929996510) {
                break;
            }
        }
        for (i = -14; i < -11; i++) {
            buf[562] = (byte)i;
            if (sha1_32(buf) == 208079629) {
                break;
            }
        }
        for (i = 19; i < 27; i++) {
            buf[563] = (byte)i;
            if (sha1_32(buf) == -2003689179) {
                break;
            }
        }
        for (i = -74; i < -51; i++) {
            buf[564] = (byte)i;
            if (sha1_32(buf) == 1726687935) {
                break;
            }
        }
        for (i = -69; i < -59; i++) {
            buf[565] = (byte)i;
            if (sha1_32(buf) == -1849932867) {
                break;
            }
        }
        for (i = -102; i < -84; i++) {
            buf[566] = (byte)i;
            if (sha1_32(buf) == 133642932) {
                break;
            }
        }
        for (i = 50; i < 71; i++) {
            buf[567] = (byte)i;
            if (sha1_32(buf) == 1720239655) {
                break;
            }
        }
        for (i = 56; i < 65; i++) {
            buf[568] = (byte)i;
            if (sha1_32(buf) == 531646363) {
                break;
            }
        }
        for (i = 113; i < 128; i++) {
            buf[569] = (byte)i;
            if (sha1_32(buf) == -1914497254) {
                break;
            }
        }
        for (i = -85; i < -75; i++) {
            buf[570] = (byte)i;
            if (sha1_32(buf) == 256103500) {
                break;
            }
        }
        for (i = 123; i < 128; i++) {
            buf[571] = (byte)i;
            if (sha1_32(buf) == -501127303) {
                break;
            }
        }
        for (i = -128; i < -109; i++) {
            buf[572] = (byte)i;
            if (sha1_32(buf) == -1994159353) {
                break;
            }
        }
        for (i = -35; i < -18; i++) {
            buf[573] = (byte)i;
            if (sha1_32(buf) == 1994073511) {
                break;
            }
        }
        for (i = 42; i < 68; i++) {
            buf[574] = (byte)i;
            if (sha1_32(buf) == -1797717236) {
                break;
            }
        }
        for (i = -71; i < -63; i++) {
            buf[575] = (byte)i;
            if (sha1_32(buf) == -1093383535) {
                break;
            }
        }
        for (i = 64; i < 82; i++) {
            buf[576] = (byte)i;
            if (sha1_32(buf) == -1169251557) {
                break;
            }
        }
        for (i = -30; i < -14; i++) {
            buf[577] = (byte)i;
            if (sha1_32(buf) == 1985581285) {
                break;
            }
        }
        for (i = 47; i < 67; i++) {
            buf[578] = (byte)i;
            if (sha1_32(buf) == -1613550234) {
                break;
            }
        }
        for (i = -10; i < 10; i++) {
            buf[579] = (byte)i;
            if (sha1_32(buf) == 2102402834) {
                break;
            }
        }
        for (i = -111; i < -91; i++) {
            buf[580] = (byte)i;
            if (sha1_32(buf) == 1637398606) {
                break;
            }
        }
        for (i = -8; i < 14; i++) {
            buf[581] = (byte)i;
            if (sha1_32(buf) == -704002696) {
                break;
            }
        }
        for (i = -31; i < -13; i++) {
            buf[582] = (byte)i;
            if (sha1_32(buf) == 1582433929) {
                break;
            }
        }
        for (i = 102; i < 111; i++) {
            buf[583] = (byte)i;
            if (sha1_32(buf) == 1656004876) {
                break;
            }
        }
        for (i = -33; i < -28; i++) {
            buf[584] = (byte)i;
            if (sha1_32(buf) == 374478838) {
                break;
            }
        }
        for (i = 70; i < 92; i++) {
            buf[585] = (byte)i;
            if (sha1_32(buf) == 521013052) {
                break;
            }
        }
        for (i = -128; i < -121; i++) {
            buf[586] = (byte)i;
            if (sha1_32(buf) == 2000444787) {
                break;
            }
        }
        for (i = -107; i < -98; i++) {
            buf[587] = (byte)i;
            if (sha1_32(buf) == -1761034083) {
                break;
            }
        }
        for (i = 111; i < 120; i++) {
            buf[588] = (byte)i;
            if (sha1_32(buf) == 427326031) {
                break;
            }
        }
        for (i = 87; i < 100; i++) {
            buf[589] = (byte)i;
            if (sha1_32(buf) == -1669247168) {
                break;
            }
        }
        for (i = 91; i < 115; i++) {
            buf[590] = (byte)i;
            if (sha1_32(buf) == -805320749) {
                break;
            }
        }
        for (i = -91; i < -89; i++) {
            buf[591] = (byte)i;
            if (sha1_32(buf) == 195904955) {
                break;
            }
        }
        for (i = 71; i < 91; i++) {
            buf[592] = (byte)i;
            if (sha1_32(buf) == -1396578334) {
                break;
            }
        }
        for (i = 59; i < 69; i++) {
            buf[593] = (byte)i;
            if (sha1_32(buf) == 480291347) {
                break;
            }
        }
        for (i = -103; i < -89; i++) {
            buf[594] = (byte)i;
            if (sha1_32(buf) == 1653990021) {
                break;
            }
        }
        for (i = 90; i < 108; i++) {
            buf[595] = (byte)i;
            if (sha1_32(buf) == -309906623) {
                break;
            }
        }
        for (i = 35; i < 57; i++) {
            buf[596] = (byte)i;
            if (sha1_32(buf) == -1191001984) {
                break;
            }
        }
        for (i = 114; i < 128; i++) {
            buf[597] = (byte)i;
            if (sha1_32(buf) == -778113837) {
                break;
            }
        }
        for (i = -60; i < -38; i++) {
            buf[598] = (byte)i;
            if (sha1_32(buf) == 2101840646) {
                break;
            }
        }
        for (i = 34; i < 43; i++) {
            buf[599] = (byte)i;
            if (sha1_32(buf) == -170421269) {
                break;
            }
        }
        for (i = 7; i < 37; i++) {
            buf[600] = (byte)i;
            if (sha1_32(buf) == 1698511069) {
                break;
            }
        }
        for (i = 60; i < 65; i++) {
            buf[601] = (byte)i;
            if (sha1_32(buf) == 165928591) {
                break;
            }
        }
        for (i = 13; i < 23; i++) {
            buf[602] = (byte)i;
            if (sha1_32(buf) == 739688764) {
                break;
            }
        }
        for (i = -118; i < -97; i++) {
            buf[603] = (byte)i;
            if (sha1_32(buf) == -1409870185) {
                break;
            }
        }
        for (i = 86; i < 93; i++) {
            buf[604] = (byte)i;
            if (sha1_32(buf) == 1104705530) {
                break;
            }
        }
        for (i = -6; i < 10; i++) {
            buf[605] = (byte)i;
            if (sha1_32(buf) == -2138995037) {
                break;
            }
        }
        for (i = -113; i < -107; i++) {
            buf[606] = (byte)i;
            if (sha1_32(buf) == 1769010429) {
                break;
            }
        }
        for (i = -81; i < -63; i++) {
            buf[607] = (byte)i;
            if (sha1_32(buf) == -394792927) {
                break;
            }
        }
        for (i = -69; i < -65; i++) {
            buf[608] = (byte)i;
            if (sha1_32(buf) == -376815523) {
                break;
            }
        }
        for (i = -96; i < -82; i++) {
            buf[609] = (byte)i;
            if (sha1_32(buf) == -1322974145) {
                break;
            }
        }
        for (i = -11; i < 0; i++) {
            buf[610] = (byte)i;
            if (sha1_32(buf) == -259648855) {
                break;
            }
        }
        for (i = 27; i < 37; i++) {
            buf[611] = (byte)i;
            if (sha1_32(buf) == 747050322) {
                break;
            }
        }
        for (i = -42; i < -29; i++) {
            buf[612] = (byte)i;
            if (sha1_32(buf) == -605870838) {
                break;
            }
        }
        for (i = 4; i < 13; i++) {
            buf[613] = (byte)i;
            if (sha1_32(buf) == -2053984890) {
                break;
            }
        }
        for (i = 68; i < 87; i++) {
            buf[614] = (byte)i;
            if (sha1_32(buf) == 213219278) {
                break;
            }
        }
        for (i = 17; i < 27; i++) {
            buf[615] = (byte)i;
            if (sha1_32(buf) == 1682407029) {
                break;
            }
        }
        for (i = 107; i < 128; i++) {
            buf[616] = (byte)i;
            if (sha1_32(buf) == 1452442697) {
                break;
            }
        }
        for (i = 46; i < 65; i++) {
            buf[617] = (byte)i;
            if (sha1_32(buf) == 1126149018) {
                break;
            }
        }
        for (i = 22; i < 27; i++) {
            buf[618] = (byte)i;
            if (sha1_32(buf) == 1573590173) {
                break;
            }
        }
        for (i = 3; i < 19; i++) {
            buf[619] = (byte)i;
            if (sha1_32(buf) == -255259449) {
                break;
            }
        }
        for (i = -126; i < -107; i++) {
            buf[620] = (byte)i;
            if (sha1_32(buf) == 415545916) {
                break;
            }
        }
        for (i = -40; i < -38; i++) {
            buf[621] = (byte)i;
            if (sha1_32(buf) == 1046464854) {
                break;
            }
        }
        for (i = 11; i < 22; i++) {
            buf[622] = (byte)i;
            if (sha1_32(buf) == -848809748) {
                break;
            }
        }
        for (i = 83; i < 92; i++) {
            buf[623] = (byte)i;
            if (sha1_32(buf) == 786923040) {
                break;
            }
        }
        for (i = 39; i < 60; i++) {
            buf[624] = (byte)i;
            if (sha1_32(buf) == 1215474511) {
                break;
            }
        }
        for (i = -2; i < 4; i++) {
            buf[625] = (byte)i;
            if (sha1_32(buf) == 616687444) {
                break;
            }
        }
        for (i = 40; i < 48; i++) {
            buf[626] = (byte)i;
            if (sha1_32(buf) == -379481867) {
                break;
            }
        }
        for (i = -48; i < -30; i++) {
            buf[627] = (byte)i;
            if (sha1_32(buf) == 142709311) {
                break;
            }
        }
        for (i = -52; i < -33; i++) {
            buf[628] = (byte)i;
            if (sha1_32(buf) == 704832213) {
                break;
            }
        }
        for (i = -51; i < -33; i++) {
            buf[629] = (byte)i;
            if (sha1_32(buf) == -750578009) {
                break;
            }
        }
        for (i = 89; i < 102; i++) {
            buf[630] = (byte)i;
            if (sha1_32(buf) == 1469993027) {
                break;
            }
        }
        for (i = 69; i < 96; i++) {
            buf[631] = (byte)i;
            if (sha1_32(buf) == -1921953189) {
                break;
            }
        }
        for (i = -32; i < -31; i++) {
            buf[632] = (byte)i;
            if (sha1_32(buf) == -1616612476) {
                break;
            }
        }
        for (i = 7; i < 21; i++) {
            buf[633] = (byte)i;
            if (sha1_32(buf) == -210791965) {
                break;
            }
        }
        for (i = -105; i < -90; i++) {
            buf[634] = (byte)i;
            if (sha1_32(buf) == -2118090182) {
                break;
            }
        }
        for (i = -65; i < -48; i++) {
            buf[635] = (byte)i;
            if (sha1_32(buf) == -404114814) {
                break;
            }
        }
        for (i = -110; i < -94; i++) {
            buf[636] = (byte)i;
            if (sha1_32(buf) == -1695667244) {
                break;
            }
        }
        for (i = 1; i < 17; i++) {
            buf[637] = (byte)i;
            if (sha1_32(buf) == 997632701) {
                break;
            }
        }
        for (i = 101; i < 115; i++) {
            buf[638] = (byte)i;
            if (sha1_32(buf) == -42561193) {
                break;
            }
        }
        for (i = 67; i < 83; i++) {
            buf[639] = (byte)i;
            if (sha1_32(buf) == -1780144308) {
                break;
            }
        }
        for (i = 106; i < 122; i++) {
            buf[640] = (byte)i;
            if (sha1_32(buf) == 30006416) {
                break;
            }
        }
        for (i = -22; i < -4; i++) {
            buf[641] = (byte)i;
            if (sha1_32(buf) == 758557651) {
                break;
            }
        }
        for (i = -84; i < -76; i++) {
            buf[642] = (byte)i;
            if (sha1_32(buf) == -56586124) {
                break;
            }
        }
        for (i = -25; i < 0; i++) {
            buf[643] = (byte)i;
            if (sha1_32(buf) == 1138658802) {
                break;
            }
        }
        for (i = -63; i < -52; i++) {
            buf[644] = (byte)i;
            if (sha1_32(buf) == 1008948071) {
                break;
            }
        }
        for (i = -51; i < -40; i++) {
            buf[645] = (byte)i;
            if (sha1_32(buf) == 1863115972) {
                break;
            }
        }
        for (i = 54; i < 75; i++) {
            buf[646] = (byte)i;
            if (sha1_32(buf) == 229757481) {
                break;
            }
        }
        for (i = -33; i < -10; i++) {
            buf[647] = (byte)i;
            if (sha1_32(buf) == 1475300049) {
                break;
            }
        }
        for (i = 64; i < 73; i++) {
            buf[648] = (byte)i;
            if (sha1_32(buf) == -1320527884) {
                break;
            }
        }
        for (i = 21; i < 38; i++) {
            buf[649] = (byte)i;
            if (sha1_32(buf) == -1090094051) {
                break;
            }
        }
        for (i = -70; i < -47; i++) {
            buf[650] = (byte)i;
            if (sha1_32(buf) == 1028129648) {
                break;
            }
        }
        for (i = 2; i < 24; i++) {
            buf[651] = (byte)i;
            if (sha1_32(buf) == -1573684176) {
                break;
            }
        }
        for (i = 124; i < 128; i++) {
            buf[652] = (byte)i;
            if (sha1_32(buf) == 2057363391) {
                break;
            }
        }
        for (i = 25; i < 43; i++) {
            buf[653] = (byte)i;
            if (sha1_32(buf) == 1299394076) {
                break;
            }
        }
        for (i = -78; i < -64; i++) {
            buf[654] = (byte)i;
            if (sha1_32(buf) == 1340719073) {
                break;
            }
        }
        for (i = 41; i < 48; i++) {
            buf[655] = (byte)i;
            if (sha1_32(buf) == 179228902) {
                break;
            }
        }
        for (i = 98; i < 113; i++) {
            buf[656] = (byte)i;
            if (sha1_32(buf) == -658598905) {
                break;
            }
        }
        for (i = -84; i < -73; i++) {
            buf[657] = (byte)i;
            if (sha1_32(buf) == 768530007) {
                break;
            }
        }
        for (i = 76; i < 92; i++) {
            buf[658] = (byte)i;
            if (sha1_32(buf) == -5536913) {
                break;
            }
        }
        for (i = 26; i < 39; i++) {
            buf[659] = (byte)i;
            if (sha1_32(buf) == 324743610) {
                break;
            }
        }
        for (i = -89; i < -66; i++) {
            buf[660] = (byte)i;
            if (sha1_32(buf) == -892410608) {
                break;
            }
        }
        for (i = 71; i < 82; i++) {
            buf[661] = (byte)i;
            if (sha1_32(buf) == -1437541165) {
                break;
            }
        }
        for (i = 59; i < 85; i++) {
            buf[662] = (byte)i;
            if (sha1_32(buf) == 957190138) {
                break;
            }
        }
        for (i = 117; i < 128; i++) {
            buf[663] = (byte)i;
            if (sha1_32(buf) == 1103003507) {
                break;
            }
        }
        for (i = 47; i < 62; i++) {
            buf[664] = (byte)i;
            if (sha1_32(buf) == 408440336) {
                break;
            }
        }
        for (i = -119; i < -90; i++) {
            buf[665] = (byte)i;
            if (sha1_32(buf) == 1375773214) {
                break;
            }
        }
        for (i = 68; i < 76; i++) {
            buf[666] = (byte)i;
            if (sha1_32(buf) == -1358761435) {
                break;
            }
        }
        for (i = -119; i < -112; i++) {
            buf[667] = (byte)i;
            if (sha1_32(buf) == -796820489) {
                break;
            }
        }
        for (i = -6; i < 3; i++) {
            buf[668] = (byte)i;
            if (sha1_32(buf) == -796820489) {
                break;
            }
        }
        for (i = 102; i < 128; i++) {
            buf[669] = (byte)i;
            if (sha1_32(buf) == -1365285873) {
                break;
            }
        }
        for (i = 119; i < 128; i++) {
            buf[670] = (byte)i;
            if (sha1_32(buf) == 974865625) {
                break;
            }
        }
        for (i = 92; i < 110; i++) {
            buf[671] = (byte)i;
            if (sha1_32(buf) == -315050070) {
                break;
            }
        }
        for (i = 125; i < 128; i++) {
            buf[672] = (byte)i;
            if (sha1_32(buf) == -1333485635) {
                break;
            }
        }
        for (i = 85; i < 108; i++) {
            buf[673] = (byte)i;
            if (sha1_32(buf) == 1659300587) {
                break;
            }
        }
        for (i = -81; i < -65; i++) {
            buf[674] = (byte)i;
            if (sha1_32(buf) == -1365412435) {
                break;
            }
        }
        for (i = 32; i < 56; i++) {
            buf[675] = (byte)i;
            if (sha1_32(buf) == 955193549) {
                break;
            }
        }
        for (i = 107; i < 115; i++) {
            buf[676] = (byte)i;
            if (sha1_32(buf) == -545812836) {
                break;
            }
        }
        for (i = 52; i < 71; i++) {
            buf[677] = (byte)i;
            if (sha1_32(buf) == 1291196923) {
                break;
            }
        }
        for (i = 84; i < 95; i++) {
            buf[678] = (byte)i;
            if (sha1_32(buf) == -1166447253) {
                break;
            }
        }
        for (i = -113; i < -99; i++) {
            buf[679] = (byte)i;
            if (sha1_32(buf) == -924048661) {
                break;
            }
        }
        for (i = 15; i < 39; i++) {
            buf[680] = (byte)i;
            if (sha1_32(buf) == 1454194119) {
                break;
            }
        }
        for (i = -87; i < -65; i++) {
            buf[681] = (byte)i;
            if (sha1_32(buf) == 1748268956) {
                break;
            }
        }
        for (i = -127; i < -107; i++) {
            buf[682] = (byte)i;
            if (sha1_32(buf) == 720886859) {
                break;
            }
        }
        for (i = -98; i < -83; i++) {
            buf[683] = (byte)i;
            if (sha1_32(buf) == 2057424147) {
                break;
            }
        }
        for (i = -114; i < -100; i++) {
            buf[684] = (byte)i;
            if (sha1_32(buf) == -1707532654) {
                break;
            }
        }
        for (i = 3; i < 14; i++) {
            buf[685] = (byte)i;
            if (sha1_32(buf) == -1619216755) {
                break;
            }
        }
        for (i = -45; i < -42; i++) {
            buf[686] = (byte)i;
            if (sha1_32(buf) == 30167864) {
                break;
            }
        }
        for (i = 43; i < 64; i++) {
            buf[687] = (byte)i;
            if (sha1_32(buf) == -1750097333) {
                break;
            }
        }
        for (i = -121; i < -105; i++) {
            buf[688] = (byte)i;
            if (sha1_32(buf) == 536108181) {
                break;
            }
        }
        for (i = -45; i < -22; i++) {
            buf[689] = (byte)i;
            if (sha1_32(buf) == -1583218063) {
                break;
            }
        }
        for (i = -34; i < -27; i++) {
            buf[690] = (byte)i;
            if (sha1_32(buf) == 1811986945) {
                break;
            }
        }
        for (i = -75; i < -52; i++) {
            buf[691] = (byte)i;
            if (sha1_32(buf) == -473215191) {
                break;
            }
        }
        for (i = -34; i < -18; i++) {
            buf[692] = (byte)i;
            if (sha1_32(buf) == 630863392) {
                break;
            }
        }
        for (i = -3; i < 22; i++) {
            buf[693] = (byte)i;
            if (sha1_32(buf) == 1760480883) {
                break;
            }
        }
        for (i = 102; i < 115; i++) {
            buf[694] = (byte)i;
            if (sha1_32(buf) == -1691896460) {
                break;
            }
        }
        for (i = -99; i < -83; i++) {
            buf[695] = (byte)i;
            if (sha1_32(buf) == -627646869) {
                break;
            }
        }
        for (i = 79; i < 86; i++) {
            buf[696] = (byte)i;
            if (sha1_32(buf) == 1077645543) {
                break;
            }
        }
        for (i = 75; i < 82; i++) {
            buf[697] = (byte)i;
            if (sha1_32(buf) == -1680564038) {
                break;
            }
        }
        for (i = 89; i < 113; i++) {
            buf[698] = (byte)i;
            if (sha1_32(buf) == 1435294074) {
                break;
            }
        }
        for (i = 103; i < 123; i++) {
            buf[699] = (byte)i;
            if (sha1_32(buf) == -1674135033) {
                break;
            }
        }
        for (i = -73; i < -55; i++) {
            buf[700] = (byte)i;
            if (sha1_32(buf) == 146567529) {
                break;
            }
        }
        for (i = -128; i < -115; i++) {
            buf[701] = (byte)i;
            if (sha1_32(buf) == -242177915) {
                break;
            }
        }
        for (i = 83; i < 88; i++) {
            buf[702] = (byte)i;
            if (sha1_32(buf) == -407899387) {
                break;
            }
        }
        for (i = -49; i < -30; i++) {
            buf[703] = (byte)i;
            if (sha1_32(buf) == -1939987463) {
                break;
            }
        }
        for (i = -53; i < -44; i++) {
            buf[704] = (byte)i;
            if (sha1_32(buf) == -1485061730) {
                break;
            }
        }
        for (i = -123; i < -113; i++) {
            buf[705] = (byte)i;
            if (sha1_32(buf) == -563785986) {
                break;
            }
        }
        for (i = 91; i < 105; i++) {
            buf[706] = (byte)i;
            if (sha1_32(buf) == -1077368482) {
                break;
            }
        }
        for (i = 106; i < 128; i++) {
            buf[707] = (byte)i;
            if (sha1_32(buf) == -395592589) {
                break;
            }
        }
        for (i = -46; i < -34; i++) {
            buf[708] = (byte)i;
            if (sha1_32(buf) == 470384571) {
                break;
            }
        }
        for (i = 47; i < 57; i++) {
            buf[709] = (byte)i;
            if (sha1_32(buf) == -2053550191) {
                break;
            }
        }
        for (i = -63; i < -54; i++) {
            buf[710] = (byte)i;
            if (sha1_32(buf) == -581639514) {
                break;
            }
        }
        for (i = -40; i < -36; i++) {
            buf[711] = (byte)i;
            if (sha1_32(buf) == 72981750) {
                break;
            }
        }
        for (i = 16; i < 36; i++) {
            buf[712] = (byte)i;
            if (sha1_32(buf) == 1827778531) {
                break;
            }
        }
        for (i = -30; i < -14; i++) {
            buf[713] = (byte)i;
            if (sha1_32(buf) == 393045044) {
                break;
            }
        }
        for (i = -26; i < -2; i++) {
            buf[714] = (byte)i;
            if (sha1_32(buf) == 806996803) {
                break;
            }
        }
        for (i = 97; i < 126; i++) {
            buf[715] = (byte)i;
            if (sha1_32(buf) == -1961770793) {
                break;
            }
        }
        for (i = -84; i < -67; i++) {
            buf[716] = (byte)i;
            if (sha1_32(buf) == 1363555884) {
                break;
            }
        }
        for (i = -68; i < -48; i++) {
            buf[717] = (byte)i;
            if (sha1_32(buf) == 708752254) {
                break;
            }
        }
        for (i = -125; i < -99; i++) {
            buf[718] = (byte)i;
            if (sha1_32(buf) == -435578908) {
                break;
            }
        }
        for (i = 34; i < 55; i++) {
            buf[719] = (byte)i;
            if (sha1_32(buf) == -8200456) {
                break;
            }
        }
        for (i = 106; i < 123; i++) {
            buf[720] = (byte)i;
            if (sha1_32(buf) == -1301404551) {
                break;
            }
        }
        for (i = 16; i < 28; i++) {
            buf[721] = (byte)i;
            if (sha1_32(buf) == 275310306) {
                break;
            }
        }
        for (i = -128; i < -120; i++) {
            buf[722] = (byte)i;
            if (sha1_32(buf) == -1428045540) {
                break;
            }
        }
        for (i = 31; i < 47; i++) {
            buf[723] = (byte)i;
            if (sha1_32(buf) == -2134043923) {
                break;
            }
        }
        for (i = -72; i < -45; i++) {
            buf[724] = (byte)i;
            if (sha1_32(buf) == 1868650601) {
                break;
            }
        }
        for (i = -42; i < -35; i++) {
            buf[725] = (byte)i;
            if (sha1_32(buf) == 1874452556) {
                break;
            }
        }
        for (i = 84; i < 99; i++) {
            buf[726] = (byte)i;
            if (sha1_32(buf) == 1452825855) {
                break;
            }
        }
        for (i = 15; i < 28; i++) {
            buf[727] = (byte)i;
            if (sha1_32(buf) == -445274989) {
                break;
            }
        }
        for (i = 74; i < 90; i++) {
            buf[728] = (byte)i;
            if (sha1_32(buf) == 2014526440) {
                break;
            }
        }
        for (i = -86; i < -71; i++) {
            buf[729] = (byte)i;
            if (sha1_32(buf) == -982517105) {
                break;
            }
        }
        for (i = 120; i < 128; i++) {
            buf[730] = (byte)i;
            if (sha1_32(buf) == -1655979658) {
                break;
            }
        }
        for (i = 20; i < 46; i++) {
            buf[731] = (byte)i;
            if (sha1_32(buf) == 1287698258) {
                break;
            }
        }
        for (i = -54; i < -34; i++) {
            buf[732] = (byte)i;
            if (sha1_32(buf) == -96615096) {
                break;
            }
        }
        for (i = -126; i < -104; i++) {
            buf[733] = (byte)i;
            if (sha1_32(buf) == 797482718) {
                break;
            }
        }
        for (i = 18; i < 44; i++) {
            buf[734] = (byte)i;
            if (sha1_32(buf) == -44994508) {
                break;
            }
        }
        for (i = 1; i < 16; i++) {
            buf[735] = (byte)i;
            if (sha1_32(buf) == 38520833) {
                break;
            }
        }
        for (i = -97; i < -72; i++) {
            buf[736] = (byte)i;
            if (sha1_32(buf) == -2032904215) {
                break;
            }
        }
        for (i = -81; i < -64; i++) {
            buf[737] = (byte)i;
            if (sha1_32(buf) == -1542917803) {
                break;
            }
        }
        for (i = -128; i < -125; i++) {
            buf[738] = (byte)i;
            if (sha1_32(buf) == -1084397861) {
                break;
            }
        }
        for (i = 97; i < 110; i++) {
            buf[739] = (byte)i;
            if (sha1_32(buf) == -536877729) {
                break;
            }
        }
        for (i = 70; i < 99; i++) {
            buf[740] = (byte)i;
            if (sha1_32(buf) == 1673920389) {
                break;
            }
        }
        for (i = -128; i < -110; i++) {
            buf[741] = (byte)i;
            if (sha1_32(buf) == 2011610375) {
                break;
            }
        }
        for (i = -40; i < -26; i++) {
            buf[742] = (byte)i;
            if (sha1_32(buf) == 1526371164) {
                break;
            }
        }
        for (i = -125; i < -116; i++) {
            buf[743] = (byte)i;
            if (sha1_32(buf) == -64693648) {
                break;
            }
        }
        for (i = -95; i < -73; i++) {
            buf[744] = (byte)i;
            if (sha1_32(buf) == 434364707) {
                break;
            }
        }
        for (i = -8; i < 16; i++) {
            buf[745] = (byte)i;
            if (sha1_32(buf) == -1837799029) {
                break;
            }
        }
        for (i = -16; i < 5; i++) {
            buf[746] = (byte)i;
            if (sha1_32(buf) == -1397618324) {
                break;
            }
        }
        for (i = 82; i < 100; i++) {
            buf[747] = (byte)i;
            if (sha1_32(buf) == -540903563) {
                break;
            }
        }
        for (i = 35; i < 64; i++) {
            buf[748] = (byte)i;
            if (sha1_32(buf) == -604664091) {
                break;
            }
        }
        for (i = -124; i < -107; i++) {
            buf[749] = (byte)i;
            if (sha1_32(buf) == 207479549) {
                break;
            }
        }
        for (i = 13; i < 32; i++) {
            buf[750] = (byte)i;
            if (sha1_32(buf) == -1082488546) {
                break;
            }
        }
        for (i = 119; i < 123; i++) {
            buf[751] = (byte)i;
            if (sha1_32(buf) == -192190426) {
                break;
            }
        }
        for (i = 17; i < 45; i++) {
            buf[752] = (byte)i;
            if (sha1_32(buf) == 1088527181) {
                break;
            }
        }
        for (i = -28; i < -17; i++) {
            buf[753] = (byte)i;
            if (sha1_32(buf) == -1486452760) {
                break;
            }
        }
        for (i = -31; i < -18; i++) {
            buf[754] = (byte)i;
            if (sha1_32(buf) == 1653317891) {
                break;
            }
        }
        for (i = 77; i < 95; i++) {
            buf[755] = (byte)i;
            if (sha1_32(buf) == 765842787) {
                break;
            }
        }
        for (i = 69; i < 76; i++) {
            buf[756] = (byte)i;
            if (sha1_32(buf) == -1353919691) {
                break;
            }
        }
        for (i = 39; i < 60; i++) {
            buf[757] = (byte)i;
            if (sha1_32(buf) == 1760188146) {
                break;
            }
        }
        for (i = -84; i < -69; i++) {
            buf[758] = (byte)i;
            if (sha1_32(buf) == 876783019) {
                break;
            }
        }
        for (i = -126; i < -109; i++) {
            buf[759] = (byte)i;
            if (sha1_32(buf) == -1577944189) {
                break;
            }
        }
        for (i = -84; i < -69; i++) {
            buf[760] = (byte)i;
            if (sha1_32(buf) == 1914057927) {
                break;
            }
        }
        for (i = -128; i < -119; i++) {
            buf[761] = (byte)i;
            if (sha1_32(buf) == 811602997) {
                break;
            }
        }
        for (i = 79; i < 93; i++) {
            buf[762] = (byte)i;
            if (sha1_32(buf) == 1612004728) {
                break;
            }
        }
        for (i = -120; i < -107; i++) {
            buf[763] = (byte)i;
            if (sha1_32(buf) == 2139417021) {
                break;
            }
        }
        for (i = -77; i < -63; i++) {
            buf[764] = (byte)i;
            if (sha1_32(buf) == -1616989470) {
                break;
            }
        }
        for (i = -113; i < -98; i++) {
            buf[765] = (byte)i;
            if (sha1_32(buf) == -1176933094) {
                break;
            }
        }
        for (i = -8; i < 7; i++) {
            buf[766] = (byte)i;
            if (sha1_32(buf) == 1281346147) {
                break;
            }
        }
        for (i = -116; i < -94; i++) {
            buf[767] = (byte)i;
            if (sha1_32(buf) == 689834960) {
                break;
            }
        }
        for (i = -128; i < -124; i++) {
            buf[768] = (byte)i;
            if (sha1_32(buf) == 1266570662) {
                break;
            }
        }
        for (i = -1; i < 16; i++) {
            buf[769] = (byte)i;
            if (sha1_32(buf) == 332717944) {
                break;
            }
        }
        for (i = 83; i < 102; i++) {
            buf[770] = (byte)i;
            if (sha1_32(buf) == -557480058) {
                break;
            }
        }
        for (i = 119; i < 128; i++) {
            buf[771] = (byte)i;
            if (sha1_32(buf) == -865336380) {
                break;
            }
        }
        for (i = -27; i < -20; i++) {
            buf[772] = (byte)i;
            if (sha1_32(buf) == 424237639) {
                break;
            }
        }
        for (i = -53; i < -35; i++) {
            buf[773] = (byte)i;
            if (sha1_32(buf) == -1966911840) {
                break;
            }
        }
        for (i = 85; i < 97; i++) {
            buf[774] = (byte)i;
            if (sha1_32(buf) == -1878965368) {
                break;
            }
        }
        for (i = -128; i < -114; i++) {
            buf[775] = (byte)i;
            if (sha1_32(buf) == 321871342) {
                break;
            }
        }
        for (i = -14; i < 11; i++) {
            buf[776] = (byte)i;
            if (sha1_32(buf) == -896976904) {
                break;
            }
        }
        for (i = -31; i < -23; i++) {
            buf[777] = (byte)i;
            if (sha1_32(buf) == -312055663) {
                break;
            }
        }
        for (i = -48; i < -25; i++) {
            buf[778] = (byte)i;
            if (sha1_32(buf) == 1912038348) {
                break;
            }
        }
        for (i = -21; i < 0; i++) {
            buf[779] = (byte)i;
            if (sha1_32(buf) == 191834275) {
                break;
            }
        }
        for (i = 71; i < 89; i++) {
            buf[780] = (byte)i;
            if (sha1_32(buf) == 126770150) {
                break;
            }
        }
        for (i = -64; i < -48; i++) {
            buf[781] = (byte)i;
            if (sha1_32(buf) == 1085406642) {
                break;
            }
        }
        for (i = 19; i < 35; i++) {
            buf[782] = (byte)i;
            if (sha1_32(buf) == -1511975816) {
                break;
            }
        }
        for (i = -45; i < -32; i++) {
            buf[783] = (byte)i;
            if (sha1_32(buf) == 430499784) {
                break;
            }
        }
        for (i = 88; i < 104; i++) {
            buf[784] = (byte)i;
            if (sha1_32(buf) == 1810259518) {
                break;
            }
        }
        for (i = 82; i < 110; i++) {
            buf[785] = (byte)i;
            if (sha1_32(buf) == 356337756) {
                break;
            }
        }
        for (i = -36; i < -17; i++) {
            buf[786] = (byte)i;
            if (sha1_32(buf) == 842821176) {
                break;
            }
        }
        for (i = -128; i < -125; i++) {
            buf[787] = (byte)i;
            if (sha1_32(buf) == -1382615062) {
                break;
            }
        }
        for (i = 21; i < 31; i++) {
            buf[788] = (byte)i;
            if (sha1_32(buf) == 1535069654) {
                break;
            }
        }
        for (i = -65; i < -55; i++) {
            buf[789] = (byte)i;
            if (sha1_32(buf) == -1410521913) {
                break;
            }
        }
        for (i = -61; i < -42; i++) {
            buf[790] = (byte)i;
            if (sha1_32(buf) == 1383221935) {
                break;
            }
        }
        for (i = 30; i < 45; i++) {
            buf[791] = (byte)i;
            if (sha1_32(buf) == 249861879) {
                break;
            }
        }
        for (i = -14; i < -7; i++) {
            buf[792] = (byte)i;
            if (sha1_32(buf) == 1674349345) {
                break;
            }
        }
        for (i = -45; i < -34; i++) {
            buf[793] = (byte)i;
            if (sha1_32(buf) == -1980850823) {
                break;
            }
        }
        for (i = 83; i < 97; i++) {
            buf[794] = (byte)i;
            if (sha1_32(buf) == -1439197337) {
                break;
            }
        }
        for (i = 91; i < 106; i++) {
            buf[795] = (byte)i;
            if (sha1_32(buf) == -1341893959) {
                break;
            }
        }
        for (i = -78; i < -52; i++) {
            buf[796] = (byte)i;
            if (sha1_32(buf) == 924244222) {
                break;
            }
        }
        for (i = -19; i < -5; i++) {
            buf[797] = (byte)i;
            if (sha1_32(buf) == -236595483) {
                break;
            }
        }
        for (i = -21; i < -5; i++) {
            buf[798] = (byte)i;
            if (sha1_32(buf) == -1160117006) {
                break;
            }
        }
        for (i = 101; i < 116; i++) {
            buf[799] = (byte)i;
            if (sha1_32(buf) == -374308081) {
                break;
            }
        }
        for (i = -62; i < -45; i++) {
            buf[800] = (byte)i;
            if (sha1_32(buf) == 1311337686) {
                break;
            }
        }
        for (i = 7; i < 19; i++) {
            buf[801] = (byte)i;
            if (sha1_32(buf) == 576559618) {
                break;
            }
        }
        for (i = -43; i < -25; i++) {
            buf[802] = (byte)i;
            if (sha1_32(buf) == -60282410) {
                break;
            }
        }
        for (i = -5; i < -2; i++) {
            buf[803] = (byte)i;
            if (sha1_32(buf) == -1142450697) {
                break;
            }
        }
        for (i = 65; i < 86; i++) {
            buf[804] = (byte)i;
            if (sha1_32(buf) == -179121812) {
                break;
            }
        }
        for (i = 105; i < 120; i++) {
            buf[805] = (byte)i;
            if (sha1_32(buf) == -602249587) {
                break;
            }
        }
        for (i = 62; i < 80; i++) {
            buf[806] = (byte)i;
            if (sha1_32(buf) == 287533639) {
                break;
            }
        }
        for (i = -48; i < -27; i++) {
            buf[807] = (byte)i;
            if (sha1_32(buf) == -552680321) {
                break;
            }
        }
        for (i = -76; i < -73; i++) {
            buf[808] = (byte)i;
            if (sha1_32(buf) == -407434829) {
                break;
            }
        }
        for (i = -47; i < -28; i++) {
            buf[809] = (byte)i;
            if (sha1_32(buf) == -861436237) {
                break;
            }
        }
        for (i = -88; i < -73; i++) {
            buf[810] = (byte)i;
            if (sha1_32(buf) == 770916117) {
                break;
            }
        }
        for (i = 9; i < 21; i++) {
            buf[811] = (byte)i;
            if (sha1_32(buf) == -462475514) {
                break;
            }
        }
        for (i = 108; i < 128; i++) {
            buf[812] = (byte)i;
            if (sha1_32(buf) == 67835404) {
                break;
            }
        }
        for (i = -128; i < -121; i++) {
            buf[813] = (byte)i;
            if (sha1_32(buf) == 1037220483) {
                break;
            }
        }
        for (i = -73; i < -50; i++) {
            buf[814] = (byte)i;
            if (sha1_32(buf) == -466278031) {
                break;
            }
        }
        for (i = 67; i < 98; i++) {
            buf[815] = (byte)i;
            if (sha1_32(buf) == -472777733) {
                break;
            }
        }
        for (i = -87; i < -72; i++) {
            buf[816] = (byte)i;
            if (sha1_32(buf) == 1670083844) {
                break;
            }
        }
        for (i = 68; i < 87; i++) {
            buf[817] = (byte)i;
            if (sha1_32(buf) == 653904690) {
                break;
            }
        }
        for (i = 35; i < 56; i++) {
            buf[818] = (byte)i;
            if (sha1_32(buf) == 1346270677) {
                break;
            }
        }
        for (i = -128; i < -112; i++) {
            buf[819] = (byte)i;
            if (sha1_32(buf) == 138883590) {
                break;
            }
        }
        for (i = -4; i < 14; i++) {
            buf[820] = (byte)i;
            if (sha1_32(buf) == 94998762) {
                break;
            }
        }
        for (i = -126; i < -107; i++) {
            buf[821] = (byte)i;
            if (sha1_32(buf) == -1821663852) {
                break;
            }
        }
        for (i = -59; i < -34; i++) {
            buf[822] = (byte)i;
            if (sha1_32(buf) == -1787213088) {
                break;
            }
        }
        for (i = -75; i < -68; i++) {
            buf[823] = (byte)i;
            if (sha1_32(buf) == -1543371131) {
                break;
            }
        }
        for (i = -1; i < 30; i++) {
            buf[824] = (byte)i;
            if (sha1_32(buf) == 931569836) {
                break;
            }
        }
        for (i = 30; i < 53; i++) {
            buf[825] = (byte)i;
            if (sha1_32(buf) == 1630087829) {
                break;
            }
        }
        for (i = -87; i < -67; i++) {
            buf[826] = (byte)i;
            if (sha1_32(buf) == -93918099) {
                break;
            }
        }
        for (i = 118; i < 128; i++) {
            buf[827] = (byte)i;
            if (sha1_32(buf) == 2109319131) {
                break;
            }
        }
        for (i = -118; i < -104; i++) {
            buf[828] = (byte)i;
            if (sha1_32(buf) == 661204374) {
                break;
            }
        }
        for (i = 52; i < 54; i++) {
            buf[829] = (byte)i;
            if (sha1_32(buf) == 142011097) {
                break;
            }
        }
        for (i = 6; i < 13; i++) {
            buf[830] = (byte)i;
            if (sha1_32(buf) == 1284481062) {
                break;
            }
        }
        for (i = 104; i < 111; i++) {
            buf[831] = (byte)i;
            if (sha1_32(buf) == 1804455921) {
                break;
            }
        }
        for (i = 7; i < 16; i++) {
            buf[832] = (byte)i;
            if (sha1_32(buf) == 1411429631) {
                break;
            }
        }
        for (i = 13; i < 17; i++) {
            buf[833] = (byte)i;
            if (sha1_32(buf) == -1895428930) {
                break;
            }
        }
        for (i = -107; i < -100; i++) {
            buf[834] = (byte)i;
            if (sha1_32(buf) == -567560634) {
                break;
            }
        }
        for (i = 80; i < 90; i++) {
            buf[835] = (byte)i;
            if (sha1_32(buf) == -378103186) {
                break;
            }
        }
        for (i = 3; i < 9; i++) {
            buf[836] = (byte)i;
            if (sha1_32(buf) == -1584190223) {
                break;
            }
        }
        for (i = -67; i < -44; i++) {
            buf[837] = (byte)i;
            if (sha1_32(buf) == 1027737597) {
                break;
            }
        }
        for (i = 54; i < 72; i++) {
            buf[838] = (byte)i;
            if (sha1_32(buf) == 2069342604) {
                break;
            }
        }
        for (i = 114; i < 128; i++) {
            buf[839] = (byte)i;
            if (sha1_32(buf) == -862913157) {
                break;
            }
        }
        for (i = 94; i < 101; i++) {
            buf[840] = (byte)i;
            if (sha1_32(buf) == 1487928168) {
                break;
            }
        }
        for (i = -96; i < -76; i++) {
            buf[841] = (byte)i;
            if (sha1_32(buf) == -1581853853) {
                break;
            }
        }
        for (i = -94; i < -77; i++) {
            buf[842] = (byte)i;
            if (sha1_32(buf) == 1181221584) {
                break;
            }
        }
        for (i = -112; i < -91; i++) {
            buf[843] = (byte)i;
            if (sha1_32(buf) == 1573565719) {
                break;
            }
        }
        for (i = -128; i < -108; i++) {
            buf[844] = (byte)i;
            if (sha1_32(buf) == 1418275783) {
                break;
            }
        }
        for (i = -21; i < -7; i++) {
            buf[845] = (byte)i;
            if (sha1_32(buf) == -184033445) {
                break;
            }
        }
        for (i = -89; i < -71; i++) {
            buf[846] = (byte)i;
            if (sha1_32(buf) == 532578871) {
                break;
            }
        }
        for (i = 91; i < 102; i++) {
            buf[847] = (byte)i;
            if (sha1_32(buf) == 347468978) {
                break;
            }
        }
        for (i = -19; i < 0; i++) {
            buf[848] = (byte)i;
            if (sha1_32(buf) == 1066586442) {
                break;
            }
        }
        for (i = 82; i < 110; i++) {
            buf[849] = (byte)i;
            if (sha1_32(buf) == -1037540152) {
                break;
            }
        }
        for (i = -121; i < -107; i++) {
            buf[850] = (byte)i;
            if (sha1_32(buf) == 574418197) {
                break;
            }
        }
        for (i = -112; i < -100; i++) {
            buf[851] = (byte)i;
            if (sha1_32(buf) == 481227237) {
                break;
            }
        }
        for (i = -84; i < -81; i++) {
            buf[852] = (byte)i;
            if (sha1_32(buf) == -2134906811) {
                break;
            }
        }
        for (i = -25; i < -11; i++) {
            buf[853] = (byte)i;
            if (sha1_32(buf) == -989429403) {
                break;
            }
        }
        for (i = -81; i < -61; i++) {
            buf[854] = (byte)i;
            if (sha1_32(buf) == 850662000) {
                break;
            }
        }
        for (i = -123; i < -105; i++) {
            buf[855] = (byte)i;
            if (sha1_32(buf) == -1147784180) {
                break;
            }
        }
        for (i = 19; i < 31; i++) {
            buf[856] = (byte)i;
            if (sha1_32(buf) == -214530242) {
                break;
            }
        }
        for (i = -51; i < -23; i++) {
            buf[857] = (byte)i;
            if (sha1_32(buf) == -1776201469) {
                break;
            }
        }
        for (i = 68; i < 84; i++) {
            buf[858] = (byte)i;
            if (sha1_32(buf) == 1010448719) {
                break;
            }
        }
        for (i = -51; i < -36; i++) {
            buf[859] = (byte)i;
            if (sha1_32(buf) == 1551475843) {
                break;
            }
        }
        for (i = -75; i < -58; i++) {
            buf[860] = (byte)i;
            if (sha1_32(buf) == -937406498) {
                break;
            }
        }
        for (i = 34; i < 58; i++) {
            buf[861] = (byte)i;
            if (sha1_32(buf) == 1550836914) {
                break;
            }
        }
        for (i = -113; i < -100; i++) {
            buf[862] = (byte)i;
            if (sha1_32(buf) == -1298442502) {
                break;
            }
        }
        for (i = -124; i < -112; i++) {
            buf[863] = (byte)i;
            if (sha1_32(buf) == -555661517) {
                break;
            }
        }
        for (i = 83; i < 101; i++) {
            buf[864] = (byte)i;
            if (sha1_32(buf) == -1438091160) {
                break;
            }
        }
        for (i = -48; i < -31; i++) {
            buf[865] = (byte)i;
            if (sha1_32(buf) == 2132698072) {
                break;
            }
        }
        for (i = -44; i < -29; i++) {
            buf[866] = (byte)i;
            if (sha1_32(buf) == -385660713) {
                break;
            }
        }
        for (i = 74; i < 79; i++) {
            buf[867] = (byte)i;
            if (sha1_32(buf) == -1842982530) {
                break;
            }
        }
        for (i = 91; i < 107; i++) {
            buf[868] = (byte)i;
            if (sha1_32(buf) == -1788925045) {
                break;
            }
        }
        for (i = -128; i < -116; i++) {
            buf[869] = (byte)i;
            if (sha1_32(buf) == -1010049993) {
                break;
            }
        }
        for (i = 34; i < 37; i++) {
            buf[870] = (byte)i;
            if (sha1_32(buf) == -1398577631) {
                break;
            }
        }
        for (i = -55; i < -39; i++) {
            buf[871] = (byte)i;
            if (sha1_32(buf) == 1736832895) {
                break;
            }
        }
        for (i = 91; i < 111; i++) {
            buf[872] = (byte)i;
            if (sha1_32(buf) == -180420805) {
                break;
            }
        }
        for (i = -85; i < -61; i++) {
            buf[873] = (byte)i;
            if (sha1_32(buf) == 642860160) {
                break;
            }
        }
        for (i = -40; i < -22; i++) {
            buf[874] = (byte)i;
            if (sha1_32(buf) == -967734170) {
                break;
            }
        }
        for (i = 82; i < 98; i++) {
            buf[875] = (byte)i;
            if (sha1_32(buf) == 295298105) {
                break;
            }
        }
        for (i = -8; i < 8; i++) {
            buf[876] = (byte)i;
            if (sha1_32(buf) == -1057428378) {
                break;
            }
        }
        for (i = 96; i < 119; i++) {
            buf[877] = (byte)i;
            if (sha1_32(buf) == 594252419) {
                break;
            }
        }
        for (i = -7; i < 10; i++) {
            buf[878] = (byte)i;
            if (sha1_32(buf) == -130004649) {
                break;
            }
        }
        for (i = -62; i < -31; i++) {
            buf[879] = (byte)i;
            if (sha1_32(buf) == -716943553) {
                break;
            }
        }
        for (i = 62; i < 73; i++) {
            buf[880] = (byte)i;
            if (sha1_32(buf) == -319169828) {
                break;
            }
        }
        for (i = 91; i < 97; i++) {
            buf[881] = (byte)i;
            if (sha1_32(buf) == 1206977582) {
                break;
            }
        }
        for (i = 90; i < 116; i++) {
            buf[882] = (byte)i;
            if (sha1_32(buf) == 1702154657) {
                break;
            }
        }
        for (i = 66; i < 82; i++) {
            buf[883] = (byte)i;
            if (sha1_32(buf) == 1600686196) {
                break;
            }
        }
        for (i = -93; i < -78; i++) {
            buf[884] = (byte)i;
            if (sha1_32(buf) == 414464061) {
                break;
            }
        }
        for (i = 123; i < 128; i++) {
            buf[885] = (byte)i;
            if (sha1_32(buf) == 2124178395) {
                break;
            }
        }
        for (i = 51; i < 63; i++) {
            buf[886] = (byte)i;
            if (sha1_32(buf) == -507698925) {
                break;
            }
        }
        for (i = -102; i < -84; i++) {
            buf[887] = (byte)i;
            if (sha1_32(buf) == 1431174695) {
                break;
            }
        }
        for (i = -67; i < -58; i++) {
            buf[888] = (byte)i;
            if (sha1_32(buf) == 81837679) {
                break;
            }
        }
        for (i = 35; i < 42; i++) {
            buf[889] = (byte)i;
            if (sha1_32(buf) == 897196083) {
                break;
            }
        }
        for (i = 107; i < 128; i++) {
            buf[890] = (byte)i;
            if (sha1_32(buf) == -1013526254) {
                break;
            }
        }
        for (i = -125; i < -111; i++) {
            buf[891] = (byte)i;
            if (sha1_32(buf) == 1675498635) {
                break;
            }
        }
        for (i = 59; i < 88; i++) {
            buf[892] = (byte)i;
            if (sha1_32(buf) == 803528464) {
                break;
            }
        }
        for (i = -108; i < -94; i++) {
            buf[893] = (byte)i;
            if (sha1_32(buf) == 1686320691) {
                break;
            }
        }
        for (i = 101; i < 120; i++) {
            buf[894] = (byte)i;
            if (sha1_32(buf) == 506009683) {
                break;
            }
        }
        for (i = -125; i < -109; i++) {
            buf[895] = (byte)i;
            if (sha1_32(buf) == -1158831148) {
                break;
            }
        }
        for (i = -45; i < -23; i++) {
            buf[896] = (byte)i;
            if (sha1_32(buf) == 124401641) {
                break;
            }
        }
        for (i = 108; i < 120; i++) {
            buf[897] = (byte)i;
            if (sha1_32(buf) == 653783614) {
                break;
            }
        }
        for (i = 36; i < 50; i++) {
            buf[898] = (byte)i;
            if (sha1_32(buf) == 164021597) {
                break;
            }
        }
        for (i = 36; i < 47; i++) {
            buf[899] = (byte)i;
            if (sha1_32(buf) == -209740902) {
                break;
            }
        }
        for (i = -99; i < -80; i++) {
            buf[900] = (byte)i;
            if (sha1_32(buf) == 491837709) {
                break;
            }
        }
        for (i = 29; i < 40; i++) {
            buf[901] = (byte)i;
            if (sha1_32(buf) == -1329124974) {
                break;
            }
        }
        for (i = -5; i < 10; i++) {
            buf[902] = (byte)i;
            if (sha1_32(buf) == -1547005349) {
                break;
            }
        }
        for (i = 90; i < 111; i++) {
            buf[903] = (byte)i;
            if (sha1_32(buf) == 858692312) {
                break;
            }
        }
        for (i = 67; i < 73; i++) {
            buf[904] = (byte)i;
            if (sha1_32(buf) == 51960892) {
                break;
            }
        }
        for (i = -17; i < 1; i++) {
            buf[905] = (byte)i;
            if (sha1_32(buf) == -2096216607) {
                break;
            }
        }
        for (i = -16; i < 1; i++) {
            buf[906] = (byte)i;
            if (sha1_32(buf) == 1049619336) {
                break;
            }
        }
        for (i = -124; i < -108; i++) {
            buf[907] = (byte)i;
            if (sha1_32(buf) == -133501008) {
                break;
            }
        }
        for (i = 15; i < 36; i++) {
            buf[908] = (byte)i;
            if (sha1_32(buf) == 1783106590) {
                break;
            }
        }
        for (i = 54; i < 70; i++) {
            buf[909] = (byte)i;
            if (sha1_32(buf) == -1119375047) {
                break;
            }
        }
        for (i = 32; i < 52; i++) {
            buf[910] = (byte)i;
            if (sha1_32(buf) == 1716542096) {
                break;
            }
        }
        for (i = 29; i < 44; i++) {
            buf[911] = (byte)i;
            if (sha1_32(buf) == -1926695384) {
                break;
            }
        }
        for (i = -109; i < -82; i++) {
            buf[912] = (byte)i;
            if (sha1_32(buf) == -890920988) {
                break;
            }
        }
        for (i = 9; i < 24; i++) {
            buf[913] = (byte)i;
            if (sha1_32(buf) == 9713633) {
                break;
            }
        }
        for (i = 51; i < 70; i++) {
            buf[914] = (byte)i;
            if (sha1_32(buf) == 1448629257) {
                break;
            }
        }
        for (i = -26; i < -13; i++) {
            buf[915] = (byte)i;
            if (sha1_32(buf) == -2097990705) {
                break;
            }
        }
        for (i = -77; i < -63; i++) {
            buf[916] = (byte)i;
            if (sha1_32(buf) == -210665503) {
                break;
            }
        }
        for (i = 22; i < 37; i++) {
            buf[917] = (byte)i;
            if (sha1_32(buf) == -2041895536) {
                break;
            }
        }
        for (i = -17; i < -13; i++) {
            buf[918] = (byte)i;
            if (sha1_32(buf) == 2038696354) {
                break;
            }
        }
        for (i = 95; i < 117; i++) {
            buf[919] = (byte)i;
            if (sha1_32(buf) == 1879666476) {
                break;
            }
        }
        for (i = -24; i < -15; i++) {
            buf[920] = (byte)i;
            if (sha1_32(buf) == 941435376) {
                break;
            }
        }
        for (i = 75; i < 90; i++) {
            buf[921] = (byte)i;
            if (sha1_32(buf) == -2101928779) {
                break;
            }
        }
        for (i = 118; i < 128; i++) {
            buf[922] = (byte)i;
            if (sha1_32(buf) == -1746108731) {
                break;
            }
        }
        for (i = -30; i < -8; i++) {
            buf[923] = (byte)i;
            if (sha1_32(buf) == -665412443) {
                break;
            }
        }
        for (i = 106; i < 119; i++) {
            buf[924] = (byte)i;
            if (sha1_32(buf) == 1786207197) {
                break;
            }
        }
        for (i = 5; i < 13; i++) {
            buf[925] = (byte)i;
            if (sha1_32(buf) == -1886594638) {
                break;
            }
        }
        for (i = 79; i < 83; i++) {
            buf[926] = (byte)i;
            if (sha1_32(buf) == 173874742) {
                break;
            }
        }
        for (i = -67; i < -52; i++) {
            buf[927] = (byte)i;
            if (sha1_32(buf) == 1560857496) {
                break;
            }
        }
        for (i = -37; i < -13; i++) {
            buf[928] = (byte)i;
            if (sha1_32(buf) == 678126394) {
                break;
            }
        }
        for (i = 4; i < 25; i++) {
            buf[929] = (byte)i;
            if (sha1_32(buf) == -390881064) {
                break;
            }
        }
        for (i = 54; i < 64; i++) {
            buf[930] = (byte)i;
            if (sha1_32(buf) == -2128891522) {
                break;
            }
        }
        for (i = 54; i < 64; i++) {
            buf[931] = (byte)i;
            if (sha1_32(buf) == -1043541889) {
                break;
            }
        }
        for (i = -96; i < -80; i++) {
            buf[932] = (byte)i;
            if (sha1_32(buf) == 1776764105) {
                break;
            }
        }
        for (i = 30; i < 55; i++) {
            buf[933] = (byte)i;
            if (sha1_32(buf) == -29003074) {
                break;
            }
        }
        for (i = -15; i < 14; i++) {
            buf[934] = (byte)i;
            if (sha1_32(buf) == 1688660123) {
                break;
            }
        }
        for (i = -82; i < -68; i++) {
            buf[935] = (byte)i;
            if (sha1_32(buf) == 1344781571) {
                break;
            }
        }
        for (i = -45; i < -33; i++) {
            buf[936] = (byte)i;
            if (sha1_32(buf) == -1128881026) {
                break;
            }
        }
        for (i = -128; i < -120; i++) {
            buf[937] = (byte)i;
            if (sha1_32(buf) == 1226032026) {
                break;
            }
        }
        for (i = -128; i < -123; i++) {
            buf[938] = (byte)i;
            if (sha1_32(buf) == 473328868) {
                break;
            }
        }
        for (i = -76; i < -64; i++) {
            buf[939] = (byte)i;
            if (sha1_32(buf) == 565010272) {
                break;
            }
        }
        for (i = -76; i < -64; i++) {
            buf[940] = (byte)i;
            if (sha1_32(buf) == 900169125) {
                break;
            }
        }
        for (i = -32; i < -14; i++) {
            buf[941] = (byte)i;
            if (sha1_32(buf) == -355130608) {
                break;
            }
        }
        for (i = 50; i < 55; i++) {
            buf[942] = (byte)i;
            if (sha1_32(buf) == 1691783069) {
                break;
            }
        }
        for (i = -116; i < -103; i++) {
            buf[943] = (byte)i;
            if (sha1_32(buf) == 1913077518) {
                break;
            }
        }
        for (i = -12; i < 5; i++) {
            buf[944] = (byte)i;
            if (sha1_32(buf) == -2053258861) {
                break;
            }
        }
        for (i = 85; i < 92; i++) {
            buf[945] = (byte)i;
            if (sha1_32(buf) == -300507563) {
                break;
            }
        }
        for (i = 107; i < 122; i++) {
            buf[946] = (byte)i;
            if (sha1_32(buf) == 282568895) {
                break;
            }
        }
        for (i = -117; i < -93; i++) {
            buf[947] = (byte)i;
            if (sha1_32(buf) == 420814292) {
                break;
            }
        }
        for (i = -14; i < 2; i++) {
            buf[948] = (byte)i;
            if (sha1_32(buf) == 423424823) {
                break;
            }
        }
        for (i = 32; i < 49; i++) {
            buf[949] = (byte)i;
            if (sha1_32(buf) == 1739496471) {
                break;
            }
        }
        for (i = -95; i < -79; i++) {
            buf[950] = (byte)i;
            if (sha1_32(buf) == 1305818328) {
                break;
            }
        }
        for (i = 123; i < 128; i++) {
            buf[951] = (byte)i;
            if (sha1_32(buf) == -385169547) {
                break;
            }
        }
        for (i = -98; i < -75; i++) {
            buf[952] = (byte)i;
            if (sha1_32(buf) == -82992251) {
                break;
            }
        }
        for (i = 16; i < 45; i++) {
            buf[953] = (byte)i;
            if (sha1_32(buf) == 736769536) {
                break;
            }
        }
        for (i = -11; i < 9; i++) {
            buf[954] = (byte)i;
            if (sha1_32(buf) == -273007010) {
                break;
            }
        }
        for (i = -63; i < -45; i++) {
            buf[955] = (byte)i;
            if (sha1_32(buf) == -959785478) {
                break;
            }
        }
        for (i = -37; i < -10; i++) {
            buf[956] = (byte)i;
            if (sha1_32(buf) == 615361039) {
                break;
            }
        }
        for (i = 38; i < 52; i++) {
            buf[957] = (byte)i;
            if (sha1_32(buf) == -1616876552) {
                break;
            }
        }
        for (i = -35; i < -24; i++) {
            buf[958] = (byte)i;
            if (sha1_32(buf) == -122302933) {
                break;
            }
        }
        for (i = 91; i < 111; i++) {
            buf[959] = (byte)i;
            if (sha1_32(buf) == -670075924) {
                break;
            }
        }
        for (i = -64; i < -37; i++) {
            buf[960] = (byte)i;
            if (sha1_32(buf) == 2128058736) {
                break;
            }
        }
        for (i = 100; i < 126; i++) {
            buf[961] = (byte)i;
            if (sha1_32(buf) == 1838976662) {
                break;
            }
        }
        for (i = -32; i < -9; i++) {
            buf[962] = (byte)i;
            if (sha1_32(buf) == -697469319) {
                break;
            }
        }
        for (i = 21; i < 35; i++) {
            buf[963] = (byte)i;
            if (sha1_32(buf) == -69516682) {
                break;
            }
        }
        for (i = 115; i < 123; i++) {
            buf[964] = (byte)i;
            if (sha1_32(buf) == -983548758) {
                break;
            }
        }
        for (i = -16; i < 9; i++) {
            buf[965] = (byte)i;
            if (sha1_32(buf) == -1323999960) {
                break;
            }
        }
        for (i = -92; i < -76; i++) {
            buf[966] = (byte)i;
            if (sha1_32(buf) == 939745) {
                break;
            }
        }
        for (i = -13; i < -7; i++) {
            buf[967] = (byte)i;
            if (sha1_32(buf) == -821302765) {
                break;
            }
        }
        for (i = -38; i < -14; i++) {
            buf[968] = (byte)i;
            if (sha1_32(buf) == -952816596) {
                break;
            }
        }
        for (i = -111; i < -95; i++) {
            buf[969] = (byte)i;
            if (sha1_32(buf) == 710245431) {
                break;
            }
        }
        for (i = 52; i < 74; i++) {
            buf[970] = (byte)i;
            if (sha1_32(buf) == -666644450) {
                break;
            }
        }
        for (i = 18; i < 36; i++) {
            buf[971] = (byte)i;
            if (sha1_32(buf) == 322787584) {
                break;
            }
        }
        for (i = -25; i < -15; i++) {
            buf[972] = (byte)i;
            if (sha1_32(buf) == 559395848) {
                break;
            }
        }
        for (i = -52; i < -27; i++) {
            buf[973] = (byte)i;
            if (sha1_32(buf) == 1166651718) {
                break;
            }
        }
        for (i = -3; i < 4; i++) {
            buf[974] = (byte)i;
            if (sha1_32(buf) == -1078101568) {
                break;
            }
        }
        for (i = 45; i < 61; i++) {
            buf[975] = (byte)i;
            if (sha1_32(buf) == -97252886) {
                break;
            }
        }
        for (i = 104; i < 116; i++) {
            buf[976] = (byte)i;
            if (sha1_32(buf) == 2024910581) {
                break;
            }
        }
        for (i = -86; i < -67; i++) {
            buf[977] = (byte)i;
            if (sha1_32(buf) == -1854481980) {
                break;
            }
        }
        for (i = -104; i < -80; i++) {
            buf[978] = (byte)i;
            if (sha1_32(buf) == -1880760509) {
                break;
            }
        }
        for (i = -68; i < -65; i++) {
            buf[979] = (byte)i;
            if (sha1_32(buf) == -808911243) {
                break;
            }
        }
        for (i = 28; i < 33; i++) {
            buf[980] = (byte)i;
            if (sha1_32(buf) == -1723897070) {
                break;
            }
        }
        for (i = 52; i < 58; i++) {
            buf[981] = (byte)i;
            if (sha1_32(buf) == -406924123) {
                break;
            }
        }
        for (i = -91; i < -76; i++) {
            buf[982] = (byte)i;
            if (sha1_32(buf) == -449720096) {
                break;
            }
        }
        for (i = 62; i < 82; i++) {
            buf[983] = (byte)i;
            if (sha1_32(buf) == -1939363208) {
                break;
            }
        }
        for (i = 68; i < 87; i++) {
            buf[984] = (byte)i;
            if (sha1_32(buf) == -1462790755) {
                break;
            }
        }
        for (i = -35; i < -25; i++) {
            buf[985] = (byte)i;
            if (sha1_32(buf) == -1747207513) {
                break;
            }
        }
        for (i = 13; i < 23; i++) {
            buf[986] = (byte)i;
            if (sha1_32(buf) == -463620173) {
                break;
            }
        }
        for (i = 87; i < 96; i++) {
            buf[987] = (byte)i;
            if (sha1_32(buf) == -2093355378) {
                break;
            }
        }
        for (i = 20; i < 36; i++) {
            buf[988] = (byte)i;
            if (sha1_32(buf) == 954766843) {
                break;
            }
        }
        for (i = 34; i < 46; i++) {
            buf[989] = (byte)i;
            if (sha1_32(buf) == 481929272) {
                break;
            }
        }
        for (i = -79; i < -59; i++) {
            buf[990] = (byte)i;
            if (sha1_32(buf) == 1206514280) {
                break;
            }
        }
        for (i = 13; i < 30; i++) {
            buf[991] = (byte)i;
            if (sha1_32(buf) == -1524111522) {
                break;
            }
        }
        for (i = 96; i < 125; i++) {
            buf[992] = (byte)i;
            if (sha1_32(buf) == 1276924125) {
                break;
            }
        }
        for (i = -126; i < -123; i++) {
            buf[993] = (byte)i;
            if (sha1_32(buf) == -1052279915) {
                break;
            }
        }
        for (i = -90; i < -69; i++) {
            buf[994] = (byte)i;
            if (sha1_32(buf) == 500568285) {
                break;
            }
        }
        for (i = 75; i < 79; i++) {
            buf[995] = (byte)i;
            if (sha1_32(buf) == 1481228035) {
                break;
            }
        }
        for (i = 19; i < 28; i++) {
            buf[996] = (byte)i;
            if (sha1_32(buf) == 2015433921) {
                break;
            }
        }
        for (i = 37; i < 41; i++) {
            buf[997] = (byte)i;
            if (sha1_32(buf) == 1062861629) {
                break;
            }
        }
        for (i = -120; i < -97; i++) {
            buf[998] = (byte)i;
            if (sha1_32(buf) == 1683920062) {
                break;
            }
        }
        for (i = 114; i < 128; i++) {
            buf[999] = (byte)i;
            if (sha1_32(buf) == -159014019) {
                break;
            }
        }
        for (i = -84; i < -58; i++) {
            buf[1000] = (byte)i;
            if (sha1_32(buf) == -275665174) {
                break;
            }
        }
        for (i = -92; i < -82; i++) {
            buf[1001] = (byte)i;
            if (sha1_32(buf) == -692259212) {
                break;
            }
        }
        for (i = -102; i < -88; i++) {
            buf[1002] = (byte)i;
            if (sha1_32(buf) == -573524091) {
                break;
            }
        }
        for (i = -31; i < -8; i++) {
            buf[1003] = (byte)i;
            if (sha1_32(buf) == 148148824) {
                break;
            }
        }
        for (i = -81; i < -53; i++) {
            buf[1004] = (byte)i;
            if (sha1_32(buf) == -1561900327) {
                break;
            }
        }
        for (i = 25; i < 45; i++) {
            buf[1005] = (byte)i;
            if (sha1_32(buf) == 474181852) {
                break;
            }
        }
        for (i = -106; i < -92; i++) {
            buf[1006] = (byte)i;
            if (sha1_32(buf) == -114123305) {
                break;
            }
        }
        for (i = 43; i < 56; i++) {
            buf[1007] = (byte)i;
            if (sha1_32(buf) == 684734311) {
                break;
            }
        }
        for (i = -62; i < -49; i++) {
            buf[1008] = (byte)i;
            if (sha1_32(buf) == 948133930) {
                break;
            }
        }
        for (i = 118; i < 126; i++) {
            buf[1009] = (byte)i;
            if (sha1_32(buf) == -1208324140) {
                break;
            }
        }
        for (i = -107; i < -103; i++) {
            buf[1010] = (byte)i;
            if (sha1_32(buf) == -1632800102) {
                break;
            }
        }
        for (i = 40; i < 52; i++) {
            buf[1011] = (byte)i;
            if (sha1_32(buf) == 935079774) {
                break;
            }
        }
        for (i = 58; i < 79; i++) {
            buf[1012] = (byte)i;
            if (sha1_32(buf) == 187205936) {
                break;
            }
        }
        for (i = -72; i < -59; i++) {
            buf[1013] = (byte)i;
            if (sha1_32(buf) == -537554221) {
                break;
            }
        }
        for (i = -67; i < -64; i++) {
            buf[1014] = (byte)i;
            if (sha1_32(buf) == 1494643837) {
                break;
            }
        }
        for (i = -40; i < -18; i++) {
            buf[1015] = (byte)i;
            if (sha1_32(buf) == -80283373) {
                break;
            }
        }
        for (i = -104; i < -84; i++) {
            buf[1016] = (byte)i;
            if (sha1_32(buf) == -1696945355) {
                break;
            }
        }
        for (i = 51; i < 72; i++) {
            buf[1017] = (byte)i;
            if (sha1_32(buf) == 1018215063) {
                break;
            }
        }
        for (i = -53; i < -34; i++) {
            buf[1018] = (byte)i;
            if (sha1_32(buf) == -2103626829) {
                break;
            }
        }
        for (i = 59; i < 68; i++) {
            buf[1019] = (byte)i;
            if (sha1_32(buf) == -482146609) {
                break;
            }
        }
        for (i = -61; i < -48; i++) {
            buf[1020] = (byte)i;
            if (sha1_32(buf) == -697059482) {
                break;
            }
        }
        for (i = 109; i < 119; i++) {
            buf[1021] = (byte)i;
            if (sha1_32(buf) == 852109421) {
                break;
            }
        }
        for (i = 64; i < 86; i++) {
            buf[1022] = (byte)i;
            if (sha1_32(buf) == -1497030025) {
                break;
            }
        }
        for (i = -29; i < -3; i++) {
            buf[1023] = (byte)i;
            if (sha1_32(buf) == 891788840) {
                break;
            }
        }
        for (i = -25; i < -11; i++) {
            buf[1024] = (byte)i;
            if (sha1_32(buf) == -898092712) {
                break;
            }
        }
        for (i = -108; i < -78; i++) {
            buf[1025] = (byte)i;
            if (sha1_32(buf) == 275779499) {
                break;
            }
        }
        for (i = -60; i < -43; i++) {
            buf[1026] = (byte)i;
            if (sha1_32(buf) == 218013134) {
                break;
            }
        }
        for (i = 111; i < 128; i++) {
            buf[1027] = (byte)i;
            if (sha1_32(buf) == -1755625693) {
                break;
            }
        }
        for (i = 100; i < 118; i++) {
            buf[1028] = (byte)i;
            if (sha1_32(buf) == -1755956036) {
                break;
            }
        }
        for (i = 50; i < 67; i++) {
            buf[1029] = (byte)i;
            if (sha1_32(buf) == -1754690556) {
                break;
            }
        }
        for (i = 74; i < 103; i++) {
            buf[1030] = (byte)i;
            if (sha1_32(buf) == -902849029) {
                break;
            }
        }
        for (i = 68; i < 84; i++) {
            buf[1031] = (byte)i;
            if (sha1_32(buf) == 1352234838) {
                break;
            }
        }
        for (i = 52; i < 70; i++) {
            buf[1032] = (byte)i;
            if (sha1_32(buf) == 1620021182) {
                break;
            }
        }
        for (i = -61; i < -43; i++) {
            buf[1033] = (byte)i;
            if (sha1_32(buf) == 1955170856) {
                break;
            }
        }
        for (i = -3; i < 26; i++) {
            buf[1034] = (byte)i;
            if (sha1_32(buf) == -1599795717) {
                break;
            }
        }
        for (i = -128; i < -116; i++) {
            buf[1035] = (byte)i;
            if (sha1_32(buf) == -1360217243) {
                break;
            }
        }
        for (i = 104; i < 128; i++) {
            buf[1036] = (byte)i;
            if (sha1_32(buf) == -1029412341) {
                break;
            }
        }
        for (i = -63; i < -41; i++) {
            buf[1037] = (byte)i;
            if (sha1_32(buf) == -137364634) {
                break;
            }
        }
        for (i = -92; i < -64; i++) {
            buf[1038] = (byte)i;
            if (sha1_32(buf) == 1615923692) {
                break;
            }
        }
        for (i = 8; i < 15; i++) {
            buf[1039] = (byte)i;
            if (sha1_32(buf) == -2112071715) {
                break;
            }
        }
        for (i = 108; i < 120; i++) {
            buf[1040] = (byte)i;
            if (sha1_32(buf) == 1427064204) {
                break;
            }
        }
        for (i = -28; i < -15; i++) {
            buf[1041] = (byte)i;
            if (sha1_32(buf) == 1823848759) {
                break;
            }
        }
        for (i = 46; i < 71; i++) {
            buf[1042] = (byte)i;
            if (sha1_32(buf) == -997272939) {
                break;
            }
        }
        for (i = -43; i < -23; i++) {
            buf[1043] = (byte)i;
            if (sha1_32(buf) == -1022856547) {
                break;
            }
        }
        for (i = 36; i < 42; i++) {
            buf[1044] = (byte)i;
            if (sha1_32(buf) == 928484592) {
                break;
            }
        }
        for (i = 5; i < 23; i++) {
            buf[1045] = (byte)i;
            if (sha1_32(buf) == -1515470633) {
                break;
            }
        }
        for (i = 106; i < 114; i++) {
            buf[1046] = (byte)i;
            if (sha1_32(buf) == -1161688421) {
                break;
            }
        }
        for (i = 27; i < 39; i++) {
            buf[1047] = (byte)i;
            if (sha1_32(buf) == 1432246524) {
                break;
            }
        }
        for (i = -34; i < -16; i++) {
            buf[1048] = (byte)i;
            if (sha1_32(buf) == -1066874182) {
                break;
            }
        }
        for (i = -97; i < -81; i++) {
            buf[1049] = (byte)i;
            if (sha1_32(buf) == -164656194) {
                break;
            }
        }
        for (i = -118; i < -95; i++) {
            buf[1050] = (byte)i;
            if (sha1_32(buf) == -696253718) {
                break;
            }
        }
        for (i = 103; i < 113; i++) {
            buf[1051] = (byte)i;
            if (sha1_32(buf) == 1135728900) {
                break;
            }
        }
        for (i = 11; i < 35; i++) {
            buf[1052] = (byte)i;
            if (sha1_32(buf) == -143126229) {
                break;
            }
        }
        for (i = -115; i < -99; i++) {
            buf[1053] = (byte)i;
            if (sha1_32(buf) == 1297162527) {
                break;
            }
        }
        for (i = 71; i < 93; i++) {
            buf[1054] = (byte)i;
            if (sha1_32(buf) == 1484476696) {
                break;
            }
        }
        for (i = -107; i < -90; i++) {
            buf[1055] = (byte)i;
            if (sha1_32(buf) == -488892774) {
                break;
            }
        }
        for (i = 59; i < 71; i++) {
            buf[1056] = (byte)i;
            if (sha1_32(buf) == -1720801169) {
                break;
            }
        }
        for (i = -123; i < -117; i++) {
            buf[1057] = (byte)i;
            if (sha1_32(buf) == -2064168177) {
                break;
            }
        }
        for (i = 50; i < 69; i++) {
            buf[1058] = (byte)i;
            if (sha1_32(buf) == -145066456) {
                break;
            }
        }
        for (i = 73; i < 79; i++) {
            buf[1059] = (byte)i;
            if (sha1_32(buf) == -127420424) {
                break;
            }
        }
        for (i = -15; i < -4; i++) {
            buf[1060] = (byte)i;
            if (sha1_32(buf) == -86729607) {
                break;
            }
        }
        for (i = 29; i < 34; i++) {
            buf[1061] = (byte)i;
            if (sha1_32(buf) == -749121046) {
                break;
            }
        }
        for (i = 86; i < 108; i++) {
            buf[1062] = (byte)i;
            if (sha1_32(buf) == 1885556232) {
                break;
            }
        }
        for (i = 64; i < 75; i++) {
            buf[1063] = (byte)i;
            if (sha1_32(buf) == 310280712) {
                break;
            }
        }
        for (i = 16; i < 41; i++) {
            buf[1064] = (byte)i;
            if (sha1_32(buf) == -521340859) {
                break;
            }
        }
        for (i = 35; i < 55; i++) {
            buf[1065] = (byte)i;
            if (sha1_32(buf) == -1586362287) {
                break;
            }
        }
        for (i = 89; i < 97; i++) {
            buf[1066] = (byte)i;
            if (sha1_32(buf) == -354662036) {
                break;
            }
        }
        for (i = -59; i < -56; i++) {
            buf[1067] = (byte)i;
            if (sha1_32(buf) == -821031336) {
                break;
            }
        }
        for (i = -24; i < -13; i++) {
            buf[1068] = (byte)i;
            if (sha1_32(buf) == -923490404) {
                break;
            }
        }
        for (i = 37; i < 52; i++) {
            buf[1069] = (byte)i;
            if (sha1_32(buf) == 177915348) {
                break;
            }
        }
        for (i = -99; i < -73; i++) {
            buf[1070] = (byte)i;
            if (sha1_32(buf) == 1529181057) {
                break;
            }
        }
        for (i = -50; i < -31; i++) {
            buf[1071] = (byte)i;
            if (sha1_32(buf) == 437616071) {
                break;
            }
        }
        for (i = -87; i < -70; i++) {
            buf[1072] = (byte)i;
            if (sha1_32(buf) == 408707608) {
                break;
            }
        }
        for (i = 33; i < 53; i++) {
            buf[1073] = (byte)i;
            if (sha1_32(buf) == -654828582) {
                break;
            }
        }
        for (i = -14; i < -2; i++) {
            buf[1074] = (byte)i;
            if (sha1_32(buf) == -2030844185) {
                break;
            }
        }
        for (i = -26; i < -22; i++) {
            buf[1075] = (byte)i;
            if (sha1_32(buf) == 1176429601) {
                break;
            }
        }
        for (i = -41; i < -31; i++) {
            buf[1076] = (byte)i;
            if (sha1_32(buf) == 453611153) {
                break;
            }
        }
        for (i = 85; i < 97; i++) {
            buf[1077] = (byte)i;
            if (sha1_32(buf) == 1363021067) {
                break;
            }
        }
        for (i = 107; i < 119; i++) {
            buf[1078] = (byte)i;
            if (sha1_32(buf) == 1755474394) {
                break;
            }
        }
        for (i = 74; i < 81; i++) {
            buf[1079] = (byte)i;
            if (sha1_32(buf) == -987548633) {
                break;
            }
        }
        for (i = -109; i < -101; i++) {
            buf[1080] = (byte)i;
            if (sha1_32(buf) == -201716662) {
                break;
            }
        }
        for (i = 93; i < 96; i++) {
            buf[1081] = (byte)i;
            if (sha1_32(buf) == 1576621631) {
                break;
            }
        }
        for (i = -116; i < -93; i++) {
            buf[1082] = (byte)i;
            if (sha1_32(buf) == -903394243) {
                break;
            }
        }
        for (i = -17; i < 8; i++) {
            buf[1083] = (byte)i;
            if (sha1_32(buf) == -1616974734) {
                break;
            }
        }
        for (i = -49; i < -41; i++) {
            buf[1084] = (byte)i;
            if (sha1_32(buf) == 738545194) {
                break;
            }
        }
        for (i = -111; i < -97; i++) {
            buf[1085] = (byte)i;
            if (sha1_32(buf) == -1811263947) {
                break;
            }
        }
        for (i = 121; i < 127; i++) {
            buf[1086] = (byte)i;
            if (sha1_32(buf) == 1810580590) {
                break;
            }
        }
        for (i = 4; i < 18; i++) {
            buf[1087] = (byte)i;
            if (sha1_32(buf) == 221650231) {
                break;
            }
        }
        for (i = 60; i < 83; i++) {
            buf[1088] = (byte)i;
            if (sha1_32(buf) == 2053246169) {
                break;
            }
        }
        for (i = -119; i < -97; i++) {
            buf[1089] = (byte)i;
            if (sha1_32(buf) == -1713736803) {
                break;
            }
        }
        for (i = -90; i < -64; i++) {
            buf[1090] = (byte)i;
            if (sha1_32(buf) == -691873802) {
                break;
            }
        }
        for (i = 10; i < 25; i++) {
            buf[1091] = (byte)i;
            if (sha1_32(buf) == -569621128) {
                break;
            }
        }
        for (i = 117; i < 128; i++) {
            buf[1092] = (byte)i;
            if (sha1_32(buf) == 793728001) {
                break;
            }
        }
        for (i = 68; i < 89; i++) {
            buf[1093] = (byte)i;
            if (sha1_32(buf) == -1319840905) {
                break;
            }
        }
        for (i = 49; i < 68; i++) {
            buf[1094] = (byte)i;
            if (sha1_32(buf) == -908273433) {
                break;
            }
        }
        for (i = -73; i < -53; i++) {
            buf[1095] = (byte)i;
            if (sha1_32(buf) == -1418799368) {
                break;
            }
        }
        for (i = -33; i < -5; i++) {
            buf[1096] = (byte)i;
            if (sha1_32(buf) == -455020657) {
                break;
            }
        }
        for (i = 67; i < 91; i++) {
            buf[1097] = (byte)i;
            if (sha1_32(buf) == 1514412203) {
                break;
            }
        }
        for (i = 9; i < 22; i++) {
            buf[1098] = (byte)i;
            if (sha1_32(buf) == -337467994) {
                break;
            }
        }
        for (i = 55; i < 66; i++) {
            buf[1099] = (byte)i;
            if (sha1_32(buf) == 1676497394) {
                break;
            }
        }
        for (i = -116; i < -103; i++) {
            buf[1100] = (byte)i;
            if (sha1_32(buf) == -237333464) {
                break;
            }
        }
        for (i = -12; i < 13; i++) {
            buf[1101] = (byte)i;
            if (sha1_32(buf) == -237333464) {
                break;
            }
        }
        for (i = -15; i < 0; i++) {
            buf[1102] = (byte)i;
            if (sha1_32(buf) == -107325756) {
                break;
            }
        }
        for (i = -65; i < -48; i++) {
            buf[1103] = (byte)i;
            if (sha1_32(buf) == -1710014121) {
                break;
            }
        }
        for (i = -25; i < -2; i++) {
            buf[1104] = (byte)i;
            if (sha1_32(buf) == 1774344827) {
                break;
            }
        }
        for (i = 93; i < 108; i++) {
            buf[1105] = (byte)i;
            if (sha1_32(buf) == -1717625827) {
                break;
            }
        }
        for (i = 20; i < 45; i++) {
            buf[1106] = (byte)i;
            if (sha1_32(buf) == -1837607842) {
                break;
            }
        }
        for (i = 105; i < 127; i++) {
            buf[1107] = (byte)i;
            if (sha1_32(buf) == -1938006798) {
                break;
            }
        }
        for (i = 51; i < 65; i++) {
            buf[1108] = (byte)i;
            if (sha1_32(buf) == 1105266631) {
                break;
            }
        }
        for (i = -62; i < -44; i++) {
            buf[1109] = (byte)i;
            if (sha1_32(buf) == 1734830392) {
                break;
            }
        }
        for (i = -27; i < -12; i++) {
            buf[1110] = (byte)i;
            if (sha1_32(buf) == -204740623) {
                break;
            }
        }
        for (i = -35; i < -18; i++) {
            buf[1111] = (byte)i;
            if (sha1_32(buf) == 1864468892) {
                break;
            }
        }
        for (i = -24; i < -15; i++) {
            buf[1112] = (byte)i;
            if (sha1_32(buf) == -1661888322) {
                break;
            }
        }
        for (i = -128; i < -117; i++) {
            buf[1113] = (byte)i;
            if (sha1_32(buf) == -1490553598) {
                break;
            }
        }
        for (i = 13; i < 38; i++) {
            buf[1114] = (byte)i;
            if (sha1_32(buf) == 304386005) {
                break;
            }
        }
        for (i = 37; i < 50; i++) {
            buf[1115] = (byte)i;
            if (sha1_32(buf) == -1955540681) {
                break;
            }
        }
        for (i = -77; i < -56; i++) {
            buf[1116] = (byte)i;
            if (sha1_32(buf) == 2105976722) {
                break;
            }
        }
        for (i = -24; i < -18; i++) {
            buf[1117] = (byte)i;
            if (sha1_32(buf) == 869640629) {
                break;
            }
        }
        for (i = 118; i < 128; i++) {
            buf[1118] = (byte)i;
            if (sha1_32(buf) == -569819832) {
                break;
            }
        }
        for (i = 56; i < 66; i++) {
            buf[1119] = (byte)i;
            if (sha1_32(buf) == 299712514) {
                break;
            }
        }
        for (i = 113; i < 128; i++) {
            buf[1120] = (byte)i;
            if (sha1_32(buf) == 2119417050) {
                break;
            }
        }
        for (i = 5; i < 24; i++) {
            buf[1121] = (byte)i;
            if (sha1_32(buf) == -766537065) {
                break;
            }
        }
        for (i = 111; i < 127; i++) {
            buf[1122] = (byte)i;
            if (sha1_32(buf) == 1187186746) {
                break;
            }
        }
        for (i = -118; i < -103; i++) {
            buf[1123] = (byte)i;
            if (sha1_32(buf) == 487055427) {
                break;
            }
        }
        for (i = 18; i < 29; i++) {
            buf[1124] = (byte)i;
            if (sha1_32(buf) == 512477773) {
                break;
            }
        }
        for (i = 13; i < 38; i++) {
            buf[1125] = (byte)i;
            if (sha1_32(buf) == 972613506) {
                break;
            }
        }
        for (i = -43; i < -27; i++) {
            buf[1126] = (byte)i;
            if (sha1_32(buf) == 136884757) {
                break;
            }
        }
        return buf;
    }
}

