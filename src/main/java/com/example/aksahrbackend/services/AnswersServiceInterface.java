package com.example.aksahrbackend.services;


import com.example.aksahrbackend.models.AnswersModel;
import com.example.aksahrbackend.models.GenericResponse;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

public interface AnswersServiceInterface {

    public GenericResponse<List<AnswersModel>> getAnswers(AnswersModel Answers) throws SQLException;
    public GenericResponse<List<AnswersModel>> saveOrUpdateAnswers(List<AnswersModel> Answers) throws SQLException;

    public void removeUsers();

}
