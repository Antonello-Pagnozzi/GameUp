package com.jdk.GameUp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disabilita CSRF (solo per test; abilita in produzione)
                .csrf(csrf -> csrf.disable())

                // Configurazione autorizzazioni
                .authorizeHttpRequests(auth -> auth
                        // Swagger e OpenAPI devono essere pubblici
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()

                        // Rotte per ruoli specifici
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")

                        // Tutte le altre richieste possono essere pubbliche
                        .anyRequest().permitAll()
                )

                // Login con form
                .formLogin(form -> form
                        //.loginPage("/login") // opzionale, se hai template personalizzato
                        .permitAll()
                )

                // Logout
                .logout(logout -> logout.permitAll());


        return http.build();
    }
}
