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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class KeypointDetection {
	private Robot robot;
	private Rectangle screenSize;
	private ExecutorService pool = Executors.newFixedThreadPool(4);
	private Point globalFound = null;
	private BufferedImage currentScreen;
	
	public static void main(String[] args) {
		KeypointDetection detec = new KeypointDetection();
		BufferedImage img = detec.robot.createScreenCapture(detec.screenSize);
		long time = System.currentTimeMillis();
		detec.takeScreen();
		for(int i = 0; i < 1; i++){
			System.out.println(detec.find(KeyPointBase.getSkillBar(InterfaceSize.Normal)));
		}
		//System.out.println(System.currentTimeMillis() - time);
	}
	
	
	public KeypointDetection() {
		screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void takeScreen() {
		currentScreen = robot.createScreenCapture(screenSize);
	}
	
	public Point find(ArrayList<KeyPoint> points){
		return findThreaded(points, currentScreen);
	}
	
	private Point findThreaded(ArrayList<KeyPoint> points, BufferedImage img){
		globalFound = null;
		Future f1 = pool.submit(new FindingTask(0, 0, img.getWidth() / 2, img.getHeight() / 2, points, img));
		Future f2 = pool.submit(new FindingTask(img.getWidth() / 2, 0, img.getWidth() / 2, img.getHeight() / 2, points, img));
		Future f3 = pool.submit(new FindingTask(0, img.getHeight() / 2, img.getWidth() / 2, img.getHeight() / 2, points, img));
		Future f4 = pool.submit(new FindingTask(img.getWidth() / 2, img.getHeight() / 2, img.getWidth() / 2, img.getHeight() / 2, points, img));
		try {
			f1.get();
			f2.get();
			f3.get();
			f4.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return globalFound;
	}
	
	
	private class FindingTask implements Runnable{
		private int startX,startY, width, height;
		private ArrayList<KeyPoint> points;
		private BufferedImage img;
		
		public FindingTask(int startX, int startY, int width, int height, ArrayList<KeyPoint> points,
				BufferedImage img) {
			this.startX = startX;
			this.startY = startY;
			this.width = width;
			this.height = height;
			this.points = points;
			this.img = img;
		} 
		
		@Override
		public void run() {
			int imgWidth = img.getWidth();
			int imgHeight = img.getHeight();
			for(int y = startY + height - 1; y >= startY; y--){
				for (int x = startX; x < startX + width; x++) {
					if(globalFound != null){
						return;
					}
					boolean found = true;
					for(KeyPoint p : points){
						if(x + p.getX() >= imgWidth || y + p.getY() >= imgHeight){
							found = false;
							break;
						}
//						if(points.indexOf(p) > 0){
//							System.out.println(p);
//							System.out.println("x: " + x + " | y: " + y);
//							System.out.println(new Color(img.getRGB(x + p.getX(), y + p.getY())));
//						}
						if(!p.check(new Color(img.getRGB(x + p.getX(), y + p.getY())))){
							found = false;
							break;
						}
					}
					if(found){
						globalFound = new Point(x, y);
					}
				}
			}
			return;
		}
	}

}
