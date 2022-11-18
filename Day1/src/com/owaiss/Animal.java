package com.owaiss;

public abstract class Animal {

	private String name;
	
	public abstract void makeNoise();
	public void sleep() {
		System.out.println(name+" is sleeping");
	}
	public abstract void eat();
	
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	public Animal(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
