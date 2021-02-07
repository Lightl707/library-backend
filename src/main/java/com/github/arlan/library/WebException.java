package com.github.arlan.library;

public class WebException extends RuntimeException{
    private int status;
    public WebException(String message,int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}