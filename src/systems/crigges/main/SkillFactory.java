package systems.crigges.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Icon;

public class SkillFactory {
	private static final HashMap<Profession, URL[]> healSkills = new HashMap<>();
	private static final HashMap<Profession, URL[]> utilSkills = new HashMap<>();
	private static final HashMap<Profession, URL[]> eliteSkills = new HashMap<>();
	
	private static final boolean init = init();
	
	// static init
	private static boolean init() {
		initChrono();
		return false;
	}
	
	public static int getSkillCount(Profession prof, int slot){
		if(slot == 1){
			return healSkills.get(prof).length;
		}else if(slot == 5){
			return eliteSkills.get(prof).length;
		}else{
			return utilSkills.get(prof).length;
		}
	}

	public static Skill getSkill(Profession prof, int index, int slot) {
		URL res;
		if(slot == 1){
			res = healSkills.get(prof)[index];
		}else if(slot == 5){
			res = eliteSkills.get(prof)[index];
		}else{
			res = utilSkills.get(prof)[index];
		}
		System.out.println(index);
		return new Skill(res, index);
	}
	
	private static void initChrono() {
//		skillCountHeal.put(Profession.Chronomancer, 5);
//		skillCountUtil.put(Profession.Chronomancer, 24);
//		skillCountElite.put(Profession.Chronomancer, 4);
		
		URL[] chronoHeals = new URL[5];
		chronoHeals[0] = getResource("/chrono/Signet_of_the_Ether.png");
		chronoHeals[1] = getResource("/chrono/Mantra_of_Recovery.png");
		chronoHeals[2] = getResource("/chrono/Mirror.png");
		chronoHeals[3] = getResource("/chrono/Ether_Feast.png");
		chronoHeals[4] = getResource("/chrono/Well_of_Eternity.png");
		healSkills.put(Profession.Chronomancer, chronoHeals);
		
		URL[] chronoUtils = new URL[24];
		chronoUtils[0] = getResource("/chrono/Signet_of_Illusions.png");
		chronoUtils[1] = getResource("/chrono/Signet_of_Midnight.png");
		chronoUtils[2] = getResource("/chrono/Signet_of_Domination.png");
		chronoUtils[3] = getResource("/chrono/Signet_of_Inspiration.png");
		chronoUtils[4] = getResource("/chrono/Mantra_of_Concentration.png");	
		chronoUtils[5] = getResource("/chrono/Mantra_of_Resolve.png");
		chronoUtils[6] = getResource("/chrono/Mantra_of_Distraction.png");
		chronoUtils[7] = getResource("/chrono/Mantra_of_Pain.png");
		chronoUtils[8] = getResource("/chrono/Mimic.png");
		chronoUtils[9] = getResource("/chrono/Illusion_of_Life.png");
		chronoUtils[10] = getResource("/chrono/Arcane_Thievery.png");
		chronoUtils[11] = getResource("/chrono/Blink.png");
		chronoUtils[12] = getResource("/chrono/Phantasmal_Disenchanter.png");
		chronoUtils[13] = getResource("/chrono/Phantasmal_Defender.png");
		chronoUtils[14] = getResource("/chrono/Mirror_Images.png");
		chronoUtils[15] = getResource("/chrono/Decoy.png");
		chronoUtils[16] = getResource("/chrono/Veil.png");
		chronoUtils[17] = getResource("/chrono/Portal_Entre.png");
		chronoUtils[18] = getResource("/chrono/Feedback.png");
		chronoUtils[19] = getResource("/chrono/Null_Field.png");
		chronoUtils[20] = getResource("/chrono/Well_of_Action.png");
		chronoUtils[21] = getResource("/chrono/Well_of_Recall.png");
		chronoUtils[22] = getResource("/chrono/Well_of_Calamity.png");
		chronoUtils[23] = getResource("/chrono/Well_of_Precognition.png");
		utilSkills.put(Profession.Chronomancer, chronoUtils);

		
		URL[] chronoElite = new URL[4];
		chronoElite[0] = getResource("/chrono/Gravity_Well.png");
		chronoElite[1] = getResource("/chrono/Mass_Invisibility.png");
		chronoElite[2] = getResource("/chrono/Signet_of_Humility.png");
		chronoElite[3] = getResource("/chrono/Time_Warp.png");
		eliteSkills.put(Profession.Chronomancer, chronoElite);


		
	}
	
	private static URL getResource(String path){
		return SkillFactory.class.getResource(path);
	}

	
	
}
