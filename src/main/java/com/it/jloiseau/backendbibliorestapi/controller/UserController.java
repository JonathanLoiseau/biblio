package com.it.jloiseau.backendbibliorestapi.controller;


import com.it.jloiseau.backendbibliorestapi.model.entity.Book;
import com.it.jloiseau.backendbibliorestapi.model.entity.Utilisateur;
import com.it.jloiseau.backendbibliorestapi.model.enumaration.Post;
import com.it.jloiseau.backendbibliorestapi.repository.BookRepository;
import com.it.jloiseau.backendbibliorestapi.repository.UserRepository;
import com.it.jloiseau.backendbibliorestapi.services.BorrowBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BorrowBook borrowBook;
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/users/{id}")
    public Utilisateur findUser(@PathVariable Long id){
       Optional<Utilisateur>  userOpt = userRepository.findById (id);
       Utilisateur user = userOpt.get ();
        return  user;
    }
    @GetMapping("users/username/{username}")
    public Utilisateur finUsersByUsername(@PathVariable String username){
        Optional<Utilisateur>userOpt=userRepository.findUserByUsername (username);
        if(userOpt.isPresent ()){
            Utilisateur user = userOpt.get ();
            return user;
        }
        else{
            return null;//return exeption
        }

    }
    @PostMapping("/users")
    public void addUser(@RequestBody Utilisateur user){
        userRepository.save (user);
    }

    @PutMapping ("/users/books/{id}/{bookId}")
    public void borrowBook (@PathVariable Long id,@PathVariable Long bookId)
        {
           borrowBook.addBook (id,bookId);
       }
       @DeleteMapping("/users/books/{id}/{bookId}")
       public void returnBook(@PathVariable Long id, @PathVariable Long bookId){
           borrowBook.removeBook (id,bookId);
       }





    }

