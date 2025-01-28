package com.xworkz.wikipedia.servlet;

import com.xworkz.wikipedia.dto.CreateAccountDto;
import com.xworkz.wikipedia.service.CreateAccountService;
import com.xworkz.wikipedia.service.CreateAccountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/createAccount")
public class CreateYourAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName= req.getParameter("userName");
        String password= req.getParameter("password");
        String confirmPassword= req.getParameter("password");
        String email= req.getParameter("email");
        String gender= req.getParameter("gender");
        CreateAccountDto dto= new CreateAccountDto();
        dto.setUserName(userName);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setConfirmPassword(confirmPassword);
        dto.setGender(gender);


        CreateAccountService service=new CreateAccountServiceImpl();
        service.validateAndSave(dto);

        req.setAttribute("userName",userName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);

        }
    }

