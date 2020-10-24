package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import processing.core.PApplet;
//Logic class in logic package
public class Logic {
	//strings used to read the text and print the list
	private String [] dogs1;
	private String [] dogs2;
	//LinkedList of objects to order
	private LinkedList<Dog> dogList;

	//Strings to save the list ordered by attribute
	private String [] byID;
	private String [] byName;
	private String [] byRace;
	private String [] byBDate;
	private String [] byAge;

	//comparators to used the partial ordering
	private NameComparator NC;
	private RaceComparator RC;
	private BirthDateComparator BDC;
	private AgeComparator AC;

	private PApplet app;

	public Logic(PApplet app){
		this.app=app;

		//load of strings from the text
		dogs1= app.loadStrings("../data/imports/datosUno.txt");
		dogs2= app.loadStrings("../data/imports/datosDos.txt");
		//initialization of LinkedList
		dogList = new LinkedList<Dog>();

		//initialization of strings to save the lists ordered
		byID = new String[10];
		byName = new String[10];
		byRace = new String[10];
		byBDate = new String[10];
		byAge = new String[10];

		//initialization of comparators
		NC = new NameComparator();
		RC = new RaceComparator();
		BDC = new BirthDateComparator();
		AC = new AgeComparator();

		//ordering Strings to match later
		dogs1 = PApplet.sort(dogs1);
		dogs2 = PApplet.sort(dogs2);

		//for to process the TXT
		for (int i = 0; i < dogs1.length; i++) {
			// the dogs1 is divided by the "," to be saved in lineString
			String[] lineString = dogs1[i].split(",");
			// the elements of the String are saved one by one like an attribute different based in their position in the String
			int ID = Integer.parseInt(lineString[0]);
			String name = lineString[1];
			int age = Integer.parseInt(lineString[2]);
			// the dogs2 is divided by the "," to be saved in lineString
			String[] lineString2 = dogs2[i].split(",");
			// the elements of the String are saved one by one like an attribute different based in their position in the String
			String race = lineString2[1];
			// the SimpleDateFormat is used to apply the format of date to the date variable to be used in the constructor of Dog
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date date = null;
			try {
				date = format.parse(lineString2[2]);
			} catch (ParseException ex) {
				// TODO Auto-generated catch block
				System.out.println(ex);
			}					
			// the element is added to the list
			addElementList(new Dog (ID,age, name, race, date, app));
		}
	}
	// add element to the list method
	public void addElementList(Dog dog) {
		//the list add the dog objects
		dogList.add(dog);
	}
	// sortList method to order the list
	public void sortList(char c) {
		switch (c) {
		// if you press i in the keyboard, the list is going to be ordered using natural ordering by ID
		case 'i':
			//the Collections.sort let call the compare method to order the element
			Collections.sort(dogList);

			//for structure used to save each attribute of the dogs in a TXT ordered by ID
			for (int i = 0; i < dogList.size(); i++) {

				// all is saved in String to be saved in the TXT
				/* the Integer.to String transform the integer variable to String, the get(i) obtains the position, and later
				 the attribute is called from dog class to be saved as string */ 
				String ID = Integer.toString(dogList.get(i).getID());
				String age = Integer.toString(dogList.get(i).getAge());
				//the get(i) obtains the position, and later the attribute is called from dog class to be saved as string 
				String name = dogList.get(i).getName();
				String race = dogList.get(i).getRace();
				//// the SimpleDateFormat is used to apply the format of date to the date variable used in the constructor of Dog
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String date = format.format (dogList.get(i).getDate());

				//the each dog of the list is saved in this order line by line
				String line = ID + ", " + name + ", " + race + ", " + age + "," + date;
				byID[i] = line;
			}
			// the new list is saved
			this.app.saveStrings("byID.txt", byID);
			break;
			// if you press n in the keyboard, the list is going to be ordered using partial ordering by name
		case 'n':
			//the Collections.sort let call the compare method to order the element saved in another comparator class
			Collections.sort(dogList, NC);
			//for structure used to save each attribute of the dogs in a TXT ordered by name
			for (int i = 0; i < dogList.size(); i++) {

				String ID = Integer.toString(dogList.get(i).getID());
				String age = Integer.toString(dogList.get(i).getAge());
				String name = dogList.get(i).getName();
				String race = dogList.get(i).getRace();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String date = format.format (dogList.get(i).getDate());

				String line = ID + ", " + name + ", " + race + ", " + age + "," + date;
				byName[i] = line;
			}
			this.app.saveStrings("byName.txt", byName);
			break;
			// if you press r in the keyboard, the list is going to be ordered using partial ordering by race
		case 'r':
			Collections.sort(dogList, RC);
			//for structure used to save each attribute of the dogs in a TXT ordered by race
			for (int i = 0; i < dogList.size(); i++) {

				String ID = Integer.toString(dogList.get(i).getID());
				String age = Integer.toString(dogList.get(i).getAge());
				String name = dogList.get(i).getName();
				String race = dogList.get(i).getRace();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String date = format.format (dogList.get(i).getDate());

				String line = ID + ", " + name + ", " + race + ", " + age + "," + date;
				byRace[i] = line;
			}
			this.app.saveStrings("byRace.txt", byRace);
			break;
			// if you press d in the keyboard, the list is going to be ordered using partial ordering by birth date
		case 'd':
			Collections.sort(dogList, BDC);
			//for structure used to save each attribute of the dogs in a TXT ordered by birth date
			for (int i = 0; i < dogList.size(); i++) {

				String ID = Integer.toString(dogList.get(i).getID());
				String age = Integer.toString(dogList.get(i).getAge());
				String name = dogList.get(i).getName();
				String race = dogList.get(i).getRace();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String date = format.format (dogList.get(i).getDate());

				String line = ID + ", " + name + ", " + race + ", " + age + "," + date;
				byBDate[i] = line;
			}
			this.app.saveStrings("byDate.txt", byBDate);
			break;
			// if you press d in the keyboard, the list is going to be ordered using partial ordering by age
		case 'e':
			Collections.sort(dogList, AC);
			//for structure used to save each attribute of the dogs in a TXT ordered by age
			for (int i = 0; i < dogList.size(); i++) {

				String ID = Integer.toString(dogList.get(i).getID());
				String age = Integer.toString(dogList.get(i).getAge());
				String name = dogList.get(i).getName();
				String race = dogList.get(i).getRace();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String date = format.format (dogList.get(i).getDate());

				String line = ID + ", " + name + ", " + race + ", " + age + "," + date;
				byAge[i] = line;
			}
			this.app.saveStrings("byAge.txt", byAge);
			break;
		default:
		}
	}

	//getters and setters
	public LinkedList<Dog> getDogList() {
		return dogList;
	}

	public void setDogList(LinkedList<Dog> dogList) {
		this.dogList = dogList;
	}


}
