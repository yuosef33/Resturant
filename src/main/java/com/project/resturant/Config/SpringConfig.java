package com.project.resturant.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
public class SpringConfig {

@Autowired
private AuthFilter authFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.csrf(csrf -> csrf.disable());
        http.sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.securityMatcher("/**").cors(cors -> cors.configurationSource(corsConfigurationSource()));

        http.authorizeHttpRequests(
                api -> api
                        .requestMatchers( "/User/**").permitAll()
                    //    .requestMatchers( "/User/**").permitAll()
                     .requestMatchers(HttpMethod.GET, "/Category/**").hasRole("USER")
                     .requestMatchers(HttpMethod.GET, "/Products/**").hasRole("USER")
                     .requestMatchers(HttpMethod.GET, "/requestorder/**").hasRole("USER")
                     .requestMatchers(HttpMethod.POST, "/requestorder/**").hasRole("USER")
                     .requestMatchers(HttpMethod.POST, "/Products/**").hasRole("USER")
                     .requestMatchers(HttpMethod.POST, "/contactinfo/**").hasRole("USER")
                     .requestMatchers(HttpMethod.GET, "/Chefs/**").hasRole("USER")
                     //   .requestMatchers(HttpMethod.GET, "/teacher/allTeacher").hasAnyRole("EMPLOYEE","MANGER")
        );


http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration= new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization","Content-Type"));

        UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return source;

    }



}


