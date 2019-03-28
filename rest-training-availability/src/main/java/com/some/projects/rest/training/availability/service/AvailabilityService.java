package com.some.projects.rest.training.availability.service;

import java.util.List;

public interface AvailabilityService {
  
  public List<AvailabilityStatus> getAvailableRooms(AvailabilityQuery query);

}
