package systems.crigges.gen;

import java.io.File;
import java.io.FileFilter;

public class ResourceCodeGen {

	public static void main(String[] args) {
		File files = new File("C:\\Users\\Firehead\\git\\Clickwars\\icons\\druid");
		for(File f : files.listFiles((FileFilter) null)){
			System.out.println("utils[0] = getResource(\"/druid/" + f.getName() + "\");");
		}
	}
	
}
