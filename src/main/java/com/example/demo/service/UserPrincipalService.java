package com.example.demo.service;

import com.example.demo.controller.errors.UserAlreadyExistException;
import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.service.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserPrincipal;
import java.util.Arrays;
import java.util.HashSet;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipal(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }
    
    @Transactional
    public UserDetails registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (userRepository.existsByUsername(userDto.getPassword())) {
            throw new UserAlreadyExistException("There is an account with that username: " + userDto.getUsername());
        } else {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.addAuthority(authorityRepository.getOne("USER"));
            
            userRepository.save(user);
            
            return new UserPrincipal(user);
        }
    }
}
