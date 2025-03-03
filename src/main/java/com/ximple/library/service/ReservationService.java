package com.ximple.library.service;

import com.ximple.library.model.dto.ReservationDTO;
import com.ximple.library.model.entity.Reservation;

public interface ReservationService {
    ReservationDTO getReservationById(Long reservationId);
    void deleteReservationById(Long reservationId);
    ReservationDTO addOrUpdateReservation(Reservation reservation);
}
