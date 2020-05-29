package com.business.proxy.service;

import com.business.proxy.model.Role;
import com.business.proxy.model.Status;
import com.business.proxy.model.User;
import com.business.proxy.repository.RoleRepository;
import com.business.proxy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mmustafin@context-it.ru
 * @created: 28.05.2020
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User signUp(User user) {
        Role role = roleRepository.findByName("USER");

        User newUser = new User();
        newUser.getRoles().add(role);
        newUser.setStatus(Status.ACTIVE);
        newUser.setName(user.getName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());

        log.info("IN signUp - new user: {} successfully created", newUser.getName());

        return userRepository.save(newUser);
    }

    public User findOne(String name) {
        User result = userRepository.findByName(name);

        // TODO not found handler
        log.info("IN findOne - user: {} found by name: {}", result, name);

        return result;
    }

    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            log.warn("IN findById - no user found by id {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", user, id);

        return user;
    }

    public List<User> getAll() {
        List<User> result = userRepository.findAll();

        log.info("IN getAll - {} users found", result.size());

        return result;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);

        log.info("IN deleteById - user with id: {} deleted successfully", id);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getName(), user.getPassword(), new ArrayList<>());
    }
}
