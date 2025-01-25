package com.application.quai.model.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quai.model.dto.ReservationDto;
import com.application.quai.model.dto.request.ReservationRequestDto;
import com.application.quai.model.entity.User;
import com.application.quai.model.entity.Reservation;
import com.application.quai.model.mapper.ReservationMapper;
import com.application.quai.model.repository.IReservationRepository;
import com.application.quai.model.repository.IUserRepository;
import com.application.quai.model.service.IReservationService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservationServiceImpl implements IReservationService{

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ReservationMapper reservationMapper;


    @Override
    public ReservationDto createReservation(ReservationRequestDto request){
    Reservation newReservation = reservationMapper.toEntity(request);
    
    User userReservation = userRepository.findById(request.getUserEmail())
    .orElseThrow(() -> new EntityNotFoundException("User not found"));

    newReservation.setUser(userReservation);
    userReservation.getReservationList().add(newReservation);
    userRepository.save(userReservation);

    Reservation createdReservation = reservationRepository.save(newReservation);
    return reservationMapper.toDto(createdReservation);
    
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        List<Reservation> listReservations = reservationRepository.findAll();
        return listReservations.stream()
        .map((Reservation) -> reservationMapper.toDto(Reservation))
        .collect(Collectors.toList());
    }

    @Override
    public ReservationDto getReservationById(int id){
        Reservation findReservation = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
        return reservationMapper.toDto(findReservation);
    }

    @Override
    public ReservationDto updateReservation(ReservationRequestDto request, int id) {
        Reservation reservationToUpdate = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
        reservationMapper.updateEntityFromRequest(request, reservationToUpdate);
        Reservation updatedReservation = reservationRepository.save(reservationToUpdate);
        return reservationMapper.toDto(updatedReservation);
    }

    @Override
    public void deleteReservation(int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reservation not found"));

        User user = reservation.getUser();
        user.getReservationList().remove(reservation);
        userRepository.save(user);
    }
}
