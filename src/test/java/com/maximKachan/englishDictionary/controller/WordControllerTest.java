package com.maximKachan.englishDictionary.controller;

import com.maximKachan.englishDictionary.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration({
        "classpath:spring/springContext.xml",
        "classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-db.xml"
})
@ActiveProfiles("dataJpa")
@WebAppConfiguration
@RunWith(SpringRunner.class)
@Transactional
public class WordControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    private WordService ws;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @PostConstruct
    void postConstruct(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void wordsList() throws Exception {
        mockMvc.perform(get("/words"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("words"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/words.jsp"))
                .andExpect(model().attribute("words", hasSize(5)));
    }

    @Test
    public void startPage() {
    }

    @Test
    public void addWord() {
    }
}