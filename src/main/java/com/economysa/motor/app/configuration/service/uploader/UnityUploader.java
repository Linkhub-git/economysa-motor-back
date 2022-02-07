package com.economysa.motor.app.configuration.service.uploader;

import com.economysa.motor.app.configuration.controller.dto.UnityDto;
import com.economysa.motor.app.configuration.entity.Unity;
import com.economysa.motor.app.configuration.service.UnityService;
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
public class UnityUploader extends Uploader<Unity> {

	private static final String RESOURCE_LOCATION = "classpath:unity.xlsx";
	private final UnityService service;

	public void load() {
		try {
			List<Unity> items = getResults(RESOURCE_LOCATION);
			service.saveAll(items);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	@Override
	protected Unity iterateCell(Iterator<Cell> iterator) {
		int i = 0;
		String code = "", name = "";
		while (iterator.hasNext()) {
			Cell cell = iterator.next();
			if (i == 0) {
				code = cell.getStringCellValue();
			} else if (i == 1) {
				name = cell.getStringCellValue();
			}

			i++;
		}
		return service.init(new UnityDto(code, name));
	}
}
