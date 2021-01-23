package com.it.jloiseau.backendbibliorestapi.controller;
import com.it.jloiseau.backendbibliorestapi.model.entity.Book;
import com.it.jloiseau.backendbibliorestapi.repository.BookRepository;
import com.it.jloiseau.backendbibliorestapi.services.BookAvailableCheck;
import com.it.jloiseau.backendbibliorestapi.services.ChangeBookDisponibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

   @Autowired
    private BookAvailableCheck bookAvailableCheck;
   @Autowired
   private ChangeBookDisponibility changeBookDisponibility;

    @GetMapping("/book/{id}")
    public Book findBookbyId(@PathVariable Long id){
        Optional <Book> optBook= bookRepository.findById (id);
        return optBook.get ();
    }

    @GetMapping("/book/title/{title}")
    public Book findBookByTitle(@PathVariable String title){
        Optional <Book>optBook=bookRepository.findByTitle(title);
        return optBook.get ();
    }

    @GetMapping("book/available/{id}")
    public boolean isBookAvailable(@PathVariable Long id){
        Optional <Book> optBook= bookRepository.findById (id);
        Book book=optBook.get ();
        return bookAvailableCheck.available (book);
    }


    @PostMapping("/available/{id}/{available}")
    public void makeAvailable( @PathVariable ("id")Long id,@PathVariable("available") boolean available){
        System.out.println (available );
        Optional <Book> optBook= bookRepository.findById (id);
        if(optBook.isPresent ()){
            Book book=optBook.get ();
            book.setAvailable (available);
            bookRepository.save (book);
        }
        else {
            System.out.println ("fail" );
        }
    }

//    @GetMapping("/book")
//    public Book findBookByTitle(@RequestParam(value="title") String title){
//        Optional <Book>optBook=bookRepository.findByTitle(title);
//        return optBook.get ();
//    }

}
