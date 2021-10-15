package com.maximKachan.englishDictionary.utils;

import com.maximKachan.englishDictionary.domain.Word;

import java.util.regex.Pattern;

public class CheckWord {

    // return false if the pattern is correct
    public static boolean checkPattern(String word){
        if (word.isEmpty()) return false;
        return !Pattern.matches("[a-z, а-я]+", word);
    }

    // return true if the word is correct
    public static boolean checkWord(Word word){
        if (word.getWord().isEmpty() || word.getMeaning().isEmpty()) return false;
        return !checkPattern(word.getWord()) && !checkPattern(word.getMeaning());
    }
}
