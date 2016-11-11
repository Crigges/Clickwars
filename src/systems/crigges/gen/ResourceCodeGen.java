package systems.crigges.gen;

import java.io.File;
import java.io.FileFilter;

public class ResourceCodeGen {

	public static void main(String[] args) {
		File files = new File("C:\\Users\\Crigges\\git\\Clickwars\\icons\\tempest");
		for(File f : files.listFiles((FileFilter) null)){
			System.out.println("tempestUtils[0] = getResource(\"/tempest/" + f.getName() + "\")");
		}
	}
	
}
