package com.qta.be.service.impl;

import com.qta.be.server.controller.ChatController;
import com.qta.be.service.IOpenAPIService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.time.Duration;

@SpringBootTest
@RunWith(SpringRunner.class)
class OpenAIServiceImplTest {
  public static final Logger logger = LoggerFactory.getLogger(OpenAIServiceImplTest.class);
  @Autowired private IOpenAPIService openAPIService;
  @Autowired private ChatController chatController;

  @Test
  public void testLog() {
    logger.info("ttt");
    logger.error("ttt error");
  }

  @Test
  public void testTemplate() {
    String rs = openAPIService.template();
    System.out.println(rs);
  }

  @Test
  void chatCompletion() {
    String rs = openAPIService.chatCompletion("如何在微信上接入ChatGPT？", Duration.ofSeconds(60L));
    System.out.println(rs);
  }

  @Test
  void chatCompletionWithStreaming() {
    //    StreamingResponseBody rs = chatController.chatAPIWithStreaming("你好！", null);
    //    System.out.println(rs);
  }
}
