package systems.crigges.main;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ResourceFactory {
	private static final HashMap<Profession, URL[]> healSkills = new HashMap<>();
	private static final HashMap<Profession, URL[]> utilSkills = new HashMap<>();
	private static final HashMap<Profession, URL[]> eliteSkills = new HashMap<>();
	private static final HashMap<Profession, URL[]> traitlines = new HashMap<>();
	
	private static final boolean init = init();
	
	// static init
	private static boolean init() {
		initChrono();
		return false;
	}
	
	public static int getSkillCount(Profession prof, int slot){
		if(slot == 0){
			return healSkills.get(prof).length;
		}else if(slot == 4){
			return eliteSkills.get(prof).length;
		}else{
			return utilSkills.get(prof).length;
		}
	}

	public static Skill getSkill(Profession prof, int index, int slot) {
		URL res;
		if(slot == 0){
			res = healSkills.get(prof)[index];
		}else if(slot == 4){
			res = eliteSkills.get(prof)[index];
		}else{
			res = utilSkills.get(prof)[index];
		}
		return new Skill(res, index);
	}
	
	public static int getTraitlineCount(Profession prof, int slot) {
		System.out.println(slot);
		if(slot == 2){
			return 6;
		}else{
			return 5;
		}
	}
	
	public static Traitline getTraitline(Profession prof, int index, int slot) {
		URL res;
		res = traitlines.get(prof)[index];
		return new Traitline(res, index);
	}
	
	public static Trait getClearTrait(){
		return new Trait(getResource("/other/notrait.png"), -1);
	}
	
	private static void initChrono() {
		URL[] chronoHeals = new URL[5];
		chronoHeals[0] = getResource("/chrono/Ether_Feast.png");
		chronoHeals[1] = getResource("/chrono/Mirror.png");
		chronoHeals[2] = getResource("/chrono/Mantra_of_Recovery.png");
		chronoHeals[3] = getResource("/chrono/Signet_of_the_Ether.png");
		chronoHeals[4] = getResource("/chrono/Well_of_Eternity.png");
		healSkills.put(Profession.Chronomancer, chronoHeals);
		
		URL[] chronoUtils  = new URL[24];
		chronoUtils[0] = getResource("/chrono/Signet_of_Inspiration.png");
		chronoUtils[1] = getResource("/chrono/Signet_of_Domination.png");
		chronoUtils[2] = getResource("/chrono/Signet_of_Midnight.png");
		chronoUtils[3] = getResource("/chrono/Signet_of_Illusions.png");
		
		chronoUtils[4] = getResource("/chrono/Mantra_of_Pain.png");
		chronoUtils[5] = getResource("/chrono/Mantra_of_Distraction.png");
		chronoUtils[6] = getResource("/chrono/Mantra_of_Resolve.png");
		chronoUtils[7] = getResource("/chrono/Mantra_of_Concentration.png");	
		
		chronoUtils[8] = getResource("/chrono/Blink.png");
		chronoUtils[9] = getResource("/chrono/Arcane_Thievery.png");
		chronoUtils[10] = getResource("/chrono/Illusion_of_Life.png");
		chronoUtils[11] = getResource("/chrono/Mimic.png");
		
		chronoUtils[12] = getResource("/chrono/Decoy.png");
		chronoUtils[13] = getResource("/chrono/Mirror_Images.png");
		chronoUtils[14] = getResource("/chrono/Phantasmal_Defender.png");
		chronoUtils[15] = getResource("/chrono/Phantasmal_Disenchanter.png");
		
		chronoUtils[16] = getResource("/chrono/Null_Field.png");
		chronoUtils[17] = getResource("/chrono/Feedback.png");
		chronoUtils[18] = getResource("/chrono/Portal_Entre.png");
		chronoUtils[19] = getResource("/chrono/Veil.png");
		
		chronoUtils[20] = getResource("/chrono/Well_of_Precognition.png");
		chronoUtils[21] = getResource("/chrono/Well_of_Calamity.png");
		chronoUtils[22] = getResource("/chrono/Well_of_Recall.png");
		chronoUtils[23] = getResource("/chrono/Well_of_Action.png");
		
		
		
		utilSkills.put(Profession.Chronomancer, chronoUtils);

		
		URL[] chronoElite = new URL[4];	
		chronoElite[0] = getResource("/chrono/Signet_of_Humility.png");
		chronoElite[1] = getResource("/chrono/Time_Warp.png");
		chronoElite[2] = getResource("/chrono/Mass_Invisibility.png");
		chronoElite[3] = getResource("/chrono/Gravity_Well.png");
		eliteSkills.put(Profession.Chronomancer, chronoElite);

		URL[] chronoTraitlines = new URL[6];
		chronoTraitlines[0] = getResource("/chrono/domination.png");
		chronoTraitlines[1] = getResource("/chrono/dueling.png");
		chronoTraitlines[2] = getResource("/chrono/chaos.png");
		chronoTraitlines[3] = getResource("/chrono/inspiration.png");
		chronoTraitlines[4] = getResource("/chrono/illusions.png");
		chronoTraitlines[5] = getResource("/chrono/chrono.png");
		traitlines.put(Profession.Chronomancer, chronoTraitlines);
		
	}
	
	public static URL getResource(String path){
		return ResourceFactory.class.getResource(path);
	}

}
