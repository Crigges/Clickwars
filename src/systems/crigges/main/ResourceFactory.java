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
		initTempest();
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
	
	public static Trait getClearTrait(int pos){
		return new Trait(getResource("/other/notrait.png"), pos);
	}
	
	public static Trait getSelectedTrait(int pos){
		return new Trait(getResource("/other/selectedtraitsmall.png"), pos);
	}
	
	private static void initChrono() {
		URL[] heals = new URL[5];
		heals[0] = getResource("/chrono/Ether_Feast.png");
		heals[1] = getResource("/chrono/Mirror.png");
		heals[2] = getResource("/chrono/Mantra_of_Recovery.png");
		heals[3] = getResource("/chrono/Signet_of_the_Ether.png");
		heals[4] = getResource("/chrono/Well_of_Eternity.png");
		healSkills.put(Profession.Chronomancer, heals);
		
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
	
	private static void initTempest() {
		URL[] heals = new URL[5];
		heals[0] = getResource("/tempest/Glyph_of_Elemental_Harmony.png");
		heals[1] = getResource("/tempest/Ether_Renewal.png");
		heals[2] = getResource("/tempest/Signet_of_Restoration.png");
		heals[3] = getResource("/tempest/Arcane_Brilliance.png");
		heals[4] = getResource("/tempest/'Wash_the_Pain_Away!'.png");
		healSkills.put(Profession.Tempest, heals);
		
		URL[] utils  = new URL[24];
		utils[0] = getResource("/tempest/Arcane_Wave.png");
		utils[1] = getResource("/tempest/Arcane_Shield.png");
		utils[2] = getResource("/tempest/Arcane_Power.png");
		utils[3] = getResource("/tempest/Arcane_Blast.png");
		
		utils[4] = getResource("/tempest/Glyph_of_Elemental_Power.png");
		utils[5] = getResource("/tempest/Glyph_of_Storms.png");
		utils[6] = getResource("/tempest/Glyph_of_Lesser_Elementals.png");
		utils[7] = getResource("/tempest/Glyph_of_Renewal.png");
		
		utils[8] = getResource("/tempest/Signet_of_Fire.png");
		utils[9] = getResource("/tempest/Signet_of_Water.png");
		utils[10] = getResource("/tempest/Signet_of_Air.png");
		utils[11] = getResource("/tempest/Signet_of_Earth.png");
		
		utils[12] = getResource("/tempest/Cleansing_Fire.png");
		utils[13] = getResource("/tempest/Mist_Form.png");
		utils[14] = getResource("/tempest/Lightning_Flash.png");
		utils[15] = getResource("/tempest/Armor_of_Earth.png");
		
		utils[16] = getResource("/tempest/Conjure_Flame_Axe.png");
		utils[17] = getResource("/tempest/Conjure_Frost_Bow.png");
		utils[18] = getResource("/tempest/Conjure_Lightning_Hammer.png");
		utils[19] = getResource("/tempest/Conjure_Earth_Shield.png");
		
		utils[20] = getResource("/tempest/'Feel_the_Burn!'.png");
		utils[21] = getResource("/tempest/'Flash-Freeze!'.png");
		utils[22] = getResource("/tempest/'Eye_of_the_Storm!'.png");
		utils[23] = getResource("/tempest/'Aftershock!'.png");
		
		
		
		utilSkills.put(Profession.Tempest, utils);

		
		URL[] elite = new URL[4];	
		elite[0] = getResource("/tempest/Glyph_of_Elementals.png");
		elite[1] = getResource("/tempest/Conjure_Fiery_Greatsword.png");
		elite[2] = getResource("/tempest/Tornado.png");
		elite[3] = getResource("/tempest/'Rebound!'.png");
		eliteSkills.put(Profession.Tempest, elite);

		URL[] tempestTraitlines = new URL[6];
		tempestTraitlines[0] = getResource("/tempest/fire.png");
		tempestTraitlines[1] = getResource("/tempest/air.png");
		tempestTraitlines[2] = getResource("/tempest/earth.png");
		tempestTraitlines[3] = getResource("/tempest/water.png");
		tempestTraitlines[4] = getResource("/tempest/arcane.png");
		tempestTraitlines[5] = getResource("/tempest/tempest.png");
		traitlines.put(Profession.Tempest, tempestTraitlines);
		
	}
	
	private static void initBerserker() {
		URL[] heals = new URL[5];
		heals[0] = getResource("/tempest/Glyph_of_Elemental_Harmony.png");
		heals[1] = getResource("/tempest/Ether_Renewal.png");
		heals[2] = getResource("/tempest/Signet_of_Restoration.png");
		heals[3] = getResource("/tempest/Arcane_Brilliance.png");
		heals[4] = getResource("/tempest/'Wash_the_Pain_Away!'.png");
		healSkills.put(Profession.Tempest, heals);
		
		URL[] utils  = new URL[24];
		utils[0] = getResource("/tempest/Arcane_Wave.png");
		utils[1] = getResource("/tempest/Arcane_Shield.png");
		utils[2] = getResource("/tempest/Arcane_Power.png");
		utils[3] = getResource("/tempest/Arcane_Blast.png");
		
		utils[4] = getResource("/tempest/Glyph_of_Elemental_Power.png");
		utils[5] = getResource("/tempest/Glyph_of_Storms.png");
		utils[6] = getResource("/tempest/Glyph_of_Lesser_Elementals.png");
		utils[7] = getResource("/tempest/Glyph_of_Renewal.png");
		
		utils[8] = getResource("/tempest/Signet_of_Fire.png");
		utils[9] = getResource("/tempest/Signet_of_Water.png");
		utils[10] = getResource("/tempest/Signet_of_Air.png");
		utils[11] = getResource("/tempest/Signet_of_Earth.png");
		
		utils[12] = getResource("/tempest/Cleansing_Fire.png");
		utils[13] = getResource("/tempest/Mist_Form.png");
		utils[14] = getResource("/tempest/Lightning_Flash.png");
		utils[15] = getResource("/tempest/Armor_of_Earth.png");
		
		utils[16] = getResource("/tempest/Conjure_Flame_Axe.png");
		utils[17] = getResource("/tempest/Conjure_Frost_Bow.png");
		utils[18] = getResource("/tempest/Conjure_Lightning_Hammer.png");
		utils[19] = getResource("/tempest/Conjure_Earth_Shield.png");
		
		utils[20] = getResource("/tempest/'Feel_the_Burn!'.png");
		utils[21] = getResource("/tempest/'Flash-Freeze!'.png");
		utils[22] = getResource("/tempest/'Eye_of_the_Storm!'.png");
		utils[23] = getResource("/tempest/'Aftershock!'.png");
		
		
		
		utilSkills.put(Profession.Tempest, utils);

		
		URL[] elite = new URL[4];	
		elite[0] = getResource("/tempest/Glyph_of_Elementals.png");
		elite[1] = getResource("/tempest/Conjure_Fiery_Greatsword.png");
		elite[2] = getResource("/tempest/Tornado.png");
		elite[3] = getResource("/tempest/'Rebound!'.png");
		eliteSkills.put(Profession.Tempest, elite);

		URL[] tempestTraitlines = new URL[6];
		tempestTraitlines[0] = getResource("/tempest/fire.png");
		tempestTraitlines[1] = getResource("/tempest/air.png");
		tempestTraitlines[2] = getResource("/tempest/earth.png");
		tempestTraitlines[3] = getResource("/tempest/water.png");
		tempestTraitlines[4] = getResource("/tempest/arcane.png");
		tempestTraitlines[5] = getResource("/tempest/tempest.png");
		traitlines.put(Profession.Tempest, tempestTraitlines);
		
	}
	
	
	public static URL getResource(String path){
		return ResourceFactory.class.getResource(path);
	}

}
