package com.qta.be.service.impl;

import com.qta.be.dao.types.register.VeriCodeType;
import com.qta.be.service.IRegisterService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RegisterServiceImplTest {
  @Autowired IRegisterService registerService;

  @Test
  void sendEmailVerCode() {
    registerService.registerByEmail(
        "tiangengwhu@gmail.com", "123456", "123456", "123132", "123123123");
  }

  @Test
  void sendPhoneMsg() {
    registerService.sendVeriPhoneMsg("+8615313978291", null);
  }
}
