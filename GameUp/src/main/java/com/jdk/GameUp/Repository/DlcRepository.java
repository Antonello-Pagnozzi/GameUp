package com.jdk.GameUp.Repository;

import com.jdk.GameUp.Entity.Dlc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DlcRepository extends JpaRepository<Dlc, Long> {
}
