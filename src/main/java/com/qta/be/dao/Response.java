package com.qta.be.dao;

import lombok.Data;

@Data
public class Response<T> {
  private int code = 0;
  private T data;
  private String message = "success!";

  public Response() {}

  public Response(int code, T data, String message) {
    this.code = code;
    this.data = data;
    this.message = message;
  }
}
