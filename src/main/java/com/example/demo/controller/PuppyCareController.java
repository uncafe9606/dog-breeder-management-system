package com.example.demo.controller;

import com.example.demo.entity.Puppy;
import com.example.demo.entity.PuppyCare;
import com.example.demo.repository.PuppyCareRepository;
import com.example.demo.repository.PuppyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//子犬お世話記録画面を管理するController
@Controller
public class PuppyCareController {

    //PuppyCareRepositoryを使えるようにする
    @Autowired
    private PuppyCareRepository puppyCareRepository;

    //PuppyRepositoryを使えるようにする
    @Autowired
    private PuppyRepository puppyRepository;

    //お世話記録画面を表示する
    @GetMapping("/puppies/{id}/care")
    public String careList(@PathVariable Long id, Model model) {

        //子犬情報を取得する
        Optional<Puppy> puppy = puppyRepository.findById(id);

        //存在しない場合
        if (puppy.isEmpty()) {
            return "redirect:/puppies";
        }

        //子犬情報を画面へ渡す
        model.addAttribute("puppy", puppy.get());

        //お世話記録一覧を画面へ渡す
        model.addAttribute(
                "careList",
                puppyCareRepository.findByPuppyOrderByRecordDateDescRecordTimeDesc(
                        puppy.get()));

        return "puppy-care-list";
    }

    //お世話記録登録画面を表示する
    @GetMapping("/puppies/{id}/care/new")
    public String newCare(@PathVariable Long id, Model model) {

        //子犬情報取得
        Optional<Puppy> puppy = puppyRepository.findById(id);

        if (puppy.isEmpty()) {
            return "redirect:/puppies";
        }

        PuppyCare care = new PuppyCare();

        //どの子犬の記録か設定
        care.setPuppy(puppy.get());

        model.addAttribute("puppy", puppy.get());
        model.addAttribute("care", care);

        return "puppy-care-form";
    }

    //お世話記録を登録する
    @PostMapping("/puppies/care")
    public String saveCare(@ModelAttribute PuppyCare care) {

        //DBへ保存
        puppyCareRepository.save(care);

        //一覧画面へ戻る
        return "redirect:/puppies/" +
                care.getPuppy().getId() +
                "/care";
    }

    //お世話記録編集画面を表示する
@GetMapping("/puppies/care/edit/{id}")
public String editCare(@PathVariable Long id, Model model) {

    //IDからお世話記録を取得する
    Optional<PuppyCare> care = puppyCareRepository.findById(id);

    //記録が存在する場合
    if (care.isPresent()) {

        //お世話記録を画面へ渡す
        model.addAttribute("care", care.get());

        //子犬情報を画面へ渡す
        model.addAttribute("puppy", care.get().getPuppy());

        //登録画面を編集画面として使用する
        return "puppy-care-form";
    }

    //記録が存在しない場合は子犬一覧へ戻る
    return "redirect:/puppies";
    }

    //お世話記録を編集して保存する
    @PostMapping("/puppies/care/edit")
    public String updateCare(@ModelAttribute PuppyCare care) {

        //DBの既存データを更新する
        puppyCareRepository.save(care);

        //編集した子犬のお世話記録一覧へ戻る
        return "redirect:/puppies/" +
                care.getPuppy().getId() +
                "/care";
    }

    //お世話記録を削除する
    @GetMapping("/puppies/care/delete/{id}")
    public String deleteCare(@PathVariable Long id) {

        //削除対象のお世話記録を取得する
        Optional<PuppyCare> care = puppyCareRepository.findById(id);

        //記録が存在する場合
        if (care.isPresent()) {

            //子犬IDを取得する
            Long puppyId = care.get().getPuppy().getId();

            //お世話記録を削除する
            puppyCareRepository.deleteById(id);

            //削除した子犬のお世話記録一覧へ戻る
            return "redirect:/puppies/" + puppyId + "/care";
        }

        //記録が存在しない場合は子犬一覧へ戻る
        return "redirect:/puppies";
    }
    
}