package org.mn.tpbasicauthspring.security;

import org.mn.tpbasicauthspring.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner{
	
	private final UtilisateurRepository utilisateurRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	public DbInit(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
		this.utilisateurRepository=utilisateurRepository;
		this.passwordEncoder= passwordEncoder;
	}


	/**
	 *
	 */
	/**
	 *
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 * Utilisateur user = new
		 * Utilisateur("dan",passwordEncoder.encode("123"),RoleUtilisateur.USER);
		 * Utilisateur admin = new
		 * Utilisateur("void",passwordEncoder.encode("1234"),RoleUtilisateur.ADMIN);
		 * utilisateurRepository.save(user); utilisateurRepository.save(admin);
		 */

	}
	

}
