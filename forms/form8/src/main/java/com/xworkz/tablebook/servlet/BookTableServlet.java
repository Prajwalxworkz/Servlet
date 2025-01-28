package com.xworkz.tablebook.servlet;

import com.xworkz.tablebook.dto.OrderDto;
import com.xworkz.tablebook.service.OrderService;
import com.xworkz.tablebook.service.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/order")
public class BookTableServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String phone = req.getParameter("phoneNumber");
        String  person = req.getParameter("number");
        String  date = req.getParameter("date");
        OrderDto dto=new OrderDto();
        dto.setUserName(userName);
        dto.setPhNumber(Long.parseLong(phone));
        dto.setNumberOfPersons(Integer.parseInt(person));
        dto.setDate(date);

        OrderService service=new OrderServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("The order is placed by "+userName);

        req.setAttribute("firstName",userName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);

    }
}
