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

@WebServlet(urlPatterns = "/apply")
public class SaveProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String firstName= req.getParameter("firstName");
       String lastName= req.getParameter("lastName");
       String education= req.getParameter("education");
       String phNum= req.getParameter("phNum");
       String email= req.getParameter("email");
       String address= req.getParameter("address");
       String gender= req.getParameter("gender");
       String resume= req.getParameter("resume");
        AddProfileDto dto=new AddProfileDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setPhNumber(Long.parseLong(phNum));
        dto.setHighestEducation(education);
        dto.setEmail(email);
        dto.setGender(gender);
        dto.setAddress(address);
        dto.setResume(resume);

        AddProfileService service= new AddProfileServiceImpl();
        service.validateAndSave(dto);

        req.setAttribute("firstName",firstName);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);

//        PrintWriter writer = resp.getWriter();
//        writer.write("Thank you "+firstName+" for applying in our company!!");
    }
}
