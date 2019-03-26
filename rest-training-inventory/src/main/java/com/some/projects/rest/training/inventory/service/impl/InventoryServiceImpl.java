package com.some.projects.rest.training.inventory.service.impl;

import com.some.projects.rest.training.inventory.domain.Room;
import com.some.projects.rest.training.inventory.domain.RoomCategory;
import com.some.projects.rest.training.inventory.dto.RoomDto;
import com.some.projects.rest.training.inventory.service.InventoryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

  @Override
  public Room getRoom(long roomId) {
    return Room.builder().id(1).roomCategory(null).name("Room 1").description("Nice, spacious room")
        .build();
  }

  @Override
  public RoomCategory getRoomCategory(long categoryId) {
    return null;
  }

  @Override
  public List<Room> getAllRoomsWithCategory(RoomCategory category) {
    return null;
  }

  @Override
  public Room createRoom(RoomDto roomDto) {
    return Room.builder().id(1).roomCategory(null).name("Room 2").description("Room, created right now")
        .build();
  }

  @Override
  public Room updateRoom(RoomDto roomDto) {
    return Room.builder()
        .id(roomDto.getId())
        .roomCategory(roomDto.getRoomCategory())
        .name(roomDto.getName())
        .description(roomDto.getDescription())
        .build();
  }
}
