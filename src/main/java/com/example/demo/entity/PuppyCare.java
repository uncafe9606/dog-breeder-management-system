package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

//このクラスはpuppy_careテーブルと対応する
@Entity
@Table(name = "puppy_care")
public class PuppyCare {

    //主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //子犬（puppyテーブルと紐付ける）
    @ManyToOne
    @JoinColumn(name = "puppy_id")
    private Puppy puppy;

    //記録日
    @Column(name = "record_date")
    private LocalDate recordDate;

    //記録時間
    @Column(name = "record_time")
    private LocalTime recordTime;

    //ご飯の量（g）
    @Column(name = "food_amount")
    private Integer foodAmount;

    //体重（g）
    private Integer weight;

    //便の様子
    @Column(name = "stool_condition")
    private String stoolCondition;

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

    //子犬情報を取得する
    public Puppy getPuppy() {
        return puppy;
    }

    //子犬情報を設定する
    public void setPuppy(Puppy puppy) {
        this.puppy = puppy;
    }

    //記録日を取得する
    public LocalDate getRecordDate() {
        return recordDate;
    }

    //記録日を設定する
    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    //記録時間を取得する
    public LocalTime getRecordTime() {
        return recordTime;
    }

    //記録時間を設定する
    public void setRecordTime(LocalTime recordTime) {
        this.recordTime = recordTime;
    }

    //ご飯の量を取得する
    public Integer getFoodAmount() {
        return foodAmount;
    }

    //ご飯の量を設定する
    public void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
    }

    //体重を取得する
    public Integer getWeight() {
        return weight;
    }

    //体重を設定する
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    //便の様子を取得する
    public String getStoolCondition() {
        return stoolCondition;
    }

    //便の様子を設定する
    public void setStoolCondition(String stoolCondition) {
        this.stoolCondition = stoolCondition;
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