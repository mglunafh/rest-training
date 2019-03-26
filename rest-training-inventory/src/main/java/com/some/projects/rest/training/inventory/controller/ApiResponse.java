package com.some.projects.rest.training.inventory.controller;

import com.some.projects.rest.training.inventory.dto.RoomDto;
import lombok.Getter;

@Getter
public class ApiResponse {

  private Status status;
  private RoomDto roomDto;
  private ApiError error;

  public ApiResponse(Status status, RoomDto roomDto) {
    this.status = status;
    this.roomDto = roomDto;
  }

  public ApiResponse(Status status, RoomDto roomDto, ApiError error) {
    this.status = status;
    this.roomDto = roomDto;
    this.error = error;
  }
}