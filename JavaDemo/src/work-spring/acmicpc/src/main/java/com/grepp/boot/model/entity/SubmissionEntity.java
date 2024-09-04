package com.grepp.boot.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
public class SubmissionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private int submissionId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "problem_id", nullable = false)
    private int problemId;

    @Column(name = "code")
    private String code;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "result", nullable = false)
    private boolean result;

    @Column(name = "submitted_at", nullable = false)
    private LocalDateTime submittedAt;

    public SubmissionEntity() {}

    public SubmissionEntity(String userId, int problemId, String code, String language, boolean result) {
        this.userId = userId;
        this.problemId = problemId;
        this.code = code;
        this.language = language;
        this.result = result;
        this.submittedAt = LocalDateTime.now();
    }

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

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    @Override
    public String toString() {
        return "SubmissionEntity{" +
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
