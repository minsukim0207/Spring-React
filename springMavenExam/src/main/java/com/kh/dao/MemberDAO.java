package com.kh.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.vo.MemberVO;

@Mapper
public interface MemberDAO {
	MemberVO loginMember(String memberId, String memberPassword);
}
