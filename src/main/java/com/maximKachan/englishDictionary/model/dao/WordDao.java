package com.maximKachan.englishDictionary.model.dao;

import com.maximKachan.englishDictionary.domain.Word;

import java.util.List;

public interface WordDao {
    List<Word> getWords(Long id);

    void addWord(Long id);

    void updateWord(Long id);

    void deleteWord(Long id);
}