package com.it.jloiseau.backendbibliorestapi.repository;

import com.it.jloiseau.backendbibliorestapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository <Book,Long> {

    Optional<Book> findByTitle(String title);
}
