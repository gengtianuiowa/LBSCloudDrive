package com.qta.be.server.controller;

import com.qta.be.dao.Response;
import com.qta.be.dao.UploadFileReq;
import com.qta.be.dao.WebFile;
import com.qta.be.service.utils.CSVHelper;
import com.qta.be.service.utils.GeoLocationHelper;
import org.apache.commons.collections.functors.TruePredicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class UploadControllerTest {
    @Autowired
    UploadController uploadController;
    @Autowired
    FileBrowserController fileBrowserController;
    @Autowired
    CSVHelper csvHelper;
    @Autowired
    GeoLocationHelper geoLocationHelper;

    @Test
    public void testController() {
        UploadFileReq uploadFileReq = new UploadFileReq();
        uploadFileReq.setName("file.txt");
//        uploadController.uploadFile(uploadFileReq);
    }

    @Test
    public void testParsing() {
        try {
            String path = "/Users/alextian/work/iot/files.csv";
            csvHelper.readCSV();
            csvHelper.writeCSV(path, new String[]{"1", "2", "3", "4"});
            csvHelper.readCSV();
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    // IP search test1
    @Test
    public void testIP1() throws Exception {
        String city = geoLocationHelper.getCity("96.54.49.225");
        Assertions.assertEquals(city, "Victoria");
    }

    // IP search test2
    @Test
    public void testIP2() throws Exception {
        String city = geoLocationHelper.getCity("66.183.83.48");
        Assertions.assertEquals(city, "Vancouver");
    }

    // Test File Browser
    @Test
    public void testFileBrowser() throws Exception {
        Response<List<WebFile>> allFiles = fileBrowserController.getAllFiles();
        for (WebFile file : allFiles.getData()) {
            if (!file.getLocation().equals("Victoria") || !file.getId().equals("76fd934e-9408-4d32-b433-2ad171ccc5c0") || !file.getUploadTime().equals("Assignment 1.log") || !file.getSize().equals(11114) || !file.getUploadTime().equals("Fri Sep 29 18:30:15 PDT 2023")) {
                Assertions.assertTrue(false);
            }
        }
        Assertions.assertTrue(true);
    }

    // Test Delete File
    @Test
    public void testDeleteFile() throws Exception {
        Response<Integer> integerResponse = fileBrowserController.deleteFile("76fd934e-9408-4d32-b433-2ad171ccc5c0");
        List<WebFile> webFiles = csvHelper.readCSV();
        for (WebFile file : webFiles) {
            if (file.getId().equals("76fd934e-9408-4d32-b433-2ad171ccc5c0")) {
                Assertions.assertTrue(false);
            }
        }
        Assertions.assertTrue(true);
    }
}