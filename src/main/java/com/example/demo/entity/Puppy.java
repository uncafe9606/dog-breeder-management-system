package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

//このクラスはpuppyテーブルと対応する
@Entity
@Table(name = "puppy")
public class Puppy {
    //主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //子犬の名前
    @Column(name = "puppy_name")
    private String puppyName;

    //犬種
    private String breed;

    //性別
    private String gender;

    // 毛の色
    private String color;

    // 誕生日
    @Column(name = "birth_date")
    private LocalDate birthDate;

    // 状態（販売中、お迎え済など）
    private String status;

    // ママ犬ID（dogテーブル）
    @ManyToOne
    @JoinColumn(name = "mother_dog_id")
    private Dog motherDog;

    // パパ犬ID（dogテーブル）
    @ManyToOne
    @JoinColumn(name = "father_dog_id")
    private Dog fatherDog;

    //友人犬
    private String friendDog;

    //備考
    private String note;

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

    //子犬名を取得する
    public String getPuppyName() {
        return puppyName;
    }

    //子犬名を設定する
    public void setPuppyName(String puppyName) {
        this.puppyName = puppyName;
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

    //誕生日を取得する
    public LocalDate getBirthDate() {
        return birthDate;
    }

    //誕生日を設定する
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //状態を取得する
    public String getStatus() {
        return status;
    }

    //状態を設定する
    public void setStatus(String status) {
        this.status = status;
    }

    //母犬IDを取得する
    public Dog getMotherDog() {
        return motherDog;
    }

    //母犬IDを設定する
    public void setMotherDog(Dog motherDog) {
        this.motherDog = motherDog;
    }

    //父犬IDを取得する
    public Dog getFatherDog() {
        return fatherDog;
    }

    //父犬IDを設定する
    public void setFatherDog(Dog fatherDog) {
        this.fatherDog = fatherDog;
    }

    //お友達犬を取得する
    public String getFriendDog() {
        return friendDog;
    }

    //お友達犬を設定する
    public void setFriendDog(String friendDog) {
        this.friendDog = friendDog;
    }

    //備考を取得する
    public String getNote() {
        return note;
    }

    //備考を設定する
    public void setNote(String note) {
        this.note = note;
    }
}