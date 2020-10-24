package model;

import java.util.Comparator;

// AgeComparator class implementing Comparator interface
public class AgeComparator implements Comparator<Dog> {

	//the method compare let compare the two elements of the list using the age to order
	public int compare(Dog o1, Dog o2) {
		return o1.getAge() - o2.getAge() ;
	}
}
