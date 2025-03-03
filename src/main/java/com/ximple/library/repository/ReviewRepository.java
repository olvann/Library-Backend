package com.ximple.library.repository;

import com.ximple.library.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewByBookId(Long bookId);
}
