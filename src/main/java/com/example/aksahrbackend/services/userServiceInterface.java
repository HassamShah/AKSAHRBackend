package com.example.aksahrbackend.services;

import com.example.aksahrbackend.models.GenericResponse;
import com.example.aksahrbackend.models.UserModel;

import java.sql.SQLException;
import java.util.List;

public interface userServiceInterface {

    public  GenericResponse<List<UserModel>> getUsers(UserModel user) throws SQLException;
    public GenericResponse<UserModel>  saveOrUpdateUsers(UserModel user) throws SQLException;

    public GenericResponse<UserModel> login(UserModel user) throws SQLException;
    public void removeUsers();

}
