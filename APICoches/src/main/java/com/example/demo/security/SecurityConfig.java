package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
private PasswordEncoder passwordEncoder;	
	
	public SecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    return http
	            .csrf(csrf -> csrf.disable())
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .authorizeHttpRequests()
	            .requestMatchers("/login")
	            .anonymous()
	            .anyRequest()
	            .authenticated()
	            .and()
	            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
	            .build();
	}


    @Bean
    InMemoryUserDetailsManager userDetails() {
	    return new InMemoryUserDetailsManager(
	            User.withUsername("jcodepoint")
	            		.passwordEncoder(passwordEncoder::encode)
	                    .password("password")
	                    .authorities("read")
	                    .build()
	    );
	}
}
