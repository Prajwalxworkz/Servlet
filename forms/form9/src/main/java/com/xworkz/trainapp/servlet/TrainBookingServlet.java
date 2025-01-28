package com.xworkz.trainapp.servlet;

import com.xworkz.trainapp.dto.AddEventDto;
import com.xworkz.trainapp.entity.AddEventEntity;
import com.xworkz.trainapp.service.AddEventService;
import com.xworkz.trainapp.service.AddEventServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/apply")
public class TrainBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fName = req.getParameter("firstName");
        String lName = req.getParameter("lastName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String trainNumber = req.getParameter("num");
        AddEventDto dto=new AddEventDto();
        dto.setFirstName(fName);
        dto.setLastName(lName);
        dto.setEmail(email);
        dto.setDob(dob);
        dto.setTrainNumber(Long.parseLong(trainNumber));

        AddEventService service=new AddEventServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("First Name : "+fName+"\n");
//        printWriter.write("Last Name : "+lName+"\n");
//        printWriter.write("Date of Birth : "+dob+"\n");
//        printWriter.write("Email ID : "+email+"\n");
//        printWriter.write("Train Number : "+trainNumber+"\n");

        req.setAttribute("firstName",fName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
