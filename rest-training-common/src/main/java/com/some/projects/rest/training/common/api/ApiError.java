package com.some.projects.rest.training.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiError {

  private int errorCode;
  private String description;

}
