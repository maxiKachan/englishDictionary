package com.maximKachan.englishDictionary.utils;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.model.dao.WordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TestHelper implements WordDao {
    private static final Logger log = LoggerFactory.getLogger(TestHelper.class);

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

    public static void reset(){
        dictionary.clear();
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

    @Override
    public List<Word> getWords(String pattern) throws DaoException {
        return dictionary;
    }

    @Override
    public void addWord(Word word) throws DaoException {
        dictionary.add(word);
    }

    @Override
    public void updateWord(Long id, Word word) throws DaoException {
        long temp = id;
        dictionary.set((int)temp, word);
    }

    @Override
    public void deleteWord(Long id) throws DaoException {
        log.info("" + dictionary.size());
        for (Word word : dictionary){
            System.out.println(word.getWord());
        }
        long temp = id;
        dictionary.remove((int) temp);
        log.info("" + dictionary.size());
    }
}
