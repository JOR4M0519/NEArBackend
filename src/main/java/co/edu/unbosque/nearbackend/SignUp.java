package co.edu.unbosque.nearbackend;

import co.edu.unbosque.nearbackend.dtos.User;
import co.edu.unbosque.nearbackend.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "singup", value = "/singup")
public class SignUp extends HttpServlet {

    private String message;
    private UserService uService;


    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");



        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        uService = new UserService();
        uService.setRuta(getServletContext().getRealPath("") + File.separator + "resources\\Users.csv");
        System.out.println(uService.getRuta());

        List<User> users = uService.getUsers().get();

        User userFounded = users.stream().filter(user -> username.equals(user.getUsername()))
                .findFirst().orElse(null);


        if (userFounded == null) {


            uService.newUser(username,name,lastname,role,password,"0");
            System.out.println(getServletContext().getRealPath("") + File.separator + "resources\\Users.csv");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");

            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("./401.html");
        }
    }

}

