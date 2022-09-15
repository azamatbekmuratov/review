package com.bekmuratov.review.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long id) {
        super(String.format("Review with Id %d not found", id));
    }
}
