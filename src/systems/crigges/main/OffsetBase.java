package systems.crigges.main;

import java.awt.Point;
import java.util.HashMap;

public class OffsetBase {
	private static HashMap<InterfaceSize, Point[]> skillBarOffsets = new HashMap<>();
	private static HashMap<InterfaceSize, Point[]> skillOffsets = new HashMap<>();
	private static HashMap<InterfaceSize, Point[]> traitlineIconOffsets = new HashMap<>();
	private static HashMap<InterfaceSize, Point[]> traitlineOffsets = new HashMap<>();
	private static HashMap<InterfaceSize, Point[]> secondaryTraitlineOffsets = new HashMap<>();
	private static HashMap<InterfaceSize, Point[]> traitOffsets = new HashMap<>();
	private static HashMap<InterfaceSize, Point> buildTabOffset = new HashMap<>();
	private static final boolean init = init();
	
	
	public static Point getSkillBarOffset(InterfaceSize size, int slot){
		return skillBarOffsets.get(size)[slot];
	}
	
	public static Point getSkillOffset(InterfaceSize size, int slot){
		return skillOffsets.get(size)[slot];
	}
	
	public static Point getBuildTabOffset(InterfaceSize size){
		return buildTabOffset.get(size);
	}
	
	public static Point getTraitlineIconOffset(InterfaceSize size, int slot){
		return traitlineIconOffsets.get(size)[slot];
	}
	
	public static Point getTraitlineOffset(InterfaceSize size, int slot){
		return traitlineOffsets.get(size)[slot];
	}
	
	public static Point getSecondaryTraitlineOffset(InterfaceSize size, int slot){
		return secondaryTraitlineOffsets.get(size)[slot];
	}
	
	public static Point getTraitOffset(InterfaceSize size, int slot){
		return traitOffsets.get(size)[slot];
	}
	


	private static boolean init() {
		initSmall();
		initNormal();
		initLarge();
		initLarger();
		return false;
	}
	
	private static void initSmall() {
		Point[] res = new Point[5];
		res[0] = new Point(-16, 29);
		res[1] = new Point(36, 29);
		res[2] = new Point(87, 29);
		res[3] = new Point(135, 29);
		res[4] = new Point(185, 29);
		skillBarOffsets.put(InterfaceSize.Small, res);
		
		res = new Point[24];
		res[0] = new Point(-68, -58);
		res[1] = new Point(-22, -58);
		res[2] = new Point(22, -58);
		res[3] = new Point(68, -58);
		res[4] = new Point(-68, -103);
		res[5] = new Point(-22, -103);
		res[6] = new Point(22, -103);
		res[7] = new Point(68, -103);
		res[8] = new Point(-68, -147);
		res[9] = new Point(-22, -147);
		res[10] = new Point(22, -147);
		res[11] = new Point(68, -147);
		res[12] = new Point(-68, -192);
		res[13] = new Point(-22, -192);
		res[14] = new Point(22, -192);
		res[15] = new Point(68, -192);
		res[16] = new Point(-68, -237);
		res[17] = new Point(-22, -237);
		res[18] = new Point(22, -237);
		res[19] = new Point(68, -237);
		res[20] = new Point(-68, -283);
		res[21] = new Point(-22, -283);
		res[22] = new Point(22, -283);
		res[23] = new Point(68, -283);
		skillOffsets.put(InterfaceSize.Small, res);
		
		Point buildTab = new Point(38, 140);
		buildTabOffset.put(InterfaceSize.Small, buildTab);
		
		res = new Point[3];
		res[0] = new Point(420, 362);
		res[1] = new Point(420, 483);
		res[2] = new Point(420, 606);
		traitlineIconOffsets.put(InterfaceSize.Small, res);
		
		res = new Point[6];
		res[0] = new Point(-66, -38);
		res[1] = new Point(-66, 5);
		res[2] = new Point(-66, 52);
		res[3] = new Point(-22, -38);
		res[4] = new Point(-22, 5);
		res[5] = new Point(-22, 52);
		traitlineOffsets.put(InterfaceSize.Small, res);
		
		res = new Point[6];
		res[0] = new Point(-113, -39);
		res[1] = new Point(-113, 5);
		res[2] = new Point(-113, 51);
		res[3] = new Point(-158, -39);
		res[4] = new Point(-158, 5);
		res[5] = new Point(-158, 51);
		secondaryTraitlineOffsets.put(InterfaceSize.Small, res);
		
		res = new Point[9];
		res[0] = new Point(154, -39);
		res[1] = new Point(154, 0);
		res[2] = new Point(154, 39);
		res[3] = new Point(283, -39);
		res[4] = new Point(283, 0);
		res[5] = new Point(283, 39);
		res[6] = new Point(413, -39);
		res[7] = new Point(413, 0);
		res[8] = new Point(413, 39);
		traitOffsets.put(InterfaceSize.Small, res);
	}
	
