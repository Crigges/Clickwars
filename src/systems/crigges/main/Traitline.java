package systems.crigges.main;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Traitline extends ImageIcon {
	private int pos;
	private URL resource;
	
	public Traitline(URL res, int pos) {
		super(res);
		this.resource = res;
		this.pos = pos;
	}
	
	public int getPos() {
		return pos;
	}

	public URL getResource() {
		return resource;
	}

	
}
