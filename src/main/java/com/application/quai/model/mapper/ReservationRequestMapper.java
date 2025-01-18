package com.application.quai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.application.quai.model.dto.request.ReservationRequest;
import com.application.quai.model.entity.Reservation;


@Mapper(componentModel= "spring")
public interface  ReservationRequestMapper {

  @Mapping(target = "idReservation", ignore = true)
  @Mapping(target = "user", ignore = true)
  Reservation toDomain(ReservationRequest request);
}
