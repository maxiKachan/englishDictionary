package com.maximKachan.englishDictionary.model.inMemory;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.model.dao.WordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryWordDao implements WordDao {
    private static final Logger log = LoggerFactory.getLogger(InMemoryWordDao.class);

    private static final List<Word> dictionary;
    static {
        log.info("create in memory dictionary");
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

    @Override
    public List<Word> getWords(String pattern) throws DaoException {
        log.info("getWord imMemoryDao");
        return dictionary;
    }

    @Override
    public Word getWordById(Long id) throws DaoException {
        return null;
    }

    @Override
    public void addWord(Word word) throws DaoException {
        log.info("addWord imMemoryDao");
        dictionary.add(word);
    }

    @Override
    public void updateWord(Long id, Word word) throws DaoException {
        log.info("updateWord imMemoryDao");
        long temp = id;
        dictionary.set((int)temp, word);
    }

    @Override
    public void deleteWord(Long id) throws DaoException {
        log.info("deleteWord imMemoryDao");
        log.info("" + dictionary.size());
        long temp = id;
        dictionary.remove((int) temp);
        log.info("" + dictionary.size());
    }
}
