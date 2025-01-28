package com.xworkz.app.servlet;

import com.xworkz.app.dto.AccountDto;
import com.xworkz.app.service.AccountService;
import com.xworkz.app.service.AccountServiceImpl;

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
        String phNumber = req.getParameter("phNum");
        String accountNumber = req.getParameter("accountNumber");
        String amount = req.getParameter("amount");
        String ifsCode = req.getParameter("ifsCode");
        AccountDto dto=new AccountDto();
        dto.setUserName(userName);
        dto.setAccountNumber(Long.parseLong(accountNumber));
        dto.setIfsCode(ifsCode);
        dto.setPhNumber(Long.parseLong(phNumber));
        dto.setAmount(Long.parseLong(amount));

        AccountService service=new AccountServiceImpl();
        service.validateAndSave(dto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("The payment is done by "+userName);

        req.setAttribute("userName",userName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
