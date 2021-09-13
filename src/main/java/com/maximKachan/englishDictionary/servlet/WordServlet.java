package com.maximKachan.englishDictionary.servlet;

import com.maximKachan.englishDictionary.model.inMemory.DictionaryList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WordServlet extends HttpServlet {
    private static final List<String> list = DictionaryList.getAll();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("words", DictionaryList.getAll());
        String sId = request.getParameter("id");
        if (sId != null && !sId.isEmpty()){
            int id = Integer.parseInt(sId);
            list.remove(id);
            System.out.println(id + " removed");
        }
        request.getRequestDispatcher("/words.jsp").forward(request, response);
        System.out.println("get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String word = request.getParameter("word");
        System.out.println(word);
        if (word != null && !word.isEmpty()){
            list.add(word);
            System.out.println("add word");
        }
        response.sendRedirect("words");
    }
}
