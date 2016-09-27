package systems.crigges.main;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SkillSet extends AbstractListModel<Icon> {
	private static final long serialVersionUID = 1L;
	private int imageScale = 128;
	private ImageIcon defaultImage = createDefaultImage();
	private Profession prof;
	private int slot;


	public SkillSet(Profession prof, int slot) {
		this.prof = prof;
		this.slot = slot;
	}

	

	private ImageIcon createDefaultImage() {
		return new Skill(new BufferedImage(imageScale, imageScale, BufferedImage.TYPE_INT_RGB), 0);
	}

	public ImageIcon getDefaultImage() {
		return defaultImage;
	}

	private BufferedImage resize(BufferedImage original, int newWidth,
			int newHeight) {
		BufferedImage resized = new BufferedImage(newWidth, newHeight,
				original.getType());
		Graphics2D g = resized.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(original, 0, 0, newWidth, newHeight, 0, 0,
				original.getWidth(), original.getHeight(), null);
		g.dispose();
		return resized;
	}
	

	@Override
	public int getSize() {
		return ResourceFactory.getSkillCount(prof, slot);
	}

	@Override
	public Icon getElementAt(int index) {
		return ResourceFactory.getSkill(prof, index, slot);
	}
	
}
