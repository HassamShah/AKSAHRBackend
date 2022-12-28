package com.example.aksahrbackend.services;

import com.example.aksahrbackend.models.ApplicantModel;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.QuestionModel;

import java.sql.SQLException;
import java.util.List;

public interface ApplicantServiceInterface {

    public GenericResponse<List<ApplicantModel>> getApplicants(ApplicantModel applicant) throws SQLException;
    public  GenericResponse<ApplicantModel> saveOrUpdateApplicants(ApplicantModel applicant) throws SQLException;
    public void removeUsers();

}
