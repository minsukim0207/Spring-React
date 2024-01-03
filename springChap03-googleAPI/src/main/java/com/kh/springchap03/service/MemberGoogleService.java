package com.kh.springchap03.service;

import com.kh.springchap03.model.MemberGoogle;

public interface MemberGoogleService {
	
	MemberGoogle findByUsername(String username);
	void saveMember(MemberGoogle user);

}
