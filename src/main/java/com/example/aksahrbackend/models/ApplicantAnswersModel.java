package com.example.aksahrbackend.models;

import org.springframework.lang.Nullable;
public class ApplicantAnswersModel {
    @Nullable  public Long APPLICANT_ANSWERS_ID;
    @Nullable public  long QUESTION_ID;
    @Nullable public  Long APPLICANT_ID;
    @Nullable public  String ANSWERS;
    @Nullable public  Long CREATED_BY;
    @Nullable public  String CREATED_DATE;
    @Nullable public  String UPDATED_DATE;
    @Nullable public  String UPDATED_BY;
    @Nullable public  String IS_DELETED;

    public ApplicantAnswersModel(Long APPLICANT_ANSWERS_ID, long QUESTION_ID, Long APPLICANT_ID, String ANSWERS, Long CREATED_BY, String CREATED_DATE, String UPDATED_DATE, String UPDATED_BY, String IS_DELETED) {
        this.APPLICANT_ANSWERS_ID = APPLICANT_ANSWERS_ID;
        this.QUESTION_ID = QUESTION_ID;
        this.APPLICANT_ID = APPLICANT_ID;
        this.ANSWERS = ANSWERS;
        this.CREATED_BY = CREATED_BY;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
        this.UPDATED_BY = UPDATED_BY;
        this.IS_DELETED = IS_DELETED;
    }
}

