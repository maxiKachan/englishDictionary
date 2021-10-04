package com.maximKachan.englishDictionary.service;

import com.maximKachan.englishDictionary.domain.Word;

import java.util.List;

public interface WordService {

    List<Word> getWords(String pattern);

    Word getWordById(Integer id);

    void addWord(Word word);

    void updateWord(Integer id, Word word);

    void deleteWord(Integer id);
}
