package com.firefat.backend.repo;

import com.firefat.backend.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
}
