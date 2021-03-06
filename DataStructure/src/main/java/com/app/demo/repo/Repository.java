package com.app.demo.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.demo.model.Laptop;

public class Repository {

	Laptop l1 = new Laptop("dell","1212146");
	Laptop l2 = new Laptop("hp","25535358");
	Laptop l3 = new Laptop("lenovo","8886867");
	Laptop l4 = new Laptop("mac","11424358");
	Laptop l5 = new Laptop("asus","23538388");
	
	public List<Laptop> getListLaptops(){
		List<Laptop> laptops = new ArrayList<Laptop>();
		laptops.add(l1);
		laptops.add(l2);
		laptops.add(l3);
		laptops.add(l4);
		laptops.add(l5);
		return laptops;
	}
	
	public Map<String, Laptop> getMappedLaptops(){
		Map<String, Laptop> lapmap = new HashMap<String, Laptop>();
		lapmap.put("lap1", l1);
		lapmap.put("lap2", l2);
		lapmap.put("lap3", l3);
		lapmap.put("lap4", l4);
		lapmap.put("lap5", l5);
		return lapmap;
	}
}
