package systems.crigges.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class KeypointDetection {
	private Robot robot;
	
	public static void main(String[] args) {
		new KeypointDetection();
	}
	
	
	public KeypointDetection() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis();
		ArrayList<KeyPoint> points = new ArrayList<>();
		points.add(new KeyPoint(new Point(0, 0), new Color(0, 162, 232)));
		System.out.println(find(points));
		System.out.println(System.currentTimeMillis() - time);
	}
	
	public Point find(ArrayList<KeyPoint> points){
		BufferedImage img = robot.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
		for(int y = 0; y < img.getHeight(); y++){
			for (int x = 0; x < img.getWidth(); x++) {
				boolean found = true;
				for(KeyPoint p : points){
					if(p.getRGB() != img.getRGB(x + p.getPoint().x, y + p.getPoint().y)){
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
