package com.qta.be.service.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CloudStorageUtilTest {
  @Autowired CloudStorageUtil cloudStorageUtil;

  @Test
  void uploadFile() throws Exception {
    cloudStorageUtil.uploadFile(
        "https://cdn.discordapp.com/attachments/1136680226361975039/1138081967477375127/gengtian_Bedroom_minimalist_decor_style_high_resolution._cca2ffdc-91a3-4912-b726-32673c007f65.png",
        "test/text.png");
  }

  @Test
  void getObjectUrl() {
    String objectUrl = cloudStorageUtil.getObjectUrl("test", "text");
    System.out.println(objectUrl.toString());
  }
}
