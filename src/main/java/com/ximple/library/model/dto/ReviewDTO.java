package com.ximple.library.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public record ReviewDTO(
        @Null Long id,
        @NotNull String content,
        @NotNull @Min(1) @Max(5) Integer rating,
        String createdAt,
        @NotNull Long bookId,
        @NotNull Long userId
) {
}
