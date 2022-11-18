package com.owaiss;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a1=new Dog();
		a1.setName("Dog");
		a1.makeNoise();
		a1.sleep();
		a1.eat();
		
		System.out.println("======================");
		
		Dog d=new Dog();
		d.play();
		
		System.out.println("======================");
		
		Animal a2=new Cat();
		a2.setName("Cat");
		a2.makeNoise();
		a2.sleep();
		a2.eat();
		
		System.out.println("======================");

		Cat c=new Cat();
		c.jump();
	}

}
