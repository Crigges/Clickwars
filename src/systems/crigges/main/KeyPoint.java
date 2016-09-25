package systems.crigges.main;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class KeyPoint{
	private Point point;
	private Color color;
	
	public KeyPoint(Point p, Color color){
		this.point = p;
		this.color = color;
	}
	
	public int getRGB(){
		return color.getRGB();
	}
	
	public Point getPoint(){
		return point;
	}

}
