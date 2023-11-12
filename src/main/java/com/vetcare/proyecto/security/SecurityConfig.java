package com.vetcare.proyecto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
            .authorizeHttpRequests(request -> request
                .requestMatchers(new AntPathRequestMatcher("/h2/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/Clientes/todos")).hasAuthority("VETERINARIO")
                .requestMatchers(new AntPathRequestMatcher("/Clientes/find/**")).hasAnyAuthority("VETERINARIO","CLIENTE")
                .requestMatchers(new AntPathRequestMatcher("/Mascota/todas")).hasAuthority("VETERINARIO")
                .requestMatchers(new AntPathRequestMatcher("/Mascota/find/**")).hasAnyAuthority("VETERINARIO","CLIENTE")
                .requestMatchers(new AntPathRequestMatcher("/Clientes/details")).hasAuthority("CLIENTE")

                .anyRequest().permitAll())
        
        .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtEntryPoint));

        http.addFilterBefore(jwtAunthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    JwtAunthenticationFilter jwtAunthenticationFilter(){
        return new JwtAunthenticationFilter();
    }
}
