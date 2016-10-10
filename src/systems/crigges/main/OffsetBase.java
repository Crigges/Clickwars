package systems.crigges.main;

import java.awt.Point;
import java.util.HashMap;

public class OffsetBase {
	private static HashMap<InterfaceSize, Point[]> skillBarOffsets = new HashMap<>();
	private static HashMap<InterfaceSize, Point[]> skillOffsets = new HashMap<>();
	private static final boolean init = init();
	
	
	public static Point getSkillBarOffset(InterfaceSize size, int slot){
		return skillBarOffsets.get(size)[slot - 1];
	}
	
	public static Point getSkillOffset(InterfaceSize size, int slot){
		return skillOffsets.get(size)[slot - 1];
	}


	private static boolean init() {
		initLarger();
		return false;
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
	}

}
