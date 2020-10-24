package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import processing.core.PApplet;
// Dog class with the interface Comparable implemented
public class Dog implements Comparable<Dog>{
	// variable's declaration
	private String name, race;
	private Date date;
	private int age, ID;
	private PApplet app;

	//Dog class constructor
	public Dog (int ID, int age, String name, String race, Date date, PApplet app) {
		this.ID=ID;
		this.age=age;
		this.name = name;
		this.race = race;
		this.date = date;
		this.app = app;
	}

	//write text method
	public void writeDog(int x) {
		//text's size setup
		app.textSize(14);
		// the text write the variables in the respective position
		app.text("ID: "+ID, x, 100);
		app.text("N: "+ name, x, 120);
		app.text("R: "+race, x, 142);
		app.text("Edad: "+ age, x, 162);
		// the SimpleDateFormat is used to apply the format of date to the date variable to write it in the main
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String date = format.format(this.date);
		app.text("B: "+date, x, 182);
	}
	// compareTo using ID to order
	public int compareTo(Dog nextDog) {
		return this.ID - nextDog.getID();
	}
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



}
