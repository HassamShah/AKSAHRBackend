package com.example.aksahrbackend.servicesImpl;

import com.example.aksahrbackend.connection.JDBCConnetion;
import com.example.aksahrbackend.models.ApplicantModel;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.services.ApplicantServiceInterface;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantServiceImp implements ApplicantServiceInterface {
    JDBCConnetion connetion = new JDBCConnetion();

    @Override
    public GenericResponse<List<ApplicantModel>> getApplicants(ApplicantModel applicant) throws SQLException {
        List<ApplicantModel> applicantModels = new ArrayList<ApplicantModel>();
        Connection con = connetion.getConnection();
            if (!con.isClosed()) {

                CallableStatement stmt = con.prepareCall("{call SP_APPLICANT_GET(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                stmt.setObject(1, applicant.ID);
                stmt.setString(2, applicant.CNIC);
                stmt.setString(3, applicant.APPLICANT_NAME);
                stmt.setString(4, applicant.QUALIFICATION);
                stmt.setString(5, applicant.CONTACT_NO);
                stmt.setString(6, applicant.EXPERIENCE);
                stmt.setObject(7, applicant.CREATED_BY);
                stmt.setString(8, applicant.INTERVIEW_POST);
                stmt.setString(9, applicant.INTERVIEWED_BY);
                stmt.registerOutParameter(10, Types.VARCHAR);
                stmt.registerOutParameter(11, Types.VARCHAR);
                stmt.registerOutParameter(12, Types.VARCHAR);
                stmt.registerOutParameter(13, Types.REF_CURSOR);
                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(13);
                while (rs.next()) {
                    Long ID = rs.getLong("ID");
                    String CNIC = rs.getString("CNIC");
                    String APPLICANT_NAME = rs.getString("APPLICANT_NAME");
                    String QUALIFICATION = rs.getString("QUALIFICATION");
                    String CONTACT_NO = rs.getString("CONTACT_NO");
                    String EXPERIENCE = rs.getString("EXPERIENCE");
                    String CREATED_BY = rs.getString("CREATED_BY");
                    String CREATED_DATE = rs.getString("CREATED_DATE");
                    String INTERVIEWED_BY = rs.getString("INTERVIEWED_BY");
                    String INTERVIEW_POST = rs.getString("INTERVIEW_POST");

                    ApplicantModel applicantModel = new ApplicantModel(ID,  CNIC,  APPLICANT_NAME,  QUALIFICATION,  CONTACT_NO,  EXPERIENCE,INTERVIEW_POST,  INTERVIEWED_BY,  null,CREATED_DATE, null, null, null);
                    applicantModels.add(applicantModel);
                }
            } else if (con.isClosed()) {
                throw new SQLException("Connection Closed");
            } else {
                throw new SQLException("Something went wrong");
            }

        return new GenericResponse("00","Success",applicantModels);
    }

    @Override
    public GenericResponse<ApplicantModel> saveOrUpdateApplicants(ApplicantModel applicant) throws SQLException {
        Connection con = connetion.getConnection();
            if (!con.isClosed()) {

                CallableStatement stmt = con.prepareCall("{call SP_ADD_UPDATE_APPLICANT(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                stmt.setObject(1, applicant.ID);
                stmt.setString(2, applicant.CNIC);
                stmt.setString(3, applicant.APPLICANT_NAME);
                stmt.setObject(4, applicant.QUALIFICATION);
                stmt.setString(5, applicant.CONTACT_NO);
                stmt.setObject(6, applicant.EXPERIENCE);
                stmt.setObject(7, applicant.CREATED_BY);
                stmt.setString(8, applicant.INTERVIEW_POST);
                stmt.setObject(9, applicant.INTERVIEWED_BY);
                stmt.registerOutParameter(10, Types.VARCHAR);
                stmt.registerOutParameter(11, Types.VARCHAR);
                stmt.registerOutParameter(12, Types.VARCHAR);
                stmt.registerOutParameter(13, Types.REF_CURSOR);
                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(13);
                rs.next();
//                while (rs.next()) {
                    Long ID = rs.getLong("ID");
                    String CNIC = rs.getString("CNIC");
                    String APPLICANT_NAME = rs.getString("APPLICANT_NAME");
                    String QUALIFICATION = rs.getString("QUALIFICATION");
                    String CONTACT_NO = rs.getString("CONTACT_NO");
                    String EXPERIENCE = rs.getString("EXPERIENCE");
                    Long CREATED_BY = rs.getLong("CREATED_BY");
                    String INTERVIEWED_BY = rs.getString("INTERVIEWED_BY");
                String INTERVIEW_POST = rs.getString("INTERVIEW_POST");
                applicant = new ApplicantModel(ID,  CNIC,  APPLICANT_NAME,  QUALIFICATION,  CONTACT_NO,  EXPERIENCE,INTERVIEW_POST,  INTERVIEWED_BY, CREATED_BY,null, null, null, null);
            } else if (con.isClosed()) {
                throw new SQLException("Connection Closed");
            } else {
                throw new SQLException("Something went wrong");
            }
        return new GenericResponse("00","Success",applicant);
    }

    @Override
    public void removeUsers() {

    }
}
