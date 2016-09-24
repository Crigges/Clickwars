package systems.crigges.main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Skill extends ImageIcon {
	private int pos;

	public Skill(Image image, int pos) {
		super(image);
		this.pos = pos;
	}
	
	public int getPos() {
		return pos;
	}
	
}
