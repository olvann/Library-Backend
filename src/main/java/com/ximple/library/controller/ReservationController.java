package com.ximple.library.controller;

import com.ximple.library.model.dto.ReservationDTO;
import com.ximple.library.model.dto.ResponseDTO;
import com.ximple.library.orchestrator.ReservationOrchestrator;
import com.ximple.library.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ximple.library.utils.ResponseUtils.buildCreatedResponse;
import static com.ximple.library.utils.ResponseUtils.buildOkResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationOrchestrator reservationOrchestrator;

    @GetMapping(value = "/{reservationId}")
    public ResponseEntity<ResponseDTO<ReservationDTO>> getReservationById(
            @PathVariable Long reservationId) {
        return buildOkResponse("Ok", reservationService.getReservationById(reservationId));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ReservationDTO>> addReservation(
            @Valid @RequestBody ReservationDTO reservationDTO
    ) {
        return buildCreatedResponse("Reservation successfully created",
                reservationOrchestrator.addReservation(reservationDTO));
    }
}
