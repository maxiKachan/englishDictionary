package com.maximKachan.englishDictionary.utils;

import com.maximKachan.englishDictionary.domain.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordTestData {

    public static Word WORD = new Word();
    public static final List<Word> mockWords;

    static {
        mockWords = new ArrayList<>();
        mockWords.add(new Word("go", "идти"));
        mockWords.add(new Word("do", "делать"));
        mockWords.add(new Word("say", "сказать"));
        mockWords.add(new Word("get", "получать"));
        mockWords.add(new Word("make", "делать"));
        WORD.setWordId(3);
        WORD.setWord("say");
        WORD.setMeaningInRussian("сказать");
    }

    public static List<Word> getMockWordsWithPattern(){
        List<Word> selectWords = new ArrayList<>();
        selectWords.add(mockWords.get(0));
        selectWords.add(mockWords.get(1));
        return selectWords;
    }

    public static List<Word> getMockWordsWithWrongPattern(){
        return Collections.emptyList();
    }

    public static List<Word> addMockWord(){
        List<Word> addOneWord = new ArrayList<>(mockWords);
        addOneWord.add(new Word("jump", "прыгать"));
        return addOneWord;
    }

    public static Word mockAddWord(){
        return new Word("jump", "прыгать");
    }

    public static Word mockUpdateWord(){
        return new Word("run", "бежать");
    }

    public static List<Word> mockDeleteWords(){
        List<Word> deletedOneWord = new ArrayList<>(mockWords);
        deletedOneWord.remove(deletedOneWord.size()-1);
        return deletedOneWord;
    }
}
