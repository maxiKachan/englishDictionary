package com.maximKachan.englishDictionary.repository.jpa;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.maximKachan.englishDictionary.utils.WordTestData.mockWords;
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
        System.out.println(words);
        assertEquals(mockWords.size(), words.size());
    }

    @Test
    public void getWordById() {
    }

    @Test
    public void addWord() {
    }

    @Test
    public void updateWord() {
    }

    @Test
    public void deleteWord() {
    }
}