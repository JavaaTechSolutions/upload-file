package com.jts.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jts.entity.FileRepository;
import com.jts.entity.Files;

@Service
public class FilesService {
	
	@Autowired
	private FileRepository fileRepository;

	public String storeFile(MultipartFile file) throws IOException {
		Files files = Files
		.builder()
		.name(file.getOriginalFilename())
		.type(file.getContentType())
		.imageData(file.getBytes())
		.build();
		
		files = fileRepository.save(files);
		
		if (files.getId() != null) {
			return "File uploaded successfuly into database";
		}
		
		return null;
	}
	
	public byte[] getFiles(String fileName) {
		return fileRepository.findByName(fileName).getImageData();
	}
}
