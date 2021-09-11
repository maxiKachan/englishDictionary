package com.maximKachan.englishDictionary.model.inMemory;

import java.util.ArrayList;
import java.util.List;

public class DictionaryList {
    private static final List<String> dictionary;
    static {
        dictionary = new ArrayList<>();
        dictionary.add("knowledge");
        dictionary.add("do");
        dictionary.add("say");
        dictionary.add("go");
        dictionary.add("get");
        dictionary.add("make");
        dictionary.add("know");
        dictionary.add("one");
        dictionary.add("time");
        dictionary.add("year");
        dictionary.add("have");
        dictionary.add("think");
    }

    public static List<String> getAll(){
        return dictionary;
    }

}
