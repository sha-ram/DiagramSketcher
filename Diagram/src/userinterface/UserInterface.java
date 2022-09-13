package userinterface;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JColorChooser;

import ecs100.UI;
import ecs100.UIFileChooser;

public class UserInterface {
	
	private String diagram;
	private double a,b;
	private ArrayList<Shapes> shapes = new ArrayList<Shapes>();
	
	
	

	public void addBox() {
		
		diagram = "box";
		
		                                
		

	}
	
	public void addCircle() {
		
		diagram = "circle";
		
	}
	public void addText() {
		diagram = "text";
		
	}
	
	public void drawLine() {
		diagram = "line";
		
	}
	
	public void Eraser() {
		
		diagram = "eraser";
		
		
		
	}
	

	
	public Shapes getShape(double x, double y) {
		
		for (Shapes s : shapes) {
			
			
			
			
			
			if (s.iswithin(x, y)) {
				return s;
			}
			
			
			
			
		
		}
		
		return null;
		
		
		
		
	}
	
	public void removeshape() {
		diagram = "remove";
	}
	
	public void removeALL() {
		UI.clearGraphics();
		shapes.removeAll(shapes);
		
		
	}
	
	public void moveShapes() {
		diagram = "move";
	}
	

	
	
	
	public void upsize() {
		
		diagram = "upsize";
		UI.println("click on the object you wanna upsize (only box and circle");
		
	}
	
	public void saveDiagram() {
		try {
			 PrintStream stream = new PrintStream(new File(UIFileChooser.open("File to save to")));
			 //stream.println(shapes);
			 for (Shapes s: shapes) {
			
			 stream.println(s);}
			 stream.close();
			} catch (IOException e) {
			 UI.println("A file-writing error: " + e);
			} 
		
		
	}
	
	public void loadDiagram() {
		try {
			 Scanner scanner = new Scanner(new File(UIFileChooser.open()));
			 
			 while(scanner.hasNext()) {
				
				 
				
				
				 
			 }
			 
			 scanner.close();
			} catch (IOException e) {
			 UI.println("A file-reading error: " + e);
			} 
	}
	
	
	public void doMouse(String action, double x, double y) {
		
		if (action.equals("pressed")) {
			
			
			
			
			this.a = x;
			this.b = y;
		}
		
		if (action.equals("released")) {
			
			if (diagram.equals("move")) {
				Shapes s = getShape(a,b);
				
				if (s == null) {
					
				}
				else {
					UI.clearGraphics();
					for (Shapes sh :shapes) {
						//sh.erase();
						if (sh == s) {
							
							if (sh instanceof Line) {
								double width = Math.abs(sh.getW()- sh.getX());
								double Y = Math.abs(sh.getH() - sh.getY());
								sh.setX(x);
								sh.setY(y);
								sh.setW(x+width);
								sh.setH(y+Y);
								sh.draw();
								
							}
							
							else{sh.setX(x);
							sh.setY(y);
							
							sh.draw();
							}
							
						}
						else {sh.draw();}
					}
				
				
				}
				
				
				
				
				
				
				
			}
			
			if(diagram.equals("remove")) {
				
				Shapes s = getShape(a,b);
				
				
				
				if (s == null) {
					
				}
				else {//s.erase();
					shapes.remove(s);
					UI.clearGraphics();
					for (Shapes sh :shapes) {
						//sh.erase();
						sh.draw();
					}
				
				
				}
				
				
				
				
				
			}
			
			if (diagram.equals("upsize")) {
				
				
				
				Shapes s = getShape(a,b);
				
				if (s==null) {
					
				}
				
				
				else {
					if (s instanceof Line) {
						
					
					
					
					
				}
					
				else{double qw = UI.askInt("How much would you like to upsize the object?:");
					s.erase();
					s.setH(s.getH()+qw);
					s.setW(s.getW()+qw);
					
					s.draw();
				}
				}
				
			}
			
			
			
			if (diagram.equals("circle")) {
				Color col = JColorChooser.showDialog(null, "Select Colour", Color.BLACK);
				UI.setColor(col);
				
			Circle c = new Circle(a,b, Math.abs(x-a), Math.abs(y-b));
			shapes.add(c);
			c.setColor(col);
			c.draw();
			
				}
			
			if (diagram.equals("box")) {
				Color col = JColorChooser.showDialog(null, "Select Colour", Color.BLACK);
				UI.setColor(col);
				Box bo = new Box(a,b,Math.abs(x-a), Math.abs(y-b));
				shapes.add(bo);
				bo.setColor(col);
				bo.draw();
				
			}
			if (diagram.equals("line")) {
				Color col = JColorChooser.showDialog(null, "Select Colour", Color.BLACK);
				UI.setColor(col);
				Line l = new Line(a,b,x,y);
				shapes.add(l);
				l.setColor(col);
				l.draw();
				
			}
			if (diagram.equals("text")) {
				Color col = JColorChooser.showDialog(null, "Select Colour", Color.BLACK);
				UI.setColor(col);
				String s = UI.askString("Please enter the text:");
				Text t = new Text(s,x,y);
				shapes.add(t);
				t.setColor(col);
				t.draw();
				
			}
			
			if (diagram.equals("eraser")) {
				
				UI.eraseOval(a,b, Math.abs(x-a), Math.abs(y-b));
				
				
			}
					
					
			
	}
		
		
	}
		
		
	

	public UserInterface() {
		UI.initialise();
		UI.addButton("Add box", this::addBox);
		UI.addButton("Add circle", this::addCircle);
		UI.addButton("Draw Line", this::drawLine);
		UI.addButton("Add text", this::addText);
		UI.addButton("Eraser" ,this::Eraser);
		UI.addButton("Remove Shapes", this::removeshape);
		UI.addButton("Remove all", this::removeALL);
		UI.addButton("upsize", this::upsize);
		UI.addButton("Move shapes", this::moveShapes);
		UI.addButton("save as diagram", this::saveDiagram);
		
				
		UI.setMouseListener(this::doMouse);
	}

	public static void main(String[] args) {
		new UserInterface();

	}

}
