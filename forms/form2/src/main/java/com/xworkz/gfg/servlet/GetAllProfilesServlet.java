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
import java.util.List;

@WebServlet(urlPatterns = "/getAllProfiles")
public class GetAllProfilesServlet extends HttpServlet {

    public GetAllProfilesServlet() {
        System.out.println("Object creation by the container");
        System.out.println(" (OR) Instantiation phase");
    }

    @Override
    public void init() throws ServletException {
      System.out.println("Initialization phase");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() invocation");
        SaveProfileService service=new SaveProfileServiceImpl();
        List<SaveProfileDto> dtoList=service.getAllProfiles();

        req.setAttribute("dtoList",dtoList);

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("getAllProfiles.jsp");
        requestDispatcher.forward(req,resp);
        System.out.println("doGet() ended");

    }

    @Override
    public void destroy() {
        System.out.println("Closing all the costly resources");
    }
}
