package com.maximKachan.englishDictionary.model.dao;

import com.maximKachan.englishDictionary.domain.Word;

import java.util.List;

public interface WordDao {
    List<Word> getWords();

    void addWord();

    void updateWord();

    void deleteWord();
}