package com.maximKachan.englishDictionary.controller;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserWordController {


    private final WordService service;

    public UserWordController(WordService wordService) {
        service = wordService;
    }

    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public String wordsList(Map<String, Object> map) {
        map.put("words", service.getWords(""));

        return "words";
    }

    @RequestMapping(value = {"", "/home"}, method = RequestMethod.GET)
    public String startPage() {

        return "home";
    }

    @RequestMapping(value = "/words", method = RequestMethod.POST)
    public String addWord(String word, String meaning) {
        Word newWord = new Word(word, meaning);
        service.addWord(newWord);

        return "redirect:/words";
    }

    @RequestMapping(value = "/words/delete", method = RequestMethod.GET)
    public String deleteWord(@RequestParam Map<String,String> params) {

        if (params.containsKey("id")) {
            String sId = params.get("id");
            if (sId != null) {
                Integer id = Integer.parseInt(sId);
                service.deleteWord(id);
            }
        }

        return "redirect:/words";
    }

    @RequestMapping(value = "/words/update", method = RequestMethod.GET)
    public String updateWord(@RequestParam Map<String,String> params, Map<String, Object> attribute){
        if (params.containsKey("id") && params.containsKey("word") && params.containsKey("meaning")){
            attribute.put("id", params.get("id"));
            attribute.put("word", params.get("word"));
            attribute.put("meaning", params.get("meaning"));
            attribute.put("words", service.getWords(""));
        }

        return "words";
    }
}
