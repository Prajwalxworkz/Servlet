package com.xworkz.vehicleregistration.servlet;

import com.xworkz.vehicleregistration.dto.AddProfileDto;
import com.xworkz.vehicleregistration.service.AddProfileService;
import com.xworkz.vehicleregistration.service.AddProfileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/apply")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        AddProfileDto dto = new AddProfileDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setDob(dob);

        dto.setAddress(address);
        AddProfileService service = new AddProfileServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Thank you " + firstName + " for registering!! ");

        req.setAttribute("firstName",firstName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);

    }
}
