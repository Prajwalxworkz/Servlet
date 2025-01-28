package com.xworkz.app.servlet;

import com.xworkz.app.dto.AddProfileDto;
import com.xworkz.app.service.AddProfileService;
import com.xworkz.app.service.AddProfileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

        AddProfileDto dto= new AddProfileDto();
        dto.setUserName(userName);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setConfirmPassword(confirmPassword);
        dto.setGender(gender);

        AddProfileService service=new AddProfileServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter=resp.getWriter();
//        printWriter.write("Thank you "+userName+" for registering!!!");

        req.setAttribute("firstName",userName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
