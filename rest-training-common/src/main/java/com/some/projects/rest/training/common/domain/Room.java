package com.some.projects.rest.training.common.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Room {

  @Id
  @GeneratedValue
  private long id;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
  fetch = FetchType.EAGER)
  private RoomCategory roomCategory;

  @Column(name = "name", unique = true, nullable = false, length = 128)
  private String name;

  @Column(name = "description")
  private String description;

}
