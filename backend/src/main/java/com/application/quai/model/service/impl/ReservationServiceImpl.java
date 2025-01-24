package com.application.quai.model.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.dto.request.ReservationRequestDto;
import com.application.quai.model.entity.Reservation;
import com.application.quai.model.mapper.ReservationMapper;
import com.application.quai.model.repository.IReservationRepository;
import com.application.quai.model.service.IReservationService;

@Service
public class ReservationServiceImpl implements IReservationService{

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    public Reservation getByReservation(int id){
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty()){
            System.err.println("ERROR");
        }
        return optionalReservation.get();
    }

    @Override
    public ReservationDto create(ReservationRequestDto request){
        Reservation newReservation = reservationMapper.toEntity(request);
        Reservation createdReservation = reservationRepository.save(newReservation);
        return reservationMapper.toDto(createdReservation);
    }

    @Override
    public ReservationDto getById(int id){
        Reservation findReservation = getByReservation(id);
        return reservationMapper.toDto(findReservation);
    }

    @Override
    public ReservationDto update(ReservationRequestDto request, int id) {
        Reservation reservationToUpdate = this.getByReservation(id);
        reservationMapper.updateEntityFromRequest(request, reservationToUpdate);
        Reservation updatedReservation = reservationRepository.save(reservationToUpdate);
        return reservationMapper.toDto(updatedReservation);
    }

    @Override
    public List<ReservationDto> findAll() {
        List<Reservation> listReservations = reservationRepository.findAll();
        return listReservations.stream()
        .map((Reservation) -> reservationMapper.toDto(Reservation))
        .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id){
        reservationRepository.deleteById(id);
    }
}
