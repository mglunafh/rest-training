package com.some.projects.rest.training.inventory.service;

import com.some.projects.rest.training.inventory.domain.Room;
import com.some.projects.rest.training.inventory.domain.RoomCategory;
import com.some.projects.rest.training.inventory.dto.RoomDto;
import java.util.List;

public interface InventoryService {

  Room getRoom(long roomId);

  RoomCategory getRoomCategory(long categoryId);

  List<Room> getAllRoomsWithCategory(RoomCategory category);

  Room createRoom(RoomDto roomDto);

  Room updateRoom(RoomDto roomDto);

  void deleteRoom(long roomId);
}
