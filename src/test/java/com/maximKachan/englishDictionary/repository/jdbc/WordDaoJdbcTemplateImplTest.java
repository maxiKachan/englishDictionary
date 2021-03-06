package com.maximKachan.englishDictionary.repository.jdbc;

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
@ActiveProfiles("jdbc")
public class WordDaoJdbcTemplateImplTest {

    @Autowired
    private WordService ws;

    @Test
    public void getAllWords() {
        List<Word> words = ws.getWords("");
        assertMatch(words, mockWords);
        assertEquals(mockWords.size(), words.size());
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
    public void getWordById(){
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
        List<Word> addedMockWord = addedMockWord();
        assertEquals(addedMockWord.size(), addedWord.size());
        assertEquals(mockAddWord().getWord(), addedWord.get(addedWord.size()-1).getWord());
        assertEquals(mockAddWord().getMeaning(), addedWord.get(addedWord.size()-1).getMeaning());
    }

    @Test
    public void addWrongWordEmpty(){
        ws.addWord(new Word("", "прыгать"));
        List<Word> addedWrongWord = ws.getWords("");
        assertEquals(addedWrongWord.size(), mockWords.size());
    }

    @Test
    public void addWrongWordMeaningIsEmpty(){
        ws.addWord(new Word("jump", ""));
        List<Word> addedWrongWord = ws.getWords("");
        assertEquals(addedWrongWord.size(), mockWords.size());
    }

    @Test
    public void addWrongWordWithDigit(){
        ws.addWord(new Word("lump69", "прыгать"));
        List<Word> addedWrongWord = ws.getWords("");
        assertEquals(addedWrongWord.size(), mockWords.size());
    }

    @Test
    public void updateWord() {
        ws.updateWord(5, new Word("run", "бежать"));
        List<Word> updatedWords = ws.getWords("");
        assertEquals(mockUpdateWord().getWord(), updatedWords.get(updatedWords.size()-1).getWord());
        assertEquals(mockUpdateWord().getMeaning(),
                updatedWords.get(updatedWords.size()-1).getMeaning());
    }

    @Test
    public void updateWrongWord(){
        ws.updateWord(5, new Word("", "бежать"));
        List<Word> updatedWords = ws.getWords("");
        assertEquals(mockWords.get(mockWords.size()-1).getWord(), updatedWords.get(updatedWords.size()-1).getWord());
        assertEquals(mockWords.get(mockWords.size()-1).getMeaning(),
                updatedWords.get(updatedWords.size()-1).getMeaning());
    }

    @Test
    public void deleteWord() {
        ws.deleteWord(5);
        List<Word> deletedWords = mockDeleteWords();
        assertEquals(mockDeleteWords().size(), deletedWords.size());
        assertEquals(mockDeleteWords().get(mockDeleteWords().size()-1).getWord(),
                deletedWords.get(deletedWords.size()-1).getWord());
    }
}