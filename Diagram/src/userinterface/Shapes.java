package userinterface;

import java.awt.Color;

public interface Shapes {
	
	public void draw();
	public double getX();
	public double getY();
	public double getW();
	public double getH();
	public void erase();
	public boolean iswithin(double x,double y);
	public void setColor(Color c);
	public Color getColor();
	public void setW(double v);
	public void setH(double k);
	public void setX(double x);
	public void setY(double y);
	

}
