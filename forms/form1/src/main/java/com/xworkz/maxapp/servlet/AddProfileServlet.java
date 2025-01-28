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
import java.io.PrintWriter;

@WebServlet(urlPatterns="/addProfile")
public class AddProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String fullName=req.getParameter("fullName");
         String email=req.getParameter("email");
         String mobile=req.getParameter("mobile");
         String address=req.getParameter("address");
        AddProfileDto dto=new AddProfileDto();
        dto.setFullName(fullName);
        dto.setEmail(fullName);
        dto.setMobile(Long.parseLong(mobile));
        dto.setAddress(address);
        AddProfileService service=new AddProfileServiceImpl();
        service.validateAndSave(dto);

        req.setAttribute("firstName",fullName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
//         PrintWriter printWriter=resp.getWriter();
//         printWriter.write("Thank you "+fullName+" for registering!!!");
    }
}
