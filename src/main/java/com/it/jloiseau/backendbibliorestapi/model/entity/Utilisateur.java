package com.it.jloiseau.backendbibliorestapi.model.entity;

import com.it.jloiseau.backendbibliorestapi.model.enumaration.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Utilisateur {

    private String name;
    private String username;
    private String mail;
    private String password;
    @ManyToMany
    @JoinTable(name="userBooks",
            joinColumns = {@JoinColumn(name="User_ID")},
            inverseJoinColumns={@JoinColumn(name="Book_id")}
    )
    private List <Book>borrowList;
    @Enumerated(EnumType.STRING)
    private Post post;
    @Column(name="User_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Utilisateur(){}

    public Utilisateur (String name, String username, String mail, String password, Post post,Long id) {
        this.name = name;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.post = post;
        this.id = id;
        this.borrowList = new ArrayList<> (  );
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getUsername ( ) {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getMail ( ) {
        return mail;
    }

    public void setMail (String mail) {
        this.mail = mail;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public List<Book> getBorrowList ( ) {
        return borrowList;
    }

    public void setBorrowList (List<Book> borrowList) {
        this.borrowList = borrowList;
    }

    public Post getPost ( ) {
        return post;
    }

    public void setPost (Post post) {
        this.post = post;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    @Override
    public String toString ( ) {
        return "Utilisateur{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", borrowList=" + borrowList +
                ", post=" + post +
                ", id=" + id +
                '}';
    }
}
