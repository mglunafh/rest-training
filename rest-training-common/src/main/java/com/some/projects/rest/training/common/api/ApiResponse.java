package com.some.projects.rest.training.common.api;

import lombok.Getter;

@Getter
public class ApiResponse {

  private Status status;
  private Object data;
  private ApiError error;

  public ApiResponse(Status status, Object data) {
    this.status = status;
    this.data = data;
  }

  public ApiResponse(Status status, Object data, ApiError error) {
    this.status = status;
    this.data = data;
    this.error = error;
  }
}