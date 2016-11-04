package systems.crigges.main;

import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

public class KeyPointBase {
	
	private static HashMap<InterfaceSize, ArrayList<KeyPoint>> skillBarPoints = new HashMap<>();
	private static HashMap<InterfaceSize, ArrayList<KeyPoint>> heroPanelPoints = new HashMap<>();
	private static boolean init = init();
	
	
	public static ArrayList<KeyPoint> getSkillBar(InterfaceSize size){
		return skillBarPoints.get(size);
	}
	
	public static ArrayList<KeyPoint> getHeroPanel(InterfaceSize size){
		return heroPanelPoints.get(size);
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
		
		
		ArrayList<KeyPoint> heroPoints = new ArrayList<>();
		heroPanelPoints.put(InterfaceSize.Larger, heroPoints);
		
		heroPoints.add(new KeyPoint(0, 0, 239, 231, 222));
		heroPoints.add(new KeyPoint(9, 9, 247, 247, 239));
		heroPoints.add(new KeyPoint(35, 11, 218, 211, 194));
		heroPoints.add(new KeyPoint(13, 34, 223, 208, 185));
		heroPoints.add(new KeyPoint(31, 78, 0, 0, 0));
		heroPoints.add(new KeyPoint(87, 87, 206, 199, 181));
	}
	
	
	
	

}
