package co.edu.unbosque.nearbackend;

import co.edu.unbosque.nearbackend.dtos.User;
import co.edu.unbosque.nearbackend.services.UserService;


import java.io.*;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println();
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> users = new UserService().getUsers().get();

        User userFounded = users.stream().filter(user -> username.equals(user.getUsername()) && password.equals(user.getPassword()))
                .findFirst().orElse(null);

        if (username.equals(userFounded.getUsername()) && password.equals(userFounded.getPassword())) {

            if (userFounded != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");

                try {

                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }

            } else {
                response.sendRedirect("./401.html");
            }
        }
    }
}