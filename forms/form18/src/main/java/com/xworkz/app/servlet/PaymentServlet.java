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

@WebServlet (urlPatterns = "/pay")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String phoneNumber = req.getParameter("phoneNumber");
        String account = req.getParameter("account");
        String amount = req.getParameter("amount");
        String type = req.getParameter("type");

        AddProfileDto dto=new AddProfileDto();
        dto.setUserName(userName);
        dto.setPhNumber(Long.parseLong(phoneNumber));
        dto.setAccountNumber(account);
        dto.setAmount(amount);
        dto.setAccountType(type);

        AddProfileService service=new AddProfileServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter = resp.getWriter();
////        printWriter.write("The payment is done by "+userName);

        req.setAttribute("firstName",userName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
