package com.productservice.productservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        //.requestMatchers("/products").hasAuthority("admin")
                        //.anyRequest().authenticated()
                        //.requestMatchers("/getProducts").permitAll()
                        .anyRequest().permitAll()
                )
                //.csrf().disable()
                //.cors().disable()
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
                // Form login handles the redirect to the login page from the
                // authorization server filter chain
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    /*@Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(issuerUri);
    }*/
}
