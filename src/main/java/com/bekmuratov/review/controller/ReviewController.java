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

    @PutMapping("/product")
    public ResponseEntity<?> update(@RequestBody ProductReviewDto review){
        SuccessOperation response = reviewService.update(review);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        SuccessOperation response = reviewService.delete(id);
        return ResponseEntity.ok(response);
    }

}
