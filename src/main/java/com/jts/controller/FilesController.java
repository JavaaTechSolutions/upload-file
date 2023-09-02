package com.jts.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jts.service.FilesService;

@RestController
@RequestMapping("/api")
public class FilesController {
	
	@Autowired
	private FilesService filesService;
	
	@PostMapping("/uploadFilesIntoDB")
	public ResponseEntity<String> storeFilesIntoDB(@RequestParam("file") MultipartFile file) throws IOException {
		String response = filesService.storeFile(file);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/getFileByName/{fileName}")
	public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
		byte[] imageData = filesService.getFiles(fileName);
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
	}

}
