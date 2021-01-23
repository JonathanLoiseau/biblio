package com.it.jloiseau.backendbibliorestapi.services;

import com.it.jloiseau.backendbibliorestapi.model.entity.Book;
import com.it.jloiseau.backendbibliorestapi.model.entity.Utilisateur;

public interface BorrowBook {

    void addBook(Long userId, Long bookId);

    void removeBook( Long userId, Long bookId);
}
