package com.firefat.backend.repo;

import com.firefat.backend.domain.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepo extends JpaRepository<Weight, Long> {
}
