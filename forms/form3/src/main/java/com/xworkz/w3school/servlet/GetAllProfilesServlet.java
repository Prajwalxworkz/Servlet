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
import java.util.List;

@WebServlet(urlPatterns = "/getAllProfiles")
public class GetAllProfilesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpService service=new SignUpServiceImpl();
        List<SignUpDto> dtoList= service.getAllProfiles();

        req.setAttribute("dtoList", dtoList);

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("getAllProfiles.jsp");
        requestDispatcher.forward(req,resp);
    }
}
