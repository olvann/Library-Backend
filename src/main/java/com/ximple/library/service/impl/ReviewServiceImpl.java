package com.ximple.library.service.impl;

import com.ximple.library.exception.NotFoundException;
import com.ximple.library.model.dto.ReviewDTO;
import com.ximple.library.mapper.ReviewMapper;
import com.ximple.library.model.entity.Review;
import com.ximple.library.repository.ReviewRepository;
import com.ximple.library.service.ReviewService;
import com.ximple.library.utils.MessageBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public List<ReviewDTO> getReviewList() {
        return reviewRepository.findAll()
                .stream()
                .map(reviewMapper::toDTO)
                .toList();
    }

    @Override
    public List<ReviewDTO> getReviewListByBookId(Long bookId) {
        return reviewRepository.findReviewByBookId(bookId)
                .stream()
                .map(reviewMapper::toDTO)
                .toList();
    }

    @Override
    public List<ReviewDTO> fetchReviewList(Long bookId) {
        return bookId == null ? getReviewList() : getReviewListByBookId(bookId);
    }

    @Override
    public ReviewDTO getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .map(reviewMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(MessageBuilder.reviewNotFound(reviewId)));
    }

    @Override
    public void deleteReviewById(Long reviewId) {
        reviewRepository.findById(reviewId).ifPresentOrElse(review -> {
            reviewRepository.delete(review);
            log.info("Review with id {} deleted", reviewId);
            }, () -> log.warn("Review with id {} was already deleted or never existed", reviewId));
    }

    @Override
    public ReviewDTO addOrUpdateReview(Review review) {
        return reviewMapper.toDTO(
                reviewRepository.save(review)
        );
    }
}
