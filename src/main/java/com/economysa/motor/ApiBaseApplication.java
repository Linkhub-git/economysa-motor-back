package com.economysa.motor;

import com.economysa.motor.app.configuration.service.uploader.BrandUploader;
import com.economysa.motor.app.configuration.service.uploader.CategoryUploader;
import com.economysa.motor.app.configuration.service.uploader.UnityUploader;
import com.economysa.motor.app.core.service.uploader.ProductUploader;
import com.economysa.motor.app.core.service.uploader.ProviderUploader;
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
	@Autowired private ProviderUploader providerUploader;
	@Autowired private ProductUploader productUploader;

	public static void main(String[] args) {
		SpringApplication.run(ApiBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		categoryUploader.load();
//		brandUploader.load();
//		providerUploader.load();
//		productUploader.load();
	}
}

