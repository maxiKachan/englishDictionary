package com.maximKachan.englishDictionary.service;

import com.maximKachan.englishDictionary.domain.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WordServiceImplSpringTest {

    @Autowired
    private WordServiceImpl wsi;

    @Test
    public void getWordsWithEmptyPattern() {
        List<Word> words = wsi.getWords("");
        assertEquals(12, words.size());
    }

    @Test
    public void getWordsWithWrongPattern(){
        List<Word> words = wsi.getWords("123");
        assertEquals(0, words.size());
    }

    @Test
    public void getWordsWithPattern_g(){
        List<Word> words = wsi.getWords("g");
        System.out.println(words.toString());
        assertEquals(3, words.size());
    }

    @Test
    public void addWord() {
        Word word = new Word("check");
        wsi.addWord(word);
        List<Word> words = wsi.getWords("check");
        assertEquals(1, words.size());
        assertEquals(word.getWord(), words.get(0).getWord());
    }

    @Test
    public void addWrongWord(){
        List<Word> wordsBefore = wsi.getWords("");
        Word word = new Word("qwerty123");
        wsi.addWord(word);
        List<Word> words = wsi.getWords("");
        assertEquals(wordsBefore.size(), words.size());
    }

    @Test
    public void updateWord() {
        Word word = new Word("gone");
        Word getWord = wsi.getWords("go").get(0);
        int id = wsi.getWords("").indexOf(getWord);
        wsi.updateWord((long) id, word);
        assertEquals(word, wsi.getWords("").get(id));
    }

    @Test
    public void updateWrongWord(){
        Word word = new Word("qwerty321");
        Word getWord = wsi.getWords("go").get(0);
        int id = wsi.getWords("").indexOf(getWord);
        wsi.updateWord((long) id, word);
        assertEquals(getWord, wsi.getWords("").get(id));
    }

    @Test
    public void deleteWord() {
        int size = wsi.getWords("").size();
        wsi.deleteWord(2L);
        assertEquals(size-1, wsi.getWords("").size());
    }

}