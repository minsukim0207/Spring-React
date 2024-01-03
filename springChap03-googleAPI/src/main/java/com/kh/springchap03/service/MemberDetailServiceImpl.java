package com.kh.springchap03.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.springchap03.model.MemberGoogle;
import com.kh.springchap03.repository.MemberGoogleRepository;

@Service
public class MemberDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private MemberGoogleRepository memberGoogleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberGoogle user = memberGoogleRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("일치하는 사용자 정보 없음" + username));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), "", Collections.emptyList());
	}

}
