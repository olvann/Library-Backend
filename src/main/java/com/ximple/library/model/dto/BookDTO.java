package com.ximple.library.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ximple.library.enums.BookStatus;


import java.util.List;

public record BookDTO(
        Long id,
        String title,
        String author,
        String genre,
        Integer publishedYear,
        BookStatus status,
        @JsonProperty("createdById")
        Long createdBy,
        String createdAt,
        String updatedAt,
        @JsonProperty("updatedById")
        Long updatedBy,
        String barcode,
        List<ReviewDTO> reviewList,
        List<ReservationDTO> reservationList
) {

}
