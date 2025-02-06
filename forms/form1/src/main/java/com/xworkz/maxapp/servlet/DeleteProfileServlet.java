package com.xworkz.maxapp.servlet;

import com.xworkz.maxapp.service.AddProfileService;
import com.xworkz.maxapp.service.AddProfileServiceImpl;

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
        String id= req.getParameter("id");
        AddProfileService service=new AddProfileServiceImpl();
        service.deleteProfileById(Integer.parseInt(id));

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("getAllProfiles");
        requestDispatcher.forward(req,resp);
    }
}
