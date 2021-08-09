package com.maximKachan.englishDictionary.model.dao;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;

import java.util.List;

public interface WordDao {
    List<Word> getWords() throws DaoException;

    List<Word> getWordsByPattern(String pattern) throws DaoException;

    Word getWordByName(String name) throws DaoException;

    void addWord(Long id);

    void updateWord(Long id);

    void deleteWord(Long id);
}