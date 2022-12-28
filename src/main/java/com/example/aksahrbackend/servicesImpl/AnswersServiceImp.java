package com.example.aksahrbackend.servicesImpl;

import com.example.aksahrbackend.connection.JDBCConnetion;
import com.example.aksahrbackend.models.AnswersModel;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.services.AnswersServiceInterface;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswersServiceImp implements AnswersServiceInterface {
    JDBCConnetion connetion = new JDBCConnetion();

    @Override
    public GenericResponse<List<AnswersModel>> getAnswers(AnswersModel answer) throws SQLException {
        List<AnswersModel> answersModels = new ArrayList<AnswersModel>();
        Connection con = connetion.getConnection();
            if (!con.isClosed()) {

                CallableStatement stmt = con.prepareCall("{call SP_APPLICANT_ANSWERS_GET(?,?,?,?,?)}");
                stmt.setObject(1, answer.APPLICANT_ID);
                stmt.registerOutParameter(2, Types.VARCHAR);
                stmt.registerOutParameter(3, Types.VARCHAR);
                stmt.registerOutParameter(4, Types.VARCHAR);
                stmt.registerOutParameter(5, Types.REF_CURSOR);
                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(5);
                while (rs.next()) {
                String CNIC = rs.getString("CNIC");
                String APPLICANT_NAME = rs.getString("APPLICANT_NAME");
                String QUALIFICATION = rs.getString("QUALIFICATION");
                String INTERVIEW_POST = rs.getString("INTERVIEW_POST");
                String INTERVIEWED_BY = rs.getString("INTERVIEWED_BY");
                String CONTACT_NO = rs.getString("CONTACT_NO");
                String EXPERIENCE = rs.getString("EXPERIENCE");
                String QUESTIONS = rs.getString("QUESTIONS");
                String ANSWERS = rs.getString("ANSWERS");
                Long CREATED_BY = rs.getLong("CREATED_BY");
                String CREATED_DATE = rs.getString("CREATED_DATE");
                    AnswersModel answerModel = new AnswersModel(CNIC,APPLICANT_NAME, QUALIFICATION, INTERVIEW_POST,INTERVIEWED_BY, CONTACT_NO, EXPERIENCE, QUESTIONS, ANSWERS, null , null ,answer.APPLICANT_ID, null, CREATED_DATE ,null,  null,  null);
                    answersModels.add(answerModel);
                }
            } else if (con.isClosed()) {
                throw new SQLException("Connection Closed");
            } else {
                throw new SQLException("Server Error");
            }
        return new GenericResponse("00","Success",answersModels);
    }

    @Override
    public GenericResponse<List<AnswersModel>>  saveOrUpdateAnswers(List<AnswersModel> Answers) throws SQLException {
        List<AnswersModel> asnwerModels = new ArrayList<AnswersModel>();
        Connection con = connetion.getConnection();
        CallableStatement stmt = con.prepareCall("{call SP_ADD_UPDATE_APPLICATION_ANSWERS(?,?,?,?,?,?,?,?)}");

            if (!con.isClosed()) {
                for (AnswersModel ans : Answers) {
                    stmt.setObject(1, ans.APPLICANT_ID);
                    stmt.setObject(2, ans.QUESTIONS_ID);
                    stmt.setString(3, ans.ANSWERS);
                    stmt.setObject(4, ans.CREATED_BY);
                    stmt.registerOutParameter(5, Types.VARCHAR);
                    stmt.registerOutParameter(6, Types.VARCHAR);
                    stmt.registerOutParameter(7, Types.VARCHAR);
                    stmt.registerOutParameter(8, Types.REF_CURSOR);
                    stmt.execute();
                    ResultSet rs = (ResultSet) stmt.getObject(8);
                    rs.next();
                }


//                while (rs.next()) {
//                    Long ID = rs.getLong("APPLICANT_ID");
//                    Long QUESTION_ID = rs.getLong("QUESTION_ID");
//                    String APPLICANT_NAME = rs.getString("ANSWERS");
//                Long QUALIFICATION = rs.getLong("CREATED_BY");

//                     answer = new AnswersModel(null,  QUESTION_ID, APPLICANT_NAME,  QUALIFICATION,  CONTACT_NO,  EXPERIENCE,  INTERVIEWED_BY, CREATED_BY,null, null, null, null);
            } else if (con.isClosed()) {
                throw new SQLException("Connection Closed");
            } else {
                throw new SQLException("Something went wrong");
            }
        return new GenericResponse("00","Success",Answers);
    }



    @Override
    public void removeUsers() {

    }
}
