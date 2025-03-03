package com.ximple.library.orchestrator;

import com.ximple.library.mapper.ReviewMapper;
import com.ximple.library.model.dto.ReviewDTO;
import com.ximple.library.service.BookService;
import com.ximple.library.service.ReviewService;
import com.ximple.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewOrchestrator {
    private final ReviewService reviewService;
    private final UserService userService;
    private final BookService bookService;
    private final ReviewMapper reviewMapper;

    public ReviewDTO addReview(ReviewDTO reviewDTO) {
        var user = userService.getUserById(reviewDTO.userId());
        var book = bookService.getBookById(reviewDTO.bookId());

        var review = reviewMapper.toEntity(reviewDTO);
        review.setUser(user);
        review.setBook(book);

        return reviewService.addOrUpdateReview(review);
    }
}
