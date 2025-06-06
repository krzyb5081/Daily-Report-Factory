package com.krzyb5081.app.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.krzyb5081.app.model.UserModel;
import com.krzyb5081.app.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
    	
        return args -> {
            if (userRepository.count() == 0) {
                UserModel user1 = new UserModel();
                user1.setUserName("admin");
                user1.setPassword("admin123");
                user1.setRole("ADMIN");

                UserModel user2 = new UserModel();
                user2.setUserName("user");
                user2.setPassword("user123");
                user2.setRole("USER");

                userRepository.save(user1);
                userRepository.save(user2);

                System.out.println("📦 Test users added.");
            }
        };
    }
}

