package com.eleos.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableScheduling
public class WebConfig {
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());

		http.cors().and().csrf().disable().authorizeHttpRequests().anyRequest().permitAll();
	    http.headers().frameOptions().disable();
        return http.build();
	}

}
