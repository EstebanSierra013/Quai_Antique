package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.dto.request.ReservationRequest;

public interface IReservationService{
  ReservationDto create(ReservationRequest request);
  ReservationDto getById(int id);
  ReservationDto update(ReservationRequest restaurant, int id);
  public List<ReservationDto> findAll();
  void deleteById(int id);
}

