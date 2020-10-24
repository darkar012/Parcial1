package model;

import java.util.Comparator;

//RaceComparator class implementing Comparator interface
public class RaceComparator implements Comparator<Dog> {

	//the method compare let compare the two elements of the list using the race to order
	public int compare(Dog o1, Dog o2) {
		return o1.getRace().compareTo(o2.getRace()) ;
	}
}
