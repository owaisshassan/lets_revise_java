package com.owaiss;

public class Dog extends Animal{
	
	private String breed;
	

	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Dog(String name, String breed) {
		super(name);
		this.breed=breed;
	}



	@Override
	public void makeNoise() {
		System.out.println("Dog is barking");
	}

	@Override
	public void eat() {
		System.out.println("Dog is eating");
	}
	
	public void play() {
		System.out.println("Dog is playing");
	}
	
	  

		public String getBreed() {
			return breed;
		}


		public void setBreed(String breed) {
			this.breed = breed;
		}
	

}
