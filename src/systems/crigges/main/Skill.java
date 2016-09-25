package systems.crigges.main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;

public class Skill extends ImageIcon {
	private int pos;
	private URL resource;

	public Skill(URL res, int pos) {
		super(res);
		this.resource = res;
		this.pos = pos;
	}
	
	public Skill(BufferedImage bufferedImage, int pos) {
		super(bufferedImage);
		this.pos = pos;
	}

	public int getPos() {
		return pos;
	}
	
	public URL getResource(){
		return resource;
	}

	@Override
	public String toString() {
		return "Skill [pos=" + pos + ", resource=" + resource + "]";
	}
	
}
