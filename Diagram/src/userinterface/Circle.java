package userinterface;

import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.UI;

public class Circle implements Shapes {
	private double a;
	private double b;
	private double height;
	private double width;
	private Color col;
	
	public Circle(double x, double y, double w, double h) {
		a = x;
		b = y;
		height = h;
		width = w;
		
	
		}
	
	public void draw() {
		UI.setColor(col);
		
		UI.drawOval(a, b,width, height);
			
	}
	
	public void erase() {
		UI.eraseOval(a, b, width, height);
		
	}
	
	public boolean iswithin(double x,double y) {
		
		
		double radius = width/2;
		
		double X = a + radius;
		double Y = b+ radius;
		
		double a1 = Math.abs(X-x);
		double b1 = Math.abs(Y -y);
		
		double c = Math.sqrt(a1*a1 + b1*b1);
		//double H = s.getH();
		
		
		
		if (c<=radius) {
			return true;
		}
		
		
		
		else{return false;}	
		
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
