package com.some.projects.rest.training.inventory.controller;

import com.some.projects.rest.training.common.api.ApiError;
import com.some.projects.rest.training.common.api.ApiResponse;
import com.some.projects.rest.training.common.api.Status;
import com.some.projects.rest.training.common.domain.Room;
import com.some.projects.rest.training.common.domain.RoomCategory;
import com.some.projects.rest.training.common.dto.RoomDto;
import com.some.projects.rest.training.common.exception.RecordNotFoundException;
import com.some.projects.rest.training.inventory.service.InventoryService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

  private final InventoryService inventoryService;
  private ModelMapper mapper = new ModelMapper();

  @Autowired
  public RoomResource(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @GetMapping
  public List<RoomDto> getRoomsInCategory(@RequestParam("categoryId") long categoryId) {

    RoomCategory roomCategory = inventoryService.getRoomCategory(categoryId);
    return inventoryService.getAllRoomsWithCategory(roomCategory)
        .stream().map(RoomDto::new).collect(Collectors.toList());
  }

  @GetMapping("/{roomId}")
  public ApiResponse getRoom(@PathVariable("roomId") Long roomId) {

    ApiResponse response;
    try {
      Room room = inventoryService.getRoom(roomId);
      RoomDto roomDto = mapper.map(room, RoomDto.class);
      response = new ApiResponse(Status.OK, roomDto);
    } catch (RecordNotFoundException ex) {
      response = new ApiResponse(Status.ERROR, null,
          new ApiError(999, "no room with ID " + roomId));
    }
    return response;
  }

  @PostMapping
  public ApiResponse addRoom(@RequestBody RoomDto roomDto) {
    Room newRoom = inventoryService.createRoom(roomDto);
    return new ApiResponse(Status.OK, mapper.map(newRoom, RoomDto.class));
  }

  @PutMapping("/{roomId}")
  public ApiResponse updateRoom(@PathVariable long roomId,
      @RequestBody RoomDto updatedRoom) {

    try {
      Room room = inventoryService.updateRoom(updatedRoom);
      return new ApiResponse(Status.OK, mapper.map(room, RoomDto.class));
    } catch (RecordNotFoundException e) {
      return new ApiResponse(Status.ERROR, null,
          new ApiError(999, "No room with ID " + roomId));
    }
  }

  @DeleteMapping("/{roomId}")
  public ApiResponse deleteRoom(@PathVariable long roomId) {
    try {
      Room room = inventoryService.getRoom(roomId);
      inventoryService.deleteRoom(roomId);
      return new ApiResponse(Status.OK, null);
    } catch (RecordNotFoundException ex) {
      return new ApiResponse(Status.ERROR, null,
          new ApiError(999, "No Room with ID " + roomId));
    }
  }
}
