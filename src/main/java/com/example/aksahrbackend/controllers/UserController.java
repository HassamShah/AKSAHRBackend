package com.example.aksahrbackend.controllers;

import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.UserModel;
import com.example.aksahrbackend.services.userServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private userServiceInterface userServiceInterface;

    @PostMapping("/get-users")
    public ResponseEntity<GenericResponse<List<UserModel>>> getUser(@RequestBody UserModel user) {
        try{
      return  ResponseEntity.status(HttpStatus.OK).body(this.userServiceInterface.getUsers(user));
    }
        catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<List<UserModel>> ("99",e.getMessage(), null));
    }
    }

    @PostMapping("/add-user")
    public ResponseEntity<GenericResponse<UserModel>> addUser(@RequestBody UserModel user) {
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(this.userServiceInterface.saveOrUpdateUsers(user));
    }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<UserModel> ("99",e.getMessage(), null));
    }
    }
}