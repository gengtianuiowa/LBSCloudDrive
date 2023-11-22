package com.qta.be.server.controller;

import com.qta.be.dao.AjaxHelper;
import com.qta.be.dao.Response;
import com.qta.be.dao.WebFile;
import com.qta.be.service.utils.CSVHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/file")
@Slf4j
public class FileBrowserController {
    @Autowired
    CSVHelper csvHelper;

    @GetMapping(value = "/get/all")
    public Response<List<WebFile>> getAllFiles() {
        List<WebFile> webFiles = csvHelper.readCSV();
        return AjaxHelper.succeed(webFiles);
    }

    @GetMapping(value = "/delete")
    public Response<Integer> deleteFile(@RequestParam String id) {
        int count = csvHelper.deleteFromCSV(id);
        return AjaxHelper.succeed(count);
    }
}
