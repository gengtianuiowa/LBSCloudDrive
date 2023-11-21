package com.qta.be.server.controller;

import com.qta.be.dao.UploadFileReq;
import com.qta.be.service.utils.CSVHelper;
import com.qta.be.service.utils.GeoLocationHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class UploadControllerTest {
    @Autowired
    UploadController uploadController;
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
        String path = "/Users/alextian/work/iot/files.csv";
        csvHelper.readCSV(path);
        csvHelper.writeCSV(path, new String[]{"1", "2", "3", "4"});
        csvHelper.readCSV(path);
        Assertions.assertTrue(true);
    }

    @Test
    public void testIP() throws Exception {
        geoLocationHelper.getCity("96.54.49.225");
    }
}