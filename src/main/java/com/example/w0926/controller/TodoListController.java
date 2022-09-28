package com.example.w0926.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet-----------------------");
        request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp").forward(request,response);

    }
    //post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp").forward(request,response);
        //String edit =
        System.out.println("doPost-----------------------");
        System.out.println(request.getParameter("editbtn"));


        //if(result == "수정"){
        //    System.out.println("edit");
        //}
        //System.out.println();
        //System.out.println(request.getParameter("delete"));
    }
    //put
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp").forward(request,response);
    }
    //delete
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp").forward(request,response);
    }
}
