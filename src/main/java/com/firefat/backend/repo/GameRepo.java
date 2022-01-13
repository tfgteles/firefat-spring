package com.firefat.backend.repo;

import com.firefat.backend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Long> {
}
