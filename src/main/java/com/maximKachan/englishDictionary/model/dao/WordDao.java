package com.maximKachan.englishDictionary.model.dao;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;

import java.util.List;

public interface WordDao {
    List<Word> getWords(String pattern) throws DaoException;

    void addWord(Word word) throws DaoException;

    void updateWord(Long id, Word word) throws DaoException;

    void deleteWord(Long id) throws DaoException;
}