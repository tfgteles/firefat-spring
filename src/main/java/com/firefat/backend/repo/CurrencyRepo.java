package com.firefat.backend.repo;

import com.firefat.backend.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepo extends JpaRepository<Currency, Long> {
}
