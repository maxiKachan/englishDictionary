package com.maximKachan.englishDictionary.model.dao;

import com.maximKachan.englishDictionary.domain.TypeOfWord;
import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordDaoImplTest {

    @Test
    public void getAllWords() {
        WordDao dao = new WordDaoImpl();
        List<Word> words = new ArrayList<>();
        try {
            words = dao.getWords("");
        } catch (DaoException ex){
            ex.printStackTrace(System.out);
        }
        words.forEach(System.out::println);
        System.out.println(words.size());
        Assert.assertFalse(words.isEmpty());
    }

    @Test
    public void getWordsByPattern() {
        WordDao dao = new WordDaoImpl();
        List<Word> words = new ArrayList<>();
        try {
            words = dao.getWords("a");
        } catch (DaoException ex){
            ex.printStackTrace(System.out);
        }
        words.forEach(System.out::println);
        System.out.println(words.size());
        Assert.assertFalse(words.isEmpty());
    }

    @Test
    public void addWord() {
        Word word = new Word();
        word.setWord("afford");
        word.setType(TypeOfWord.VERB);
        word.setMeaningInRussian("позволить себе");

        WordDao dao = new WordDaoImpl();

        try {
            dao.addWord(word);
        } catch (DaoException ex){
            ex.printStackTrace(System.out);
        }
    }

    @Test
    public void updateWord() {
        Word word = new Word();
        word.setWord("afford");
        word.setType(TypeOfWord.VERB);
        word.setMeaningInRussian("позволить себе что-то");

        WordDao dao = new WordDaoImpl();

        try {
            dao.updateWord(18L ,word);
        } catch (DaoException ex){
            ex.printStackTrace(System.out);
        }
    }

    @Test
    public void deleteWord() {
    }
}