package com.bekmuratov.review.exception;

public class ReviewByProductIdNotFoundException extends RuntimeException {
    public ReviewByProductIdNotFoundException(String productId) {
        super(String.format("Review with Id %s not found", productId));
    }
}
