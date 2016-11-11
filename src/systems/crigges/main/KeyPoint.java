package systems.crigges.main;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class KeyPoint{
	private static final int tollerance = 15;
	
	private int x, y;
	private int r, b, g;
	private boolean inverted = false;
	
	public KeyPoint(int x, int y, int r, int g, int b, boolean inverted){
		this(x, y, r, g, b);
		this.inverted = inverted;
	}
	
	public KeyPoint(int x, int y, int r, int g, int b){
		this.x = x;
		this.y = y;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public boolean check(Color b){
		return check(b, tollerance);
	}
	
	public boolean check(Color c, int tollerance){
		if(inverted){
			return !((Math.abs(r - c.getRed()) <= tollerance) 
					&& (Math.abs(g - c.getGreen()) <= tollerance) 
					&& (Math.abs(b - c.getBlue()) <= tollerance));
		}else{
			return (Math.abs(r - c.getRed()) <= tollerance) 
				&& (Math.abs(g - c.getGreen()) <= tollerance) 
				&& (Math.abs(b - c.getBlue()) <= tollerance);
		}
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public static void main(String[] args) {
		KeyPoint p = null;
		System.out.println(Color.BLACK);
		System.out.println(Color.BLACK.brighter());
		System.out.println(p.check(Color.BLACK));
		System.out.println(p.check(Color.BLACK.brighter()));
	}

	@Override
	public String toString() {
		return "KeyPoint [x=" + x + ", y=" + y + ", r=" + r + ", g=" + g + ", b=" + b + "]";
	}
	
	

}
