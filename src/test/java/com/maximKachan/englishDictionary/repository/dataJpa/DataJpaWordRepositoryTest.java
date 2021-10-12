package com.maximKachan.englishDictionary.repository.dataJpa;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.maximKachan.englishDictionary.utils.WordTestData.*;
import static org.junit.Assert.assertEquals;

@ContextConfiguration({"classpath:spring/springContext.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/dictionarySmallProject.sql", config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles("dataJpa")
public class DataJpaWordRepositoryTest {

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
        assertEquals(addedMockWord().size(), addedWord.size());
        assertMatch(addedMockWord(), addedWord);
    }

    @Test
    public void addEmptyWord(){
        ws.addWord(new Word("", "прыгать"));
        List<Word> addedEmptyWord = ws.getWords("");
        assertEquals(addedEmptyWord.size(), mockWords.size());
        assertMatch(addedEmptyWord, mockWords);
    }

    @Test
    public void addWordMeaningIsEmpty(){
        ws.addWord(new Word("jump", ""));
        List<Word> addedWordMeaningIsEmpty = ws.getWords("");
        assertEquals(addedWordMeaningIsEmpty.size(), mockWords.size());
        assertMatch(addedWordMeaningIsEmpty, mockWords);
    }

    @Test
    public void addWordWithDigit(){
        ws.addWord(new Word("lump69", "прыгать"));
        List<Word> addedWordWithDigit = ws.getWords("");
        assertEquals(addedWordWithDigit.size(), mockWords.size());
        assertMatch(addedWordWithDigit, mockWords);
    }

    @Test
    public void updateWord() {
        ws.updateWord(5, mockUpdateWord());
        List<Word> updatedWords = ws.getWords("");
        assertMatch(updatedWords, mockUpdatedWord());
    }

    @Test
    public void updateWrongWord(){
        ws.updateWord(5, new Word("", "бежать"));
        List<Word> updatedWords = ws.getWords("");
        assertMatch(updatedWords, mockWords);
    }

    @Test
    public void deleteWord() {
        ws.deleteWord(5);
        List<Word> deletedWords = ws.getWords("");
        assertMatch(deletedWords, mockDeleteWords());
    }
}