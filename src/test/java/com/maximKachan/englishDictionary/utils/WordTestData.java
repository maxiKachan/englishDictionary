package com.maximKachan.englishDictionary.utils;

import com.maximKachan.englishDictionary.domain.Word;
import org.assertj.core.api.Assertions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class WordTestData {

    public static final List<Word> mockWords;
    public static final List<Word> wordsWithPattern_o;
    public static Word WORD;
    static {
        mockWords = new ArrayList<>();
        wordsWithPattern_o = new ArrayList<>();
        mockWords.add(new Word(1, "go", "идти"));
        mockWords.add(new Word(2, "do", "делать"));
        mockWords.add(new Word(3, "say", "сказать"));
        mockWords.add(new Word(4, "get", "получать"));
        mockWords.add(new Word(5, "make", "делать"));
        wordsWithPattern_o.add(mockWords.get(0));
        wordsWithPattern_o.add(mockWords.get(1));
        WORD = mockWords.get(2);
    }

    public static void assertMatch(Iterable<Word> actual, Iterable<Word> expected){
        Assertions.assertThat(actual).usingDefaultElementComparator().isEqualTo(expected);
    }

    public static void assertMatch(Word actual, Word expected){
        assertEquals(actual, expected);
    }

    public static List<Word> getMockWordsWithWrongPattern(){
        return Collections.emptyList();
    }

    public static List<Word> addedMockWord(){
        List<Word> addOneWord = new ArrayList<>(mockWords);
        addOneWord.add(new Word(6,"jump", "прыгать"));
        return addOneWord;
    }

    public static Word mockAddWord(){
        return new Word("jump", "прыгать");
    }

    public static Word mockUpdateWord(){
        return new Word(5,"run", "бежать");
    }

    public static List<Word> mockUpdatedWord(){
        List<Word> updatedWords = new ArrayList<>(mockWords);
        updatedWords.set(4,mockUpdateWord());
        return updatedWords;
    }

    public static List<Word> mockDeleteWords(){
        List<Word> deletedOneWord = new ArrayList<>(mockWords);
        deletedOneWord.remove(4);
        return deletedOneWord;
    }

    public static ResultMatcher contentJson(Word ... expected){
        List<Word> words = new ArrayList<>();
        Collections.addAll(words, expected);
        return result -> assertMatch(TestUtil.readListFromJsonMvcResult(result, Word.class), words);
    }

    public static ResultMatcher contentJson(Word expected){
        return result -> assertMatch(TestUtil.readFromJsonMvcResult(result, Word.class), expected);
    }
}
