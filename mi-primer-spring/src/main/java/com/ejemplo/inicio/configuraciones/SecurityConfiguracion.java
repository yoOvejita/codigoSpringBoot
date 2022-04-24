package com.ejemplo.inicio.configuraciones;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableJpaRepositories("com.ejemplo.inicio.*")
@ComponentScan(basePackages = {"com.ejemplo.inicio.*"})
@EntityScan("com.ejemplo.inicio.*")
public class SecurityConfiguracion {
	
	protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable();
    }
	
	/* Solicita seguridad para HTTPS
	Bean
	SecurityFilterChain filterChainE(HttpSecurity http) throws Exception {
			return http.requiresChannel(canal -> canal.anyRequest().requiresSecure())
					.authorizeRequests(autor -> autor.anyRequest().permitAll()).build();
	}*/
}
