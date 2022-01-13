package com.firefat.backend.repo;

import com.firefat.backend.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
