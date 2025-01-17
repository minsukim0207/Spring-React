package com.kh.springchap01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq")
	@SequenceGenerator(name="users_seq", sequenceName="users_seq", allocationSize=1)
	private Long id;
	private String username;
	private String email;
	
}
