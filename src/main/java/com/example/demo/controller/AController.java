package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

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
			FileInputStream file = new FileInputStream(path02);
			
		}catch(Exception e) {
			System.out.println("path02 wrong");
		}
		try {
			path03 = new ClassPathResource("temp/a.txt").getPath();
			FileInputStream file = new FileInputStream(path03);
		}catch(Exception e) {
			System.out.println("path03 wrong");
		}

		try {
			InputStream file = new ClassPathResource("temp/a.txt").getInputStream();
			int available = file.available();
			System.out.println("path04 "+available);
		}catch(Exception e) {
			System.out.println("path04 wrong");
		}
		return "1:"+path01+"; 2:"+path02 +"; 3:"+path03;
	}
}
