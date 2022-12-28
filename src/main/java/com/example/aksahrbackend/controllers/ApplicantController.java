package com.example.aksahrbackend.controllers;

import com.example.aksahrbackend.models.ApplicantModel;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.UserModel;
import com.example.aksahrbackend.services.ApplicantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("applicant")
public class ApplicantController {

    @Autowired
    private ApplicantServiceInterface applicantServiceInterface;

    @PostMapping("/get-applicants")
    public ResponseEntity<GenericResponse<List<ApplicantModel>>> getApplicant(@RequestBody ApplicantModel applicant) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.applicantServiceInterface.getApplicants(applicant));
        }
            catch(Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<>("99",e.getMessage(), null));
        }
    }

    @PostMapping("/add-applicants")
    public ResponseEntity<GenericResponse<ApplicantModel>>  addApplicant(@RequestBody ApplicantModel applicant) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.applicantServiceInterface.saveOrUpdateApplicants(applicant));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<> ("99",e.getMessage(), null));
        }

    }
}