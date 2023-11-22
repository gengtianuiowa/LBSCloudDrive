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
import java.util.stream.Collectors;

@Slf4j
@Component
public class CSVHelper {
    private final String path = "/Users/alextian/work/iot/files.csv";

    public List<WebFile> readCSV() {
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

    public int deleteFromCSV(String id) {
        try {
            List<WebFile> webFiles = readCSV();
            List<WebFile> filtered = webFiles.stream()
                    .filter(f -> !f.getId().equals(id))
                    .collect(Collectors.toList());
            FileWriter fw = new FileWriter(path);
            CSVWriter w = new CSVWriter(fw);
            w.writeNext(new String[]{"id", "name", "location", "size", "uploadTime"});
            filtered.forEach(line -> w.writeNext(new String[]{line.getId(), line.getName(), line.getLocation(), line.getSize(), line.getUploadTime()}));
            w.close();
            return 1;
        } catch (IOException e) {
            log.error("", e);
            return 0;
        }
    }
}
