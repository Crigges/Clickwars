package systems.crigges.gen;

import java.io.File;
import java.io.FileFilter;

public class ResourceCodeGen {

	public static void main(String[] args) {
		File files = new File("C:\\Users\\Firehead\\git\\Clickwars\\icons\\scrapper");
		for(File f : files.listFiles((FileFilter) null)){
			System.out.println("utils[0] = getResource(\"/scrapper/" + f.getName() + "\");");
		}
	}
	
}
