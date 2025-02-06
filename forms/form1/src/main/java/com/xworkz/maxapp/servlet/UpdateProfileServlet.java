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

@WebServlet(urlPatterns = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String userName=req.getParameter("userName");
        String email=req.getParameter("email");
        String mobile=req.getParameter("mobile");
        String address=req.getParameter("address");
        AddProfileDto dto=new AddProfileDto();
        dto.setId(Integer.parseInt(id));
        dto.setFullName(userName);
        dto.setEmail(email);
        dto.setMobile(Long.parseLong(mobile));
        dto.setAddress(address);
        AddProfileService service=new AddProfileServiceImpl();
        service.updateProfileById(dto);

        req.setAttribute("updatedMessage","Profile updated  successfully!!!");
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("userProfileUpdate.jsp");
        requestDispatcher.forward(req,resp);
    }
}
