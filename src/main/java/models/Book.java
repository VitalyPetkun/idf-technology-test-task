package models;

import lombok.Data;

import java.util.Date;

@Data
public class Book{

    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private Date publish_date;
    private String publisher;
    private int pages;
    private String description;
    private String website;
}
