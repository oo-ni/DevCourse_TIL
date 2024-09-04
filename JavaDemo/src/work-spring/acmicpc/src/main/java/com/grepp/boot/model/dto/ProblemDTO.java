package com.grepp.boot.model.dto;

import java.time.LocalDateTime;

public class ProblemDTO {
    private int problemId;
    private String problemName;
    private String description;
    private LocalDateTime createdAt;
    private String userId;

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ProblemDTO{" +
                "problemId=" + problemId +
                ", problemName='" + problemName + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", userId='" + userId + '\'' +
                '}';
    }
}
