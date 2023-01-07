package com.owaiss.model;

public class Person {
	
	private Integer person_id;
	private String name;
	private String email;
	private Integer age;
	private String mobile;
	
	
	public Person() {
		
	}


	public Person(Integer person_id, String name, String email, Integer age, String mobile) {
		super();
		this.person_id = person_id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.mobile = mobile;
	}


	public Integer getPerson_id() {
		return person_id;
	}


	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", name=" + name + ", email=" + email + ", age=" + age + ", mobile="
				+ mobile + "]";
	}
	
	
	
	

}
