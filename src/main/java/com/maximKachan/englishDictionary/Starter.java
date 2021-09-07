package com.maximKachan.englishDictionary;

import com.maximKachan.englishDictionary.domain.Word;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");

        Word word = (Word) context.getBean("word");
        word.setWord("FirstWord");
        System.out.println(word.getWord());
    }
}
