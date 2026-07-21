package com.example.demo.repository;

import com.example.demo.entity.Puppy;
import com.example.demo.entity.PuppyCare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//子犬お世話記録を管理するRepository
public interface PuppyCareRepository extends JpaRepository<PuppyCare, Long> {

    //指定した子犬のお世話記録一覧を取得する
    List<PuppyCare> findByPuppyOrderByRecordDateDescRecordTimeDesc(Puppy puppy);

}