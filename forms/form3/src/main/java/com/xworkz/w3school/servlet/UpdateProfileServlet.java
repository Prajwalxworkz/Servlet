package com.xworkz.w3school.servlet;

import com.xworkz.w3school.dto.SignUpDto;
import com.xworkz.w3school.service.SignUpService;
import com.xworkz.w3school.service.SignUpServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateProfile")
public class UpdateProfileServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpDto dto=new SignUpDto();
        dto.setId(Integer.parseInt(req.getParameter("id")));
        dto.setFirstName(req.getParameter("firstName"));
        dto.setLastName(req.getParameter("lastName"));
        dto.setEmail(req.getParameter("email"));
        dto.setPassword(req.getParameter("password"));
        dto.setGender(req.getParameter("gender"));

        SignUpService service=new SignUpServiceImpl();
        service.updateProfile(dto);
        req.setAttribute("updateMessage","Account updated successfully!!");

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
