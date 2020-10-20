package com.mobiletrain.web;

import com.mobiletrain.service.ContactService;
import com.mobiletrain.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_contact")
public class DeleteCountactServlet extends HttpServlet {
    private ContactService service=new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contactId = request.getParameter("id");
        service.deleteById(contactId);

//        跳转到query_contact
//        优先重定向。
//        使用转发，使用斜线。重定向，不使用
        response.sendRedirect("query_contact");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
