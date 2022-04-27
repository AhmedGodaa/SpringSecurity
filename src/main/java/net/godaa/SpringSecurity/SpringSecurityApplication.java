package net.godaa.SpringSecurity;

import net.godaa.SpringSecurity.models.Role;
import net.godaa.SpringSecurity.models.User;
import net.godaa.SpringSecurity.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {

            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));

            userService.saveUser(new User(null, "ahmed", "ahmed@gmail.com", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "ali", "ali@gmail.com", "password", new ArrayList<>()));

            userService.addRoleToUser("ahmed", "ROLE_ADMIN");
        };

    }
}
