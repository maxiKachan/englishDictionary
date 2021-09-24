package com.maximKachan.englishDictionary.model.dao;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:spring/springContext.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/dictionarySmallProject.sql", config = @SqlConfig(encoding = "UTF-8"))
public class WordDaoJdbcTemplateImplTest {

    @Autowired
    private WordService ws;

    @Test
    public void getAllWords() {
        List<Word> words = ws.getWords("");
        assertEquals(5, words.size());
    }

    @Test
    public void getWordsWithPattern(){
        List<Word> words = ws.getWords("o");
        assertEquals(2, words.size());
    }

    @Test
    public void addWord() {
        ws.addWord(new Word("jump", "прыгать"));
    }

    @Test
    public void updateWord() {
        ws.updateWord(6L, new Word("run", "бежать"));
    }

    @Test
    public void deleteWord() {
        ws.deleteWord(6L);
    }
}