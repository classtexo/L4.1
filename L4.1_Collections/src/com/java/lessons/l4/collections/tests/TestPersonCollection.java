package com.java.lessons.l4.collections.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.lessons.l4.collections.lib.Person;
import com.java.lessons.l4.collections.lib.PersonCollection;

public class TestPersonCollection {
  
	public static PersonCollection personRegister;
  
    @BeforeClass
    public static void onceExecutedBeforeAll() {
        System.out.println("@BeforeClass      : onceExecutedBeforeAll\n");
        System.out.println("Number of persons : " + Person.countPersons());
        
        personRegister = new PersonCollection();
        personRegister.addNewPerson("Name", "Test003");
        personRegister.addNewPerson("Name", "Test001");
        personRegister.addNewPerson("Name", "Test004");
        personRegister.addNewPerson("Name", "Test002");
        personRegister.addNewPerson("Jan", "Novak");
        personRegister.addNewPerson("Jen", "Novakova");
        personRegister.addNewPerson("Jen", "Novak");
        
        personRegister.toString();
        
    }
 
    @Before
    public void executedBeforeEach() {
        System.out.println("@Before: executedBeforeEach");
        System.out.println("Number of persons : " + Person.countPersons());
    }
    
    public void mainTest(){
        int[] idOrder = TestLibrary.getIdArray(personRegister);
        System.out.println(idOrder);
    }

}
