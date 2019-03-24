package com.some.projects.rest.training.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomCategory {

  @Id
  @GeneratedValue
  Long id;

}