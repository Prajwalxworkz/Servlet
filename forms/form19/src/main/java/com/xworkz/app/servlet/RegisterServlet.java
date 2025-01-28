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

@WebServlet (urlPatterns = "/apply")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        AddProfileDto dto =new AddProfileDto();
        dto.setFirstName(fName);
        dto.setLastName(lName);
        dto.setEmail(email);
        dto.setDob(dob);
        dto.setDob(address);
        dto.setAddress(address);

        AddProfileService service=new AddProfileServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("First Name : "+fName+"\n");
//        printWriter.write("Last Name : "+lName+"\n");
//        printWriter.write("Date of Birth : "+dob+"\n");
//        printWriter.write("Email ID : "+email+"\n");
//        printWriter.write("Address : "+address+"\n");

        req.setAttribute("firstName",fName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
