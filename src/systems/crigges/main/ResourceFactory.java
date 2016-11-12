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
		initBerserker();
		initDaredevil();
		initDruid();
		initHerald();
		initDragonhunter();
		initReaper();
		initScrapper();
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
		heals[0] = getResource("/berserker/'To_the_Limit!'.png");
		heals[1] = getResource("/berserker/Mending.png");
		heals[2] = getResource("/berserker/Healing_Signet.png");
		heals[3] = getResource("/berserker/Defiant_Stance.png");
		heals[4] = getResource("/berserker/Blood_Reckoning.png");
		healSkills.put(Profession.Berserker, heals);
		
		URL[] utils  = new URL[24];
		utils[0] = getResource("/berserker/Kick_(warrior_utility_skill).png");
		utils[1] = getResource("/berserker/Throw_Bolas.png");
		utils[2] = getResource("/berserker/Bull's_Charge.png");
		utils[3] = getResource("/berserker/Stomp.png");
		
		utils[4] = getResource("/berserker/Signet_of_Might.png");
		utils[5] = getResource("/berserker/Signet_of_Fury.png");
		utils[6] = getResource("/berserker/Signet_of_Stamina.png");
		utils[7] = getResource("/berserker/Dolyak_Signet.png");
		
		utils[8] = getResource("/berserker/'For_Great_Justice!'.png");
		utils[9] = getResource("/berserker/'Shake_It_Off!'.png");
		utils[10] = getResource("/berserker/'On_My_Mark!'.png");
		utils[11] = getResource("/berserker/'Fear_Me!'.png");
		
		utils[12] = getResource("/berserker/Banner_of_Defense.png");
		utils[13] = getResource("/berserker/Banner_of_Strength.png");
		utils[14] = getResource("/berserker/Banner_of_Discipline.png");
		utils[15] = getResource("/berserker/Banner_of_Tactics.png");
		
		utils[16] = getResource("/berserker/Berserker_Stance.png");
		utils[17] = getResource("/berserker/Endure_Pain.png");
		utils[18] = getResource("/berserker/Balanced_Stance.png");
		utils[19] = getResource("/berserker/Frenzy_(warrior_skill).png");
		
		utils[20] = getResource("/berserker/Wild_Blow.png");
		utils[21] = getResource("/berserker/Shattering_Blow.png");
		utils[22] = getResource("/berserker/Sundering_Leap.png");
		utils[23] = getResource("/berserker/Outrage.png");
		utilSkills.put(Profession.Berserker, utils);

		URL[] elite = new URL[4];	
		elite[0] = getResource("/berserker/Battle_Standard.png");
		elite[1] = getResource("/berserker/Signet_of_Rage.png");
		elite[2] = getResource("/berserker/Rampage.png");
		elite[3] = getResource("/berserker/Head_Butt.png");
		eliteSkills.put(Profession.Berserker, elite);

		URL[] berserkerTraitlines = new URL[6];
		berserkerTraitlines[0] = getResource("/berserker/strength.png");
		berserkerTraitlines[1] = getResource("/berserker/arms.png");
		berserkerTraitlines[2] = getResource("/berserker/defense.png");
		berserkerTraitlines[3] = getResource("/berserker/tactics.png");
		berserkerTraitlines[4] = getResource("/berserker/diszipline.png");
		berserkerTraitlines[5] = getResource("/berserker/berserker.png");
		traitlines.put(Profession.Berserker, berserkerTraitlines);
		
	}
	
	private static void initDaredevil() {
		URL[] heals = new URL[5];
		heals[0] = getResource("/daredevil/Hide_in_Shadows.png");
		heals[1] = getResource("/daredevil/Withdraw.png");
		heals[2] = getResource("/daredevil/Skelk_Venom.png");
		heals[3] = getResource("/daredevil/Signet_of_Malice.png");
		heals[4] = getResource("/daredevil/Channeled_Vigor.png");
		healSkills.put(Profession.Daredevil, heals);
		
		URL[] utils  = new URL[24];
		utils[0] = getResource("/daredevil/Spider_Venom.png");
		utils[1] = getResource("/daredevil/Skale_Venom.png");
		utils[2] = getResource("/daredevil/Ice_Drake_Venom.png");
		utils[3] = getResource("/daredevil/Devourer_Venom.png");
		
		utils[4] = getResource("/daredevil/Tripwire.png");
		utils[5] = getResource("/daredevil/Needle_Trap.png");
		utils[6] = getResource("/daredevil/Shadow_Trap.png");
		utils[7] = getResource("/daredevil/Ambush.png");
		
		utils[8] = getResource("/daredevil/Assassin's_Signet.png");
		utils[9] = getResource("/daredevil/Infiltrator's_Signet.png");
		utils[10] = getResource("/daredevil/Signet_of_Agility.png");
		utils[11] = getResource("/daredevil/Signet_of_Shadows.png");
		
		utils[12] = getResource("/daredevil/Scorpion_Wire.png");
		utils[13] = getResource("/daredevil/Roll_for_Initiative.png");
		utils[14] = getResource("/daredevil/Haste.png");
		utils[15] = getResource("/daredevil/Caltrops.png");
		
		utils[16] = getResource("/daredevil/Shadowstep.png");
		utils[17] = getResource("/daredevil/Blinding_Powder.png");
		utils[18] = getResource("/daredevil/Smoke_Screen.png");
		utils[19] = getResource("/daredevil/Shadow_Refuge.png");
		
		utils[20] = getResource("/daredevil/Fist_Flurry.png");
		utils[21] = getResource("/daredevil/Distracting_Daggers.png");
		utils[22] = getResource("/daredevil/Bandit's_Defense.png");
		utils[23] = getResource("/daredevil/Impairing_Daggers.png");
		utilSkills.put(Profession.Daredevil, utils);

		URL[] elite = new URL[4];	
		elite[0] = getResource("/daredevil/Thieves_Guild.png");
		elite[1] = getResource("/daredevil/Basilisk_Venom.png");
		elite[2] = getResource("/daredevil/Dagger_Storm.png");
		elite[3] = getResource("/daredevil/Impact_Strike.png");
		eliteSkills.put(Profession.Daredevil, elite);

		URL[] daredevilTraitlines = new URL[6];
		daredevilTraitlines[0] = getResource("/daredevil/deadly arts.png");
		daredevilTraitlines[1] = getResource("/daredevil/critical strikes.png");
		daredevilTraitlines[2] = getResource("/daredevil/shadow arts.png");
		daredevilTraitlines[3] = getResource("/daredevil/acrobatics.png");
		daredevilTraitlines[4] = getResource("/daredevil/trickery.png");
		daredevilTraitlines[5] = getResource("/daredevil/daredevil.png");
		traitlines.put(Profession.Daredevil, daredevilTraitlines);
		
	}
	
	private static void initDruid() {
		URL[] heals = new URL[5];
		heals[0] = getResource("/druid/'We_Heal_As_One!'.png");
		heals[1] = getResource("/druid/Troll_Unguent.png");
		heals[2] = getResource("/druid/Healing_Spring.png");
		heals[3] = getResource("/druid/Water_Spirit.png");
		heals[4] = getResource("/druid/Glyph_of_Rejuvenation.png");
		healSkills.put(Profession.Druid, heals);
		
		URL[] utils  = new URL[24];
		utils[0] = getResource("/druid/Spike_Trap.png");
		utils[1] = getResource("/druid/Flame_Trap.png");
		utils[2] = getResource("/druid/Viper's_Nest.png");
		utils[3] = getResource("/druid/Frost_Trap.png");
		
		utils[4] = getResource("/druid/Signet_of_Renewal.png");
		utils[5] = getResource("/druid/Signet_of_the_Hunt.png");
		utils[6] = getResource("/druid/Signet_of_Stone.png");
		utils[7] = getResource("/druid/Signet_of_the_Wild.png");
		
		utils[8] = getResource("/druid/Sharpening_Stone.png");
		utils[9] = getResource("/druid/Lightning_Reflexes.png");
		utils[10] = getResource("/druid/Muddy_Terrain.png");
		utils[11] = getResource("/druid/Quickening_Zephyr.png");
		
		utils[12] = getResource("/druid/Sun_Spirit.png");
		utils[13] = getResource("/druid/Stone_Spirit.png");
		utils[14] = getResource("/daredevil/Haste.png");
		utils[15] = getResource("/druid/Storm_Spirit.png");
		
		utils[16] = getResource("/druid/'Sic_'Em!'.png");
		utils[17] = getResource("/druid/'Protect_Me!'.png");
		utils[18] = getResource("/druid/'Guard!'.png");
		utils[19] = getResource("/druid/'Search_and_Rescue!'.png");
		
		utils[20] = getResource("/druid/Glyph_of_Alignment.png");
		utils[21] = getResource("/druid/Glyph_of_Equality.png");
		utils[22] = getResource("/druid/Glyph_of_Empowerment.png");
		utils[23] = getResource("/druid/Glyph_of_the_Tides.png");
		utilSkills.put(Profession.Druid, utils);

		URL[] elite = new URL[4];	
		elite[0] = getResource("/druid/'Strength_of_the_Pack!'.png");
		elite[1] = getResource("/druid/Entangle.png");
		elite[2] = getResource("/druid/Spirit_of_Nature.png");
		elite[3] = getResource("/druid/Glyph_of_Unity.png");
		eliteSkills.put(Profession.Druid, elite);

		URL[] druidTraitlines = new URL[6];
		druidTraitlines[0] = getResource("/druid/marksmanship.png");
		druidTraitlines[1] = getResource("/druid/skirmishing.png");
		druidTraitlines[2] = getResource("/druid/wilderness survival.png");
		druidTraitlines[3] = getResource("/druid/nature magic.png");
		druidTraitlines[4] = getResource("/druid/beastmastery.png");
		druidTraitlines[5] = getResource("/druid/druid.png");
		traitlines.put(Profession.Druid, druidTraitlines);
		
	}
	
	private static void initHerald() {
		URL[] heals = new URL[0];
		healSkills.put(Profession.Herald, heals);
		
		URL[] utils  = new URL[0];
		utilSkills.put(Profession.Herald, utils);

		URL[] elite = new URL[0];	
		eliteSkills.put(Profession.Herald, elite);

		URL[] heraldTraitlines = new URL[6];
		heraldTraitlines[0] = getResource("/revenant/corruption.png");
		heraldTraitlines[1] = getResource("/revenant/retribution.png");
		heraldTraitlines[2] = getResource("/revenant/salvation.png");
		heraldTraitlines[3] = getResource("/revenant/invocation.png");
		heraldTraitlines[4] = getResource("/revenant/devastation.png");
		heraldTraitlines[5] = getResource("/revenant/herald.png");
		traitlines.put(Profession.Herald, heraldTraitlines);
		
	}
	
	private static void initDragonhunter() {
		URL[] heals = new URL[5];
		heals[0] = getResource("/guard/Shelter.png");
		heals[1] = getResource("/guard/Signet_of_Resolve.png");
		heals[2] = getResource("/guard/'Receive_the_Light!'.png");
		heals[3] = getResource("/guard/Litany_of_Wrath.png");
		heals[4] = getResource("/guard/Purification.png");
		healSkills.put(Profession.Dragonhunter, heals);
		
		URL[] utils  = new URL[24];
		utils[0] = getResource("/guard/Hammer_of_Wisdom.png");
		utils[1] = getResource("/guard/Sword_of_Justice.png");
		utils[2] = getResource("/guard/Bow_of_Truth.png");
		utils[3] = getResource("/guard/Shield_of_the_Avenger.png");
		
		utils[4] = getResource("/guard/Bane_Signet.png");
		utils[5] = getResource("/guard/Signet_of_Judgment.png");
		utils[6] = getResource("/guard/Signet_of_Wrath.png");
		utils[7] = getResource("/guard/Signet_of_Mercy.png");
		
		utils[8] = getResource("/guard/'Retreat!'.png");
		utils[9] = getResource("/guard/'Save_Yourselves!'.png");
		utils[10] = getResource("/guard/'Stand_Your_Ground!'.png");
		utils[11] = getResource("/guard/'Hold_the_Line!'.png");
		
		utils[12] = getResource("/guard/Wall_of_Reflection.png");
		utils[13] = getResource("/guard/Purging_Flames.png");
		utils[14] = getResource("/guard/Hallowed_Ground.png");
		utils[15] = getResource("/guard/Sanctuary.png");
		
		utils[16] = getResource("/guard/Smite_Condition.png");
		utils[17] = getResource("/guard/Contemplation_of_Purity.png");
		utils[18] = getResource("/guard/Judge's_Intervention.png");
		utils[19] = getResource("/guard/Merciful_Intervention.png");
		
		utils[20] = getResource("/guard/Test_of_Faith.png");
		utils[21] = getResource("/guard/Fragments_of_Faith.png");
		utils[22] = getResource("/guard/Procession_of_Blades.png");
		utils[23] = getResource("/guard/Light's_Judgment.png");
		utilSkills.put(Profession.Dragonhunter, utils);

		URL[] elite = new URL[4];	
		elite[0] = getResource("/guard/'Feel_My_Wrath!'.png");
		elite[1] = getResource("/guard/Renewed_Focus.png");
		elite[2] = getResource("/guard/Signet_of_Courage.png");
		elite[3] = getResource("/guard/Dragon's_Maw.png");
		eliteSkills.put(Profession.Dragonhunter, elite);

		URL[] guardTraitlines = new URL[6];
		guardTraitlines[0] = getResource("/guard/zeal.png");
		guardTraitlines[1] = getResource("/guard/radiance.png");
		guardTraitlines[2] = getResource("/guard/valor.png");
		guardTraitlines[3] = getResource("/guard/honor.png");
		guardTraitlines[4] = getResource("/guard/virtues.png");
		guardTraitlines[5] = getResource("/guard/dragonhunter.png");
		traitlines.put(Profession.Dragonhunter, guardTraitlines);
		
	}
	
	private static void initReaper() {
		URL[] heals = new URL[5];
		heals[0] = getResource("/reaper/Summon_Blood_Fiend.png");
		heals[1] = getResource("/reaper/Consume_Conditions.png");
		heals[2] = getResource("/reaper/Well_of_Blood.png");
		heals[3] = getResource("/reaper/Signet_of_Vampirism.png");
		heals[4] = getResource("/reaper/'Your_Soul_Is_Mine!'.png");
		healSkills.put(Profession.Reaper, heals);
		
		URL[] utils  = new URL[24];
		utils[0] = getResource("/reaper/Summon_Bone_Minions.png");
		utils[1] = getResource("/reaper/Summon_Bone_Fiend.png");
		utils[2] = getResource("/reaper/Summon_Shadow_Fiend.png");
		utils[3] = getResource("/reaper/Summon_Flesh_Wurm.png");
	
		utils[4] = getResource("/reaper/Well_of_Suffering.png");
		utils[5] = getResource("/reaper/Well_of_Corruption.png");
		utils[6] = getResource("/reaper/Well_of_Power.png");
		utils[7] = getResource("/reaper/Well_of_Darkness.png");
		
		utils[8] = getResource("/reaper/Signet_of_Spite.png");
		utils[9] = getResource("/reaper/Signet_of_the_Locust.png");
		utils[10] = getResource("/reaper/Plague_Signet.png");
		utils[11] = getResource("/reaper/Signet_of_Undeath.png");
		
		utils[12] = getResource("/reaper/Spectral_Armor.png");
		utils[13] = getResource("/reaper/Spectral_Grasp.png");
		utils[14] = getResource("/reaper/Spectral_Wall.png");
		utils[15] = getResource("/reaper/Spectral_Walk.png");
		
		utils[16] = getResource("/reaper/Corrosive_Poison_Cloud.png");
		utils[17] = getResource("/reaper/Epidemic.png");
		utils[18] = getResource("/reaper/Corrupt_Boon.png");
		utils[19] = getResource("/reaper/Blood_Is_Power.png");
		
		utils[20] = getResource("/reaper/'You_Are_All_Weaklings!'.png");
		utils[21] = getResource("/reaper/'Suffer!'.png");
		utils[22] = getResource("/reaper/'Nothing_Can_Save_You!'.png");
		utils[23] = getResource("/reaper/'Rise!'.png");
		utilSkills.put(Profession.Reaper, utils);

		URL[] elite = new URL[4];	
		elite[0] = getResource("/reaper/Plague.png");
		elite[1] = getResource("/reaper/Summon_Flesh_Golem.png");
		elite[2] = getResource("/reaper/Lich_Form.png");
		elite[3] = getResource("/reaper/'Rise!'.png");
		eliteSkills.put(Profession.Reaper, elite);

		URL[] reaperTraitlines = new URL[6];
		reaperTraitlines[0] = getResource("/reaper/spite.png");
		reaperTraitlines[1] = getResource("/reaper/curses.png");
		reaperTraitlines[2] = getResource("/reaper/death magic.png");
		reaperTraitlines[3] = getResource("/reaper/blood magic.png");
		reaperTraitlines[4] = getResource("/reaper/soul reaping.png");
		reaperTraitlines[5] = getResource("/reaper/reaper.png");
		traitlines.put(Profession.Reaper, reaperTraitlines);
		
	}
	
	private static void initScrapper() {
		URL[] heals = new URL[5];
		heals[0] = getResource("/scrapper/Elixir_H.png");
		heals[1] = getResource("/scrapper/Med_Kit.png");
		heals[2] = getResource("/scrapper/A.E.D..png");
		heals[3] = getResource("/scrapper/Healing_Turret.png");
		heals[4] = getResource("/scrapper/Medic_Gyro.png");
		healSkills.put(Profession.Scrapper, heals);
		
		URL[] utils  = new URL[24];
		utils[0] = getResource("/scrapper/Rifle_Turret.png");
		utils[1] = getResource("/scrapper/Flame_Turret.png");
		utils[2] = getResource("/scrapper/Net_Turret.png");
		utils[3] = getResource("/scrapper/Thumper_Turret.png");
	
		utils[4] = getResource("/scrapper/Rocket_Turret.png");
		utils[5] = getResource("/scrapper/Elixir_B.png");
		utils[6] = getResource("/scrapper/Elixir_U.png");
		utils[7] = getResource("/scrapper/Elixir_S.png");
		
		utils[8] = getResource("/scrapper/Elixir_C.png");
		utils[9] = getResource("/scrapper/Elixir_R.png");
		utils[10] = getResource("/scrapper/Grenade_Kit.png");
		utils[11] = getResource("/scrapper/Bomb_Kit.png");
		
		utils[12] = getResource("/scrapper/Flamethrower.png");
		utils[13] = getResource("/scrapper/Elixir_Gun.png");
		utils[14] = getResource("/scrapper/Tool_Kit.png");
		utils[15] = getResource("/scrapper/Throw_Mine.png");
		
		utils[16] = getResource("/scrapper/Utility_Goggles.png");
		utils[17] = getResource("/scrapper/Rocket_Boots.png");
		utils[18] = getResource("/scrapper/Personal_Battering_Ram.png");
		utils[19] = getResource("/scrapper/Slick_Shoes.png");
		
		utils[20] = getResource("/scrapper/Bulwark_Gyro.png");
		utils[21] = getResource("/scrapper/Purge_Gyro.png");
		utils[22] = getResource("/scrapper/Blast_Gyro_Tag.png");
		utils[23] = getResource("/scrapper/Shredder_Gyro.png");
		utilSkills.put(Profession.Scrapper, utils);

		URL[] elite = new URL[4];	
		elite[0] = getResource("/scrapper/Supply_Crate.png");
		elite[1] = getResource("/scrapper/Elixir_X.png");
		elite[2] = getResource("/scrapper/Elite_Mortar_Kit.png");
		elite[3] = getResource("/scrapper/Sneak_Gyro.png");
		eliteSkills.put(Profession.Scrapper, elite);

		URL[] scrapperTraitlines = new URL[6];
		scrapperTraitlines[0] = getResource("/scrapper/explosives.png");
		scrapperTraitlines[1] = getResource("/scrapper/firearms.png");
		scrapperTraitlines[2] = getResource("/scrapper/inventions.png");
		scrapperTraitlines[3] = getResource("/scrapper/alchemy.png");
		scrapperTraitlines[4] = getResource("/scrapper/tools.png");
		scrapperTraitlines[5] = getResource("/scrapper/scrapper.png");
		traitlines.put(Profession.Scrapper, scrapperTraitlines);
		
	}

	
	public static URL getResource(String path){
		return ResourceFactory.class.getResource(path);
	}

}
