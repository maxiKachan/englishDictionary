package com.maximKachan.englishDictionary.controller;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class UserWordController {


    private final WordService service;

    public UserWordController(WordService wordService){
        service = wordService;
    }

    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public String userList(Map<String, Object> map){
        map.put("words", service.getWords(""));
        return "words";
    }

    @RequestMapping(value = {"","/home"} , method = RequestMethod.GET)
    public String startPage(){
        return "home";
    }
}
