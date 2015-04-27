package com.java.lessons.l4.collections.lib;

import java.util.Comparator;

public class PersonComparatorById implements Comparator<Person>  {

	@Override
	public int compare(Person personA, Person personB) {
		 int resultCmp = personA.id - personB.id;
         if (resultCmp< -1) {resultCmp = -1;}
         if (resultCmp>  1) {resultCmp =  1;}
		 return resultCmp;
	}

}


