package org.mn.tpbasicauthspring.security;

import org.mn.tpbasicauthspring.enum_.RoleUtilisateur;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final DetailsUtilisateurServices detailsUtilisateurServices;

	public SecurityConfiguration(DetailsUtilisateurServices detailsUtilisateurServices) {
		this.detailsUtilisateurServices = detailsUtilisateurServices;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// AuthenticationProvider daoAuthentificationProvider;
		auth.authenticationProvider(daoAuthentificationProvider());
	}

	@Bean
	public AuthenticationProvider daoAuthentificationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(detailsUtilisateurServices);
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.httpBasic().and().authorizeRequests()
		.antMatchers("/api/secured").authenticated()
		.antMatchers("/api/secured/admin").hasRole(RoleUtilisateur.ADMIN.name()); // commencer par les plus specifique pour finir par les generaux

	}
}