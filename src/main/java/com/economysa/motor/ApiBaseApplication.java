package com.economysa.motor;

import com.economysa.motor.app.configuration.service.uploader.BrandUploader;
import com.economysa.motor.app.configuration.service.uploader.CategoryUploader;
import com.economysa.motor.app.configuration.service.uploader.UnityUploader;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class ApiBaseApplication implements CommandLineRunner {


	@Autowired private UnityUploader unityUploader;
	@Autowired private CategoryUploader categoryUploader;
	@Autowired private BrandUploader brandUploader;

	public static void main(String[] args) {
		SpringApplication.run(ApiBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		categoryUploader.load();
//		brandUploader.load();
	}
}

