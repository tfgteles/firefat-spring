package com.firefat.backend.repo;

import com.firefat.backend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Long> {
}
