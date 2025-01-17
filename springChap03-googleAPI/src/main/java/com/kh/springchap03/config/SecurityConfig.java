package com.kh.springchap03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests(authorizeHttpRequests) -> authorizeHttpRequests
		.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		.cors(Customizer.withDefaults())
		.csrf((csrf) -> csrf.disable());
		return http.build();
	}
}
