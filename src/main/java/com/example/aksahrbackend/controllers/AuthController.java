package com.example.aksahrbackend.controllers;

import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.UserModel;
import com.example.aksahrbackend.services.userServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private userServiceInterface userServiceInterface;

    @PostMapping("/login")
    public ResponseEntity<GenericResponse<UserModel>> login(@RequestBody UserModel user) {
        try{
        return  ResponseEntity.status(HttpStatus.OK).body(this.userServiceInterface.login(user));
    }
        catch(Exception e){
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<UserModel>("99",e.getMessage(), null));
    }
    }
}