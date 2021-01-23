package com.it.jloiseau.backendbibliorestapi.services;

import com.it.jloiseau.backendbibliorestapi.model.entity.Book;

public interface BookAvailableCheck {
    boolean available(Book book);
}
