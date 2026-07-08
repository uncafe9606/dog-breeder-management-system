package com.example.demo.controller;

import com.example.demo.entity.Puppy;
import com.example.demo.repository.PuppyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

//子犬画面を管理するController
@Controller
public class PuppyController {

    //PuppyRepositoryを使えるようにする
    @Autowired
    private PuppyRepository puppyRepository;

    //子犬一覧画面を表示する
    @GetMapping("/puppies")
    public String puppyList(Model model) {

        //DBから子犬一覧を取得する
        List<Puppy> puppyList = puppyRepository.findAll();

        //HTMLへデータを渡す
        model.addAttribute("puppyList", puppyList);

        //puppy-list.htmlを表示する
        return "puppy-list";
    }

     //子犬登録画面を表示する
    @GetMapping("/puppies/new")
    public String showPuppyForm(Model model) {

        // 空の子犬オブジェクトを画面へ渡す
        model.addAttribute("puppy", new Puppy());
        
        // 子犬登録画面を表示する
        return "puppy-form";
    }

    // 子犬を登録する
    @PostMapping("/puppies")
    public String savePuppy(@ModelAttribute Puppy puppy) {

        // DBへ保存
        puppyRepository.save(puppy);

        // 一覧画面へ戻る
        return "redirect:/puppies";
    }

    //子犬編集画面を表示する
    @GetMapping("/puppies/edit/{id}")
    public String editPuppy(@PathVariable Long id, Model model) {

        //IDから子犬情報を取得する
        Optional<Puppy> puppy = puppyRepository.findById(id);

    //子犬が存在する場合
        if (puppy.isPresent()) {

            //取得した子犬情報を画面へ渡す
            model.addAttribute("puppy", puppy.get());

            //子犬登録画面を表示する（編集用）
            return "puppy-form";
        }

    //データが存在しない場合は一覧画面へ戻る
        return "redirect:/puppies";
    }

    //子犬を削除する
    @GetMapping("/puppies/delete/{id}")
    public String deletePuppy(@PathVariable Long id) {

        //IDを指定して子犬を削除する
        puppyRepository.deleteById(id);

        //一覧画面へ戻る
        return "redirect:/puppies";
    }
}