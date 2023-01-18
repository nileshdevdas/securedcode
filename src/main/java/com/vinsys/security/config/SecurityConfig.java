package com.vinsys.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// decide what you wish to whitelist ?
		http.csrf().disable();
		// always and always disable / same site to be enabled for
		/// for frameOptions
		// Same Origin means my own side can embed iframes for other pages
		http.headers().frameOptions().sameOrigin();
		http.authorizeHttpRequests((r) -> r.requestMatchers("/cookies/**", "/framedemo.html", "/register/**", "/sense",
				"/cookieHack.html", "/login/**", "/error/**", "/", "/index.html").permitAll());
//		http.headers().contentSecurityPolicy(
//				"default-src 'self'; script-src 'self' ajax.googleapis.com maxcdn.bootstrapcdn.com; script-src-elem 'self' ajax.googleapis.com maxcdn.bootstrapcdn.com; script-src-attr 'self' ajax.googleapis.com maxcdn.bootstrapcdn.com; style-src 'self' maxcdn.bootstrapcdn.com; style-src-elem 'self' maxcdn.bootstrapcdn.com; style-src-attr 'self' maxcdn.bootstrapcdn.com; font-src 'self' maxcdn.bootstrapcdn.com");
		return http.build();
	}
}
