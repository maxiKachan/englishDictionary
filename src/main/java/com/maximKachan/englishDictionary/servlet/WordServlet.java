package com.maximKachan.englishDictionary.servlet;

import com.maximKachan.englishDictionary.model.inMemory.DictionaryList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("words", DictionaryList.getAll());
        request.getRequestDispatcher("/words.jsp").forward(request, response);
    }
}
