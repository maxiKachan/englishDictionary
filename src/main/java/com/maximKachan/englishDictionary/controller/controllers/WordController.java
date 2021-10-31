package com.maximKachan.englishDictionary.controller.controllers;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/words")
public class WordController {

    private final WordService service;

    public WordController(WordService wordService) {
        service = wordService;
    }

    @GetMapping
    public String wordsList(Model model) {

        model.addAttribute("words", service.getWords(""));

        return "words";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model){

        model.addAttribute("word", service.getWordById(id));

        return "item";
    }

    @GetMapping("/{id}/edit")
    public String updatePage(@PathVariable int id, Model model){

        model.addAttribute("word", service.getWordById(id));

        return "updateWord";
    }

    @GetMapping("/new")
    public String addPage(){
        return "new";
    }

    @PostMapping
    public String addWord(@ModelAttribute("word") Word word){

        service.addWord(word);

        return "redirect:/words";
    }

    @PatchMapping("/{id}")
    public String updateWord(@PathVariable int id, @ModelAttribute("word") Word word) {

        service.updateWord(id, word);

        return "redirect:/words";
    }

    @DeleteMapping("/{id}")
    private String deleteWord(@PathVariable int id){

        service.deleteWord(id);

        return "redirect:/words";
    }
}
