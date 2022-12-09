package com.mimoudix.usermanagement;

import com.mimoudix.usermanagement.entities.User;
import com.mimoudix.usermanagement.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class UserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User(null, "Hassan", new Date(), false, 12));
            userRepository.save(new User(null, "Mohamed", new Date(), false, 12));
            userRepository.save(new User(null, "Adam", new Date(), false, 12));
            userRepository.save(new User(null, "Mohcine", new Date(), false, 12));
            userRepository.save(new User(null, "Ahmed", new Date(), false, 12));
            userRepository.save(new User(null, "Ali", new Date(), false, 12));
            userRepository.save(new User(null, "Oussama", new Date(), false, 12));
            userRepository.save(new User(null, "Hamza", new Date(), false, 12));
            userRepository.findAll().forEach(p -> {
                System.out.println(p.getName());
            });
        };
    }
}
