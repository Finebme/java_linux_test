package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AController {
	@GetMapping("/classloader")
	public String classloaderTest() {
		String path01 = "default";
		String path02 = "default";
		String path03 = "default";

		try {
			path01 = ClassLoader.getSystemClassLoader().getResource("temp/a.txt").getPath();
		}catch(Exception e) {
			System.out.println("ClassLoader wrong");
		}
		
		try {
			path02 = AController.class.getClassLoader().getResource("temp/a.txt").getPath();
		}catch(Exception e) {
			System.out.println("ACon class");
		}
		try {
			path03 = new ClassPathResource("temp/a.txt").getPath();
		}catch(Exception e) {
			System.out.println("ACon class");
		}

		return "1:"+path01+"; 2:"+path02 +"; 3:"+path03;
	}
}
