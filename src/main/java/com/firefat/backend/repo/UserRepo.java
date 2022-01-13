package com.firefat.backend.repo;

import com.firefat.backend.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
