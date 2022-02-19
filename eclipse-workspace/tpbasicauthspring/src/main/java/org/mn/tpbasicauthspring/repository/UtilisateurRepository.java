package org.mn.tpbasicauthspring.repository;

import java.util.Optional;

import org.mn.tpbasicauthspring.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	Optional<Utilisateur> findByLogin(String login);
}