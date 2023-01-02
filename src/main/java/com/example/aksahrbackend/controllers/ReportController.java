package com.example.aksahrbackend.controllers;
import com.example.aksahrbackend.models.AnswersModel;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.services.AnswersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private AnswersServiceInterface answersServiceInterface;

    @PostMapping("/report")
    public String getReport(@RequestBody AnswersModel answer) {
        Model model= new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                return null;
            }

            @Override
            public Model addAttribute(Object attributeValue) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }

            @Override
            public Object getAttribute(String attributeName) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        try{
            this.answersServiceInterface.getReport(answer,model);
            return "report";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

}