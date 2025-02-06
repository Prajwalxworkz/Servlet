package com.xworkz.maxapp.servlet;

import com.xworkz.maxapp.dto.AddProfileDto;
import com.xworkz.maxapp.service.AddProfileService;
import com.xworkz.maxapp.service.AddProfileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getProfile")
public class GetProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id= req.getParameter("id");
        AddProfileService service=new AddProfileServiceImpl();
       AddProfileDto dto= service.getProfileById(Integer.parseInt(id));
       req.setAttribute("userDto",dto);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("userProfileUpdate.jsp");
        requestDispatcher.forward(req,resp);
    }
}
