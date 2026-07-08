package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Puppy;

//Puppyテーブルを操作するRepository
public interface PuppyRepository extends JpaRepository<Puppy, Long> {

}