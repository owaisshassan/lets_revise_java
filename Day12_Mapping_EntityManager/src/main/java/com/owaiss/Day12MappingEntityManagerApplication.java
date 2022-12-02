package com.owaiss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.owaiss.entity.Post;
import com.owaiss.repository.CustomerRepo;

@SpringBootApplication
public class Day12MappingEntityManagerApplication implements CommandLineRunner{

	@Autowired
	CustomerRepo customerDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Day12MappingEntityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Post> posts= customerDao.getPosts(2);
		
	}

}
