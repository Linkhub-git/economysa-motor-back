package com.economysa.motor.app.configuration.service.uploader;

import com.economysa.motor.app.configuration.controller.dto.CategoryDto;
import com.economysa.motor.app.configuration.entity.Category;
import com.economysa.motor.app.configuration.service.CategoryService;
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
public class CategoryUploader extends Uploader<Category> {

  private static final String RESOURCE_LOCATION = "classpath:category.xlsx";
  private final CategoryService service;

  public void load() {
    try {
      List<Category> items = getResults(RESOURCE_LOCATION);
    } catch (IOException ex) {
      System.out.println(ex);
    }
  }

  @Override
  protected Category iterateCell(Iterator<Cell> iterator) {
    int i = 0;
    String parent = "", name = "";
    while (iterator.hasNext()) {
      Cell cell = iterator.next();
      if (i == 0) {
        parent = cell.getStringCellValue();
      } else if (i == 1) {
        name = cell.getStringCellValue();
      }

      i++;
    }

    Category category = service.save(new CategoryDto(parent, name));
    return category;
  }
}
