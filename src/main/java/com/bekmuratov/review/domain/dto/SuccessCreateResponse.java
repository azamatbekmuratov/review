package com.bekmuratov.review.domain.dto;

public class SuccessCreateResponse extends SuccessOperation {
    public Long id;
    public SuccessCreateResponse(String code, String message, Long id) {
        super(code, message);
        this.id = id;
    }
}
