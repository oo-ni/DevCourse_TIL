package com.grepp.boot.model.dto;

import java.sql.Timestamp;

public class SubmissionDTO {
    private int submissionId;
    private String userId;
    private int problemId;
    private String code;
    private String language;
    private boolean result;
    private Timestamp submittedAt;

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Timestamp getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Timestamp submittedAt) {
        this.submittedAt = submittedAt;
    }

    @Override
    public String toString() {
        return "SubmissionDTO{" +
                "submissionId=" + submissionId +
                ", userId='" + userId + '\'' +
                ", problemId=" + problemId +
                ", code='" + code + '\'' +
                ", language='" + language + '\'' +
                ", result=" + result +
                ", submittedAt=" + submittedAt +
                '}';
    }
}
