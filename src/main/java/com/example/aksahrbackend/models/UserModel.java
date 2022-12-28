package com.example.aksahrbackend.models;
import javax.validation.constraints.*;
import org.springframework.lang.Nullable;

public class UserModel {
    @Nullable public Long ID;

    @Nullable public  String USER_NAME;
    @Nullable @Email public  String EMAIL;
    @Nullable public  Long ROLE_ID;

    @Nullable public  String ROLE_NAME;
    @Nullable public  String PASSWORD;
    @Nullable public  String CONTACT_NO;
    @Nullable public  Long CREATED_BY;
    @Nullable public  String CREATED_DATE;
    @Nullable public  String UPDATED_DATE;
    @Nullable public  String UPDATED_BY;
    @Nullable public  String IS_DELETED;

    public UserModel(Long ID, String USER_NAME, String EMAIL, Long ROLE_ID, String ROLE_NAME, String PASSWORD, String CONTACT_NO, Long CREATED_BY, String CREATED_DATE, String UPDATED_DATE, String UPDATED_BY, String IS_DELETED) {
        this.ID = ID;
        this.USER_NAME = USER_NAME;
        this.EMAIL = EMAIL;
        this.ROLE_ID = ROLE_ID;
        this.ROLE_NAME = ROLE_NAME;
        this.PASSWORD = PASSWORD;
        this.CONTACT_NO = CONTACT_NO;
        this.CREATED_BY = CREATED_BY;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
        this.UPDATED_BY = UPDATED_BY;
        this.IS_DELETED = IS_DELETED;
    }




}

