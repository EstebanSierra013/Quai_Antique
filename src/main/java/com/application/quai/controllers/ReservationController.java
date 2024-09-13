package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.quai.model.dto.request.ReservationRequest;
import com.application.quai.model.service.IReservationService;


@RestController
@RequestMapping("/reservation")
public class ReservationController {
  
  @Autowired
  private IReservationService reservationService;

  @PostMapping("/")
  public ResponseEntity<?> create(@RequestBody ReservationRequest request) {
    return ResponseEntity.ok(reservationService.create(request));
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
    return ResponseEntity.ok(reservationService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody ReservationRequest reservation, @PathVariable int id){
    return ResponseEntity.ok(reservationService.update(reservation, id));
  }

  @GetMapping("/list")
  public ResponseEntity<?> findAll(){
    return ResponseEntity.ok(reservationService.findAll());
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable int id){
    reservationService.deleteById(id);
    return ResponseEntity.ok("Deleted Reservation");
  }
}
