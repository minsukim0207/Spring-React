package com.kh.springchap03.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap03.model.MemberGoogle;

public interface MemberDetailRepository extends JpaRepository<MemberGoogle, Long> {

	Optional<MemberGoogle> findByUsername(String username);
}
