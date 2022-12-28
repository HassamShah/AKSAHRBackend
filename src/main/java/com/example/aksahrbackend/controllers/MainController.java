package com.example.aksahrbackend.controllers;

import com.example.aksahrbackend.connection.JDBCConnetion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class MainController {


    JDBCConnetion connetion = new JDBCConnetion();

    @GetMapping("/home")
    public String home() throws SQLException {

//        if (connetion.getConnection().isClosed()) {
//            return "learn";
//
//        } else if (!connetion.getConnection().isClosed()) {
//            return "connection established";
//        }
//        else
//        {
            return "Welcome to my spring boot application";
//
//        }


    }
}
