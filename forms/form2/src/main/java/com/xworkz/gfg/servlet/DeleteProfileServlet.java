package com.xworkz.gfg.servlet;

import com.xworkz.gfg.service.SaveProfileService;
import com.xworkz.gfg.service.SaveProfileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteProfileServlet extends HttpServlet {
    public DeleteProfileServlet() {
        System.out.println("Instantiation phase");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Initialization phase");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() invocation");
        String id=req.getParameter("id");
        SaveProfileService service=new SaveProfileServiceImpl();
        service.deleteProfileById(Integer.parseInt(id));
        req.setAttribute("deleteMessage","Account deleted successfully!!");
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("deleteResponse.jsp");
        requestDispatcher.forward(req,resp);
        System.out.println("doGet() ended");
    }

    @Override
    public void destroy() {
        System.out.println("Closing all the costly resources");
    }
}
