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
import java.io.PrintWriter;

@WebServlet(urlPatterns="/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String password= req.getParameter("password");
        SignUpDto dto= new SignUpDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setGender(gender);

        SignUpService service=new SignUpServiceImpl();
        service.validateAndSave(dto);
//
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Hello " + firstName + " " + lastName + " :)");

        req.setAttribute("firstName",firstName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
