package com.application.quai.model.mapper;

import org.mapstruct.Mapper;

import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.entity.Reservation;


@Mapper(componentModel = "spring") 
public interface ReservationDtoMapper {  
  ReservationDto toDto(Reservation restaurant);
}
