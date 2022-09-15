package com.bekmuratov.review.service.api;

import com.bekmuratov.review.domain.dto.ProductReviewDto;

public interface ReviewService {
    ProductReviewDto findReviewByProductId(String productId);
}
