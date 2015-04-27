package com.java.lessons.l4.collections.lib;

import java.util.Comparator;

/**
 * @author vilem_reznicek
 */

public class Person  {
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonSurname() {
		return personSurname;
	}

	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}

	private static int idRegister = 0;

	public int id;
	public int originalHashInt  = super.hashCode();
	public String personName    = "unknown";
	public String personSurname = "unknown";
	public String hashString;
	
	/**
	 *   Constructor : creates a new instance of Person
	 *   Unique ID is set using internal STATIC idRegister (inremented) 
	 */
	public Person() {
	  this.id = this.getUniqueID();
	}

	/**
	 *   Constructor : creates a new instance of Person
	 *   Unique ID is set using internal STATIC idRegister (inremented) 
	 * @param name
	 * @param surname
	 */
	public Person(String name, String surname) {
		this.id = this.getUniqueID();
		setPersonName(name);
		setPersonSurname(surname);
	}
	
	/** 
	 * @return Unique Instance ID of the PERSON
	 */
	private int getUniqueID(){
		idRegister++;
		//System.out.println("Vytvorena osoba s id " + idRegister);
		return idRegister;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Chci aby se ID zobrazilo s leading zero!!!
	 */
	@Override
	public String toString() {
		String personDetail = "[" + String.format("%06d", this.id) + "] " + this.personSurname.toUpperCase() + " " + this.personName;
		return personDetail;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * int ma x bitu
	 * 
	 */
	@Override
	public int hashCode() {
		int hashInt = originalHashInt;
		
/*		System.out.println("hashCode Super    BIN : " + Integer.toBinaryString(hashInt));
		System.out.println("hashCode Super    INT : " + hashInt);
		System.out.println("Max    INT : " + Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println("Max    INT : " + Integer.MAX_VALUE);*/

	 //	Binarni operace - maskovani ID do spodnich 4 bitu (max ID tedy 8!)
	 // Max int binarne   : 0b1111111111111111111111111111111	 (2147483647)
		hashInt = hashInt & 0b1111111111111111111111111110000;
		hashInt = hashInt ^ (this.id & 0b1111);
		
/*		System.out.println("hashCode Override BIN : " + Integer.toBinaryString(hashInt));
		System.out.println("hashCode Override INT : " + hashInt);*/
		
		this.hashString = originalHashInt + "." + hashInt + "." + this.id ;
		
		return hashInt;
	}
	
	
	// Tady mi to nedovoli Override! Proc???
	/**
	 * Comapres two persons. If name & surname are equal = TRUE
	 * @param personToCompareWith
	 * @return
	 */
	 public boolean equals(Person personToCompareWith) {
	   boolean personIsSame = true;
	   if (!this.personName.equals(personToCompareWith.personName)) {
		   personIsSame = false;}
	   if (!this.personSurname.equals(personToCompareWith.personSurname)) {
		   personIsSame = false;}	   	
	   return personIsSame;	
	 }
	 
	 /** Returns number of instances of Person class
	 * @return
	 */
	public static int countPersons(){
		 return idRegister;
	 }
	 
	/** Sort BY SURNAME,NAME 
	 * @param personToComapare
	 * @return -1 0 1
	 */
	public int compareTo(Person personToComapare){
		 int resultCmp = this.personSurname.compareTo(personToComapare.personSurname);
		 if (resultCmp == 0) {
			 resultCmp = this.personName.compareTo(personToComapare.personName);
		 }
		 return resultCmp;
	 }

	public int compare(Person personToComapare){
		 int resultCmp = this.personSurname.compareTo(personToComapare.personSurname);
		 if (resultCmp == 0) {
			 resultCmp = this.personName.compareTo(personToComapare.personName);
		 }
		 return resultCmp;
	 }
	
	
}
