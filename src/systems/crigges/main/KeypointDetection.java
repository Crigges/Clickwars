package systems.crigges.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KeypointDetection {
	private Robot robot;
	private Rectangle screenSize;
	
	public static void main(String[] args) {
		KeypointDetection detec = new KeypointDetection();
		long time = System.currentTimeMillis();
		System.out.println(detec.find(KeyPointBase.getSkillBar(InterfaceSize.Larger)));
		System.out.println(System.currentTimeMillis() - time);
	}
	
	
	public KeypointDetection() {
		screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public Point find(ArrayList<KeyPoint> points){
		BufferedImage img = robot.createScreenCapture(screenSize);
		for(int y = 0; y < img.getHeight(); y++){
			for (int x = 0; x < img.getWidth(); x++) {
				boolean found = true;
				for(KeyPoint p : points){
					if(x + p.getPoint().x >= img.getWidth() || y + p.getPoint().y >= img.getHeight()){
						found = false;
						break;
					}
					if(!p.check(new Color(img.getRGB(x + p.getPoint().x, y + p.getPoint().y)))){
						found = false;
						break;
					}
				}
				if(found){
					return new Point(x, y);
				}
			}
		}
		return null;
	}

}
