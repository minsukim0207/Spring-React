package com.kh.springchap01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kh.springchap01.model.*;

public interface UserRepository extends JpaRepository<Users, Long> {

}
