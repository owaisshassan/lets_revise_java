package com.owaiss.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.owaiss.model.Gym;
import com.owaiss.model.Person;

@Service
public class PersonService {
	
	@Autowired(required = false)
	private Map<Person, Gym> theMap;
	
	@Autowired(required = false)
	private List<Person> theList;
	
	@Value("${appName}")
	private String appName;
	
	
	public void printMap() {
		System.out.println("Printing the Map : ");
		System.out.println("\n");
		
		for(Entry<Person, Gym> entry : theMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue() );
		}
	}
	
	
	public void printList() {
		Collections.sort(theList, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				// TODO Auto-generated method stub
				return p1.getAge() - p2.getAge();
			}
		});
		System.out.println("\n");
		System.out.println("Printing sorted Person list according to age : ");
		System.out.println("\n");
		theList.forEach(p -> System.out.println(p));
	}

	public void printAppName() {
		System.out.println("\n");
		System.out.println("Printing the appName : ");
		System.out.println("\n");
		System.out.println(appName);
	}

}
