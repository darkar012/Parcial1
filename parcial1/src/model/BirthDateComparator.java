package model;

import java.util.Comparator;

public class BirthDateComparator implements Comparator<Dog> {

	public int compare(Dog o1, Dog o2) {
		return o1.getbDate().compareTo(o2.getbDate()) ;
	}
}
