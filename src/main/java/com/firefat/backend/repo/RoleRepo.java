package com.firefat.backend.repo;

import com.firefat.backend.domain.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
