package com.aaron.todo.todoapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails userDetails = User.builder()
                .username("aaron").password(encoder.encode("password"))
                .roles("USER", "ADMIN").build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
