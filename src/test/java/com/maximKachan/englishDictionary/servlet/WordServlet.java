package com.maximKachan.englishDictionary.servlet;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.repository.inMemory.InMemoryWordDao;
import com.maximKachan.englishDictionary.service.WordService;
import com.maximKachan.englishDictionary.service.WordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WordServlet extends HttpServlet {
    private  WordService wordService;
    private static final Logger log = LoggerFactory.getLogger(WordServlet.class);

    @Override
    public void init() throws ServletException {
        wordService = new WordServiceImpl(new InMemoryWordDao());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("getAll");
        List<Word> words = wordService.getWords("");
        String sId = request.getParameter("id");
        String word = request.getParameter("word");
        if (sId != null && !sId.isEmpty()){
            log.info("do get - id not null");
            int id = Integer.parseInt(sId);
            if (word != null && !word.isEmpty()){
                log.info("do get - word not null");
                request.setAttribute("word", word);
                request.setAttribute("id", id+"");
            } else {
                if (id >= 0 && id < words.size()) {
                    log.info("{} removed", id);
                    wordService.deleteWord(id);
                }
            }
        }
        request.setAttribute("words", words);
        request.getRequestDispatcher("/words.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String word = request.getParameter("word");
        String sId = request.getParameter("id");
        if (word != null && !word.isEmpty()){
            if (sId != null && !sId.isEmpty()){
                Integer id = Integer.parseInt(sId);
                wordService.updateWord(id, new Word(word));
            } else {
                log.info("add word");
                wordService.addWord(new Word(word));
            }
        }
        response.sendRedirect("words");
    }
}
