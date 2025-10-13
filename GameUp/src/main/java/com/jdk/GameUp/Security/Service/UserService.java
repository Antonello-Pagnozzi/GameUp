package com.jdk.GameUp.Security.Service;

import com.jdk.GameUp.Entity.UserDTO;
import com.jdk.GameUp.Security.Entity.Role;
import com.jdk.GameUp.Security.Entity.RoleName;
import com.jdk.GameUp.Security.Entity.User;
import com.jdk.GameUp.Security.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public User createUser(String username, String password, String email, Set<Role> roles) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user);
    }

    public User createUser(UserDTO user) {
        User userCrea = new User();
        userCrea.setUsername(user.getUsername());
        userCrea.setEmail(user.getEmail());
        userCrea.setPassword(passwordEncoder.encode(user.getPassword()));
        //creazione ruoli
        Set<Role> nuoviRuoli = new HashSet<>();
        Role ruoloUser = roleService.findByRoleName(RoleName.ROLE_USER);
        nuoviRuoli.add(ruoloUser);
        userCrea.setRoles(nuoviRuoli);

        return userRepository.save(userCrea);
    }

    public User createUser(User user) {
       if (userRepository.findByUsername(user.getUsername()).isPresent()) {
           throw new IllegalArgumentException("ERRORE! Username già in utilizzo!");
       }
       if (user.getRoles().isEmpty()){
           Set<Role> nuoviRuoli = new HashSet<>();
           Role ruoloUser = roleService.findByRoleName(RoleName.ROLE_USER);
           nuoviRuoli.add(ruoloUser);
           user.setRoles(nuoviRuoli);
        }
       return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        Optional<User> utente = userRepository.findById(id);
        if (utente.isEmpty()){
            throw new EntityNotFoundException("ERRORE! Nessun utente con questo id!");
        }
        return utente;
    }

    public void deleteUser(Long id){
        Optional<User> utente = userRepository.findById(id);
        if (utente.isEmpty()) {
            throw new EntityNotFoundException("ERRORE! Nessun utente con questo id!");
        }
        userRepository.deleteById(id);
    }

}
