package com.example.aksahrbackend.servicesImpl;

import com.example.aksahrbackend.connection.JDBCConnetion;
import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.UserModel;
import com.example.aksahrbackend.services.userServiceInterface;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.PipedOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements userServiceInterface {
    JDBCConnetion connetion = new JDBCConnetion();

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public  GenericResponse<List<UserModel>> getUsers(UserModel user) throws SQLException{
        List<UserModel> userModels = new ArrayList<UserModel>();
        Connection con = connetion.getConnection();
            if (!con.isClosed()) {
                CallableStatement stmt = con.prepareCall("{call SP_USER_GET(?,?,?,?,?,?,?,?,?,?,?)}");
                stmt.setObject(1, user.ID);
                stmt.setString(2, user.USER_NAME);
                stmt.setString(3, user.EMAIL);
                stmt.setString(4, user.PASSWORD);
                stmt.setObject(5, user.ROLE_ID);
                stmt.setString(6, user.CONTACT_NO);
                stmt.setObject(7, user.CREATED_BY);
                stmt.registerOutParameter(8, Types.VARCHAR);
                stmt.registerOutParameter(9, Types.VARCHAR);
                stmt.registerOutParameter(10, Types.VARCHAR);
                stmt.registerOutParameter(11, Types.REF_CURSOR);
                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(11);
                while (rs.next()) {
                    Long ID = rs.getLong("ID");
                    String USER_NAME = rs.getString("USER_NAME");
                    Long ROLE_ID = rs.getLong("ROLE_ID");
                    String EMAIL = rs.getString("EMAIL");
//                    String PASSWORD = rs.getString("PASSWORD");
                    String CONTACT_NO = rs.getString("CONTACT_NO");
                    String ROLE_NAME = rs.getString("ROLE_NAME");

                    UserModel userModel = new UserModel(ID, USER_NAME, EMAIL,ROLE_ID, null, ROLE_NAME,CONTACT_NO, null, null, null, null, null);
                    userModels.add(userModel);
                }
            } else if (con.isClosed()) {
                throw new SQLException("Connection Closed");
            } else {
                throw new SQLException("Something went wrong");
            }
        return new GenericResponse("00","Success",userModels);
    }

    @Override
    public GenericResponse<UserModel> saveOrUpdateUsers(UserModel user) throws SQLException {
        List<UserModel> userModels = new ArrayList<UserModel>();
        Connection con = connetion.getConnection();

            if (!con.isClosed()) {
                System.out.println(passwordEncoder.encode(user.PASSWORD));
                CallableStatement stmt = con.prepareCall("{call sp_add_update_user(?,?,?,?,?,?,?,?,?,?,?)}");
                stmt.setObject(1, user.ID);
                stmt.setString(2, user.USER_NAME);
                stmt.setString(3, user.EMAIL);
                stmt.setString(4, passwordEncoder.encode(user.PASSWORD));
                stmt.setObject(5, user.ROLE_ID);
                stmt.setString(6, user.CONTACT_NO);
                stmt.setObject(7, user.CREATED_BY);
                stmt.registerOutParameter(8, Types.VARCHAR);
                stmt.registerOutParameter(9, Types.VARCHAR);
                stmt.registerOutParameter(10, Types.VARCHAR);
                stmt.registerOutParameter(11, Types.REF_CURSOR);
                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(11);
                while (rs.next()) {
                    Long ID = rs.getLong("user_id");
                    String USER_NAME = rs.getString("USER_NAME");
                    Long ROLE_ID = rs.getLong("ROLE_ID");
                    String ROLE_NAME = rs.getString("ROLE_NAME");
                    String EMAIL = rs.getString("EMAIL");
                    String PASSWORD = rs.getString("PASSWORD");
                    String CONTACT_NO = rs.getString("CONTACT_NO");
                    Long CREATED_BY = rs.getLong("CREATED_BY");
                    String CREATED_DATE = rs.getString("CREATED_DATE");
                    String UPDATED_DATE = rs.getString("UPDATED_DATE");
                    String UPDATED_BY = rs.getString("UPDATED_BY");
                    String IS_DELETED = rs.getString("IS_DELETED");
                    UserModel userModel = new UserModel(ID, USER_NAME,EMAIL, ROLE_ID, ROLE_NAME,PASSWORD, CONTACT_NO, CREATED_BY, CREATED_DATE, UPDATED_DATE, UPDATED_BY, IS_DELETED);
                    userModels.add(userModel);
                }
            } else if (con.isClosed()) {
                throw new SQLException("Connection Closed");
            } else {
                throw new SQLException("Something went wrong");
            }
        return new GenericResponse("00","Success",user);
    }

    @Override
    public void removeUsers() {

    }

    @Override
    public GenericResponse<UserModel> login(UserModel user) throws SQLException{
        Connection con = connetion.getConnection();

        if (!con.isClosed()) {
            CallableStatement stmt = con.prepareCall("{call SP_USER_LOGIN(?,?,?,?,?)}");
            stmt.setObject(1, user.EMAIL);
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.registerOutParameter(5, Types.REF_CURSOR);
            stmt.execute();
            String PASSWORD="";
            ResultSet rs = (ResultSet) stmt.getObject(5);
            while (rs.next()) {
                user.ID = rs.getLong("ID");
                user.USER_NAME = rs.getString("USER_NAME");
                user.ROLE_ID = rs.getLong("ROLE_ID");
//                user.ROLE_NAME = rs.getString("ROLE_NAME");
                user.EMAIL = rs.getString("EMAIL");
                PASSWORD = rs.getString("PASSWORD");
                user.CONTACT_NO = rs.getString("CONTACT_NO");
//            user.CREATED_BY = rs.getLong("CREATED_BY");
//            user.CREATED_DATE = rs.getString("CREATED_DATE");
//            user.UPDATED_DATE = rs.getString("UPDATED_DATE");
//            user.UPDATED_BY = rs.getString("UPDATED_BY");
//            user.IS_DELETED = rs.getString("IS_DELETED");
            }
            if (!(passwordEncoder.matches(user.PASSWORD, PASSWORD))){
                throw new SQLException("Invalid Email or Password");
            }

        } else if (con.isClosed()) {
            throw new SQLException("Connection Closed");
        } else {
            throw new SQLException("Something went wrong");
        }
    return new GenericResponse("00","Success",user);
    }
}
