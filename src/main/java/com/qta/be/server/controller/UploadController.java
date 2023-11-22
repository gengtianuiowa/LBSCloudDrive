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
import java.util.Date;
import java.util.UUID;

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
        String[] newRecord = new String[5];
        newRecord[0] = UUID.randomUUID().toString();
        newRecord[1] = req.getName();
        Path file = Paths.get(filePath + "/" + req.getName());
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println(new Date(attr.lastModifiedTime().toMillis()).getTime() / 1000);
            newRecord[2] = geoLocationHelper.getCity("96.54.49.225");
            newRecord[3] = Long.toString(attr.size());
            newRecord[4] = new Date(attr.lastModifiedTime().toMillis()).toString();
        } catch (Exception e) {
            log.error("Read file meta data error!", e);
        }
        csvHelper.writeCSV(csvPath, newRecord);
        return AjaxHelper.succeed(newRecord[2]);
    }

}