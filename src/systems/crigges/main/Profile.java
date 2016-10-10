package systems.crigges.main;

import java.util.ArrayList;

public class Profile {
	private int hotkeyCode;
	private int hotkeyMod;
	private InterfaceSize interfaceSize;
	private Profession prof;
	private ArrayList<Integer> skillPos;
	private ArrayList<Integer> traitlinePos;
	private ArrayList<Integer> traitPos;

	public Profile(int hotkeyCode, int hotkeyMod, InterfaceSize interfaceSize, Profession prof,
			ArrayList<Integer> skillPos, ArrayList<Integer> traitlinePos, ArrayList<Integer> traitPos) {
		super();
		this.hotkeyCode = hotkeyCode;
		this.hotkeyMod = hotkeyMod;
		this.interfaceSize = interfaceSize;
		this.prof = prof;
		this.skillPos = skillPos;
		this.traitlinePos = traitlinePos;
		this.traitPos = traitPos;
	}
	
	public Profile() {	}

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

	public ArrayList<Integer> getSkillPos() {
		return skillPos;
	}

	public ArrayList<Integer> getTraitlinePos() {
		return traitlinePos;
	}

	public ArrayList<Integer> getTraitPos() {
		return traitPos;
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

	public void setSkillPos(ArrayList<Integer> skillPos) {
		this.skillPos = skillPos;
	}

	public void setTraitlinePos(ArrayList<Integer> traitlinePos) {
		this.traitlinePos = traitlinePos;
	}

	public void setTraitPos(ArrayList<Integer> traitPos) {
		this.traitPos = traitPos;
	}

}
