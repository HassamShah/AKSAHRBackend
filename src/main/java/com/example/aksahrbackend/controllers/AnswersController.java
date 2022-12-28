package com.example.aksahrbackend.controllers;

import com.example.aksahrbackend.models.AnswersModel;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.services.AnswersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("answers")
public class AnswersController {

    @Autowired
    private AnswersServiceInterface answersServiceInterface;

    @PostMapping("/get-answers")
    public ResponseEntity<GenericResponse<List<AnswersModel>>> getAnswers(@RequestBody AnswersModel answer) {
        try{
        return ResponseEntity.status(HttpStatus.OK).body(this.answersServiceInterface.getAnswers(answer));
        }
            catch(Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<> ("99",e.getMessage(), null));
        }
    }

    @PostMapping("/add-answers")
    public ResponseEntity<GenericResponse<List<AnswersModel>>> addUser(@RequestBody List<AnswersModel> answer) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.answersServiceInterface.saveOrUpdateAnswers(answer));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<> ("99",e.getMessage(), null));
        }

    }

}