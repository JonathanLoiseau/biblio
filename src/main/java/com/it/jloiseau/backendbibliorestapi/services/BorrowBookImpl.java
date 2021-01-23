package com.it.jloiseau.backendbibliorestapi.services;

import com.it.jloiseau.backendbibliorestapi.model.entity.Book;
import com.it.jloiseau.backendbibliorestapi.model.entity.Utilisateur;
import com.it.jloiseau.backendbibliorestapi.repository.BookRepository;
import com.it.jloiseau.backendbibliorestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowBookImpl  implements BorrowBook {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;


    @Override
    public void addBook (Long userid, Long bookId) {

        Optional<Utilisateur> optionalUtilisateur = userRepository.findById (userid);
        Optional<Book> optionalBook = bookRepository.findById (bookId);

        if (optionalUtilisateur.isPresent ( ) && optionalBook.isPresent ( )) {
            System.out.println ("present");
            Utilisateur verifiedUser = optionalUtilisateur.get ( );
            Book verifiedBook = optionalBook.get ( );
            List<Book>bookList=verifiedUser.getBorrowList ();
            List<Utilisateur>userList=verifiedBook.getUser ();
            bookList.add (verifiedBook);
            verifiedUser.setBorrowList (bookList);
            userRepository.save (verifiedUser);
            userList.add (verifiedUser);
            verifiedBook.setUser (userList);
            bookRepository.save (verifiedBook);
        }
    }

    @Override
    public void removeBook ( Long userId, Long bookId) {


        Optional<Book> optionalBook = bookRepository.findById (bookId);
        Optional<Utilisateur> optionalUtilisateur = userRepository.findById (userId);

        if (optionalUtilisateur.isPresent ( ) && optionalBook.isPresent ( )) {
            System.out.println ("present");
            Book verifiedBook = optionalBook.get ( );
            Utilisateur verifiedUtilisateur=optionalUtilisateur.get ();

            String bookTitle=verifiedBook.getTitle ();

            List<Utilisateur>userList=verifiedBook.getUser ();
            List<Book>bookList=verifiedUtilisateur.getBorrowList ();



//            for (  Book book :bookList
//                 )
//            {
//                if(book.getTitle ().equals (bookTitle)){
//                    bookList.remove (book);
//                }
//            }

            Iterator<Book>iterator=bookList.iterator ();
            while (iterator.hasNext ()){
                Book book=iterator.next ();
                if(book.getTitle ().equals (bookTitle)){
                    iterator.remove ();
                }
            }

            verifiedUtilisateur.setBorrowList (bookList);
            userRepository.save (verifiedUtilisateur);
            userList.add (verifiedUtilisateur);
            verifiedBook.setUser (userList);
            bookRepository.save (verifiedBook);

        }
    }

}
