package com.app.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, String> {

}
