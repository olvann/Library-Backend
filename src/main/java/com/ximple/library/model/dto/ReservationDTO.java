package com.ximple.library.model.dto;

import com.ximple.library.enums.ReservationStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public record ReservationDTO(
        @Null Long id,
        @NotNull Long bookId,
        @NotNull Long userId,
        @Null ReservationStatus status,
        @Null String reservedAt,
        @Null String dueDate
) {
}

