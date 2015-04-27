package com.java.lessons.l4.collections.lib;

import java.util.Comparator;
import com.java.lessons.l4.collections.lib.Person;

public class PersonComparatorByNames implements Comparator<Person> {

	@Override
	public int compare(Person personA, Person personB) {
		 int resultCmp = personA.personSurname.compareTo(personB.personSurname);
		 if (resultCmp == 0) {
			 resultCmp = personA.personName.compareTo(personB.personName);
		 }
		 return resultCmp;
	}

}
