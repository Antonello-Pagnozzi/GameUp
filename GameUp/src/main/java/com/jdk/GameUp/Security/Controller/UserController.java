package com.jdk.GameUp.Security.Controller;

import com.jdk.GameUp.Security.Entity.UserDTO;
import com.jdk.GameUp.Security.Entity.User;
import com.jdk.GameUp.Security.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.of(Optional.ofNullable(userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        return ResponseEntity.of(userService.findById(id));
    }

    @PostMapping("/register")
    public User registraUtente(@RequestBody UserDTO user){
        return userService.createUser(user);
    }

    @DeleteMapping("/cancella/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void cancellaUtente(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
