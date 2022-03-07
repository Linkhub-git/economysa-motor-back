package com.economysa.motor.app.core.service.uploader;

import com.economysa.motor.app.configuration.controller.dto.UnityDto;
import com.economysa.motor.app.core.controller.dto.ProviderDto;
import com.economysa.motor.app.core.entity.Provider;
import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.util.Uploader;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class ProviderUploader extends Uploader<Provider> {

	private static final String RESOURCE_LOCATION = "classpath:provider.xlsx";
	private final ProviderService service;

	public void load() {
		try {
			List<Provider> items = getResults(RESOURCE_LOCATION);
			service.saveAll(items);
		} catch (IOException ex) {
			log.info(ex.getMessage());
		}
	}

	@Override
	protected Provider iterateCell(Iterator<Cell> iterator) {
		int i = 0;
		String code = "", name = "", ruc = "";
		while (iterator.hasNext()) {
			Cell cell = iterator.next();
			if (i == 0) {
				code = cell.getStringCellValue();
			} else if (i == 1) {
				name = cell.getStringCellValue();
			} else if (i == 2) {
				ruc = cell.getStringCellValue();
			}

			i++;
		}
		return service.init(new ProviderDto(code, name, ruc));
	}
}
