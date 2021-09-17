package com.maximKachan.englishDictionary;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.model.inMemory.DictionaryList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Starter {
    private static final Logger log = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) throws DaoException {
        log.info("Start application");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");

        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        DictionaryList dl = context.getBean(DictionaryList.class);
        List<Word> wordList = dl.getWords("");
        Word word = context.getBean(Word.class);
        word.setWord("FirstWord");
        wordList.add(word);
        System.out.println(wordList);
        log.info("Close application");
        context.close();
    }
}
