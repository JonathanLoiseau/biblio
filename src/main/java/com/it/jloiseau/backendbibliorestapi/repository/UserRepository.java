package com.it.jloiseau.backendbibliorestapi.repository;

import com.it.jloiseau.backendbibliorestapi.model.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<Utilisateur,Long> {

    Optional<Utilisateur>findUserByUsername(String username);

}
