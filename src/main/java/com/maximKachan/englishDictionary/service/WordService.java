package com.maximKachan.englishDictionary.service;

import com.maximKachan.englishDictionary.domain.Word;

import java.util.List;

public interface WordService {

    List<Word> getWords(String pattern);

    void addWord(Word word);

    void updateWord(Long id, Word word);

    void deleteWord(Long id);
}
