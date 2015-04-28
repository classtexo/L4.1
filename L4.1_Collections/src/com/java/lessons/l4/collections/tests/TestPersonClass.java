package com.java.lessons.l4.collections.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.lessons.l4.collections.lib.Person;

public class TestPersonClass {

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        System.out.println("@BeforeClass      : onceExecutedBeforeAll\n");
        System.out.println("Number of persons : " + Person.countPersons());
    }
 
    @Before
    public void executedBeforeEach() {
        System.out.println("@Before: executedBeforeEach");
        System.out.println("Number of persons : " + Person.countPersons());
    }	
	
	
	
/*	@Test
 	public void test() {
		fail("Not yet implemented");
	}
*/	
	@Test
	public void testCreatePerson(){
     // Testovaci hodnoty pro ucely testovani 
		int beforeCountPersons = Person.countPersons();
        String defaultNameValue = "unknown";
		String sNewName = "Jan";
		String sNewSurname = "Novak";        
        
        
 	 // testPerson1 : Vytvoreni rychlym konstruktorem, dosazeni "unknown", not null (N,S,ID), ID>0
     // Zvysuje se ID o 1 pro vytvoreni nove Person
	
		Person testPerson1 = (Person) new Person();
		assertNotNull(testPerson1);
		assertNotNull(testPerson1.personName);
		assertNotNull(testPerson1.getPersonSurname());
		assertNotNull(testPerson1.id);
		assertTrue( testPerson1.id > 0 );
		assertEquals(Person.countPersons(), beforeCountPersons + 1 );
		assertTrue(defaultNameValue.equals(testPerson1.personName));
		assertTrue(defaultNameValue.equals(testPerson1.personSurname));
		assertFalse(defaultNameValue.equals(testPerson1.personName + "xx"));
		assertFalse(defaultNameValue.equals(testPerson1.personSurname + "xx"));
		
	 // Jak otestovat ze to nefailnulo?
	 // Test Set/Get, overeni pro N a S	
		testPerson1.setPersonName(sNewName);
		testPerson1.setPersonSurname(sNewSurname);
		assertEquals( sNewName    , testPerson1.getPersonName()    );
		assertEquals( sNewSurname , testPerson1.getPersonSurname() );
	    
		System.out.println(testPerson1.toString());
		Person testPerson2 = (Person) new Person();
		System.out.println(testPerson2.toString());
		
		assertFalse(testPerson1.equalsToPerson(testPerson2));
		testPerson2.setPersonName(sNewName);
		testPerson2.setPersonSurname(sNewSurname);
		System.out.println(testPerson2.toString());
		assertTrue(testPerson1.equalsToPerson(testPerson2));
		
	 // Test metody toString => [000002] NOVAK Jan	
		assertTrue(testPerson2.toString().equals("[000002] NOVAK Jan"));
		
	 // Test hashCode - SUPER() maskovany ID	
		assertEquals( testPerson1.hashCode() & 0b1111 , testPerson1.id );
		assertEquals( testPerson1.hashCode() & 0b1111111111111111111111111110000 , testPerson1.originalHashInt & 0b1111111111111111111111111110000 );

		
		
	 // Otestovat set/get aby neslo NULL
	 // Otestovat vyhozeni exception	
		
	}
	
	
	
	
/*  Chci do logu vypisovat nastartovany test a jeho dokonceni
    priklady otestovani:
    	assert positive
    	assert negative
    	expected value
    	exception
    	rule
    	
    	reuse : udelam jedno Person a otestuji. Pote tam naskladam vice
    	Test zda ma vsechny metody co pozadoval David
    	co dal?*/
	

}
