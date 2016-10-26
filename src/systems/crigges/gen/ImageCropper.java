package systems.crigges.gen;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCropper {
	
	public static void main(String[] args) throws IOException {
		int i = 0;
		File folder = new File("C:\\Users\\Crigges\\Desktop\\traitimg");
		for(File f : folder.listFiles((FileFilter) null)){
			System.out.println(i);
			BufferedImage img = ImageIO.read(f);
			BufferedImage scaled = img.getSubimage(0, 256-136, 647, 136);
			ImageIO.write(scaled, "png", new File("C:\\Users\\Crigges\\Desktop\\traitimg\\crig" + i + ".png"));
			i++;
		}
	}

}
