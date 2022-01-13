package com.firefat.backend.repo;

import com.firefat.backend.domain.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberStatusRepo extends JpaRepository<MemberStatus, Long> {
}
