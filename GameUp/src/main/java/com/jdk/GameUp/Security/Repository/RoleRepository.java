package com.jdk.GameUp.Security.Repository;

import com.jdk.GameUp.Security.Entity.Role;
import com.jdk.GameUp.Security.Entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRuolo(RoleName name);
}
