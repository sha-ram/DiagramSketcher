package userinterface;

import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.UI;

public class Line implements Shapes {
	private double a;
	private double b;
	private double a1;
	private double b1;
	private Color col;
	public Line(double x, double y, double x1,double y1){
		
		a = x;
		b = y;
		a1 = x1;
		b1 = y1;
		
	}
	
	public void draw() {
		
		UI.setColor(col);
		UI.drawLine(a, b, a1, b1);
	}

	public void erase() {
		UI.eraseLine(a, b, a1, b1);
		
	}
	
	public boolean iswithin(double x, double y) {
		
	
		
		
		if (a<=x && x<=a1 && b<=y && y<=b1 ) {
			return true;
		}
		else {return false;}
	
	}
	

	public double getX() {
		return a;
	}
	
	public double getY() {
		return b;
	}
	public void setX(double x) {
		this.a = x;
	}
	public void setY(double y) {
		this.b = y;
	}
	public void setW(double v) {
		this.a1 = v;
	}
	public void setH(double k) {
		this.b1 = k;
	}
	public double getW() {
		return a1;
	}
	public double getH() {
		return b1;
	}
	public void setColor(Color c) {
		this.col = c;
		
		
	}
	public Color getColor() {
		return col;
	}


}
