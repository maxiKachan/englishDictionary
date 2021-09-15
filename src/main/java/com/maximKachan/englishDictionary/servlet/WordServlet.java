package com.maximKachan.englishDictionary.servlet;

import com.maximKachan.englishDictionary.domain.Word;
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
    private static final List<Word> list = DictionaryList.getAll();
    private static final Logger log = LoggerFactory.getLogger(WordServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("getAll");
        request.setAttribute("words", DictionaryList.getAll());
        String sId = request.getParameter("id");
        if (sId != null && !sId.isEmpty()){
            int id = Integer.parseInt(sId);
            if (id >= 0 && id < list.size()){
                log.info("{} removed", id);
                list.remove(id);
            }
        }
        request.getRequestDispatcher("/words.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String word = request.getParameter("word");
        System.out.println(word);
        if (word != null && !word.isEmpty()){
            log.info("add word");
            list.add(new Word(word));
        }
        response.sendRedirect("words");
    }
}
