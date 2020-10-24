package model;

import java.util.Comparator;


	public class RaceComparator implements Comparator<Dog> {

		public int compare(Dog o1, Dog o2) {
			return o1.getRace().compareTo(o2.getRace()) ;
		}
	}
