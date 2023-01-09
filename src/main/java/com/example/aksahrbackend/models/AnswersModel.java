package com.example.aksahrbackend.models;


import org.springframework.lang.Nullable;

public class AnswersModel {

    @Nullable
    public  String CNIC;

    @Nullable
    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(@Nullable String CNIC) {
        this.CNIC = CNIC;
    }

    @Nullable
    public String getAPPLICANT_NAME() {
        return APPLICANT_NAME;
    }

    public void setAPPLICANT_NAME(@Nullable String APPLICANT_NAME) {
        this.APPLICANT_NAME = APPLICANT_NAME;
    }

    @Nullable
    public String getQUALIFICATION() {
        return QUALIFICATION;
    }

    public void setQUALIFICATION(@Nullable String QUALIFICATION) {
        this.QUALIFICATION = QUALIFICATION;
    }

    @Nullable
    public String getINTERVIEW_POST() {
        return INTERVIEW_POST;
    }

    public void setINTERVIEW_POST(@Nullable String INTERVIEW_POST) {
        this.INTERVIEW_POST = INTERVIEW_POST;
    }

    @Nullable
    public String getINTERVIEWED_BY() {
        return INTERVIEWED_BY;
    }

    public void setINTERVIEWED_BY(@Nullable String INTERVIEWED_BY) {
        this.INTERVIEWED_BY = INTERVIEWED_BY;
    }

    @Nullable
    public String getCONTACT_NO() {
        return CONTACT_NO;
    }

    public void setCONTACT_NO(@Nullable String CONTACT_NO) {
        this.CONTACT_NO = CONTACT_NO;
    }

    @Nullable
    public String getEXPERIENCE() {
        return EXPERIENCE;
    }

    public void setEXPERIENCE(@Nullable String EXPERIENCE) {
        this.EXPERIENCE = EXPERIENCE;
    }

    @Nullable
    public String getQUESTIONS() {
        return QUESTIONS;
    }

    public void setQUESTIONS(@Nullable String QUESTIONS) {
        this.QUESTIONS = QUESTIONS;
    }

    @Nullable
    public String getANSWERS() {
        return ANSWERS;
    }

    public void setANSWERS(@Nullable String ANSWERS) {
        this.ANSWERS = ANSWERS;
    }

    @Nullable
    public Long getAPPLICANT_ANSWERS_ID() {
        return APPLICANT_ANSWERS_ID;
    }

    public void setAPPLICANT_ANSWERS_ID(@Nullable Long APPLICANT_ANSWERS_ID) {
        this.APPLICANT_ANSWERS_ID = APPLICANT_ANSWERS_ID;
    }

    @Nullable
    public Long getQUESTIONS_ID() {
        return QUESTIONS_ID;
    }

    public void setQUESTIONS_ID(@Nullable Long QUESTIONS_ID) {
        this.QUESTIONS_ID = QUESTIONS_ID;
    }

    @Nullable
    public Long getAPPLICANT_ID() {
        return APPLICANT_ID;
    }

    public void setAPPLICANT_ID(@Nullable Long APPLICANT_ID) {
        this.APPLICANT_ID = APPLICANT_ID;
    }

    @Nullable
    public Long getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(@Nullable Long CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    @Nullable
    public String getCREATED_DATE() {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(@Nullable String CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    @Nullable
    public String getUPDATED_DATE() {
        return UPDATED_DATE;
    }

    public void setUPDATED_DATE(@Nullable String UPDATED_DATE) {
        this.UPDATED_DATE = UPDATED_DATE;
    }

    @Nullable
    public String getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(@Nullable String UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    @Nullable
    public String getIS_DELETED() {
        return IS_DELETED;
    }

    public void setIS_DELETED(@Nullable String IS_DELETED) {
        this.IS_DELETED = IS_DELETED;
    }

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


    public AnswersModel() {
    }

    @Nullable public  String UPDATED_BY;
    @Nullable public  String IS_DELETED;


}

