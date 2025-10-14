package com.jdk.GameUp.Repository;

import com.jdk.GameUp.Entity.Gioco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiocoRepository extends JpaRepository<Gioco, Long> {
}
