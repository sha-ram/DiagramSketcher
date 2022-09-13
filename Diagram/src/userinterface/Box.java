package userinterface;

import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.UI;

public class Box implements Shapes{
	
	private double a;
	private double b;
	private double width;
	private double height;
	private Color col;
	
	public Box(double x, double y, double w, double h) {
		
		a =x;
		b=y;
		width = w;
		height = h;
		
	}
	
	public void draw() {
		UI.setColor(col);
		UI.drawRect(a, b, width, height);
	}

	public void erase() {
		UI.eraseRect(a, b, width, height);
		
	}
	
	public boolean iswithin(double x, double y) {
		
		if (a <= x && x <= (a + width) && b <= y && y  <= (b + height)) {
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
	public double getW() {
		return width;
	}
	public void setW(double v) {
		this.width = v;
	}
	public void setH(double k) {
		this.height = k;
	}
	public double getH() {
		return height;
	}
	public void setColor(Color c) {
		this.col = c;
		
		
	}
	public Color getColor() {
		return col;
	}

}
