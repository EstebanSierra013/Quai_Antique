package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.dto.request.ReservationRequestDto;

public interface IReservationService{
  ReservationDto createReservation(ReservationRequestDto request);
  List<ReservationDto> getAllReservations();
  ReservationDto getReservationById(int id);
  ReservationDto updateReservation(ReservationRequestDto restaurant, int id);  
  void deleteReservation(int id);
}

