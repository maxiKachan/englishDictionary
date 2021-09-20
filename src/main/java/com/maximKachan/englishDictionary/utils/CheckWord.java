package com.maximKachan.englishDictionary.utils;

import java.util.regex.Pattern;

public class CheckWord {

    public static boolean checkWord(String word){
        return !Pattern.matches("[a-z, ]+", word);
    }
}
