package com.app.demo.ex;

public class Condition {

	public boolean isOlderThan(Person person, int targetAge) {
		boolean flag = false;
		if(person != null) {
			flag = person.getAge() > targetAge;
		}
		return flag;
	}
}
