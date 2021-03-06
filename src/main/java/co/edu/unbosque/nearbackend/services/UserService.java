package co.edu.unbosque.nearbackend.services;

import co.edu.unbosque.nearbackend.dtos.FCoins;
import co.edu.unbosque.nearbackend.dtos.NFT_Picture;
import co.edu.unbosque.nearbackend.dtos.User;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class UserService {


    private static String ruta = "";
    //Leer Usuario
    public static Optional<List<User>> getUsers() throws IOException {

        List<User> users;

        try (InputStream is = new FileInputStream(ruta)) {

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

    public static Optional<List<FCoins>> getFCoins() throws IOException {

        List<FCoins> fcoins;

        try (InputStream is = new FileInputStream(ruta)) {

            if (is == null) {
                return Optional.empty();
            }
            HeaderColumnNameMappingStrategy<FCoins> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(FCoins.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                CsvToBean<FCoins> csvToBean = new CsvToBeanBuilder<FCoins>(br)
                        .withType(FCoins.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                fcoins = csvToBean.parse();
            }
        }
        return Optional.of(fcoins);
    }

    //Leer NFT
    public static Optional<List<NFT_Picture>> getNft() throws IOException {

        List<NFT_Picture> nft;

        try (InputStream is = new FileInputStream(ruta)) {

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

    public void createUser(String username, String name, String lastname, String password, String role, String Fcoins, String path) throws IOException {
            String newLine =  username + "," + name + ","+lastname+ "," + role + ","+ password +","+"0"+"\n";
        String fullpath = path.replace("NEArBackend-1.0-SNAPSHOT"+File.separator,"")+ "classes"+File.separator+"Users.csv";

        FileOutputStream os = new FileOutputStream(fullpath, true);
            os.write(newLine.getBytes());
            os.close();
    }
    public void createMoney(String username,String fcoins, String path) throws IOException {
        String newLine = username + "," + fcoins + "\n";
        String fullpath = path.replace("NEArBackend-1.0-SNAPSHOT" + File.separator, "") + "classes" + File.separator + "FCoins.csv";

        FileOutputStream os = new FileOutputStream(fullpath, true);
        os.write(newLine.getBytes());
        os.close();
    }


    public void createNFT(String id, String extension, String title, String author, String price, String email_owner, String path) throws IOException {
        String newLine = id + "," + extension + "," + title + ","+author+ "," + price + ","+"0"+","+ email_owner +"\n";

        String fullpath = path.replace("NEArBackend-1.0-SNAPSHOT"+File.separator,"")+ "classes"+File.separator+"Nfts.csv";


        FileOutputStream os = new FileOutputStream( fullpath, true);
        os.write(newLine.getBytes());
        os.close();

    }

    public long amountMoney(String username) throws IOException {

        long amount = 0;
        List<FCoins> fCoins = getFCoins().get();

        for (int i = 0; i < fCoins.size(); i++) {
            if (fCoins.get(i).getUsername().equals(username)) {
                amount += Long.parseLong(fCoins.get(i).getFCoins());
            }
        }
        return amount;
    }

    public static void deleteFile(String URL){
         new File(URL).delete();
    }

    public String generateRandomString() {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

        return generatedString;
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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}