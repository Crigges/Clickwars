package systems.crigges.gen;

import java.io.File;
import java.io.FileFilter;

public class ResourceCodeGen {

	public static void main(String[] args) {
		File files = new File("C:\\Users\\Crigges\\git\\Clickwars\\icons\\chrono");
		for(File f : files.listFiles((FileFilter) null)){
			System.out.println("eleUtils[0] = getResource(\"/ele/" + f.getName() + "\")");
		}
	}
	
}
