package com.example.aksahrbackend.models;


import org.springframework.lang.Nullable;

public class AnswersModel {

    @Nullable
    public  String CNIC;

    @Nullable public  String APPLICANT_NAME;
    @Nullable public  String QUALIFICATION;
    @Nullable public  String INTERVIEW_POST;

    @Nullable public  String INTERVIEWED_BY;
    @Nullable public  String CONTACT_NO;
    @Nullable public  String EXPERIENCE;

    @Nullable public  String QUESTIONS;
    @Nullable public  String ANSWERS;
    @Nullable  public Long APPLICANT_ANSWERS_ID;
    @Nullable public  Long QUESTIONS_ID;
    @Nullable public  Long APPLICANT_ID;

    public AnswersModel(@Nullable String CNIC, @Nullable String APPLICANT_NAME, @Nullable String QUALIFICATION, @Nullable String INTERVIEW_POST, @Nullable String INTERVIEWED_BY, @Nullable String CONTACT_NO, @Nullable String EXPERIENCE, @Nullable String QUESTIONS, @Nullable String ANSWERS, @Nullable Long APPLICANT_ANSWERS_ID, @Nullable Long QUESTIONS_ID, @Nullable Long APPLICANT_ID, @Nullable Long CREATED_BY, @Nullable String CREATED_DATE, @Nullable String UPDATED_DATE, @Nullable String UPDATED_BY, @Nullable String IS_DELETED) {
        this.CNIC = CNIC;
        this.APPLICANT_NAME = APPLICANT_NAME;
        this.QUALIFICATION = QUALIFICATION;
        this.INTERVIEW_POST = INTERVIEW_POST;
        this.INTERVIEWED_BY = INTERVIEWED_BY;
        this.CONTACT_NO = CONTACT_NO;
        this.EXPERIENCE = EXPERIENCE;
        this.QUESTIONS = QUESTIONS;
        this.ANSWERS = ANSWERS;
        this.APPLICANT_ANSWERS_ID = APPLICANT_ANSWERS_ID;
        this.QUESTIONS_ID = QUESTIONS_ID;
        this.APPLICANT_ID = APPLICANT_ID;
        this.CREATED_BY = CREATED_BY;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
        this.UPDATED_BY = UPDATED_BY;
        this.IS_DELETED = IS_DELETED;
    }

    @Nullable public  Long CREATED_BY;
    @Nullable public  String CREATED_DATE;
    @Nullable public  String UPDATED_DATE;



    @Nullable public  String UPDATED_BY;
    @Nullable public  String IS_DELETED;


}

