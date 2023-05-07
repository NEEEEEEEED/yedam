package com.yedam.moa.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yedam.moa.member.service.Logintest;

public interface UserRepository extends JpaRepository<Logintest, Long> {
	Optional<Logintest> findByEmail(String email);
}
