package view;

import controller.Control;
import processing.core.PApplet;

//Main class in view package
public class Main extends PApplet{
	
	//Control class in controller package initialized
	private Control control;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	//settings method to set up the size of the canvas
	public void settings() {
		size (2000,500);
	}
	
	// setup method to declared Control
	public void setup() {
		//Control declaration
		control= new Control(this);
	}
	
	// draw method
	public void draw() {
		//canvas color
		background(0);
		
		//For structure used to get the dogList from the logic and call the writeDog method from the Dog class
		for (int i = 0; i < control.getDogList().size(); i++) {
			control.getDogList().get(i).writeDog(10+(140*i));
		}
		
		//text used to created the UI with the instructions to use the program
		textSize(30);
		text("Pulse i para ordenar por ID", 10, 375);
		text("Pulse n para ordenar por nombre", 10, 405);
		text("Pulse r para ordenar por raza", 10, 435);
		text("Pulse d para ordenar por fecha de nacimiento", 10, 465);
		text("Pulse e para ordenar por edad", 10, 495);
	}

	// keyPressed method
	public void keyPressed() {
		/*the sortList method receive the key pressed in the keyboard and send it to the logic to change the switch in sortList
		and order the list*/
		control.sortList(key);
	}
	
	

}
