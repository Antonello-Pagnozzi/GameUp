package com.jdk.GameUp.Security.Service;

import com.jdk.GameUp.Security.Entity.Role;
import com.jdk.GameUp.Security.Entity.User;
import com.jdk.GameUp.Security.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String username, String password, String email, Set<Role> roles) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setRoles(roles);

        // 🔑 qui la password viene criptata
        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user);
    }
}
