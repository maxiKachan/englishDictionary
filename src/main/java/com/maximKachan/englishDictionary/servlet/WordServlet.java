package com.maximKachan.englishDictionary.servlet;

import com.maximKachan.englishDictionary.domain.Word;
import com.maximKachan.englishDictionary.exception.DaoException;
import com.maximKachan.englishDictionary.model.dao.WordDao;
import com.maximKachan.englishDictionary.model.inMemory.DictionaryList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WordServlet extends HttpServlet {
    private static final WordDao wordDao = new DictionaryList();
    private static final Logger log = LoggerFactory.getLogger(WordServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("getAll");
        List<Word> words;
        try {
            words = wordDao.getWords("");
        } catch (DaoException e) {
            throw new ServletException();
        }
        String sId = request.getParameter("id");
        String word = request.getParameter("word");
        if (sId != null && !sId.isEmpty()){
            log.info("do get - id not null");
            long id = Integer.parseInt(sId);
            if (word != null && !word.isEmpty()){
                log.info("do get - word not null");
                request.setAttribute("word", word);
                request.setAttribute("id", id+"");
            } else {
                if (id >= 0 && id < words.size()) {
                    log.info("{} removed", id);
                    try {
                        wordDao.deleteWord(id);
                    } catch (DaoException e) {
                        throw new ServletException();
                    }
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
        System.out.println(word);
        if (word != null && !word.isEmpty()){
            if (sId != null && !sId.isEmpty()){
                Long id = Long.parseLong(sId);
                try {
                    wordDao.updateWord(id, new Word(word));
                } catch (DaoException e) {
                    throw new ServletException();
                }
            } else {
                log.info("add word");
                try {
                    wordDao.addWord(new Word(word));
                } catch (DaoException e) {
                    throw new ServletException();
                }
            }
        }
        response.sendRedirect("words");
    }
}
