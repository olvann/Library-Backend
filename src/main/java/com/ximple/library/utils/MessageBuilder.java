package com.ximple.library.utils;

import com.ximple.library.model.dto.BookSearchDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageBuilder {

    public static String reviewFound(Long reviewId) {
        return "Review with ID " + reviewId + " retrieved successfully";
    }

    public static String reviewsRetrieved(List<?> reviews, Long bookId) {
        if (bookId == null) {
            return "Retrieved " + reviews.size() + " reviews";
        }
        return "Retrieved " + reviews.size() + " reviews for book ID " + bookId;
    }

    public static String reviewNotFound(Long reviewId) {
        return "Review with ID " + reviewId + " not found";
    }

    public static String bookNotFound(Long bookId) {
        return "Book with ID " + bookId + " not found";
    }

    public static String userNotFound(Long userId) {
        return "User with ID " + userId + " not found";
    }

    public static String booksRetrieved(List<?> books) {
        return "Retrieved " + books.size() + " books";
    }

    public static String booksRetrievedWithFilter(List<?> books, BookSearchDTO dto) {
        List<String> filters = new ArrayList<>();

        if (dto.title() != null) filters.add("title=" + dto.title());
        if (dto.author() != null) filters.add("author=" + dto.author());
        if (dto.genre() != null) filters.add("genre=" + dto.genre());
        if (dto.publishedYear() != null) filters.add("publishedYear=" + dto.publishedYear());
        if (dto.status() != null) filters.add("status=" + dto.status());

        return "Retrieved " + books.size() + " books with filter: [" + String.join(", ", filters) + "]";
    }

    public static String reservationNotFound(Long reservationId) {
        return "Reservation with ID " + reservationId + " not found";
    }
}
