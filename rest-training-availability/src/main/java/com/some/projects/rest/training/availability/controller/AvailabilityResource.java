package com.some.projects.rest.training.availability.controller;

import com.some.projects.rest.training.availability.service.AvailabilityQuery;
import com.some.projects.rest.training.availability.service.AvailabilityService;
import com.some.projects.rest.training.availability.service.AvailabilityStatus;
import com.some.projects.rest.training.common.api.ApiResponse;
import com.some.projects.rest.training.common.api.Status;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availability")
public class AvailabilityResource {
  
  private final AvailabilityService service;
  
  @Autowired
  public AvailabilityResource(AvailabilityService service) {
    this.service = service;
  }

  @GetMapping
  public ApiResponse getAvailability(
      @RequestParam("from") String from, 
      @RequestParam("until") String until,
      @RequestParam(value = "roomCategoryId", required = false) Long categoryId) throws ParseException {
    
    DateFormat format = new SimpleDateFormat("YYYY-MM-dd");
    Date dateFrom = format.parse(from);
    Date dateUntil = format.parse(until);
    
    AvailabilityQuery query = new AvailabilityQuery(dateFrom, dateUntil, categoryId);
    
    List<AvailabilityStatus> availableRooms = service.getAvailableRooms(query);
    
    
    return new ApiResponse(Status.OK, availableRooms);
  }
}
