package systems.crigges.main;

import java.io.File;
import java.io.FileFilter;

public class ResourceCodeGen {

	public static void main(String[] args) {
		File files = new File("C:\\Users\\Crigges\\git\\Clickwars\\icons\\chrono");
		for(File f : files.listFiles((FileFilter) null)){
			System.out.println("chronoUtils[0] = getResource(\"/chrono/" + f.getName() + "\")");
		}
	}
	
}
