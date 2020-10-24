package model;

import processing.core.PApplet;

public class Dog implements Comparable<Dog>{
	
	private String name, race, bDate;
	private int age, ID;
	private PApplet app;
	
	public Dog (int ID, int age, String name, String race, String bDate, PApplet app) {
		this.ID=ID;
		this.age=age;
		this.name = name;
		this.race = race;
		this.bDate = bDate;
		this.app = app;
	}
	
	public void writeDog(int x) {
		app.textSize(14);
		app.text(ID, x, 300);
		app.text(name, x, 320);
		app.text(race, x, 342);
		app.text(age, x, 362);
		app.text(bDate.toString(), x, 382);
	}
	
	public int compareTo(Dog nextDog) {
		return this.ID - nextDog.getID();
	}

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

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}



	
}
