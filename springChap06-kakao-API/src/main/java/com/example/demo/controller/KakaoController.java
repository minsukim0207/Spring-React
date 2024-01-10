package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.MsgEntity;
import com.example.demo.dto.KakaoDTO;
import com.example.demo.service.KakaoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("kakao")
public class KakaoController {

	private final KakaoService kakaoService;
	
	@GetMapping("/callback")
	public ResponseEntity<MsgEntity> callback(HttpServletRequest request) throws Exception {
		KakaoDTO kakaoInfo = kakaoService.getKakaoInfo(request.getParameter("code"));
		
		return ResponseEntity.ok()
				.body(new MsgEntity("Success", kakaoInfo));
	}
}
