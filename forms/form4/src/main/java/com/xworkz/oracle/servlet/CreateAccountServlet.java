package com.xworkz.oracle.servlet;

import com.xworkz.oracle.dto.CreateAccountDto;
import com.xworkz.oracle.service.CreateAccountService;
import com.xworkz.oracle.service.CreateAccountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/createAccount")
public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phNum = req.getParameter("phNum");
        String password= req.getParameter("password");
        String retypePassword= req.getParameter("password");
        String address= req.getParameter("address");
        CreateAccountDto dto= new CreateAccountDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setConfirmPassword(retypePassword);
        dto.setConfirmPassword(retypePassword);
        dto.setPhNum(Long.parseLong(phNum));

        CreateAccountService service=new CreateAccountServiceImpl();
        service.validateAndSave(dto);
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Thank you " + firstName + " " + lastName + " for registering");

        req.setAttribute("firstName",firstName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
