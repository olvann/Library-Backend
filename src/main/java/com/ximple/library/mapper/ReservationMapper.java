package com.ximple.library.mapper;

import com.ximple.library.model.dto.ReservationDTO;
import com.ximple.library.model.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.ximple.library.utils.Constants.DTO_DATE_FORMAT;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(target = "reservedAt", source = "reservedAt", dateFormat = DTO_DATE_FORMAT)
    @Mapping(target = "dueDate", source = "dueDate", dateFormat = DTO_DATE_FORMAT)
    ReservationDTO toDTO(Reservation reservation);

    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "userId", target = "user.id")
    Reservation toEntity(ReservationDTO reservationDTO);
}
