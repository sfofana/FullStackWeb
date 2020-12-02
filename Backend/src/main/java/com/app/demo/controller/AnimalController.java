package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.Animal;
import com.app.demo.service.AnimalService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class AnimalController {

	@Autowired
	AnimalService service;
	
	@PostMapping("create")
	public Animal addAnimal(@RequestBody Animal animal) {
		return service.addAnimal(animal);
	}
	
	@GetMapping("read/{name}")
	public Animal getAnimal(@PathVariable("name") String name) {
		return service.getAnimal(name);
	}
	
	@PutMapping("update")
	public Animal updateAnimal(@RequestBody Animal animal) {
		return service.updateAnimal(animal);
	}
	
	@DeleteMapping("delete/{name}")
	public void deleteAnimal(@PathVariable("name") String name) {
		service.deleteAnimal(name);
	}
	
	@GetMapping("all")
	public List<Animal> getAllAnimals() {
		return service.getAllAnimals();
	}
	
}
