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


    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        uService = new UserService();

        String fileName="";
        String tittle = request.getParameter("titulo");
        String price = request.getParameter("precio");
        //BUSCAR
        String author = request.getParameter("username");


        String uploadPath = getServletContext().getRealPath("");
        uploadPath = uploadPath.replace("NEArBackend-1.0-SNAPSHOT","")+ "classes"+File.separator+"NFTS";

        System.out.println("Upload NFTruta: "+uploadPath);

        File uploadDir = new File(uploadPath);
        // If path doesn`t exist, create it
        if (!uploadDir.exists()) uploadDir.mkdir();


        try {
            // Getting each part from the request
            for (Part part : request.getParts()) {
                // Storing the file using the same name
                fileName = uService.generateRandomString()+"0X0"+tittle;
                part.write(uploadPath + File.separator + fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


        uService.createNFT2(fileName,tittle,author,price,"",getServletContext().getRealPath("") + File.separator);

        // Redirecting
        response.sendRedirect("./result.html");

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

