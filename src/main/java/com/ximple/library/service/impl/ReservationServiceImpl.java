package com.ximple.library.service.impl;

import com.ximple.library.exception.NotFoundException;
import com.ximple.library.mapper.ReservationMapper;
import com.ximple.library.model.dto.ReservationDTO;
import com.ximple.library.model.entity.Reservation;
import com.ximple.library.repository.ReservationRepository;
import com.ximple.library.service.ReservationService;
import com.ximple.library.utils.MessageBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    @Override
    public ReservationDTO getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .map(reservationMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(MessageBuilder.reservationNotFound(reservationId)));
    }

    @Override
    public void deleteReservationById(Long reservationId) {

    }

    @Override
    public ReservationDTO addOrUpdateReservation(Reservation reservation) {
        return reservationMapper.toDTO(
                reservationRepository.save(reservation));
    }
}
