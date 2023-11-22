package com.qta.be.dao;

import lombok.Data;

@Data
public class WebFile {
    private String id;
    private String name;
    private String location;
    private String size;
    private String uploadTime;
}
