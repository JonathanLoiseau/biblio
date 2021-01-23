package com.it.jloiseau.backendbibliorestapi.services;

import com.it.jloiseau.backendbibliorestapi.model.entity.Book;

public interface ChangeBookDisponibility {
    void changeDisponibility (boolean disponibility, Book book);
}