package com.economysa.motor.app.core.service.uploader;

import com.economysa.motor.app.core.controller.dto.ProductDto;
import com.economysa.motor.app.core.controller.dto.ProviderDto;
import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.entity.Provider;
import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.util.Uploader;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class ProductUploader extends Uploader<Product> {

	private static final String RESOURCE_LOCATION = "classpath:product.xlsx";
	private final ProductService service;

	public void load() {
		try {
			List<Product> items = getResults(RESOURCE_LOCATION);
			service.saveAll(items);
		} catch (IOException ex) {
			log.info(ex.getMessage());
		}
	}

	@Override
	protected Product iterateCell(Iterator<Cell> iterator) {
		int i = 0;
		String code = "", name = "", category = "", brand = "", provider = "",
				unitMaster = "", unitMasterDescription = "",
				unitMin = "", unitMinDescription = "";
		Integer chatBot = 0, tomaPedido = 0, unitMasterEquivalent = 0,
				unitMinEquivalent = 0;
		while (iterator.hasNext()) {
			Cell cell = iterator.next();
			if (i == 0) {
				code = cell.getStringCellValue();
			} else if (i == 1) {
				name = cell.getStringCellValue();
			} else if (i == 2) {
				category = cell.getStringCellValue();
			} else if (i == 3) {
				brand = cell.getStringCellValue();
			} else if (i == 4) {
				provider = cell.getStringCellValue();
			} else if (i == 5) {
				try {
					chatBot = Integer.valueOf(cell.getStringCellValue());
				} catch (IllegalStateException ex) {
					chatBot = (int)cell.getNumericCellValue();
				}
			} else if (i == 6) {
				tomaPedido = (int)cell.getNumericCellValue();
			} else if (i == 7) {
				unitMaster = cell.getStringCellValue();
			} else if (i == 8) {
				unitMasterDescription = cell.getStringCellValue();
			} else if (i == 9) {
				unitMasterEquivalent = (int)cell.getNumericCellValue();
			} else if (i == 10) {
				unitMin = cell.getStringCellValue();
			} else if (i == 11) {
				unitMinDescription = cell.getStringCellValue();
			} else if (i == 12) {
				unitMinEquivalent = (int)cell.getNumericCellValue();
			}

			i++;
		}
		return service.init(new ProductDto(code, name, category, brand, provider,
				chatBot, tomaPedido, unitMaster, unitMasterDescription, unitMasterEquivalent,
				unitMin, unitMinDescription, unitMinEquivalent));
	}
}
