package com.owaiss.beans;

import org.springframework.stereotype.Component;

//@Component
public class MarioGame implements GameConsole{

//	public void up() {
//		System.out.println("up");
//	}
//	public void jump() {
//		System.out.println("jump");
//	}
//	public void down() {
//		System.out.println("down");
//	}
	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("left");
		
	}
	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("right");
	}
	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("up");
		
	}
	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("down");
		
	}
	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("jump");
		
	}
	
}