	private static void initNormal() {
		Point[] res = new Point[5];
		res[0] = new Point(-17, 34);
		res[1] = new Point(38, 34);
		res[2] = new Point(94, 34);
		res[3] = new Point(149, 34);
		res[4] = new Point(204, 34);
		skillBarOffsets.put(InterfaceSize.Normal, res);
		
		res = new Point[24];
		res[0] = new Point(-75, -65);
		res[1] = new Point(-25, -65);
		res[2] = new Point(25, -65);
		res[3] = new Point(75, -65);
		res[4] = new Point(-75, -115);
		res[5] = new Point(-25, -115);
		res[6] = new Point(25, -115);
		res[7] = new Point(75, -115);
		res[8] = new Point(-75, -165);
		res[9] = new Point(-25, -165);
		res[10] = new Point(25, -165);
		res[11] = new Point(75, -165);
		res[12] = new Point(-75, -215);
		res[13] = new Point(-25, -215);
		res[14] = new Point(25, -215);
		res[15] = new Point(75, -215);
		res[16] = new Point(-75, -265);
		res[17] = new Point(-25, -265);
		res[18] = new Point(25, -265);
		res[19] = new Point(75, -265);
		res[20] = new Point(-75, -315);
		res[21] = new Point(-25, -315);
		res[22] = new Point(25, -315);
		res[23] = new Point(75, -315);
		skillOffsets.put(InterfaceSize.Normal, res);
		
		Point buildTab = new Point(44, 157);
		buildTabOffset.put(InterfaceSize.Normal, buildTab);
		
		res = new Point[3];
		res[0] = new Point(467, 404);
		res[1] = new Point(467, 539);
		res[2] = new Point(467, 676);
		traitlineIconOffsets.put(InterfaceSize.Normal, res);
		
		res = new Point[6];
		res[0] = new Point(-73, -44);
		res[1] = new Point(-73, 5);
		res[2] = new Point(-73, 56);
		res[3] = new Point(-22, -44);
		res[4] = new Point(-22, 5);
		res[5] = new Point(-22, 56);
		traitlineOffsets.put(InterfaceSize.Normal, res);
		
		res = new Point[6];
		res[0] = new Point(-123, -44);
		res[1] = new Point(-123, 5);
		res[2] = new Point(-123, 56);
		res[3] = new Point(-174, -44);
		res[4] = new Point(-174, 5);
		res[5] = new Point(-174, 56);
		secondaryTraitlineOffsets.put(InterfaceSize.Normal, res);
		
		res = new Point[9];
		res[0] = new Point(173, -43);
		res[1] = new Point(173, 0);
		res[2] = new Point(173, 43);
		res[3] = new Point(318, -43);
		res[4] = new Point(318, 0);
		res[5] = new Point(318, 43);
		res[6] = new Point(462, -43);
		res[7] = new Point(462, 0);
		res[8] = new Point(462, 43);
		traitOffsets.put(InterfaceSize.Normal, res);
	}
	
