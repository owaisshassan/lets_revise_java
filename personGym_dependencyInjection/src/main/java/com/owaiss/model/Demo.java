package com.owaiss.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.owaiss.config.AppConfig;
import com.owaiss.service.PersonService;

public class Demo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext actx=new AnnotationConfigApplicationContext(AppConfig.class);
		PersonService person=actx.getBean("personService",PersonService.class);
		person.printMap();
		person.printList();
		person.printAppName();
		
		((AnnotationConfigApplicationContext)actx).close();
	}
	
}
