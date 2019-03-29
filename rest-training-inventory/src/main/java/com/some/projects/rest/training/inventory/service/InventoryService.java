package com.some.projects.rest.training.inventory.service;

import com.some.projects.rest.training.common.domain.Room;
import com.some.projects.rest.training.common.domain.RoomCategory;
import com.some.projects.rest.training.common.dto.RoomDto;
import java.util.List;

public interface InventoryService {

  Room getRoom(long roomId);

  RoomCategory getRoomCategory(long categoryId);

  List<Room> getAllRoomsWithCategory(RoomCategory category);

  Room createRoom(RoomDto roomDto);

  Room updateRoom(RoomDto roomDto);

  void deleteRoom(long roomId);
}
