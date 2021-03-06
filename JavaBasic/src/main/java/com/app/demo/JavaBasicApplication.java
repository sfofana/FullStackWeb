package com.app.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.demo.ex.Car;
import com.app.demo.ex.Condition;
import com.app.demo.ex.Person;

@SpringBootApplication
public class JavaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBasicApplication.class, args);
		
		
		Condition check = new Condition();

		Car car = new Car();
		car.setColor("grey");
		car.setMake("ford");
		car.setModel("escape"); 
		
		Person person = new Person();
		person.setName("Suan Fofana");
		person.setAge(25);
		person.setHeight("5 foot 10 inches");
		person.setCar(car);
		
		Person person2 = new Person();
		person2.setName("Alhaji Fofana");
		person2.setAge(23);
		person2.setHeight("6 foot 4 inches");
		System.out.println(person2.toString());
		
		List<Person> people = new ArrayList<Person>();
		people.add(person);
		people.add(person2);
		people.get(1);
		
		Map<String, Person> personMap = new HashMap<String, Person>();
		personMap.put("number1", person);
		personMap.put("number2", person2);
		personMap.get("number2");
		
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(person);
		personSet.add(person2);

		if(check.isOlderThan(person, 35)) {
			System.out.println("executed");
		}
		
		if(check.isOlderThan(person2, 17)) {
			System.out.println("executed");
		}

	}

}
