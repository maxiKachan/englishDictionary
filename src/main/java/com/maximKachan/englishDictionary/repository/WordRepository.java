package com.maximKachan.englishDictionary.repository;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;

import java.util.List;

public interface WordRepository {
    List<Word> getWords(String pattern) throws DaoException;

    Word getWordById(Integer id) throws DaoException;

    void addWord(Word word) throws DaoException;

    void updateWord(Integer id, Word word) throws DaoException;

    void deleteWord(Integer id) throws DaoException;
}