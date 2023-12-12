package com.example.onck3.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void  globalConfig(AuthenticationManagerBuilder authenticationManagerBuilder,
                              PasswordEncoder encoder) throws  Exception{
    authenticationManagerBuilder.inMemoryAuthentication()
            .withUser(User.withUsername("admin")
                    .password(encoder.encode("admin"))
                    .roles("ADMIN")
                    .build())
    ;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/admin/products/delete/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
        );
        http.httpBasic(Customizer.withDefaults());
        return  http.build();
    }
}
