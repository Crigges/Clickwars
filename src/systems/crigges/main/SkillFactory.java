package systems.crigges.main;

import java.util.ArrayList;
import java.util.HashMap;

public class SkillFactory {
	private static HashMap<Profession, Integer> skillCountHeal = new HashMap<>();
	private static HashMap<Profession, Integer> skillCountUtil = new HashMap<>();
	private static HashMap<Profession, Integer> skillCountElite = new HashMap<>();
	private static boolean init = init();
	
	// static init
	private static boolean init() {
		initChrono();
		return false;
	}
	
	public static int getSkillCount(Profession prof, int slot){
		if(slot == 1){
			return skillCountHeal.get(prof);
		}else if(slot == 5){
			return skillCountElite.get(prof);
		}else{
			return skillCountUtil.get(prof);
		}
	}

	private static void initChrono() {
		skillCountHeal.put(Profession.Chronomancer, 5);
		skillCountUtil.put(Profession.Chronomancer, 24);
		skillCountElite.put(Profession.Chronomancer, 4);
	}
	
	
}
