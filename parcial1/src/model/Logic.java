package model;

import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {

	private String [] dogs1;
	private String [] dogs2;
	private LinkedList<Dog> dogList;
	
	private String [] byID;
	private PApplet app;

	public Logic(PApplet app){
		this.app=app;
		dogs1= app.loadStrings("../data/imports/datosUno.txt");
		dogs2= app.loadStrings("../data/imports/datosDos.txt");
		dogList = new LinkedList<Dog>();
		
		byID = new String[10];
		
		dogs1 = PApplet.sort(dogs1);
		dogs2 = PApplet.sort(dogs2);
		
		for (int i = 0; i < dogs1.length; i++) {
			String[] lineString = dogs1[i].split(",");
			int ID = Integer.parseInt(lineString[0]);
			String name = lineString[1];
			int age = Integer.parseInt(lineString[2]);
				String[] lineString2 = dogs2[i].split(",");
				//if (lineString.equals(ID)) {
					String race = lineString2[1];
					String date = lineString2[2];
					addElementList(new Dog (ID,age, name, race, date, app));
				}
		}

	public void addElementList(Dog dog) {
		dogList.add(dog);
	}
	
	public void sortList(char c) {
		switch (c) {
		case 'i':
			Collections.sort(dogList);
			
			for (int i = 0; i < dogList.size(); i++) {
				
				String ID = Integer.toString(dogList.get(i).getID());
				String age = Integer.toString(dogList.get(i).getAge());
				String name = dogList.get(i).getName();
				String race = dogList.get(i).getRace();
				String date = dogList.get(i).getbDate();

				String line = ID + ", " + name + ", " + race + ", " + age + "," + date;
				byID[i] = line;
			}
			this.app.saveStrings("byRating.txt", byID);
			
		default:
		
	}
	}
	

	public LinkedList<Dog> getDogList() {
		return dogList;
	}

	public void setDogList(LinkedList<Dog> dogList) {
		this.dogList = dogList;
	}

	
}
