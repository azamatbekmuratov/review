package com.bekmuratov.review.controller;

import com.bekmuratov.review.domain.dto.ProductReviewDto;
import com.bekmuratov.review.service.api.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Azamat Bekmuratov
 */
@RestController
@RequestMapping
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> findReviewByProductId(@PathVariable String productId){
        ProductReviewDto productReviewDto = reviewService.findReviewByProductId(productId);
        return ResponseEntity.ok(productReviewDto);
    }

}
