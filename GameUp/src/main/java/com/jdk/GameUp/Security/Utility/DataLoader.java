package com.jdk.GameUp.Security.Utility;

import com.jdk.GameUp.Security.Entity.Role;
import com.jdk.GameUp.Security.Entity.RoleName;
import com.jdk.GameUp.Security.Entity.User;
import com.jdk.GameUp.Security.Repository.RoleRepository;
import com.jdk.GameUp.Security.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private UserService userService;
    private RoleRepository roleRepository;

    public DataLoader(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = roleRepository.save(new Role(RoleName.ROLE_ADMIN));
        Role userRole = roleRepository.save(new Role(RoleName.ROLE_USER));

        userService.createUser("admin","admin","admin@admin.it", Set.of(adminRole));
        userService.createUser("user","user","user@user.it", Set.of(userRole));
    }
}
