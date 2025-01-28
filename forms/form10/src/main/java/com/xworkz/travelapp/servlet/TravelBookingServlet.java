package com.xworkz.travelapp.servlet;

import com.xworkz.travelapp.dto.BookingDto;
import com.xworkz.travelapp.service.BookingService;
import com.xworkz.travelapp.service.BookingServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.UserDefinedFileAttributeView;

@WebServlet (urlPatterns = "/book")
public class TravelBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String phoneNumber = req.getParameter("phoneNumber");
        String startDate = req.getParameter("start");
        String travelingTo = req.getParameter("travelingTo");
        String vehicle = req.getParameter("vehicle");

        BookingDto dto=new BookingDto();
        dto.setUserName(userName);
        dto.setPhNumber(Long.parseLong(phoneNumber));
        dto.setStartDate(startDate);
        dto.setModeOfTransport(vehicle);
        dto.setTravellingTo(travelingTo);

        BookingService service = new BookingServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("The travel is booked by : "+userName+"\n");
//        printWriter.write("Phone Number : "+phoneNumber+"\n");
//        printWriter.write("Start date : "+startDate+"\n");
//        printWriter.write("Traveling : "+travelingTo+"\n");
//        printWriter.write("Vehicle : "+vehicle+"\n");

        req.setAttribute("firstName",userName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
