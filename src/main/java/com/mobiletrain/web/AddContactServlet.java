package com.mobiletrain.web;

import com.mobiletrain.domain.Contact;
import com.mobiletrain.service.ContactService;
import com.mobiletrain.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/add_contact")
public class AddContactServlet extends HttpServlet {
    private ContactService service=new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Contact contact = new Contact();
        try {
            BeanUtils.populate(contact,parameterMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        service.add(contact);
        response.sendRedirect("query_contact");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
