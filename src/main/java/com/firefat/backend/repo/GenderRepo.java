package com.firefat.backend.repo;

import com.firefat.backend.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepo extends JpaRepository<Gender, Long> {
}
