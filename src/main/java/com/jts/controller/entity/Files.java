package com.jts.controller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "file_data")
public class Files {
	@Id
	private String id;

	private String desc1;

	private String desc2;

	private String val1;

	private String val2;

	private String val3;

	private String val4;

	private String val5;

	private String val6;

	private String val7;

}
