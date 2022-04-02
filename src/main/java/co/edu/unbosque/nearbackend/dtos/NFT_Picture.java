package co.edu.unbosque.nearbackend.dtos;

import com.opencsv.bean.CsvBindByName;

public class NFT_Picture {
    @CsvBindByName
    private String id;
    @CsvBindByName
    private String pictureLink;
    @CsvBindByName
    private String title;
    @CsvBindByName
    private String author;
    @CsvBindByName
    private String precio;
    @CsvBindByName
    private String email_owner;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getPictureLink() {return pictureLink;}

    public void setPictureLink(String pictureLink) {this.pictureLink = pictureLink;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}

    public void setAuthor(String author) {this.author = author;}

    public String getPrecio() {return precio;}

    public void setPrecio(String precio) {this.precio = precio;}

    public String getEmail_owner() {return email_owner;}

    public void setEmail_owner(String email_owner) {this.email_owner = email_owner;}

    @Override
    public String toString() {
        return "NFT_Picture{" +
                "id='" + id + '\'' +
                ", pictureLink='" + pictureLink + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", precio='" + precio + '\'' +
                ", email_owner='" + email_owner + '\'' +
                '}';
    }
}
