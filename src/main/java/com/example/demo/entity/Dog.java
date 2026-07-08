package com.example.demo.entity;
import jakarta.persistence.*;

//このクラスはdogテーブルと対応する
@Entity
@Table(name = "dog")
public class Dog {
    //主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //成犬の名前
    private String dogName;
    //犬種
    private String breed;
    //性別
    private String gender;
    //毛の色
    private String color;

    //------------------
    //取得と設定
    //------------------

    //IDを取得する
    public Long getId() {
        return id;
    }

    //IDを設定する
    public void setId(Long id) {
        this.id = id;
    }

    //犬名(成犬)を取得する
    public String getDogName() {
        return dogName;
    }

    //犬名(成犬)を設定する
    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    //犬種を取得する
    public String getBreed() {
        return breed;
    }

    //犬種を設定する
    public void setBreed(String breed) {
        this.breed = breed;
    }

    //性別を取得する
    public String getGender() {
        return gender;
    }

    //性別を設定する
    public void setGender(String gender) {
        this.gender = gender;
    }

    //毛色を取得する
    public String getColor() {
        return color;
    }

    //毛色を設定する
    public void setColor(String color) {
        this.color = color;
    }
}