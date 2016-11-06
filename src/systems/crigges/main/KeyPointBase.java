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
		loadNormalInterface();
		loadLargerInterface();
		return false;
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
