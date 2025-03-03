package com.ximple.library.orchestrator;

import com.ximple.library.enums.BookStatus;
import com.ximple.library.enums.ReservationStatus;
import com.ximple.library.exception.LibraryException;
import com.ximple.library.mapper.ReservationMapper;
import com.ximple.library.model.dto.ReservationDTO;
import com.ximple.library.service.BookService;
import com.ximple.library.service.ReservationService;
import com.ximple.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReservationOrchestrator {
    private final ReservationService reservationService;
    private final BookService bookService;
    private final UserService userService;
    private final ReservationMapper reservationMapper;


    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        var user = userService.getUserById(reservationDTO.userId());
        var book = bookService.getBookById(reservationDTO.bookId());
        if(!BookStatus.isAvailable(book.getStatus())) {
            throw new LibraryException("Book is not available");
        }

        var reservation = reservationMapper.toEntity(reservationDTO);
        reservation.setUser(user);
        reservation.setBook(book);
        reservation.setDueDate(Date.from(Instant.now().plus(Duration.ofDays(15))));
        reservation.setStatus(ReservationStatus.ACTIVE);

        var reservationResponse = reservationService.addOrUpdateReservation(reservation);

        book.setStatus(BookStatus.UNAVAILABLE);
        book.setUpdatedAt(Date.from(Instant.now()));
        book.setUpdatedBy(user.getId());
        bookService.addOrUpdateBook(book);

        return reservationResponse;
    }
}
