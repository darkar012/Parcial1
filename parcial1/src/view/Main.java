package view;

import controller.Control;
import processing.core.PApplet;

public class Main extends PApplet{

	private Control control;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size (2000,600);
	}
	
	public void setup() {
		control= new Control(this);
	}
	
	public void draw() {
		background(0);
		
		for (int i = 0; i < control.getDogList().size(); i++) {
			control.getDogList().get(i).writeDog(10+(140*i));
		}
		
		textSize(30);
		text("Pulse i para ordenar por ID", 10, 500);
		text("Pulse n para ordenar por nombre", 10, 535);
		text("Pulse r para ordenar por raza", 10, 565);
		text("Pulse d para ordenar por fecha de nacimiento", 10, 595);

	}

	
	public void keyPressed() {
		control.sortList(key);
	}
	
	

}
