package com.maximKachan.englishDictionary.repository.jpa;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.maximKachan.englishDictionary.utils.WordTestData.*;
import static org.junit.Assert.*;

@ContextConfiguration({"classpath:spring/springContext.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/dictionarySmallProject.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JpaWordRepositoryTest {

    @Autowired
    private WordService ws;

    @Test
    public void getWords() {
        List<Word> words = ws.getWords("");
        assertEquals(mockWords.size(), words.size());
        assertMatch(words, mockWords);
    }

    @Test
    public void getWordsWithPattern(){
        List<Word> words = ws.getWords("o");
        assertMatch(words, wordsWithPattern_o);
    }

    @Test
    public void getWordsWithWrongPattern(){
        List<Word> words = ws.getWords("0sdf");
        assertEquals(getMockWordsWithWrongPattern().isEmpty(), words.isEmpty());
    }

    @Test
    public void getWordById() {
        Word word = ws.getWordById(3);
        Assert.assertEquals(WORD, word);
    }

    @Test
    public void getWordByWithOverId(){
        Word word = ws.getWordById(7);
        Assert.assertNull(word);
    }

    @Test
    public void addWord() {
        ws.addWord(new Word("jump", "прыгать"));
        List<Word> addedWord = ws.getWords("");
        List<Word> addedMockWord = addMockWord();
        assertEquals(addedMockWord.size(), addedWord.size());
        assertMatch(addedMockWord, addedWord);
    }

    @Test
    public void updateWord() {
        Word word = new Word("gone");
        Word getWord = ws.getWordById(1);
        word.setWordId(getWord.getWordId());
        word.setMeaningInRussian(getWord.getMeaningInRussian());
        ws.updateWord(word.getWordId(), word);
        assertEquals(word, ws.getWordById(word.getWordId()));
    }

    @Test
    public void deleteWord() {
        ws.deleteWord(1);
        assertMatch(mockDeleteWords(), ws.getWords(""));
    }
}