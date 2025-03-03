package com.ximple.library.service;

import com.ximple.library.model.dto.ReviewDTO;
import com.ximple.library.model.entity.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getReviewList();
    List<ReviewDTO> getReviewListByBookId(Long bookId);
    List<ReviewDTO> fetchReviewList(Long bookId);
    ReviewDTO getReviewById(Long reviewId);
    void deleteReviewById(Long reviewId);
    ReviewDTO addOrUpdateReview(Review Review);
}
