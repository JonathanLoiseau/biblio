package com.it.jloiseau.backendbibliorestapi.services;

import com.it.jloiseau.backendbibliorestapi.model.entity.Book;
import com.it.jloiseau.backendbibliorestapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookAvailableCheckImpl implements BookAvailableCheck{
    @Autowired
    private BookRepository bookRepository;


    @Override
    public boolean available (Book book) {

        return book.isAvailable ();
    }
}
