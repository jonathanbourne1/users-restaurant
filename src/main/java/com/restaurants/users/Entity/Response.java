package com.restaurants.users.Entity;

import org.springframework.http.HttpStatus;

public class Response {
    public Response(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String message;
    //GETTERS AND SETTERS


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
