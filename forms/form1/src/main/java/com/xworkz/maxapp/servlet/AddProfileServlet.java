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

@WebServlet(urlPatterns="/addProfile", loadOnStartup=+2)
public class AddProfileServlet extends HttpServlet {
    public AddProfileServlet() {
        System.out.println("Instantiation phase");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Initialization phase");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("service Phase");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost() invocation");
         String userName=req.getParameter("userName");
         String email=req.getParameter("email");
         String mobile=req.getParameter("mobile");
         String address=req.getParameter("address");
        AddProfileDto dto=new AddProfileDto();
        dto.setFullName(userName);
        dto.setEmail(email);
        dto.setMobile(Long.parseLong(mobile));
        dto.setAddress(address);
        AddProfileService service=new AddProfileServiceImpl();
        service.validateAndSave(dto);

        //         PrintWriter printWriter=resp.getWriter();
//         printWriter.write("Thank you "+fullName+" for registering!!!");

        req.setAttribute("userName",userName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);

        System.out.println("doPost() ended");
    }

    @Override
    public void destroy() {
        System.out.println("Closing all the costly resources");
    }
}
