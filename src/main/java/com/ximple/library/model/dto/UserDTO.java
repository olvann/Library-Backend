package com.ximple.library.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ximple.library.enums.UserRole;


import java.util.List;

public record UserDTO(
        Long id,
        String name,
        String email,
        UserRole role,
        boolean isActive,
        @JsonProperty("createdById")
        Long createdBy,
        String createdAt,
        String updatedAt,
        @JsonProperty("updatedById")
        Long updatedBy,
        List<ReviewDTO> reviewList,
        List<ReservationDTO> reservationList
) {
}
