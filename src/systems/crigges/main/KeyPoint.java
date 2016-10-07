package systems.crigges.main;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class KeyPoint{
	private static final int tollerance = 10;
	
	private Point point;
	private Color color;
	
	public KeyPoint(Point p, Color color){
		this.point = p;
		this.color = color;
	}
	
	public KeyPoint(int x, int y, int r, int g, int b){
		this.point = new Point(x, y);
		this.color = new Color(r, g, b);
	}
	
	public boolean check(Color b){
		return check(b, tollerance);
	}
	
	public boolean check(Color b, int tollerance){
		Color a  = this.color;
		return (Math.abs(a.getRed() - b.getRed()) <= tollerance) 
				&& (Math.abs(a.getGreen() - b.getGreen()) <= tollerance) 
				&& (Math.abs(a.getBlue() - b.getBlue()) <= tollerance);
	}
	
	public int getRGB(){
		return color.getRGB();
	}
	
	public Point getPoint(){
		return point;
	}
	
	public static void main(String[] args) {
		KeyPoint p = new KeyPoint(null, Color.BLACK);
		System.out.println(Color.BLACK);
		System.out.println(Color.BLACK.brighter());
		System.out.println(p.check(Color.BLACK));
		System.out.println(p.check(Color.BLACK.brighter()));
	}

}
