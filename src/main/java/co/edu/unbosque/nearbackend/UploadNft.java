package co.edu.unbosque.nearbackend;

import co.edu.unbosque.nearbackend.dtos.User;
import co.edu.unbosque.nearbackend.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "uploadNft", value = "/uploadNft")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class UploadNft extends HttpServlet {

    private String message;
    private UserService uService;
    private String name;


    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Redirecting
        response.sendRedirect("./result.html");

        String titulo = request.getParameter("titulo");
        String precio = request.getParameter("precio");
        String url = request.getParameter("url");
        String file = request.getParameter("file");

        String uploadPath = getServletContext().getRealPath("") + File.separator + "resources\\Nfts.csv";
        File uploadDir = new File(uploadPath);

        // If path doesn`t exist, create it
        if (!uploadDir.exists()) uploadDir.mkdir();

        try {
            // Getting each part from the request
            for (Part part : request.getParts()) {
                // Storing the file using the same name
                String fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


        uService = new UserService();
        uService.setRuta(getServletContext().getRealPath("") + File.separator + "resources\\Users.csv");
        System.out.println(uService.getRuta());

        List<User> users = uService.getUsers().get();

      // User userFounded = users.stream().filter(user -> username.equals(user.getUsername()))        .findFirst().orElse(null);

        /*if (userFounded == null) {
            //uService.newUser(username,name,lastname,role,password,"0");
            System.out.println(getServletContext().getRealPath("") + File.separator + "resources\\Users.csv");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("./401.html");
        }*/
    }

}

