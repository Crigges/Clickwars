package systems.crigges.main;

import java.util.ArrayList;

public class Profile {
	private int hotkeyCode;
	private int hotkeyMod;
	private InterfaceSize interfaceSize;
	private Profession prof = Profession.Chronomancer;
	private int[] skillPos;
	private int[] traitlinePos;
	private int[] traitPos;
	private String name = "?";
	private String hotkeyName = "?";

	public Profile(int hotkeyCode, int hotkeyMod, InterfaceSize interfaceSize, Profession prof,
			ArrayList<Integer> skillPos, ArrayList<Integer> traitlinePos, ArrayList<Integer> traitPos) {
		this();
		this.hotkeyCode = hotkeyCode;
		this.hotkeyMod = hotkeyMod;
		this.interfaceSize = interfaceSize;
		this.prof = prof;
	}
	
	public Profile() {	
		skillPos = new int[5];
		initArray(skillPos);
		traitlinePos = new int[3];
		initArray(traitlinePos);
		traitPos = new int[9];
		initArray(traitPos);
	}

	public int getHotkeyCode() {
		return hotkeyCode;
	}

	public int getHotkeyMod() {
		return hotkeyMod;
	}

	public InterfaceSize getInterfaceSize() {
		return interfaceSize;
	}

	public Profession getProf() {
		return prof;
	}

	public int getSkillPos(int slot) {
		return skillPos[slot];
	}

	public int getTraitlinePos(int slot) {
		return traitlinePos[slot];
	}

	public int getTraitPos(int slot) {
		return traitPos[slot];
	}

	public void setHotkeyCode(int hotkeyCode) {
		this.hotkeyCode = hotkeyCode;
	}

	public void setHotkeyMod(int hotkeyMod) {
		this.hotkeyMod = hotkeyMod;
	}

	public void setInterfaceSize(InterfaceSize interfaceSize) {
		this.interfaceSize = interfaceSize;
	}

	public void setProf(Profession prof) {
		this.prof = prof;
	}

	public void setSkillPos(int slot, int value) {
		skillPos[slot] = value;
	}

	public void setTraitlinePos(int slot, int value) {
		traitlinePos[slot] = value;
	}

	public void setTraitPos(int slot, int value) {
		traitPos[slot] = value;
	}
	
	public Object[] getModelEntry(){
		Object[] o = new Object[3];
		o[0] = name;
		o[1] = prof;
		o[2] = hotkeyName;
		return o;
	}

	public static ArrayList<Profile> get() {
		return new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHotkeyName() {
		return hotkeyName;
	}

	public void setHotkeyName(String hotkeyName) {
		this.hotkeyName = hotkeyName;
	}

	public int[] getAllSkillPos() {
		return skillPos;
	}
	
	public int[] getAllTraitlinePos() {
		return traitlinePos;
	}

	public int[] getAllTraitPos() {
		return traitPos;
	}


	private void initArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
	}

}
