package com.maximKachan.englishDictionary.service;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.model.dao.WordDao;
import com.maximKachan.englishDictionary.utils.CheckWord;
import com.maximKachan.englishDictionary.utils.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WordServiceImpl implements WordService{

    private static final Logger log = LoggerFactory.getLogger(WordServiceImpl.class);
    private final WordDao wordDao;

    public WordServiceImpl(@Qualifier("wordDaoJdbcImpl") WordDao wordDao){
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

        if(pattern.isEmpty()) {
            return words;
        } else {
            if (CheckWord.checkWord(pattern)){
                return Collections.emptyList();
            }
            return StreamUtils.filterWordBySubstring(pattern, words);
        }
    }

    @Override
    public void addWord(Word word) {
        log.info("add word service");
        if (CheckWord.checkWord(word.getWord())){
            log.info("wrong word");
            return;
        }
        try {
            wordDao.addWord(word);
        } catch (DaoException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateWord(Long id, Word word) {
        log.info("update word service");
        if (CheckWord.checkWord(word.getWord())){
            return;
        }
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
