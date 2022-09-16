package com.bekmuratov.review.service.api;

import com.bekmuratov.review.domain.dto.ProductReviewDto;
import com.bekmuratov.review.domain.dto.SuccessCreateResponse;

public interface IReviewService {
    ProductReviewDto findReviewByProductId(String productId);

    SuccessCreateResponse save(ProductReviewDto input);
}
