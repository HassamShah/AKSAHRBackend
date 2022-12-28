package com.example.aksahrbackend.services;

import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.QuestionModel;

import java.sql.SQLException;
import java.util.List;

public interface QuestionServiceInterface {

    public GenericResponse<List<QuestionModel>> getQuestions(QuestionModel question) throws SQLException;
    public GenericResponse<QuestionModel> saveOrUpdateQuestions(QuestionModel question) throws SQLException;
    public GenericResponse<QuestionModel> removeQuestions(QuestionModel question) throws SQLException;

}
