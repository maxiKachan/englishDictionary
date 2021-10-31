package com.maximKachan.englishDictionary.utils.json;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.utils.WordTestData;
import org.junit.Test;

import java.util.List;

import static com.maximKachan.englishDictionary.utils.WordTestData.*;
import static org.junit.Assert.*;

public class JsonUtilTest {

    @Test
    public void readValues() {
        String json = JsonUtil.writeValue(mockWords);
        System.out.println(json);
        List<Word> words = JsonUtil.readValues(json, Word.class);
        assertMatch(words, mockWords);
    }

    @Test
    public void readValue() {
        String json = JsonUtil.writeValue(WORD);
        System.out.println(json);
        Word word = JsonUtil.readValue(json, Word.class);
        assertEquals(WORD, word);
    }
}