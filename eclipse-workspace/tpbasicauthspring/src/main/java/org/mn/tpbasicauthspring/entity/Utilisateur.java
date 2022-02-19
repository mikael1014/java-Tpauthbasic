package org.mn.tpbasicauthspring.entity;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.mn.tpbasicauthspring.enum_.RoleUtilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Mike
 */
@Entity
public class Utilisateur implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true,nullable = false)
    private String login;
    private String mdp;
    @Enumerated(EnumType.STRING)
    private RoleUtilisateur roleUtilisateur;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public RoleUtilisateur getRoleUtilisateur() {
		return roleUtilisateur;
	}
	public void setRoleUtilisateur(RoleUtilisateur roleUtilisateur) {
		this.roleUtilisateur = roleUtilisateur;
	}

	
	  @Override public String toString() { return "Utilisateur [id=" + id +
	  ", login=" + login + ", mdp=" + mdp + ", roleUtilisateur=" + roleUtilisateur
	  + "]"; }
	 
	
	
	public Utilisateur(String login, String mdp, RoleUtilisateur roleUtilisateur) {		
		this.login = login;
		this.mdp = mdp;
		this.roleUtilisateur = roleUtilisateur;
	}
	public Utilisateur() {
		super();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+roleUtilisateur);		
		return Collections.singletonList(grantedAuthority);
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return mdp;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

   
	
    
}
