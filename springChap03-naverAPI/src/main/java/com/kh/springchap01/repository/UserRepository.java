package com.kh.springchap01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap01.model.UserSNS;

public interface UserRepository  extends JpaRepository<UserSNS, Long>{

}