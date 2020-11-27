package com.example.demo.service;

import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.UserRepository;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AuthorityRepository authorityRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private Logger logger = LoggerFactory.getLogger(DbInit.class);

    @Override
    public void run(String... args) throws Exception {
        /*
        authorityRepository.deleteAll();
        
        authorityRepository.saveAll(Arrays.asList(
            new Authority("ADMIN"),
            new Authority("USER")
        ));
        */
        /*
        userRepository.deleteAll();
        
        userRepository.saveAll(Arrays.asList(
                new User("adam", passwordEncoder.encode("test123")),
                new User("lucy", passwordEncoder.encode("test123")),
                new User("alice", passwordEncoder.encode("test123"))
        ));*/
    }

}
