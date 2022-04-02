package co.edu.unbosque.nearbackend.services;

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

    public void createNFT(String id,String pictureLink,String title,String author,String precio,String email_owner){
        String STRING_ARRAY_SAMPLE = "./string-array-sample.csv";
            try (   
                    Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

                    CSVWriter csvWriter = new CSVWriter(writer,
                            CSVWriter.DEFAULT_SEPARATOR,
                            CSVWriter.NO_QUOTE_CHARACTER,
                            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                            CSVWriter.DEFAULT_LINE_END);
            ) {
                String[] headerRecord = {"id","pictureLink","title","author","precio","email_owner"};
                csvWriter.writeNext(headerRecord);

                csvWriter.writeNext(new String[]{"Sundar Pichai ♥", "sundar.pichai@gmail.com", "+1-1111111111", "India"});
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void createUser(String email,String username,String password,String role){
        String STRING_ARRAY_SAMPLE = "./string-array-sample.csv";

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

            csvWriter.writeNext(new String[]{"Sundar Pichai ♥", "sundar.pichai@gmail.com", "+1-1111111111", "India"});
        } catch (IOException e) {
            e.printStackTrace();
        }
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