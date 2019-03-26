package com.some.projects.rest.training.inventory.controller;

import com.some.projects.rest.training.exception.RecordNotFoundException;
import com.some.projects.rest.training.inventory.domain.Room;
import com.some.projects.rest.training.inventory.service.InventoryService;
import com.some.projects.rest.training.inventory.domain.RoomCategory;
import com.some.projects.rest.training.inventory.dto.RoomDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

  private final InventoryService inventoryService;

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
  public RoomDto getRoom(@PathVariable("roomId") Long roomId) {

    Room room = inventoryService.getRoom(roomId);

    return new RoomDto(room);
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
