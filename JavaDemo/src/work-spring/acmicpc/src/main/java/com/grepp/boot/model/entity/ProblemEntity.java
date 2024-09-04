package com.grepp.boot.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "problems")
public class ProblemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private int problemId;

    @Column(name = "problem_name")
    private String problemName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp          // 엔티티가 처음으로 persist될 때 현재 타임스탬프가 자동으로 설정
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp    // 수정 시 자동으로 설정
    private LocalDateTime updatedAt;

    @Column(name = "user_id", nullable = false) // 추가된 부분
    private String userId;

    public ProblemEntity() {}

    public ProblemEntity(String problemName, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String userId) {
        this.problemName = problemName;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }

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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ProblemEntity{" +
                "problemId=" + problemId +
                ", problemName='" + problemName + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userId='" + userId + '\'' +
                '}';
    }
}
