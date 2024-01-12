package com.kh.xml.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlApiController {

	@GetMapping("/api-explorer")
	public ResponseEntity xamlApi() {
		StringBuilder result = new StringBuilder();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		List<String> headerList = new ArrayList<String>();
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get("isgi.d_0001.xml"));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				List<String> stringList = new ArrayList<String>();
				String stringArray[] = line.split("");
				stringList = Arrays.asList(stringArray);
				
				if (headerList.size() == 0) {
					headerList = stringList;
				} else {
					Map<String, Object> map = new HashMap<String, Object>();
					
					for (int i = 0; i < headerList.size(); i++) {
						map.put(headerList.get(i), stringList.get(i));
					}
					mapList.add(map);
				}
			}
			System.out.println(mapList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}
}
