package systems.crigges.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Profile implements Serializable{
	private static final long serialVersionUID = 2L;

	private static transient ArrayList list;
	
	private int hotkeyCode;
	private int hotkeyMod;
	private InterfaceSize interfaceSize;
	private Profession prof = Profession.Chronomancer;
	private int[] skillPos;
	private int[] traitlinePos;
	private int[] traitPos;
	private int[] equipmentPos;
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
		equipmentPos = new int[16];
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
		saveProfiles();
	}

	public void setInterfaceSize(InterfaceSize interfaceSize) {
		this.interfaceSize = interfaceSize;
		saveProfiles();
	}

	public void setProf(Profession prof) {
		this.prof = prof;
		saveProfiles();
	}

	public void setSkillPos(int slot, int value) {
		skillPos[slot] = value;
		saveProfiles();
	}

	public void setTraitlinePos(int slot, int value) {
		traitlinePos[slot] = value;
		saveProfiles();
	}

	public void setTraitPos(int slot, int value) {
		traitPos[slot] = value;
		saveProfiles();
	}
	
	public void setEquipmetPos(int slot, int value){
		equipmentPos[slot] = value;
		saveProfiles();
	}
	
	public Object[] getModelEntry(){
		Object[] o = new Object[3];
		o[0] = name;
		o[1] = prof;
		o[2] = hotkeyName;
		return o;
	}

	public static ArrayList<Profile> get() {
		FileInputStream fout;
		try {
			FileInputStream fin = new FileInputStream("profiles.crig");
			ObjectInputStream in = new ObjectInputStream(fin);
			list = (ArrayList) in.readObject();
			return list;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			list = new ArrayList<>();
			return list;
		}
		
	
	}
	
	public static void saveProfiles(){
		try {
			File f = new File("profiles.crig");
			if(!f.exists()){
				f.createNewFile();
			}
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(list);
			fout.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		saveProfiles();
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

	public int[] getAllEquipmentPos() {
		return equipmentPos;
	}

}
