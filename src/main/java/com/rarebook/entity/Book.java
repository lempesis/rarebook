package com.rarebook.entity;

<<<<<<< HEAD
public class Book {
    private int id;
    private String name;
    private String publishedDate;
    private double price;

    public Book(int id, String name, String publishedDate, Double price) {
        this.id = id;
        this.name = name;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
=======
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String description;
    private String coverImage;
>>>>>>> master
}
