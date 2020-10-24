package controller;

import java.util.LinkedList;

import model.Dog;
import model.Logic;
import processing.core.PApplet;

//Control class in controller package
public class Control {

	//Logic class in logic package initialized in Control
	private Logic logic;
	private PApplet app;
	
	public Control (PApplet app) {
		this.app = app;
		//Logic class declaration
		logic= new Logic(app);
	}
	
	//sortList method called from Logic class
	public void sortList(char c) {
		logic.sortList(c);
	}
	// LinkedList's get called from Logic class
	public LinkedList<Dog> getDogList() {
		return logic.getDogList();
	}
	
}
