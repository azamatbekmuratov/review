package com.bekmuratov.review.service.impl;

import com.bekmuratov.review.domain.dto.ProductReviewDto;
import com.bekmuratov.review.domain.model.ProductReview;
import com.bekmuratov.review.repository.ProductReviewRepository;
import com.bekmuratov.review.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ProductReviewRepository reviewRepository;

    @Override
    public ProductReviewDto findReviewByProductId(String productId) {
        Optional<ProductReview> productReview = reviewRepository.findByProductId(productId);
        return productReview.map(this::mapModelToDto).orElse(null);
    }

    ProductReviewDto mapModelToDto(ProductReview model){
        ProductReviewDto result = new ProductReviewDto();

        result.setId(model.getId());
        result.setAverageReviewScore(model.getAverageReviewScore());
        result.setNumberOfReviews(model.getNumberOfReviews());
        result.setProductId(model.getProductId());
        return result;
    }
}
