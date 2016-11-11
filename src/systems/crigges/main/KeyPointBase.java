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
		loadSmallInterface();
		loadNormalInterface();
		loadLargerInterface();
		return false;
	}
	
	private static void loadSmallInterface() {
		ArrayList<KeyPoint> barPoints = new ArrayList<>();
		skillBarPoints.put(InterfaceSize.Small, barPoints);
		
		barPoints.add(new KeyPoint(0, 0, 214, 186, 148));
		barPoints.add(new KeyPoint(198, 0, 214, 186, 148));
		barPoints.add(new KeyPoint(198, 4, 0, 0, 0));
		barPoints.add(new KeyPoint(99, 0, 214, 186, 148));
		barPoints.add(new KeyPoint(99, 4, 0, 0, 0));
		barPoints.add(new KeyPoint(49, 0, 214, 186, 148));
		barPoints.add(new KeyPoint(-127, -12, 214, 140, 8));
		
		
		ArrayList<KeyPoint> heroPoints = new ArrayList<>();
		heroPanelPoints.put(InterfaceSize.Small, heroPoints);
		
		heroPoints.add(new KeyPoint(0, 0, 239, 231, 222));
		heroPoints.add(new KeyPoint(9, 9, 247, 247, 247));
		heroPoints.add(new KeyPoint(26, 7, 213, 207, 190));
		heroPoints.add(new KeyPoint(9, 25, 192, 180, 160));
		heroPoints.add(new KeyPoint(28, 45, 210, 201, 187));
		heroPoints.add(new KeyPoint(21, 55, 1, 1, 0));
	}
	
	private static void loadNormalInterface() {
		ArrayList<KeyPoint> barPoints = new ArrayList<>();
		skillBarPoints.put(InterfaceSize.Normal, barPoints);
		
		barPoints.add(new KeyPoint(0, 0, 211, 183, 145));
		barPoints.add(new KeyPoint(220, 0, 211, 183, 145));
		barPoints.add(new KeyPoint(220, 5, 1, 1, 1));
		barPoints.add(new KeyPoint(110, 0, 211, 183, 145));
		barPoints.add(new KeyPoint(110, 5, 1, 1, 1));
		barPoints.add(new KeyPoint(165, 0, 211, 183, 145));
		barPoints.add(new KeyPoint(-141, -13, 214, 142, 8));
		
		
		ArrayList<KeyPoint> heroPoints = new ArrayList<>();
		heroPanelPoints.put(InterfaceSize.Normal, heroPoints);
		
		heroPoints.add(new KeyPoint(0, 0, 239, 231, 222));
		heroPoints.add(new KeyPoint(9, 9, 247, 247, 239));
		heroPoints.add(new KeyPoint(29, 9, 222, 215, 198));
		heroPoints.add(new KeyPoint(11, 28, 239, 223, 198));
		heroPoints.add(new KeyPoint(25, 64, 0, 0, 0));
		heroPoints.add(new KeyPoint(36, 48, 198, 195, 189));
	}
	


	private static void loadLargerInterface() {
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
