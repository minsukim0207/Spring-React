package com.kh.springchap03.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public void socialLogin(String code, String registrationId) {

		System.out.println("code: " + code);
		System.out.println("Regist ID: " + registrationId);
		
	}
}
