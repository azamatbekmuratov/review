package com.bekmuratov.review.exception;

public class DatabaseOperationException extends RuntimeException {
    public DatabaseOperationException(Exception ex) {
        super(String.format("There is a problem with database operation", ex));
    }
}
