package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Animal;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, String> {

}
