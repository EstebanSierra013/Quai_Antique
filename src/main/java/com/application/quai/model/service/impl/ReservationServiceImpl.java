package com.application.quai.model.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.dto.request.ReservationRequest;
import com.application.quai.model.entity.Reservation;
import com.application.quai.model.entity.Reservation;
import com.application.quai.model.mapper.ReservationDtoMapper;
import com.application.quai.model.mapper.ReservationRequestMapper;
import com.application.quai.model.repository.IReservationRepository;
import com.application.quai.model.service.IReservationService;

@Service
public class ReservationServiceImpl implements IReservationService{

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private ReservationDtoMapper reservationDtoMapper;

    @Autowired
    private ReservationRequestMapper reservationRequestMapper;

    public Reservation getByReservation(int id){
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty()){
            System.err.println("ERROR");
        }
        return optionalReservation.get();
    }

    @Override
    public ReservationDto create(ReservationRequest request){
        Reservation newReservation = reservationRequestMapper.toDomain(request);
        Reservation createdReservation = reservationRepository.save(newReservation);
        return reservationDtoMapper.toDto(createdReservation);
    }

    @Override
    public ReservationDto getById(int id){
        Reservation findReservation = getByReservation(id);
        System.out.println(reservationDtoMapper.toDto(findReservation));
        return reservationDtoMapper.toDto(findReservation);
    }

    @Override
    public ReservationDto update(ReservationRequest request, int id) {
        Reservation reservationToUpdate = this.getByReservation(id);
        setValuesToUpdate(request,reservationToUpdate);
        Reservation updatedReservation = reservationRepository.save(reservationToUpdate);
        return reservationDtoMapper.toDto(updatedReservation);
    }

    private void setValuesToUpdate(ReservationRequest request, Reservation currentReservation){
        currentReservation.setDate(request.getDate());
        currentReservation.setHour(request.getHour());
        currentReservation.setGuestNumbers(request.getGuestNumbers());
        currentReservation.setAllergy(request.getAllergy());
    }

    @Override
    public List<ReservationDto> findAll() {
        List<Reservation> listReservations = reservationRepository.findAll();
        System.out.println(listReservations);
        return listReservations.stream()
        .map((Reservation) -> reservationDtoMapper.toDto(Reservation))
        .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id){
        reservationRepository.deleteById(id);
    }
}
