package com.java.lessons.l4.collections.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.java.lessons.l4.collections.lib.Person;


public class PersonCollection {
	public List<Person> register;
    
	/**
	 *  Constructor Fast/AddPersonIncluded
	 */
	public PersonCollection() {
		   register = new ArrayList<Person>();
		
	}
	public PersonCollection(Person newPerson) {
		   register = new ArrayList<Person>();
		   register.add(newPerson);
	}
	
	/**Creates and adds a new Person object into the PersonCollection.register list
	 * @param name
	 * @param surName
	 */
	public int addNewPerson(String name, String surName) {
	  Person newPersonObject = new Person(name,surName);
	  register.add(newPersonObject);
	  return newPersonObject.id;
	}
	
	/**
	 * Removes all Person(s) from the list 
	 */
	public void clearRegister(){
		register.clear();	
	}
	
	/** Returns number of Person(s) in the list.
	 * @return
	 */
	public int size(){
		return register.size();
	}
	
	public String toString() {
	   String registerFullList = "====================================\nList of persons: (" + this.size() + ")\n"	;
	   for (Person person : register) {
		   registerFullList = registerFullList + person.toString() + "\n";
	   }
	return registerFullList + "====================================\n" ;
	}


}
