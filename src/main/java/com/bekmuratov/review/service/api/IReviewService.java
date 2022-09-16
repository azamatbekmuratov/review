package com.bekmuratov.review.service.api;

import com.bekmuratov.review.domain.dto.ProductReviewDto;
import com.bekmuratov.review.domain.dto.SuccessCreateResponse;
import com.bekmuratov.review.domain.dto.SuccessOperation;

public interface IReviewService {
    ProductReviewDto findReviewByProductId(String productId);

    SuccessCreateResponse save(ProductReviewDto input);

    SuccessOperation update(ProductReviewDto input);
}
