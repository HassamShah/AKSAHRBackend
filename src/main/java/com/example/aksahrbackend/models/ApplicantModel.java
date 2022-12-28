package com.example.aksahrbackend.models;

import org.springframework.lang.Nullable;

public class ApplicantModel {
    @Nullable  public Long ID;
    @Nullable public  String CNIC;
    @Nullable public  String APPLICANT_NAME;

    public ApplicantModel(Long ID, String CNIC, String APPLICANT_NAME, String QUALIFICATION, String CONTACT_NO, String EXPERIENCE, String INTERVIEW_POST, String INTERVIEWED_BY, Long CREATED_BY, String CREATED_DATE, String UPDATED_DATE, String UPDATED_BY, String IS_DELETED) {
        this.ID = ID;
        this.CNIC = CNIC;
        this.APPLICANT_NAME = APPLICANT_NAME;
        this.QUALIFICATION = QUALIFICATION;
        this.CONTACT_NO = CONTACT_NO;
        this.EXPERIENCE = EXPERIENCE;
        this.INTERVIEW_POST = INTERVIEW_POST;
        this.INTERVIEWED_BY = INTERVIEWED_BY;
        this.CREATED_BY = CREATED_BY;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
        this.UPDATED_BY = UPDATED_BY;
        this.IS_DELETED = IS_DELETED;
    }

    @Nullable public  String QUALIFICATION;
    @Nullable public  String CONTACT_NO;
    @Nullable public  String EXPERIENCE;
    @Nullable public  String INTERVIEW_POST;

    @Nullable public  String INTERVIEWED_BY;
    @Nullable public  Long CREATED_BY;
    @Nullable public  String CREATED_DATE;
    @Nullable public  String UPDATED_DATE;
    @Nullable public  String UPDATED_BY;

    @Nullable public  String IS_DELETED;


}

