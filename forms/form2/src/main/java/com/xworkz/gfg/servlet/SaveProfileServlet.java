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
@WebServlet(urlPatterns="/saveProfile"  )
public class SaveProfileServlet extends HttpServlet {
    public SaveProfileServlet() {
        System.out.println("It is the first phase of servlet lifecycle i.e., Instantiation");
        System.out.println("SaveProfileServlet constructor is invoked");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Initialization phase");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service phase");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost() is called");
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
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("addResponse.jsp");
        requestDispatcher.forward(req,resp);

        System.out.println("doPost() is ended ");
    }

    @Override
    public void destroy() {
        System.out.println("Closing all the costly resources");
    }
}
