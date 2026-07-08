package com.example.demo.controller;

import com.example.demo.repository.DogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//dog画面を管理するController
@Controller
public class DogController {

    //DogRepositoryを使えるようにする
    private final DogRepository dogRepository;

    //DogRepositoryを受け取る
    public DogController(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    //親犬一覧画面を表示する
    @GetMapping("/dogs")
    public String dogList(Model model) {

        //DBから親犬一覧を取得する
        model.addAttribute("dogs", dogRepository.findAll());

        //dog-list.htmlを表示する
        return "dog-list";
    }
}