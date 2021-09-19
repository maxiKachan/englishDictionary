package com.maximKachan.englishDictionary.service;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.model.dao.WordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService{

    private static final Logger log = LoggerFactory.getLogger(WordServiceImpl.class);
    private final WordDao wordDao;

    @Autowired
    public WordServiceImpl(WordDao wordDao){
        this.wordDao = wordDao;
    }

    @Override
    public List<Word> getWords(String pattern) {
        log.info("get all service");
        List<Word> words;

        try {
            words = wordDao.getWords(pattern);
        } catch (DaoException e) {
            throw new RuntimeException();
        }

        return words;
    }

    @Override
    public void addWord(Word word) {
        log.info("add word service");
        try {
            wordDao.addWord(word);
        } catch (DaoException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateWord(Long id, Word word) {
        log.info("update word service");
        try {
            wordDao.updateWord(id, word);
        } catch (DaoException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteWord(Long id) {
        log.info("delete word service");
        try {
            wordDao.deleteWord(id);
        } catch (DaoException e) {
            throw new RuntimeException();
        }
    }
}