package com.qta.be.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.qta.be.service.ITestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.SecureRandom;
import java.util.Base64;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class TestServiceImplTest {
  @Autowired ITestService testService;

  @Test
  void mybatisTest() {
    System.out.println(testService.mybatisTest());
  }

  @Test
  void genKey() {
    SecureRandom random = new SecureRandom();
    byte[] keyBytes = new byte[64];
    random.nextBytes(keyBytes);
    String keyString = Base64.getUrlEncoder().encodeToString(keyBytes);
    System.out.println(keyString);
  }

  @Test
  void testPayment() throws Exception {
    String privateKey =
        //
        // "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCRBmGp9BVBbKJ48ikhAZROG5u2fJeKOIjogzQBveGAorFZgi16sYYsiS7pn5Ot47qlDIlYOJZFCTKfxpDJNNV1LzOxzXPrdA5xVH7U3MlK3jz4S7g/H79TMtMQfTKBxN2u/pwa2Pw3bNJ06EfhlyD2rk7g8Y3vKoJ8EwDY7ILyc6RjzR84Js6UYzNtF4jVWNcfkpVu2cs0BYcgzOx/W+Up4QLnY/6QpjDNz+rh+RsOQsJVRv/y940Lt6rz1DDw6+g47uNP9aBZxG8IzkgJnAnRUOEX4DCF0joVqHV7MrN5xmMjz604E9VeGUJknoTrtIr0hz22Je1LyQUPcvhNJuTzAgMBAAECggEAYX6ixXh7maIIj7psf+3p36Cby9Byp89d6sHZgpo+MRYul/f1zxftFZ+b1B8dTrdb0H1fD9nq27pVOChrSXilT8RNwmhWV6GL3BBru3o6MIS7BEkTMgyLuMjgL6ObArZwOaadF0dsN26HBWTqffP1iyCfkoWRX4l6cyLrXOmTFp43TV3qis84vVk0r5yENy/2u9jAH6p2qhqCMvJML4nU1YLdrFUok/teRlWiLDJH2Q+uwS9zLZJPqmQmNBxlfuMksyosd8y3VGSWC1xwJ6BMGJicRWJcbpPQliLP1gjTDCvURIk2Nozg96YhxmNL7wXwLWVAx+Zi7sqbPRjxURvnYQKBgQDULmHddWbmQtoKHoJl86rxI2AVgR2IwSgzp8jBYkINWWHrrc7qgOIwphI9H3J25Ka+9tsGe5HZ7an8PfzMrUc+iKdUAqsOJd1jnMEqwDQwJNRrxpgg/H24PhNXRGrn8T7vg4B7/zfxEqEEe1tc2P2MlOecj2j02Twx7bIwbZ30WQKBgQCu+ZM72mBoirM0wrRl2vkQUlvTB0B1alD3H5ngMZmyErcEE/67Sx1Xej1Aax8V+521/anslZd6H6t7LlwYO12Fbdw06eDEPIyPhNAYWPC8dwN9Ye5HDmysFbw/Cdx8YGh9m0fMBAvsornJsp0r2RwrzddCJ3miIZDSe5gjucJqKwKBgF1WDezaQSqXS8zZwOjSOGcc9Z5gDrripSmb7B7Nd1rh78Y5zeSwT0+xLiK/G54bVRJ6Cr0eTHl+J6FzLypmKwniGSFGjzKJC4tPIFYK+KoY+WxzjuYry63peJ6R1Sk0oUfBJBrnmRct57DOBtGgDmDx+7SODVBv4x/ffNv6zFn5AoGBAJbA/yLVbrUDs40kqCsNtANlAipamCXRuPqCJqCr+4EacMa5t4KFID2rWzSyVrEo/eO8Lvhgloco3CUgd0aFd3krg0uvqfFJPc21n1kq4Bdw7vfLNXHRMr49Z9hkVaxvn/eAnyZe4is6tJncI2CRCZ2QFwOvYTPYeZ9vz1AQjznLAoGAKfQ2sB4wqRbdS0X5LNYqGSJ5pJJEwlMrDfuCmhVCqrKCT/izW84bgZJ0IsyUmlWkgWO9XEi5brqFhwY8UqH2IgMnwZmDm+yHuP7Xhuwn5yJMO+0118IRNtrg0EcuAbvhbNlwjIMi8c7wKGHaJ5XO0nlLpve+txYRS1HK0cMKSrE=";
        "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDUJ8VBSsEBeBsiXvW2l6XyBtV4hkmaRs3pklk7dmCsOqnnM9QNzyYdANSgxcI74a6bRghyuDwSsLJsUAy3a3Ha2g4MUjdc0aqQ9+5BnZVf2qxBWdr/xDhuKHvXpVPqFDMAlsOH82dLHNiLiiYxNtTCOxPwC32+1xwJ/KuWF3FgCNk/ByOomEqpe1fu0hEvEWrDiiUr1NpriLkzmfL0LySA6rsPoNq5TJp/CPpJ2FI3EM0CGZHp37Eo58UfInOQWD8vhlsJttORa0zXf2gv9ey8YqNY+sY1nd6JakKzHDxeEmOqUHanuOzT/+0MOHPe+nPkfqWmbpvVhB97XsQtaxFfAgMBAAECggEAeKgFrxRsoAFGrU2EQMwOPI9WaK02vt71zJjG1uKEKG9UoYEAYLom2ufWBXly9ctsGjLCKzxMLfUABEmicc5Rej35L1iy078KWlgm0HpmsZUT0jbgLgXSchPkGsiT6NSEDRmxKmhrnnRRU0rGXcbpSW1/8U0Xvqln8OYaT8oVWJ+mamr6SyioSC9F3DiLtvf8NPy1pTkERa0sVj9qpAg6XTgZNjoENlELD2igWeTafe6gOl6hKacaJWAsyZ2Tx7x8Ly38/gUIPtyaW0GxsA8ghlJLpFVHNNMSRSMMPKD5Q0pq2zeISorCQcRWNdzRDR+aQgjXyqoXYeG62N1zQtfFwQKBgQDx23c/0f1OroR9TWL5mbdZgSetSczIx5F3LfeMWf/C/W213CntnZUfYv7zPIh8AkOBe06VuyAWA7khC8s+Q467g9BNNcvCS1xhd15vpK10e+lpj42zytjVQE3WVJNoEODfYUEKdiDWVYEngSRUoGpy+1nSI12iB2dbsH2Q8dfptQKBgQDgj6zer6CeyKKwIdtk18IBkK2sWC16UwS0yJ3xpodOy0mnvzqFsegnpCxtIIH5PlroOs741DF8Zh01LetBIdED5JEZx2BWUNmAjwasC5RnLkQ+MSkT4t57r0bVUjDDWTOeEm0VePMoYDqVAnVi7SA+qQ3Ka+unBuub/iTB0bmrQwKBgGD/j/f8lAb2XxSR8NwCFlLDRdJuAr+TqneN6/ZSMg1V7qY9QmOWC7Sm03FiGasCjWhkt8O9ZMTvgVQLktvJ5Hi4CNaueKXX65j7cth7x0UsXRSFCmPNOuFsBMus5+GYw1dTfe5gKhNL/5yEYrm+DHNI82Ef5fGR3pYbVoDHPbzxAoGACInuDNmoxeDjLsdazE7X9a9Gq1L/B7O4bhdiyhmG85wPRO2kkAjfxwIbHlsqFgwk8MerrxKCfzRyz97bHzLl+7vpOI24QA/69UR7AHfAQNwlhCfiY/swcouLqfjiGct+hvg0Zaiftl1SXPAm/of9veQ3vga0gzlkJB5Zz3TmFnkCgYAtzMoANm2zZbqWLpYo8UshQYjAuekkt66FSi3DwSOzFJ0plBLNbik22UmJIs65PcgilyFLTkP6MESo9U2o/wRsn9iHNe2Y7qx38Bz6uOe2L9Hb2+hGHSGFiOw+QbW7TewTiP6qtgaAxEZbvet3v7lBILfk/NqB1z5x+BBRGVHw9g==";
    String publicKey =
        //
        // "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkQZhqfQVQWyiePIpIQGUThubtnyXijiI6IM0Ab3hgKKxWYIterGGLIku6Z+TreO6pQyJWDiWRQkyn8aQyTTVdS8zsc1z63QOcVR+1NzJSt48+Eu4Px+/UzLTEH0ygcTdrv6cGtj8N2zSdOhH4Zcg9q5O4PGN7yqCfBMA2OyC8nOkY80fOCbOlGMzbReI1VjXH5KVbtnLNAWHIMzsf1vlKeEC52P+kKYwzc/q4fkbDkLCVUb/8veNC7eq89Qw8OvoOO7jT/WgWcRvCM5ICZwJ0VDhF+AwhdI6Fah1ezKzecZjI8+tOBPVXhlCZJ6E67SK9Ic9tiXtS8kFD3L4TSbk8wIDAQAB";
        //
        // "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwgz1bJJda4HomHeGkWVY+hkSO/pQ/KhGDHsBk6N25bZZRhiYgt9x32lUwQCAoLu+hSHB4T7faeKkR8A4f7jVkQwxq2QXZC4bMPjJVJmfZE7MdnOskKxWLzh/oPIcc7S7ieHBzbBBPTuyuqIvxNMedMnG4S5+kVaLPeJlZcGtW+K+CUhHqj1OSJALTitiaBUh4WtXXl6X+A/ivZcQ0VRPHxKOzHQ2kB6VcAZcYqEYCMLxkMCqrpZCjgFpVu0fLCkuELQW473X4Go+RCxUp96wf4nOXbuVpOef2ctZN7Lfn7KYDOG0rCJTkJPbLxhkefNW0HZec2Pbg5uHiZAhRSZfOQIDAQAB";
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1CfFQUrBAXgbIl71tpel8gbVeIZJmkbN6ZJZO3ZgrDqp5zPUDc8mHQDUoMXCO+Gum0YIcrg8ErCybFAMt2tx2toODFI3XNGqkPfuQZ2VX9qsQVna/8Q4bih716VT6hQzAJbDh/NnSxzYi4omMTbUwjsT8At9vtccCfyrlhdxYAjZPwcjqJhKqXtX7tIRLxFqw4olK9Taa4i5M5ny9C8kgOq7D6DauUyafwj6SdhSNxDNAhmR6d+xKOfFHyJzkFg/L4ZbCbbTkWtM139oL/XsvGKjWPrGNZ3eiWpCsxw8XhJjqlB2p7js0//tDDhz3vpz5H6lpm6b1YQfe17ELWsRXwIDAQAB";
    //
    // "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgu8QiUIPGghF3UPZaBfv4ivGZDK1BwfNskSYvUMDk7w5YeX5uIdNgAPgxksJTSf1Lj7NaQ23u4c3a4ZbIK+ShOuxGlsnMzRQLrEHUp4Nze8syXJVcg9Oe061ZnH1ocEdtzmGg3b3J7m1jaTsQP5PlmiFCL67n4Nn2zocezGXnlmReJFLX4gaPJbAtcQGOYkFTsvaY0OJjshGl3rDLc60/HBSeJ2rw/meqvIgYb6kQfGXMiMvGJRKrFJTfKaM6zNKgkr73I2GPWIPzyZfcBm4nNITQ/HOagy9u+zk/Tt6rDYy3xtoB2dFmO2qL6ZlX0U4YtIhh1WfOe1FDIvrKlUytwIDAQAB";
    AlipayClient alipayClient =
        new DefaultAlipayClient(
            //            "https://openapi.alipay.com/gateway.do",
            "https://openapi.alipaydev.com/gateway.do",
            //            "2021003192659605",
            "2021000122690252",
            privateKey,
            "json",
            "GBK",
            publicKey,
            "RSA2");
    AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
    // 异步接收地址，仅支持http/https，公网可访问
    request.setNotifyUrl("");
    // 同步跳转地址，仅支持http/https
    request.setReturnUrl("");
    /******必传参数******/
    JSONObject bizContent = new JSONObject();
    // 商户订单号，商家自定义，保持唯一性
    bizContent.put("out_trade_no", "20210817010101004");
    // 支付金额，最小值0.01元
    bizContent.put("total_amount", 0.01);
    // 订单标题，不可使用特殊符号
    bizContent.put("subject", "test");
    // 电脑网站支付场景固定传值FAST_INSTANT_TRADE_PAY
    bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");

    /******可选参数******/
    // bizContent.put("time_expire", "2022-08-01 22:00:00");

    //// 商品明细信息，按需传入
    // JSONArray goodsDetail = new JSONArray();
    // JSONObject goods1 = new JSONObject();
    // goods1.put("goods_id", "goodsNo1");
    // goods1.put("goods_name", "子商品1");
    // goods1.put("quantity", 1);
    // goods1.put("price", 0.01);
    // goodsDetail.add(goods1);
    // bizContent.put("goods_detail", goodsDetail);

    //// 扩展信息，按需传入
    // JSONObject extendParams = new JSONObject();
    // extendParams.put("sys_service_provider_id", "2088511833207846");
    // bizContent.put("extend_params", extendParams);

    request.setBizContent(bizContent.toString());
    AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
    if (response.isSuccess()) {
      System.out.println("调用成功");
    } else {
      System.out.println("调用失败");
    }
    System.out.println(response.getBody());
  }
}
