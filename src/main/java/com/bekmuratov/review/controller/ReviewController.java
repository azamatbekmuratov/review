package com.bekmuratov.review.controller;

import com.bekmuratov.review.domain.dto.ProductReviewDto;
import com.bekmuratov.review.domain.dto.SuccessCreateResponse;
import com.bekmuratov.review.domain.dto.SuccessOperation;
import com.bekmuratov.review.service.api.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Azamat Bekmuratov
 */
@RestController
@RequestMapping("/api/reviews/v1")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @GetMapping("/review/{id}")
    public ResponseEntity<?> findReviewById(@PathVariable Long id){
        ProductReviewDto productReviewDto = reviewService.findReviewById(id);
        return ResponseEntity.ok(productReviewDto);
    }

    @GetMapping("/review/product/{productId}")
    public ResponseEntity<?> findReviewByProductId(@PathVariable String productId){
        ProductReviewDto productReviewDto = reviewService.findReviewByProductId(productId);
        return ResponseEntity.ok(productReviewDto);
    }

    @PostMapping("/review")
    public ResponseEntity<?> create(@RequestBody ProductReviewDto review){
        SuccessCreateResponse response = reviewService.save(review);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/review")
    public ResponseEntity<?> update(@RequestBody ProductReviewDto review){
        SuccessOperation response = reviewService.update(review);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        SuccessOperation response = reviewService.delete(id);
        return ResponseEntity.ok(response);
    }

}
