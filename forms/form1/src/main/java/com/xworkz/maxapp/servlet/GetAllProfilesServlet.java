package com.xworkz.maxapp.servlet;

import com.xworkz.maxapp.dto.AddProfileDto;
import com.xworkz.maxapp.entity.AddProfileEntity;
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
import java.util.List;

@WebServlet(urlPatterns = "/getAllProfiles", loadOnStartup = +1)
public class GetAllProfilesServlet extends HttpServlet {

    public GetAllProfilesServlet() {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() invocation");

        AddProfileService service=new AddProfileServiceImpl();
        List<AddProfileDto> dto=service.getAllProfiles();

//        System.out.println(dto);
//        PrintWriter writer = resp.getWriter();
//        writer.write(dto.toString());
//       dto.stream().forEach(System.out::println);
//        dto.stream().forEach(list->writer.write(String.valueOf(list)));
//    for(AddProfileDto ref:dto){
//        writer.println(ref);
//        writer.write(ref.getFullName());
//        writer.write(ref.getEmail());
//        writer.println(ref.getMobile());
//        writer.write(ref.getAddress());
//        writer.write(ref.getFullName()+" "+ref.getAddress()+" "+ref.getEmail()+" "+ref.getMobile());

//    }

       req.setAttribute("dtoList",dto);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("getAllProfiles.jsp");
        requestDispatcher.forward(req,resp);

        System.out.println("doGet() ended");
    }

    @Override
    public void destroy() {
        System.out.println("Closing all the costly resources");
    }
}
