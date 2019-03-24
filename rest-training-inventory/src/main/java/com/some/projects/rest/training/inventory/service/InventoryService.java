package com.some.projects.rest.training.inventory.service;

import com.some.projects.rest.training.inventory.domain.Room;
import com.some.projects.rest.training.inventory.domain.RoomCategory;
import java.util.List;

public interface InventoryService {

  public Room getRoom(long roomId);

  public RoomCategory getRoomCategory(long categoryId);

  public List<Room> getAllRoomsWithCategory(RoomCategory category);
}
