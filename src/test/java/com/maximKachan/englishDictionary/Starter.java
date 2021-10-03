package com.maximKachan.englishDictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Starter {
    private static final Logger log = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        log.info("Start application");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/springContext.xml", "spring/spring-db.xml");

        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        context.close();
    }
}
