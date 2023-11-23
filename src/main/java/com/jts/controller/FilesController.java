package com.jts.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jts.service.FileService;
import com.opencsv.exceptions.CsvException;

@RestController
@RequestMapping("/api")
public class FilesController {

	@Autowired
	private FileService fileService;

	@PostMapping("/uploadFilesIntoDB")
	public ResponseEntity<String> storeFilesIntoDB(@RequestParam MultipartFile file) throws IOException, CsvException {
		fileService.save(file);
		
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}

}
