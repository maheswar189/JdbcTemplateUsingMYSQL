package com.example.springbootWithMysqlConn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootWithMysqlConnApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootWithMysqlConnApplication.class, args);
		
		/** This is one way to test*/
		/*AlienRepository alienRepo = context.getBean(AlienRepository.class);
		Alien alien = context.getBean(Alien.class);
		alien.setId("1");
		alien.setName("Mahesh");
		alien.setTechnology("Java");
		alienRepo.saveObject(alien);
		
		Alien alien2 = context.getBean(Alien.class);
		alien2.setId("2");
		alien2.setName("Charna");
		alien2.setTechnology("Java1");
		
		alienRepo.saveObject(alien2);
		
		if (alien2 == alien) {
			System.out.println("Both objects are same.....");
		}
		
		List<Alien> alienList = alienRepo.getAlienList();
		System.out.println("Alient List::"+alienList);*/
	}

}
