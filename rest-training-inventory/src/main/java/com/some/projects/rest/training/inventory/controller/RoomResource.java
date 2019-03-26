package com.some.projects.rest.training.inventory.controller;

import com.some.projects.rest.training.inventory.domain.Room;
import com.some.projects.rest.training.inventory.exception.RecordNotFoundException;
import com.some.projects.rest.training.inventory.service.InventoryService;
import com.some.projects.rest.training.inventory.domain.RoomCategory;
import com.some.projects.rest.training.inventory.dto.RoomDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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

  @PostMapping
  public ApiResponse addRoom(@RequestBody RoomDto roomDto) {
    Room newRoom = inventoryService.createRoom(roomDto);

    return new ApiResponse(Status.OK, new RoomDto(newRoom));
  }

  @PutMapping("/{roomId}")
  public ApiResponse updateRoom(@PathVariable long roomId,
      @RequestBody RoomDto updatedRoom) {

    try {
      Room room = inventoryService.updateRoom(updatedRoom);
      return new ApiResponse(Status.OK, new RoomDto(room));
    } catch (RecordNotFoundException e) {
      return new ApiResponse(Status.ERROR, null,
          new ApiError(999, "No room with ID " + roomId));
    }

  }
}
