package com.hivetech.lib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.hivetech.lib.model.entity")
public class LibApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibApplication.class, args);
	}

}
