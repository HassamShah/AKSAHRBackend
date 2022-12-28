package com.example.aksahrbackend.servicesImpl;
import com.example.aksahrbackend.connection.JDBCConnetion;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.QuestionModel;
import com.example.aksahrbackend.services.QuestionServiceInterface;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImp implements QuestionServiceInterface {


    @Override
    public GenericResponse<List<QuestionModel>> getQuestions(QuestionModel question) throws SQLException {
        List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
        Connection con =  JDBCConnetion.getConnection();
            if (!con.isClosed()) {

                CallableStatement stmt = con.prepareCall("{call SP_QUESTION_GET(?,?,?,?,?,?,?,?)}");
                stmt.setObject(1, question.QUESTIONS_ID);
                stmt.setString(2, question.QUESTIONS);
                stmt.setObject(3, question.QUES_SEQUENCE);
                stmt.setObject(4, question.CREATED_BY);
                stmt.registerOutParameter(5, Types.VARCHAR);
                stmt.registerOutParameter(6, Types.VARCHAR);
                stmt.registerOutParameter(7, Types.VARCHAR);
                stmt.registerOutParameter(8, Types.REF_CURSOR);
                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(8);
                while (rs.next()) {
                    Long QUESTIONS_ID = rs.getLong("QUESTIONS_ID");
                    String QUESTIONS = rs.getString("QUESTIONS");
                    Long QUES_SEQUENCE = rs.getLong("QUES_SEQUENCE");
//                    Long QUES_SEQUENCE = rs.getLong("QUES_SEQUENCE");

                    QuestionModel questionModel = new QuestionModel( QUESTIONS_ID,QUESTIONS,null,null,question.APPLICANT_ID,QUES_SEQUENCE,null, null, null, null, null);
                    questionModels.add(questionModel);
                }
            } else if (con.isClosed()) {
                throw new SQLException("Connection Closed");
            } else {
                throw new SQLException("Something went wrong");
            }
        return new GenericResponse("00","Success",questionModels);
    }

    @Override
    public GenericResponse<QuestionModel> saveOrUpdateQuestions(QuestionModel question)  throws SQLException {
        List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
        Connection con = JDBCConnetion.getConnection();

            if (!con.isClosed()) {

                CallableStatement stmt = con.prepareCall("{call SP_ADD_UPDATE_QUESTIONS(?,?,?,?,?,?,?,?)}");
                stmt.setObject(1, question.QUESTIONS_ID);
                stmt.setString(2, question.QUESTIONS);
                stmt.setObject(3, question.QUES_SEQUENCE);
                stmt.setObject(4, question.CREATED_BY);
                stmt.registerOutParameter(5, Types.VARCHAR);
                stmt.registerOutParameter(6, Types.VARCHAR);
                stmt.registerOutParameter(7, Types.VARCHAR);
                stmt.registerOutParameter(8, Types.REF_CURSOR);
                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(8);
                while (rs.next()) {
                    Long QUESTIONS_ID = rs.getLong("QUESTIONS_ID");
                    String QUESTIONS = rs.getString("QUESTIONS");
                    Long QUES_SEQUENCE = rs.getLong("QUES_SEQUENCE");
                    QuestionModel questionModel = new QuestionModel( QUESTIONS_ID,QUESTIONS,null,null,null,QUES_SEQUENCE,null, null, null, null, null);
                    questionModels.add(questionModel);
                }
            } else if (con.isClosed()) {
                throw new SQLException("Connection Closed");
            } else {
                throw new SQLException("Something went wrong");
            }
        return new GenericResponse("00","Success",question);
    }

    @Override
    public GenericResponse<QuestionModel> removeQuestions(QuestionModel question)  throws SQLException {
        List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
        Connection con = JDBCConnetion.getConnection();

        if (!con.isClosed()) {

            CallableStatement stmt = con.prepareCall("{call SP_DELETE_QUESTIONS(?,?,?,?)}");
            stmt.setObject(1, question.QUESTIONS_ID);
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.execute();
//            ResultSet rs = (ResultSet) stmt.getObject(8);
//            while (rs.next()) {
//                Long QUESTIONS_ID = rs.getLong("QUESTIONS_ID");
//                String QUESTIONS = rs.getString("QUESTIONS");
//                Long QUES_SEQUENCE = rs.getLong("QUES_SEQUENCE");
//                QuestionModel questionModel = new QuestionModel( QUESTIONS_ID,QUESTIONS,null,null,QUES_SEQUENCE,null, null, null, null, null);
//                questionModels.add(questionModel);
//            }
        } else if (con.isClosed()) {
            throw new SQLException("Connection Closed");
        } else {
            throw new SQLException("SQL Exception Occured");
        }
        return new GenericResponse("00","Success",question);
    }
}
