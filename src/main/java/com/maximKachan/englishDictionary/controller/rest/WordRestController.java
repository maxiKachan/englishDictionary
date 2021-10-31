package com.maximKachan.englishDictionary.controller.rest;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/words", produces = MediaType.APPLICATION_JSON_VALUE)
public class WordRestController {

    private final WordService service;

    public WordRestController(WordService wordService) {
        service = wordService;
    }

    @GetMapping
    public List<Word> wordsList() {
        return service.getWords("");
    }

    @GetMapping("/{id}")
    public Word getById(@PathVariable int id){
        return service.getWordById(id);
    }

    @GetMapping("/{id}/edit")
    public Word updatePage(@PathVariable int id){
        return service.getWordById(id);
    }

    @GetMapping("/new")
    public String addPage(){
        return "new";
    }

    @PostMapping("/words")
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
