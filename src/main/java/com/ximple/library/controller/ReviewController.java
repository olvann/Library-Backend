package com.ximple.library.controller;

import com.ximple.library.model.dto.ResponseDTO;
import com.ximple.library.model.dto.ReviewDTO;
import com.ximple.library.orchestrator.ReviewOrchestrator;
import com.ximple.library.service.ReviewService;
import com.ximple.library.utils.MessageBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ximple.library.enums.ResponseStatus.SUCCESS;
import static com.ximple.library.utils.ResponseUtils.buildCreatedResponse;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@Tag(name = "Reviews", description = "API to manage revies")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewOrchestrator reviewOrchestrator;


    @Operation(summary = "Get all reviews")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Return all reviews or empty list if none exists"))
    @GetMapping()
    public ResponseEntity<ResponseDTO<List<ReviewDTO>>> fetchReviewList(
            @RequestParam(name = "bookId", required = false) Long bookId) {
        var reviews = reviewService.fetchReviewList(bookId);
        return ResponseEntity.ok(new ResponseDTO<>(SUCCESS, MessageBuilder.reviewsRetrieved(reviews, bookId),
                null, reviews));
    }

    @GetMapping(value = "/{reviewId}")
    public ResponseEntity<ResponseDTO<ReviewDTO>> getReviewById(@PathVariable Long reviewId) {
        return ResponseEntity.ok(new ResponseDTO<>(SUCCESS, MessageBuilder.reviewFound(reviewId),
                null, reviewService.getReviewById(reviewId)));
    }

    @DeleteMapping(value = "/{reviewId}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable Long reviewId) {
        reviewService.deleteReviewById(reviewId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ReviewDTO>> addReview(
            @Valid @RequestBody ReviewDTO reviewDTO) {
        return buildCreatedResponse("Review added successfully",
                reviewOrchestrator.addReview(reviewDTO));
    }

}
