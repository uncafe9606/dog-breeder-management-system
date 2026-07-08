package com.example.demo.repository;

import com.example.demo.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

//Dogテーブルを操作するRepository
public interface DogRepository extends JpaRepository<Dog, Long> {

}