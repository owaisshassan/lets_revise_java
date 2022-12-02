package com.owaiss.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
	
	Calculator cal=null;
	
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("would run before all testcases..");
	}
	
	
	@BeforeEach
	public void beforeEach() {		
		System.out.println("Would run before each testcase..");
		 cal=new Calculator();
	}

	@Test
	public void testAddIntegers() {
		//String msg="Hello";
		
		assertEquals(22,cal.addIntegers(10, 12));
	
	}
	
	@Test
	@DisplayName("dummy test cases")
	public void dummyTests() {
		//assertThrows(null, null);  //checks exception handling
		
	}
	
	@Test
	public void shouldThrowException() {
		assertThrows(ClassCastException.class,()-> cal.multiply(12, 4), "Please enter valid integer");
	}
	
	
	
	@Test
	@Disabled
	public void testNotRequiredAnymore() {
		assertTrue(true);
	}
	
	
	@AfterAll
	public static void afterAll() {
		System.out.println("would run after all testcases..");
	}
	
}
