package br.edu.ifrn.lajes.even.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.ifrn.lajes.even.services.CustomDetailsService;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private CustomDetailsService detailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
	    
		builder
	    	.userDetailsService(detailsService)
	    	.passwordEncoder(new BCryptPasswordEncoder());
	    	
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		builder
//			.inMemoryAuthentication()
//			.withUser("joao").password(encoder.encode("123")).roles("ADMIN", "USUARIO")
//			.and()
//			.withUser("jose").password(encoder.encode("123")).roles("USUARIO", "AVALIADOR");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
