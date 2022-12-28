package com.example.aksahrbackend.models;

public class HandleException {
    private String Status;
    private String Description;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public HandleException(String status, String description) {
        Status = status;
        Description = description;
    }

}
