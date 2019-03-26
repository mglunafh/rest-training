package com.some.projects.rest.training.inventory.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiError {

  private int errorCode;
  private String description;

}
