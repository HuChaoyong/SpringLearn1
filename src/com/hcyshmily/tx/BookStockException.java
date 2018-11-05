package com.hcyshmily.tx;

public class BookStockException extends RuntimeException {

    private static final long serivalVersionUID = 1L;

    public BookStockException() {
        super();
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    protected BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}