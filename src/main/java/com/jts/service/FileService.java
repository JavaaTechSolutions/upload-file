package com.jts.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jts.controller.entity.FileRepository;
import com.jts.controller.entity.Files;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class FileService {

	private final String FILE_PATH = "E:\\projects\\images\\storage\\";

	@Autowired
	private FileRepository fileRepository;

	public void save(MultipartFile file) throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader(FILE_PATH + file.getOriginalFilename()));

		List<String[]> rows = reader.readAll();
		List<Files> filesList = new ArrayList<>();

		for (String[] row : rows) {
			System.out.println(row[0] + "," + row[1] + "," + row[2] + "," + row[3]);

			Files files = new Files();
			files.setId(row[0]);
			files.setDesc1(row[1]);
			files.setDesc2(row[2]);
			files.setVal1(row[3]);
			files.setVal2(row[4]);
			files.setVal3(row[5]);
			files.setVal4(row[6]);
			files.setVal5(row[7]);
			files.setVal6(row[8]);
			files.setVal7(row[9]);

			filesList.add(files);
		}

		fileRepository.saveAll(filesList);

	}
}
