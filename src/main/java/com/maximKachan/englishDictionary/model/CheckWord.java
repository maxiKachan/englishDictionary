package com.maximKachan.englishDictionary.model;

import java.nio.CharBuffer;
import java.util.regex.Pattern;

public class CheckWord {

    public static void main(String[] args) {
        System.out.println(checkWord("was,were"));
    }

    public static boolean checkWord(String word){
        return Pattern.matches("[a-z,]+",word);
    }
}
