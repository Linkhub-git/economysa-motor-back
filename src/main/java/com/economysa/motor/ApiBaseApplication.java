package com.economysa.motor;

import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.repository.ProductRepository;
import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.app.security.repository.UserRepository;
import com.economysa.motor.util.UtilCore;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@Log4j2
public class ApiBaseApplication implements CommandLineRunner {

	@Autowired private UserRepository repository;
	@Autowired ResourceLoader resourceLoader;
	@Autowired private ProductService productService;
	@Autowired private ProductRepository productRepository;
	@Autowired private ProviderService providerService;

	public static void main(String[] args) {
		SpringApplication.run(ApiBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User user = new User();
		user.setId(1L);
		user.setEmail("jcieza90@gmail.com");
		user.setPassword("{bcrypt}$2a$10$51VMRmGqcLqojqXkZFFwIufc7trvCmTp/dDVmeBSTUVZoQhrEB/YK");
		user.setRole("ROLE_USER");
		user.setName("Jeferson");
		user.setLastName("Cieza");
		user.setPhone("983552193");
		user.setCreationDate(new Date());
		user.setStatus(Boolean.TRUE);
		repository.save(user);*/
	}

	private List<String> read2() {
		int i = 0;
		int j = 0;
		List<String> numbers = new ArrayList<>();
		try {
//			Resource resource = resourceLoader.getResource("classpath:config/listas.xlsx");
//			File file = resource.getFile();

//			String fileName = "config/listas.xlsx";
//			ClassLoader classLoader = getClass().getClassLoader();
//			File file = new File(classLoader.getResource(fileName).getFile());

			File file = ResourceUtils.getFile("classpath:listas.xlsx");

			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIt = sheet.iterator();

			while(rowIt.hasNext()) {
				j++;
				Row row = rowIt.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				int providerId = 0;
				String providerCode = "";
				String productName = "";

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (i == 0) {
						providerId = (int) cell.getNumericCellValue();
					}
					if (i == 1) {
						providerCode = cell.getStringCellValue();
					}
					if (i == 2) {
						productName = cell.getStringCellValue();
					}
					i++;
				}

				Product product = new Product();
				product.setProvider(providerService.get(Long.valueOf(providerId)));
				product.setName(productName);
				product.setPurchasePackaging("---");
				product.setMasterStockAmount(BigDecimal.ZERO);
				product.setSalesPackaging(BigDecimal.ZERO);
				product.setStockAmount(BigDecimal.ZERO);
				product.setStock(BigDecimal.ZERO);
				product.setBasePrice(BigDecimal.ZERO);
				product.setMargin(BigDecimal.ZERO);
				product.setFinalPrice(BigDecimal.ZERO);
				product.setCreationUser("jcieza90@gmail.com");
				product.setCreationDate(UtilCore.UtilDate.fechaActual());
				product.setStatus(Boolean.TRUE);

				productRepository.save(product);
				log.info("J ==> " + j);
				i = 0;
			}

			workbook.close();
			fis.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return numbers;
	}
}

