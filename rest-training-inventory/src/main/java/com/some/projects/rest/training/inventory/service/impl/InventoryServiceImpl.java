package com.some.projects.rest.training.inventory.service.impl;

import com.some.projects.rest.training.inventory.domain.Room;
import com.some.projects.rest.training.inventory.domain.RoomCategory;
import com.some.projects.rest.training.inventory.dto.RoomDto;
import com.some.projects.rest.training.inventory.exception.RecordNotFoundException;
import com.some.projects.rest.training.inventory.repo.RoomRepo;
import com.some.projects.rest.training.inventory.service.InventoryService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class InventoryServiceImpl implements InventoryService {

  private final RoomRepo repo;
  private final ModelMapper mapper = new ModelMapper();

  @Autowired
  public InventoryServiceImpl(RoomRepo repo) {
    this.repo = repo;
  }

  @Override
  public Room getRoom(long roomId) {

    return repo.findById(roomId).orElseThrow(RecordNotFoundException::new);
  }

  @Override
  public RoomCategory getRoomCategory(long categoryId) {
    return null;
  }

  @Override
  public List<Room> getAllRoomsWithCategory(RoomCategory category) {

    return repo.findByRoomCategory(category);
  }

  @Override
  public Room createRoom(RoomDto roomDto) {

    Room room = mapper.map(roomDto, Room.class);
    return  repo.save(room);
  }

  @Override
  public Room updateRoom(RoomDto roomDto) {

    Room room = mapper.map(roomDto, Room.class);
    return repo.save(room);
  }

  @Override
  public void deleteRoom(long roomId) {
    repo.deleteById(roomId);
  }
}