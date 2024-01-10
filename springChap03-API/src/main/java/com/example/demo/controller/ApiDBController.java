package com.example.demo.controller;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv-data")
public class ApiDBController {
	
	/*
	produces = MediaType.TEXT_PLAIN_VALUE
	가지고 올 타입 지정
	 */
	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<InputStreamResource> csvData() {
		String csvFileName = "cultureMap.csv";
		Path csvFilePath = Paths.get(getClass().getResource(csvFileName).toURI());
		
		InputStreamResource resource = new InputStreamResource(new FileInputStream(csvFilePath.toFile()));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + csvFileName);
		return ResponseEntity.ok().headers(headers).body(resource);
	}

}
