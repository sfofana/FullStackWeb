package com.app.demo.service;

import com.app.demo.model.Cat;
import com.app.demo.model.Dog;

public class AnimalService {

	public void makeCatMeowAndWalk() {
		Cat cat = new Cat();
		cat.meow();
		cat.walk();
		cat.running();
	}
	
	public void makeDogBarkAndWalk() {
		Dog dog = new Dog();
		dog.bark();
		dog.walk();
	}
}
