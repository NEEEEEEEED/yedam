package com.yedam.moa.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yedam.moa.member.service.Member;

public interface UserRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByEmail(String email);
}
