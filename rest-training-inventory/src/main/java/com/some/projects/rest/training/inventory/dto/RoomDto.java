package com.some.projects.rest.training.inventory.dto;

import com.some.projects.rest.training.inventory.domain.Room;
import com.some.projects.rest.training.inventory.domain.RoomCategory;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class RoomDto implements Serializable {

  private static final long serialVersionUID = 2133877623935L;

  private long id;
  private RoomCategory roomCategory;
  private String name;
  private String description;

  public RoomDto() {}

  public RoomDto(Room room) {
    id = room.getId();
    roomCategory = room.getRoomCategory();
    name = room.getName();
    description = room.getDescription();
  }

}
