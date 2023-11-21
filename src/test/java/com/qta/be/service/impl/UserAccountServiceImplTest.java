package com.qta.be.service.impl;

import com.qta.be.dao.types.chat.CreditOperaterEnum;
import com.qta.be.service.IUserAccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserAccountServiceImplTest {
  @Autowired IUserAccountService userAccountService;

  @Test
  void selectAndUpdateCredit() {
    userAccountService.selectAndChangeCredit(5L, 5, CreditOperaterEnum.MINUS);
  }
}
