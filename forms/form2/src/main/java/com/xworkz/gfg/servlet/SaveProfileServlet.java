package com.xworkz.gfg.servlet;

import com.xworkz.gfg.dto.SaveProfileDto;
import com.xworkz.gfg.service.SaveProfileService;
import com.xworkz.gfg.service.SaveProfileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns="/saveProfile")
public class SaveProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String firstName= req.getParameter("firstName");
       String lastName= req.getParameter("lastName");
       String dob= req.getParameter("dob");
       String email= req.getParameter("email");
       String gender= req.getParameter("gender");
       String address= req.getParameter("address");
       SaveProfileDto dto= new SaveProfileDto();
       dto.setFirstName(firstName);
       dto.setLastName(lastName);
       dto.setEmail(email);
       dto.setDob(dob);
       dto.setGender(gender);
       dto.setAddress(address);
       SaveProfileService service=new SaveProfileServiceImpl();
       service.validateAndSave(dto);
//       PrintWriter printWriter=resp.getWriter();
//        printWriter.write("Thank you "+firstName+" "+lastName+" for registering!!!");
        req.setAttribute("firstName",firstName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);
    }
}
