package com.proj1.spring1proj.config;

import com.proj1.spring1proj.model.User;
import com.proj1.spring1proj.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner createTestUser(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.findByUsername("admin").isEmpty()) {

                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("password123"));

                userRepository.save(user);
            }
        };
    }
}