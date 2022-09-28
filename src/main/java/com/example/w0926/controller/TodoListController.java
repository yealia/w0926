package com.example.w0926.controller;

import com.example.w0926.dao.TodoDAO;
import com.example.w0926.dto.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
        List<TodoDTO> data = TodoDAO.INSTANCE.list(1,100);
        request.setAttribute("list",data);
    }catch (Exception e){
        throw new RuntimeException(e);
    }
    request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp")
            .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
