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

@WebServlet(urlPatterns = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    public UpdateProfileServlet() {
        System.out.println("Instantiation phase");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Initialization phase");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost() invocation");
        SaveProfileDto dto=new SaveProfileDto();
        dto.setId(Integer.parseInt(req.getParameter("id")));
        dto.setFirstName(req.getParameter("firstName"));
        dto.setLastName(req.getParameter("lastName"));
        dto.setDob(req.getParameter("dob"));
        dto.setEmail(req.getParameter("email"));
        dto.setGender(req.getParameter("gender"));
        dto.setAddress(req.getParameter("address"));

        SaveProfileService service=new SaveProfileServiceImpl();
        service.updateProfile(dto);

        req.setAttribute("updatedMessage","Account updated successfully!!");
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);

        System.out.println("doPost() ended");
    }

    @Override
    public void destroy() {
        System.out.println("Closing all the costly resources");
    }
}
