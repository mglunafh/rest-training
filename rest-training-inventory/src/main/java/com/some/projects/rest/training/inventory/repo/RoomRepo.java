package com.some.projects.rest.training.inventory.repo;

import com.some.projects.rest.training.common.domain.Room;
import com.some.projects.rest.training.common.domain.RoomCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Long> {

  List<Room> findByRoomCategory(RoomCategory roomCategory);

}
