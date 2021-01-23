package com.it.jloiseau.backendbibliorestapi.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    private String title;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate issueDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @Column(name="Book_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @ManyToMany(mappedBy = "borrowList")
    private List<Utilisateur> user;
    private String Description;
    private String siteImg;
    private boolean available;



    public Book (String title, String author, LocalDate issueDate, LocalDate dueDate, Long id,   String description, String siteImg) {
        this.title = title;
        this.author = author;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.id = id;
        this.Description = description;
        this.siteImg = siteImg;
        this.user=new ArrayList<> ( );
        this.available=true;
    }

    public Book (){}

    public String getTitle ( ) {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getAuthor ( ) {
        return author;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public LocalDate getIssueDate ( ) {
        return issueDate;
    }

    public List<Utilisateur> getUser ( ) {
        return user;
    }

    public void setUser (List<Utilisateur> user) {
        this.user = user;
    }

    public void setIssueDate (LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate ( ) {
        return dueDate;
    }

    public void setDueDate (LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }



    public boolean isAvailable ( ) {
        return available;
    }

    public void setAvailable (boolean available) {
        this.available = available;
    }

   /* public User getUser ( ) {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }*/

    public String getDescription ( ) {
        return Description;
    }

    public void setDescription (String description) {
        Description = description;
    }

    public String getSiteImg ( ) {
        return siteImg;
    }

    public void setSiteImg (String siteImg) {
        this.siteImg = siteImg;
    }

    @Override
    public String toString ( ) {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", id=" + id +
                ", Description='" + Description + '\'' +
                ", siteImg='" + siteImg + '\'' +
                '}';
    }
}
