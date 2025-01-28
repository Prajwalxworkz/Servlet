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

@WebServlet(urlPatterns="/signUp")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password= req.getParameter("password");
        String confirmPassword= req.getParameter("password");
        String email= req.getParameter("email");
        String gender= req.getParameter("gender");

        AddProfileDto dto= new AddProfileDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setConfirmPassword(confirmPassword);
        dto.setGender(gender);

        AddProfileService service=new AddProfileServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter=resp.getWriter();
//        printWriter.write("Thank you "+firstName+" for registering!!!");

        req.setAttribute("firstName",firstName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
