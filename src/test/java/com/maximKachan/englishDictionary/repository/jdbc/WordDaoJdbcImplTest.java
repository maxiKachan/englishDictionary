package com.maximKachan.englishDictionary.repository.jdbc;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("classpath:spring/springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WordDaoJdbcImplTest {

    @Autowired
    private WordService ws;

    @Ignore
    @Test
    public void getWords() {
        List<Word> words = ws.getWords("");
        assertEquals(5, words.size());
    }

    @Ignore
    @Test
    public void addWord() {
        Word word = new Word();
        word.setWord("run");
        word.setMeaning("бежать");
        ws.addWord(word);
        List<Word> words = ws.getWords("");
        assertEquals(word.getWord(), words.get(words.size()-1).getWord());
    }

    @Ignore
    @Test
    public void updateWord() {
        Word word = new Word();
        word.setWord("jump");
        word.setMeaning("прыгать или скакать");
        ws.updateWord(6, word);
        List<Word> words = ws.getWords("");
        assertEquals(word.getWord(), words.get(words.size()-1).getWord());
    }

    @Ignore
    @Test
    public void deleteWord() {
        List<Word> words = ws.getWords("");
        int id = words.size()-1;
        ws.deleteWord(id);
        List<Word> updatedWords = ws.getWords("");
        assertEquals(words.size()-1, updatedWords.size());
    }
}