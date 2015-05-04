package com.java.lessons.l4.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import com.java.lessons.l4.collections.lib.LogSetter;
import com.java.lessons.l4.collections.lib.Person;
import com.java.lessons.l4.collections.lib.PersonCollection;
import com.java.lessons.l4.collections.lib.PersonComparatorById;
import com.java.lessons.l4.collections.lib.PersonComparatorByNames;

public class MainClass {

	public static void main(String[] args) {
        
		Logger logger = Logger.getLogger(MainClass.class.getName());
		logger = LogSetter.setLogger(logger);
		
        PersonCollection personRegister = new PersonCollection();
        personRegister.addNewPerson("Jan", "Novak");
        personRegister.addNewPerson("Jen", "Novak");
        personRegister.addNewPerson("Frantisek", "Novotny");
        personRegister.addNewPerson("Bohus", "Hlavaty");
        personRegister.addNewPerson("Jen", "Novak");
        personRegister.addNewPerson("Frantisek", "Novotny");
        personRegister.addNewPerson("Anna", "Jiraskova");
        personRegister.addNewPerson("Jen", "Novak");
        
        Collections.sort(personRegister.register, new PersonComparatorByNames());
        System.out.println("Sorted by NAME\n" + personRegister.toString());

        Collections.sort(personRegister.register, new PersonComparatorById());
        System.out.println("Sorted by ID\n" + personRegister.toString());

        Person removePerson = new Person("Frantisek", "Novotny");
        
        Map<String,Person> mapPersons = new HashMap<String,Person>();
        for (Iterator<Person> iterator = personRegister.register.iterator(); iterator.hasNext();) {
            Person inspectedPerson = iterator.next();
            mapPersons.put("" + inspectedPerson.id, inspectedPerson);
            if (inspectedPerson.equalsToPerson(removePerson)) {
                iterator.remove();
            }
        }

        System.out.println("Removed " + removePerson.toString() + " \n" + personRegister.toString());
        System.out.println(personRegister.toString());
 
        // Proc nefunguje equal na type Person. Proc to musim mit na Object?
        Person doublePersonalRecord = new Person( "Jen","Novak");
        System.out.println("Pocet vyskytu osoby " + doublePersonalRecord.personSurname + " " + doublePersonalRecord.personName + " : " +
        		            Collections.frequency(personRegister.register,doublePersonalRecord));
        
        //Trenovani HashMap
        System.out.println("Size:" +  mapPersons.size());
        for(String key : mapPersons.keySet()){
        	System.out.println("Map item <" + key + "> " + mapPersons.get(key).toString());
        }

        // Map - klic je unikatni - viz 12/12A prepise se value u ID12
        mapPersons.put("" + 12, new Person("Map", "Duplicate12"));
        mapPersons.put("" + 12, new Person("Map", "Duplicate12a"));
        mapPersons.put("" + 13, new Person("Map", "Duplicate13"));

        System.out.println("Size:" +  mapPersons.size());
        for(String key : mapPersons.keySet()){
        	System.out.println("Map item <" + key + "> " + mapPersons.get(key).toString());
        }        
        
        logger.info("info");
        logger.warning("info");
        logger.severe("info");

	}

}
