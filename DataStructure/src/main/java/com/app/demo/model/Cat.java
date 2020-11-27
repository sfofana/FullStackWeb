package com.app.demo.model;

public class Cat extends AnimalBase implements Animal {
	
	public void meow() {
		System.out.println("cat meowing");
	}

	@Override
	public String walk() {
		String action = "cat is walking";
		System.out.println(action);
		return action;
	}

	public String walk(String signature) {
		String action = "do something different";
		return action;
	}
}
