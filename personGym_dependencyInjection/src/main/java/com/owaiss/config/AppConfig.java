package com.owaiss.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.owaiss.model.Gym;
import com.owaiss.model.Person;

@Configuration
@ComponentScan(basePackages = "com.owaiss")
@PropertySource("application.properties")
public class AppConfig {
	
	@Bean
	public Map<Person, Gym> getMap(){
		Map<Person, Gym> map=new HashMap<>();
		
		map.put(new Person(1, "owaiss", "owaiss@gmail.com", 22, "7006312783"), new Gym(4, "spartans gym", 600));
		map.put(new Person(2, "ovee", "ovee@gmail", 23, "3456782934"), new Gym(5, "beasts gym", 800));
		map.put(new Person(3, "bhat", "bhat@gmail", 20, "1234567890"), new Gym(6, "hulks gym", 740));
		return map;
	}
	
	@Bean
	public List<Person> getPersons(){
		List<Person> list=new ArrayList<>();
		
		list.add(new Person(1, "owaiss", "owaiss@gmail.com", 22, "7006312783"));
		list.add(new Person(2, "ovee", "ovee@gmail", 23, "3456782934"));
		list.add(new Person(3, "bhat", "bhat@gmail", 20, "1234567890"));
		list.add(new Person(4, "hassan", "hassan@gmail", 19, "434728239"));
		list.add(new Person(5, "owais", "owais@gmail", 20, "7262493"));
		return list;
	}

}
