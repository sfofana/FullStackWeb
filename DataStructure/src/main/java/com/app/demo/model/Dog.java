package com.app.demo.model;

public class Dog implements Animal {

	public void bark() {
		System.out.println("dog barking");
	}

	@Override
	public String walk() {
		String action = "dog is walking";
		System.out.println(action);
		return action;
	}
}
