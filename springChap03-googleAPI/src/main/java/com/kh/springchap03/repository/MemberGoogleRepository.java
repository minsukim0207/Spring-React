package com.kh.springchap03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap03.model.MemberGoogle;

public interface MemberGoogleRepository extends JpaRepository<MemberGoogle, Long> {

	MemberGoogle findByUsername(String username);
}
