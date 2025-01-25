package com.application.quai.model.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.dto.request.ReservationRequestDto;
import com.application.quai.model.entity.Reservation;


@Mapper(componentModel = "spring") 
public interface ReservationMapper {  

  @Mapping(target="idReservation", ignore = true)
  @Mapping(target="user", ignore = true)
  Reservation toEntity(ReservationRequestDto request);

  @Mapping(target = "userEmail", source = "user.email")
  ReservationDto toDto(Reservation reservation);

  List<ReservationDto> toDtoList(List<Reservation> reservations);
  
  @Mapping(target="idReservation", ignore = true)
  @Mapping(target="user", ignore = true)
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntityFromRequest(ReservationRequestDto reservationRequestDto, @MappingTarget Reservation existingReservation);
  
}
