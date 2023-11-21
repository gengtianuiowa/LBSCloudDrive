package com.qta.be.server.controller;

import com.qta.be.dao.AjaxHelper;
import com.qta.be.dao.Response;
import com.qta.be.dao.UploadFileReq;
import com.qta.be.service.utils.CSVHelper;
import com.qta.be.service.utils.GeoLocationHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

@RestController
@RequestMapping("/api")
@Slf4j
public class UploadController {
    @Autowired
    CSVHelper csvHelper;
    @Autowired
    GeoLocationHelper geoLocationHelper;
    @Value("${filePath}")
    private String filePath;
    @Value("${csvPath}")
    private String csvPath;

    @PostMapping(value = "/upload")
    public Response<String> uploadFile(@RequestBody UploadFileReq req, HttpServletRequest request) {
        String[] newRecord = new String[4];
        newRecord[0] = req.getName();
        Path file = Paths.get(filePath + "/" + req.getName());
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println(attr.lastModifiedTime().toMillis());
            newRecord[1] = geoLocationHelper.getCity("96.54.49.225");
            newRecord[2] = Long.toString(attr.lastModifiedTime().toMillis());
        } catch (Exception e) {
            log.error("Read file meta data error!", e);
        }
        csvHelper.writeCSV(csvPath, newRecord);
        return AjaxHelper.succeed(newRecord[2]);
    }
}