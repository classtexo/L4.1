package com.java.lessons.l4.collections.tests;

import com.java.lessons.l4.collections.lib.Person;
import com.java.lessons.l4.collections.lib.PersonCollection;

public class TestLibrary {

	public static int[] getIdArray(PersonCollection register) {

	   int[] arrayToReturn;
	   arrayToReturn = new int[register.size()];
	   
	   int i=0;
	   for (Person person : register.register) {
		   System.out.println("Adding " + person.id);
		   arrayToReturn[i] = person.id;
		   i++;
	   }
	   
	   return arrayToReturn;
   }
}
