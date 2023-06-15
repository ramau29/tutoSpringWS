package com.tutoSpringWS.util;

import com.tutoSpringWS.model.Authority;
import com.tutoSpringWS.model.User;
import com.tutoSpringWS.repository.AuthorityRepository;
import com.tutoSpringWS.repository.UserRepository;
import com.tutoSpringWS.security.WebSecurityConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder encoder;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        encoder = WebSecurityConfig.passwordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
        }

        if (this.userRepository.count() == 0) {
            this.userRepository.saveAll(List.of(
                    new User("userAdmin", encoder.encode("passAdmin"), List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("userRead", encoder.encode("passRead"), List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                    new User("userWrite", encoder.encode("passWrite"), List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get()))
            ));
        }

    }
}
