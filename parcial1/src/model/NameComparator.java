package model;

import java.util.Comparator;

//NameComparator class implementing Comparator interface
public class NameComparator implements Comparator<Dog> {

	//the method compare let compare the two elements of the list using the name to order
	public int compare(Dog o1, Dog o2) {
		return o1.getName().compareTo(o2.getName()) ;
	}
}
