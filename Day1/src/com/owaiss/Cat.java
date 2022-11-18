package com.owaiss;

public class Cat extends Animal{

	private String nickName;
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Cat(String name, String nickName) {
		super(name);
		this.nickName = nickName;
	}


	@Override
	public void makeNoise() {
		// TODO Auto-generated method stub
		System.out.println("Cat is meowing");
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Cat is eating");
	}

	public  void jump() {
		System.out.println("Cat is  jumping");
	}


	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	
	
	
	

}
