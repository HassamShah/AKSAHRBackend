package com.example.aksahrbackend.controllers;

import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.QuestionModel;
import com.example.aksahrbackend.models.UserModel;
import com.example.aksahrbackend.services.QuestionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("questions")
public class QuestionsController {

    @Autowired
    private QuestionServiceInterface questionServiceInterface;

    @PostMapping("/get-questions")
    public ResponseEntity<GenericResponse<List<QuestionModel>>>  getQuestion(@RequestBody QuestionModel question) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.questionServiceInterface.getQuestions(question));
        }
      catch(Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<List<QuestionModel>> ("99",e.getMessage(), null));
        }
    }

    @PostMapping("/add-questions")
    public ResponseEntity<GenericResponse<QuestionModel>> addQuestion(@RequestBody QuestionModel question) {
        try{
        return ResponseEntity.status(HttpStatus.OK).body(this.questionServiceInterface.saveOrUpdateQuestions(question));
        }
            catch(Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<QuestionModel> ("99",e.getMessage(), null));
            }
    }

    @PostMapping("/remove-questions")
    public ResponseEntity<GenericResponse<QuestionModel>> removeQuestion(@RequestBody QuestionModel question) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.questionServiceInterface.saveOrUpdateQuestions(question));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<QuestionModel> ("99",e.getMessage(), null));
        }
    }
}