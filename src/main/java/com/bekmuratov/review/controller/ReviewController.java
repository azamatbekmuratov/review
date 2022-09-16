package com.bekmuratov.review.controller;

import com.bekmuratov.review.domain.dto.ProductReviewDto;
import com.bekmuratov.review.domain.dto.SuccessCreateResponse;
import com.bekmuratov.review.service.api.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Azamat Bekmuratov
 */
@RestController
@RequestMapping("/api/review/v1")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> findReviewByProductId(@PathVariable String productId){
        ProductReviewDto productReviewDto = reviewService.findReviewByProductId(productId);
        return ResponseEntity.ok(productReviewDto);
    }

    @PostMapping("/product")
    public ResponseEntity<?> create(@RequestBody ProductReviewDto review){
        SuccessCreateResponse response = reviewService.save(review);
        return ResponseEntity.ok(response);
    }

}
