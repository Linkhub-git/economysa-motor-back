package com.economysa.motor.app.configuration.service.uploader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Uploader<T> {

	private static FileInputStream stream;
	private static XSSFWorkbook workbook;

	protected List<T> getResults(String filename) throws IOException {
		Iterator<Row> iterator = getRowIterator(filename);
		List<T> items = new ArrayList<>();
		while (iterator.hasNext()) {
			Row row = iterator.next();
			items.add(iterateCell(row.cellIterator()));
		}

		stream.close();
		workbook.close();
		return items;
	}

	protected abstract T iterateCell(Iterator<Cell> iterator);

	private static Iterator<Row> getRowIterator(String filename) throws IOException {
		stream = getStream(filename);
		workbook = new XSSFWorkbook(stream);
		return workbook.getSheetAt(0).iterator();
	}

	private static FileInputStream getStream(String filename) throws FileNotFoundException {
		File file = ResourceUtils.getFile(filename);
		return new FileInputStream(file);
	}
}
