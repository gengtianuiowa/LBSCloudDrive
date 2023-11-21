package com.qta.be.dao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class AjaxHelper {

  public static final int SUCCESS_CODE = 0;
  public static final int FAILURE_CODE = -1;

  public static <T> Response<T> succeed(T data) {
    return new Response<>(SUCCESS_CODE, data, "success");
  }

  public static <T> Response<T> fail(int code, String message) {
    log.error("Response error code {}, message: {}", code, message);
    return new Response<>(code, null, message);
  }
}
