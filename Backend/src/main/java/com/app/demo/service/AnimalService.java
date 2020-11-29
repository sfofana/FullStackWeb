package com.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Animal;
import com.app.demo.repository.AnimalRepo;

@Service
public class AnimalService {

	@Autowired
	AnimalRepo repo;
	
	/** Create Animal logic
	 * @param animal
	 * @return
	 */
	public Animal addAnimal(Animal animal) {
		return repo.save(animal);
	}
	
	/** Read Animal logic
	 * @param animal
	 * @return
	 */
	public Animal getAnimal(String name) {
		return repo.findById(name).get();
	}
	
	/** Update Animal logic
	 * @param animal
	 * @return
	 */
	public Animal updateAnimal(Animal animal) {
		return repo.save(animal);
	}
	
	/** Delete Animal logic
	 * @param animal
	 */
	public void deleteAnimal(String name) {
		Animal animal = new Animal();
		animal.setName(name);
		repo.delete(animal);
	}
	
	public List<Animal> getAllAnimals() {
		return repo.findAll();
	}
}
