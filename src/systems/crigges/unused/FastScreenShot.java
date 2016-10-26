package systems.crigges.unused;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FastScreenShot {
	private ExecutorService pool = Executors.newFixedThreadPool(4);
	private Robot[] robot = new Robot[4];
	private BufferedImage[] imgs = new BufferedImage[4];

	
	public FastScreenShot() {
		try {
			robot[0] = new Robot();
			robot[1] = new Robot();
			robot[2] = new Robot();
			robot[3] = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}	
	}
		
	public void make(int width, int height){
		Future t1 = pool.submit(new ShootingTask(0, 0, width / 2, height / 2, 0));
		Future t2 = pool.submit(new ShootingTask(width / 2, 0, width / 2, height / 2, 1));
		Future t3 = pool.submit(new ShootingTask(0, height / 2, width / 2, height / 2, 2));
		Future t4 = pool.submit(new ShootingTask(width / 2, height / 2, width / 2, height / 2, 3));
//		try {
//			t1.get();
//			t2.get();
//			t3.get();
//			t4.get();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public Color getColor(int x, int y){
		return null;
	}
	
	class ShootingTask implements Runnable {
		private int x, y, width, height, index;
		
		public ShootingTask(int x, int y, int width, int height, int index) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.index = index;
		}
		
		public void run() {
			imgs[index] = robot[index].createScreenCapture(new Rectangle(x, y, width, height));
		}
	}
	
	public static void main(String[] args) {
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		FastScreenShot sc = new FastScreenShot();
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long time = System.currentTimeMillis();
		for(int i = 0; i < 100; i++){
			sc.make(screenSize.width, screenSize.height);
		}
		sc.pool.shutdown();
		try {
			sc.pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - time);
	}

}
