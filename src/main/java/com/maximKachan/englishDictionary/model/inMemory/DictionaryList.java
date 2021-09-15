package com.maximKachan.englishDictionary.model.inMemory;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.model.dao.WordDao;

import java.util.ArrayList;
import java.util.List;

public class DictionaryList implements WordDao {

    private static final List<Word> dictionary;
    static {
        dictionary = new ArrayList<>();
        dictionary.add(new Word("knowledge"));
        dictionary.add(new Word("do"));
        dictionary.add(new Word("say"));
        dictionary.add(new Word("go"));
        dictionary.add(new Word("get"));
        dictionary.add(new Word("make"));
        dictionary.add(new Word("know"));
        dictionary.add(new Word("one"));
        dictionary.add(new Word("time"));
        dictionary.add(new Word("year"));
        dictionary.add(new Word("have"));
        dictionary.add(new Word("think"));
    }

    public static List<Word> getAll(){
        return dictionary;
    }

    @Override
    public List<Word> getWords(String pattern) throws DaoException {
        return null;
    }

    @Override
    public void addWord(Word word) throws DaoException {

    }

    @Override
    public void updateWord(Long id, Word word) throws DaoException {

    }

    @Override
    public void deleteWord(Long id) throws DaoException {

    }
}
