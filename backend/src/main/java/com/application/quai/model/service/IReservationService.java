package com.application.quai.model.service;

import java.util.List;

import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.dto.request.ReservationRequestDto;

public interface IReservationService{
  ReservationDto create(ReservationRequestDto request);
  ReservationDto getById(int id);
  ReservationDto update(ReservationRequestDto restaurant, int id);
  public List<ReservationDto> findAll();
  void deleteById(int id);
}

