package co.edu.unbosque.nearbackend.services;

import co.edu.unbosque.nearbackend.dtos.NFT_Picture;
import co.edu.unbosque.nearbackend.dtos.User;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class UserService {

    //Leer Usuario
    public static Optional<List<User>> getUsers() throws IOException {

        List<User> users;

        try (InputStream is = UserService.class.getClassLoader()
                .getResourceAsStream("users.csv")) {

            if (is == null) {
                return Optional.empty();
            }

            HeaderColumnNameMappingStrategy<User> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(User.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(br)
                        .withType(User.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                users = csvToBean.parse();
            }
        }

        return Optional.of(users);
    }

    //Leer NFT
    public static Optional<List<NFT_Picture>> getNft() throws IOException {

        List<NFT_Picture> nft;

        try (InputStream is = UserService.class.getClassLoader()
                .getResourceAsStream("Nfts.csv")) {

            if (is == null) {
                return Optional.empty();
            }

            HeaderColumnNameMappingStrategy<NFT_Picture> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(NFT_Picture.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                CsvToBean<NFT_Picture> csvToBean = new CsvToBeanBuilder<NFT_Picture>(br)
                        .withType(NFT_Picture.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                nft = csvToBean.parse();
            }
        }
        return Optional.of(nft);
    }

    //Crear NFT
    public void createNFT(String id,String pictureLink,String title,String author,String price,String email_owner){
        String STRING_ARRAY_SAMPLE = "./Nfts.csv";
            try (   
                    Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

                    CSVWriter csvWriter = new CSVWriter(writer,
                            CSVWriter.DEFAULT_SEPARATOR,
                            CSVWriter.NO_QUOTE_CHARACTER,
                            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                            CSVWriter.DEFAULT_LINE_END);
            ) {
                String[] headerRecord = {"id","pictureLink","title","author","price","email_owner"};
                csvWriter.writeNext(headerRecord);

                csvWriter.writeNext(new String[]{id,pictureLink,title,author,price,email_owner});
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    //Crear Usuario
    public void createUser(String email,String username,String password,String role,String Fcoins){
        String STRING_ARRAY_SAMPLE = ".User/.csv";

        try (
                Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {

            String[] headerRecord = {"email","username","password","role","Fcoins"};
            csvWriter.writeNext(headerRecord);

            csvWriter.writeNext(new String[]{email,username, password, role, Fcoins});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Recargar Cuenta
    public void reloadMoney(String email, int coins){
        try {
            List<User> users = getUsers().get();

            User userFounded = users.stream().filter(user -> email.equals(user.getEmail())).findFirst().orElse(null);
            userFounded.setFcoins((Integer.parseInt(userFounded.getFcoins())+coins)+"");
            updateUser(users);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(List<User> users){
        deleteFile("Users.csv");
        for (int i=0;i<users.size();i++){
            createUser(users.get(i).getEmail(),users.get(i).getUsername(),users.get(i).getPassword(),users.get(i).getRole(),users.get(i).getFcoins());
        }
    }

    //Eliminar Usuario
    public void deleteUser(String email){
        try {
            List<User> users = getUsers().get();
            User userFounded = users.stream().filter(user -> email.equals(user.getEmail())).findFirst().orElse(null);
            users.remove(userFounded);
            updateUser(users);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Eliminar archivo
    public void deleteFile(String URL){
         new File(URL).delete();
    }

    public static void main(String args[]) {
        try {
            Optional<List<User>> users = new UserService().getUsers();

            for (User user: users.get()) {
                System.out.println(user.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}