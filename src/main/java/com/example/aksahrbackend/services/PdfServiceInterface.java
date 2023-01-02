package com.example.aksahrbackend.services;


import com.example.aksahrbackend.models.AnswersModel;
import com.example.aksahrbackend.models.GenericResponse;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface PdfServiceInterface {
    public void generate(List < AnswersModel > studentList, HttpServletResponse response) throws IOException;

}
