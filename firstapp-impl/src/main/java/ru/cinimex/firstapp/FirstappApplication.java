package ru.cinimex.firstapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstappApplication implements CommandLineRunner {

//    @Autowired
//    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FirstappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        UserEntity admin = new UserEntity();
//        admin.setUsername("admin");
//        admin.setPassword(passwordEncoder.encode("123"));
//        admin.setRoles(Set.of("ROLE_USER", "ROLE_ADMIN"));
//        userRepository.save(admin);
//
//        UserEntity user = new UserEntity();
//        user.setUsername("user");
//        user.setPassword(passwordEncoder.encode("123"));
//        user.setRoles(Set.of("ROLE_USER"));
//        userRepository.save(user);
    }

}
