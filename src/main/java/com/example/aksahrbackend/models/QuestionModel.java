package com.example.aksahrbackend.models;

import org.springframework.lang.Nullable;

public class QuestionModel {
    @Nullable  public Long QUESTIONS_ID;
    @Nullable public  String QUESTIONS;

    @Nullable public  String  ANSWERS;
    @Nullable public  String  INTERVIEWED_BY;

    @Nullable public  String  APPLICANT_ID;
    @Nullable public  Long QUES_SEQUENCE;
    @Nullable public  Long CREATED_BY;
    @Nullable public  String CREATED_DATE;
    @Nullable public  String UPDATED_DATE;
    @Nullable public  String UPDATED_BY;
    @Nullable public  String IS_DELETED;

    public QuestionModel(@Nullable Long QUESTIONS_ID, @Nullable String QUESTIONS, @Nullable String ANSWERS, @Nullable String INTERVIEWED_BY, @Nullable String APPLICANT_ID, @Nullable Long QUES_SEQUENCE, @Nullable Long CREATED_BY, @Nullable String CREATED_DATE, @Nullable String UPDATED_DATE, @Nullable String UPDATED_BY, @Nullable String IS_DELETED) {
        this.QUESTIONS_ID = QUESTIONS_ID;
        this.QUESTIONS = QUESTIONS;
        this.ANSWERS = ANSWERS;
        this.INTERVIEWED_BY = INTERVIEWED_BY;
        this.APPLICANT_ID = APPLICANT_ID;
        this.QUES_SEQUENCE = QUES_SEQUENCE;
        this.CREATED_BY = CREATED_BY;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
        this.UPDATED_BY = UPDATED_BY;
        this.IS_DELETED = IS_DELETED;
    }
}

