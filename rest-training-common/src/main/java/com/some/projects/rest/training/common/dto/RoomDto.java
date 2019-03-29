package com.some.projects.rest.training.common.dto;

import com.some.projects.rest.training.common.domain.Room;
import com.some.projects.rest.training.common.domain.RoomCategory;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomDto implements Serializable {

  private static final long serialVersionUID = 2133877623935L;

  private long id;
  private RoomCategory roomCategory;
  private String name;
  private String description;

  public RoomDto(Room room) {
    id = room.getId();
    roomCategory = room.getRoomCategory();
    name = room.getName();
    description = room.getDescription();
  }
}
