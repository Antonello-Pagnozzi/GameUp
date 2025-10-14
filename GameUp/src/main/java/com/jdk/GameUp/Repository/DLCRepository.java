package com.jdk.GameUp.Repository;

import com.jdk.GameUp.Entity.DLC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DLCRepository extends JpaRepository<DLC, Long> {
}
