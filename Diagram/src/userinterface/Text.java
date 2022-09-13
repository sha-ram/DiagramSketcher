package userinterface;

import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.UI;

public class Text implements Shapes {
	
	private double X;
	private double Y;
	private String s;
	private Color col;
	
	public Text(String st,double x, double y) {
		s = st;
		X=x;
		Y=y;
	}
	
	
	public void draw() {
		UI.setColor(col);
		UI.drawString(s, X, Y);
	}
	public double getX() {
		return X;
	}
	public double getY() {
		return Y;
	}
	public void setX(double x) {
		this.X = x;
	}
	public void setY(double y) {
		this.Y = y;
	}
	public double getW() {
		return 0;
	}
	public double getH() {
		return 0;
	}
	public void erase() {
		
		//System.out.println("ok");
		
		
		//UI.fillRect(X, Y, 100, 50);
		
		UI.eraseString(s, X, Y);
	}
	public boolean iswithin(double x,double y) {
		
		double x1 = X + s.length();
		double x2 = Y+ s.length();
		if (X<=x && x<=X + x1 && Y <=y && y<=Y+x2) {
			return true;
		}
		
		else{return false;}
		
	}
	public void setColor(Color c) {
	this.col = c;
	}
	public Color getColor() {
		return col;
	}
	public void setW(double v) {
		
	}
	public void setH(double k) {
		
	}
	

}
