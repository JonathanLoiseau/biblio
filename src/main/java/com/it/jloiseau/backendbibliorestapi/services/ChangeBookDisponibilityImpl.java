package com.it.jloiseau.backendbibliorestapi.services;

import com.it.jloiseau.backendbibliorestapi.model.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class ChangeBookDisponibilityImpl  implements ChangeBookDisponibility{
    @Override
    public void changeDisponibility (boolean disponibility ,Book book) {
        book.setAvailable (disponibility);
    }
}
