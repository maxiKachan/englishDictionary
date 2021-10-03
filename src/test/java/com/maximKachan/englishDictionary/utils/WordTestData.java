package com.maximKachan.englishDictionary.utils;

import com.maximKachan.englishDictionary.domain.Word;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordTestData {

    public static final List<Word> mockWords;
    public static Word WORD;
    static {
        mockWords = new ArrayList<>();
        mockWords.add(new Word(1, "go", "идти"));
        mockWords.add(new Word(2, "do", "делать"));
        mockWords.add(new Word(3, "say", "сказать"));
        mockWords.add(new Word(4, "get", "получать"));
        mockWords.add(new Word(5, "make", "делать"));
        WORD = mockWords.get(2);
    }

    public static List<Word> getMockWordsWithPattern(){
        List<Word> selectWords = new ArrayList<>();
        selectWords.add(mockWords.get(0));
        selectWords.add(mockWords.get(1));
        return selectWords;
    }

    public static void assertMatch(Iterable<Word> actual, Iterable<Word> expected){
        Assertions.assertThat(actual).usingDefaultElementComparator().isEqualTo(expected);
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
