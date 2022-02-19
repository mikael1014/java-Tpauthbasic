package org.mn.tpbasicauthspring.security;

import java.util.Optional;

import org.mn.tpbasicauthspring.entity.Utilisateur;
import org.mn.tpbasicauthspring.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailsUtilisateurServices implements UserDetailsService {

	private final UtilisateurRepository utilisateurRepository;

	public DetailsUtilisateurServices(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Utilisateur> optionalUtilateur = utilisateurRepository.findByLogin(username);
		if (optionalUtilateur.isPresent()) {
			return optionalUtilateur.get();
		}
		throw new UsernameNotFoundException(username + " Pas en BD");
	}

}