	private static void initLarge() {
		Point[] res = new Point[5];
		res[0] = new Point(-19, 36);
		res[1] = new Point(44, 36);
		res[2] = new Point(105, 36);
		res[3] = new Point(167, 36);
		res[4] = new Point(228, 36);
		skillBarOffsets.put(InterfaceSize.Large, res);
		
		res = new Point[24];
		res[0] = new Point(-85, -70);
		res[1] = new Point(-27, -70);
		res[2] = new Point(27, -70);
		res[3] = new Point(85, -70);
		res[4] = new Point(-85, -125);
		res[5] = new Point(-27, -125);
		res[6] = new Point(27, -125);
		res[7] = new Point(85, -125);
		res[8] = new Point(-85, -181);
		res[9] = new Point(-27, -181);
		res[10] = new Point(27, -181);
		res[11] = new Point(85, -181);
		res[12] = new Point(-85, -235);
		res[13] = new Point(-27, -235);
		res[14] = new Point(27, -235);
		res[15] = new Point(85, -235);
		res[16] = new Point(-85, -290);
		res[17] = new Point(-27, -290);
		res[18] = new Point(27, -290);
		res[19] = new Point(85, -290);
		res[20] = new Point(-85, -348);
		res[21] = new Point(-27, -348);
		res[22] = new Point(27, -348);
		res[23] = new Point(85, -348);
		skillOffsets.put(InterfaceSize.Large, res);
		
		Point buildTab = new Point(47, 175);
		buildTabOffset.put(InterfaceSize.Large, buildTab);
		
		res = new Point[3];
		res[0] = new Point(518, 447);
		res[1] = new Point(518, 597);
		res[2] = new Point(518, 748);
		traitlineIconOffsets.put(InterfaceSize.Large, res);
		
		res = new Point[6];
		res[0] = new Point(-82, -46);
		res[1] = new Point(-82, 10);
		res[2] = new Point(-82, 67);
		res[3] = new Point(-25, -46);
		res[4] = new Point(-25, 10);
		res[5] = new Point(-25, 67);
		traitlineOffsets.put(InterfaceSize.Large, res);
		
		res = new Point[6];
		res[0] = new Point(-139, -46);
		res[1] = new Point(-139, 10);
		res[2] = new Point(-139, 67);
		res[3] = new Point(-195, -46);
		res[4] = new Point(-195, 10);
		res[5] = new Point(-195, 67);
		secondaryTraitlineOffsets.put(InterfaceSize.Large, res);
		
		res = new Point[9];
		res[0] = new Point(191, -48);
		res[1] = new Point(191, 0);
		res[2] = new Point(191, 48);
		res[3] = new Point(351, -48);
		res[4] = new Point(351, 0);
		res[5] = new Point(351, 48);
		res[6] = new Point(510, -48);
		res[7] = new Point(510, 0);
		res[8] = new Point(510, 48);
		traitOffsets.put(InterfaceSize.Large, res);
	}

	private static void initLarger() {
		Point[] res = new Point[5];
		res[0] = new Point(-25, 48);
		res[1] = new Point(50, 48);
		res[2] = new Point(115, 48);
		res[3] = new Point(180, 48);
		res[4] = new Point(245, 48);
		skillBarOffsets.put(InterfaceSize.Larger, res);
		
		res = new Point[24];
		res[0] = new Point(-95, -84);
		res[1] = new Point(-35, -84);
		res[2] = new Point(35, -84);
		res[3] = new Point(95, -84);
		res[4] = new Point(-95, -140);
		res[5] = new Point(-35, -140);
		res[6] = new Point(35, -140);
		res[7] = new Point(95, -140);
		res[8] = new Point(-95, -205);
		res[9] = new Point(-35, -205);
		res[10] = new Point(35, -205);
		res[11] = new Point(95, -205);
		res[12] = new Point(-95, -265);
		res[13] = new Point(-35, -265);
		res[14] = new Point(35, -265);
		res[15] = new Point(95, -265);
		res[16] = new Point(-95, -325);
		res[17] = new Point(-35, -325);
		res[18] = new Point(35, -325);
		res[19] = new Point(95, -325);
		res[20] = new Point(-95, -385);
		res[21] = new Point(-35, -385);
		res[22] = new Point(35, -385);
		res[23] = new Point(95, -385);
		skillOffsets.put(InterfaceSize.Larger, res);
		
		Point buildTab = new Point(53, 194);
		buildTabOffset.put(InterfaceSize.Larger, buildTab);
		
		res = new Point[3];
		res[0] = new Point(572, 495);
		res[1] = new Point(572, 660);
		res[2] = new Point(572, 825);
		traitlineIconOffsets.put(InterfaceSize.Larger, res);
		
		res = new Point[6];
		res[0] = new Point(-92, -55);
		res[1] = new Point(-92, 10);
		res[2] = new Point(-92, 70);
		res[3] = new Point(-30, -55);
		res[4] = new Point(-30, 10);
		res[5] = new Point(-30, 70);
		traitlineOffsets.put(InterfaceSize.Larger, res);
		
		res = new Point[6];
		res[0] = new Point(-155, -55);
		res[1] = new Point(-155, 10);
		res[2] = new Point(-155, 70);
		res[3] = new Point(-218, -55);
		res[4] = new Point(-218, 10);
		res[5] = new Point(-218, 70);
		secondaryTraitlineOffsets.put(InterfaceSize.Larger, res);
		
		res = new Point[9];
		res[0] = new Point(210, -53);
		res[1] = new Point(210, 0);
		res[2] = new Point(210, 53);
		res[3] = new Point(390, -53);
		res[4] = new Point(390, 0);
		res[5] = new Point(390, 53);
		res[6] = new Point(565, -53);
		res[7] = new Point(565, 0);
		res[8] = new Point(565, 53);
		traitOffsets.put(InterfaceSize.Larger, res);
	}

}
