package com.bekmuratov.review.service.api;

import com.bekmuratov.review.domain.dto.ProductReviewDto;

public interface IReviewService {
    ProductReviewDto findReviewByProductId(String productId);
}
