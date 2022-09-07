package com.kpjunaid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class SocialAppApplication {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC-5"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SocialAppApplication.class, args);
	}
/*
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		//corsConfiguration.setAllowedOrigins(Collections.singletonList(SiteConstants.SITE_ROOT_FRONTEND));
		corsConfiguration.setAllowedHeaders(List.of(
				"Origins", "Accept-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept",
				"X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"
		));
		corsConfiguration.setExposedHeaders(List.of(
				"Origins", "Accept-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept",
				"X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"
		));
		corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter((CorsConfigurationSource) corsConfigurationSource);
	}*/

}
