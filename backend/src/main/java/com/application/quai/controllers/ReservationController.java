package com.application.quai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.quai.model.dto.request.ReservationRequestDto;
import com.application.quai.model.service.IReservationService;


@RestController
@RequestMapping("/reservations")
@CrossOrigin("http://localhost:4200/")
public class ReservationController {
  
  @Autowired
  private IReservationService reservationService;

  @PostMapping("/")
  public ResponseEntity<?> createReservation(@RequestBody ReservationRequestDto request) {
    return ResponseEntity.ok(reservationService.createReservation(request));
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<?> getReservationById(@PathVariable int id){
    return ResponseEntity.ok(reservationService.getReservationById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateReservation(@RequestBody ReservationRequestDto reservation, @PathVariable int id){
    return ResponseEntity.ok(reservationService.updateReservation(reservation, id));
  }

  @GetMapping("/")
  public ResponseEntity<?> getAllReservations(){
    return ResponseEntity.ok(reservationService.getAllReservations());
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteReservation(@PathVariable int id){
    reservationService.deleteReservation(id);
    return ResponseEntity.ok("Deleted Reservation");
  }
}
