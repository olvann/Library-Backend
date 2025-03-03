package com.ximple.library.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ximple.library.enums.BookStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookSearchDTO(
        String title,
        String author,
        String genre,
        Integer publishedYear,
        BookStatus status
) {
}
