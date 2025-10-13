package com.jdk.GameUp.Security.Service;

import com.jdk.GameUp.Security.Entity.Role;
import com.jdk.GameUp.Security.Entity.RoleName;
import com.jdk.GameUp.Security.Repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role findByRoleName(RoleName name){
        Optional<Role> ruolo = roleRepository.findByRuolo(name);
        if (ruolo.isEmpty()){
            throw new EntityNotFoundException("ERRORE! Nessun ruolo con questo nome!");
        }
        return ruolo.get();
    }
}
