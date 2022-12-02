package com.owaiss.junit;

public class AppRunner {

	public static void main(String[] args) throws ClassCastException{
		
		Calculator cal=new Calculator();
		
		System.out.println("Multiplication is : "+ cal.multiply(12, 2));
		
		System.out.println("Addition is : "+ cal.addIntegers(12, 2));
	}

}
