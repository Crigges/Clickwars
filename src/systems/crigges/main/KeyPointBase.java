package systems.crigges.main;

import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

public class KeyPointBase {
	
	private static HashMap<InterfaceSize, ArrayList<KeyPoint>> skillBarPoints = new HashMap<>();
	private static boolean init = init();
	
	
	public static ArrayList<KeyPoint> getSkillBar(InterfaceSize size){
		return skillBarPoints.get(size);
	}


	private static boolean init() {
		initLargerInterface();
		return false;
	}


	private static void initLargerInterface() {
		ArrayList<KeyPoint> barPoints = new ArrayList<>();
		skillBarPoints.put(InterfaceSize.Larger, barPoints);
		
		barPoints.add(new KeyPoint(0, 0, 210, 182, 144));
		barPoints.add(new KeyPoint(269, 0, 208, 181, 143));
		barPoints.add(new KeyPoint(68, 0, 211, 182, 145));
		barPoints.add(new KeyPoint(202, 0, 211, 182, 145));
		barPoints.add(new KeyPoint(135, 0, 210, 182, 144));
		barPoints.add(new KeyPoint(135, 8, 7, 4, 2));
	}
	
	
	
	

}
