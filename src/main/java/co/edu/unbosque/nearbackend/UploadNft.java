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
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

@WebServlet(name = "uploadNft", value = "/uploadNft")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class UploadNft extends HttpServlet {

    private String message;
    private UserService uService;


    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String author = request.getParameter("author");

        RequestDispatcher dispatcher = request.getRequestDispatcher("./createNFT.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher =null;
        uService = new UserService();

        String extension="";
        String fileName="";
        String tittle = request.getParameter("titulo");
        String price = request.getParameter("precio");
        //BUSCAR
        String emailAuthor = request.getParameter("author");

        uService = new UserService();
        uService.setRuta(getServletContext().getRealPath("").replace("NEArBackend-1.0-SNAPSHOT","")+ "classes"+File.separator+"Users.csv");
        List<User> users = new UserService().getUsers().get();
        User userFounded = users.stream().filter(user -> emailAuthor.equals(user.getUsername()))
                .findFirst().orElse(null);
        String author = userFounded.getName() +" "+ userFounded.getLastname();
        String uploadPath = getServletContext().getRealPath("")+File.separator+"NFTS";

        request.setAttribute("name",userFounded.getName());
       

        File uploadDir = new File(uploadPath);
        // If path doesn`t exist, create it
        if (!uploadDir.exists()) uploadDir.mkdir();
        try {
            // Getting each part from the request
            int i = 0;
            for (Part part : request.getParts() ) {
                // Storing the file using the same name
                if(part.getSubmittedFileName() != null)
                {
                    extension = part.getSubmittedFileName().toString().split("\\.")[1];
                }
                fileName = uService.generateRandomString()+"&"+tittle+"."+extension;
                part.write(uploadPath + File.separator + fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        uService.createNFT(fileName,extension,tittle,author,price,emailAuthor,getServletContext().getRealPath("") + File.separator);
        // Redirecting

        dispatcher = request.getRequestDispatcher("./index.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}

