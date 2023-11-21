package com.qta.be.service.utils;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.qta.be.dao.WebFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class CSVHelper {
    public List<WebFile> readCSV(String path) {
        List<WebFile> beans = null;
        try {
            beans = new CsvToBeanBuilder(new FileReader(path))
                    .withType(WebFile.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            log.error("", e);
        }

        beans.forEach(System.out::println);
        return beans;
    }

    public void writeCSV(String path, String[] record) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(path, true));
            writer.writeNext(record);
            writer.close();
        } catch (IOException e) {
            log.error("", e);
        }
    }
}
