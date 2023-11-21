package com.qta.be.dao;

import lombok.Data;

@Data
public class WebFile {
    private String name;
    private String location;
    private float size;
    private String uploadTime;
}
