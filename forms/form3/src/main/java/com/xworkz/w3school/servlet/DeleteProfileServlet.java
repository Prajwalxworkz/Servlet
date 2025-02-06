package com.xworkz.w3school.servlet;

import com.xworkz.w3school.service.SignUpService;
import com.xworkz.w3school.service.SignUpServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpService service=new SignUpServiceImpl();
        service.deleteProfileById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("deleteMessage","Account deleted successfully!!");

        RequestDispatcher requestDispatcher= req.getRequestDispatcher("deleteResponse.jsp");
        requestDispatcher.forward(req,resp);
    }
}
