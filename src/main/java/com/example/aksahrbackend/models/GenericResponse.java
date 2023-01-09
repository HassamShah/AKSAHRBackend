package com.example.aksahrbackend.models;

public class GenericResponse<T> {
    private String status;
    private String message="Success";
    private T data;

    public GenericResponse() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GenericResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
