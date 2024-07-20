package com.excel_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobDataApplication.class, args);
		System.out.println("ETL app is running!!!");
	}

}
