package com.java.lessons.l4.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import com.java.lessons.l4.collections.lib.Person;
import com.java.lessons.l4.collections.lib.PersonCollection;
import com.java.lessons.l4.collections.lib.PersonComparatorById;
import com.java.lessons.l4.collections.lib.PersonComparatorByNames;

public class MainClass {

	public static void main(String[] args) {
        
        PersonCollection personRegister = new PersonCollection();
        personRegister.addNewPerson("Jan", "Novak");
        personRegister.addNewPerson("Jen", "Novak");
        personRegister.addNewPerson("Frantisek", "Novotny");
        personRegister.addNewPerson("Bohus", "Hlavaty");
        personRegister.addNewPerson("Jen", "Novak");
        personRegister.addNewPerson("Anna", "Jiraskova");
        personRegister.addNewPerson("Jen", "Novak");
        
        Collections.sort(personRegister.register, new PersonComparatorByNames());
        System.out.println(personRegister.toString());

        Collections.sort(personRegister.register, new PersonComparatorById());
        System.out.println(personRegister.toString());

        Person removePerson = new Person("Frantisek", "Novotny");
        
        for (Iterator<Person> iterator = personRegister.register.iterator(); iterator.hasNext();) {
            Person inspectedPerson = iterator.next();
            if (inspectedPerson.equals(removePerson)) {
                iterator.remove();
            }
        }
        
        System.out.println(personRegister.toString());
        
	}

}
