package com.example.demo.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.KakaoDTO;


@Service
public class KakaoService {
	
	@Value("${kakao.client.id}")
	private String KAKAO_CLIENT_ID;
	
	@Value("${kakao.client.secret")
	private String KAKAO_CLIENT_SECRET;
	
	@Value("${kakao.redirect.url}")
	private String KAKAO_REDIRECT_URI;

	private final static String KAKAO_AUTH_URI="http://kauth.kakao.com";
	private final static String KAKAO_API_URI="https://kapi.kakao.com";
	
	public String getKakaoLogin() {
		return KAKAO_AUTH_URI + "/oauth/authorize" + "?client_id=" + KAKAO_CLIENT_ID + "&redirect_uri=" + KAKAO_REDIRECT_URI + "&response_type=code";
	}
	
	public KakaoDTO getKakaoInfo(String code) throws Exception {
		if (code == null) throw new Exception("존재하는 인증코드가 없음");
		String accessToken="";
		String refreshToken="";
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-type", "application/x-www-form-urlencoded");
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("grant_type", "aothorization_code");
			params.add("client_id", KAKAO_CLIENT_ID);
			params.add("client_secret", KAKAO_CLIENT_SECRET);
			params.add("code", code);
			params.add("redirect_uri", KAKAO_REDIRECT_URI);
			
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
			
			ResponseEntity<String> response = restTemplate.exchange(KAKAO_AUTH_URI + "/oauth/token", HttpMethod.POST, httpEntity, String.class);
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(response.getBody());
			
			accessToken = (String) jsonObj.get("access_token");
			refreshToken = (String) jsonObj.get("refresh_token");
		} catch (Exception err) {
			err.printStackTrace();
		}
		
		return getUserInforWithToken(accessToken);
	}
	
	private KakaoDTO getUserInforWithToken(String accessToken) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer"+accessToken);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		RestTemplate rt = new RestTemplate();
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = rt.exchange(KAKAO_API_URI + "/v2/users/m2", HttpMethod.POST, httpEntity, String.class);
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(response.getBody());
		JSONObject account = (JSONObject) jsonObj.get("kakao_account");
		JSONObject profile = (JSONObject) account.get("profile");
		
		long id = (long) jsonObj.get("id");
		String email = String.valueOf(account.get("email"));
		String nickname = String.valueOf(profile.get("nickname"));
		
		return KakaoDTO.builder()
				.id(id)
				.email(email)
				.nickname(nickname).build();
	}
}
