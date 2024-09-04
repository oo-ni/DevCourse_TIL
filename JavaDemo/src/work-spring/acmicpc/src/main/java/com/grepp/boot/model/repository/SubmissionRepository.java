package com.grepp.boot.model.repository;

import com.grepp.boot.model.dto.SubmissionDTO;
import com.grepp.boot.model.entity.SubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface SubmissionRepository extends JpaRepository<SubmissionEntity, Integer> {
    // 제출 목록 조회
//    @Select("SELECT submission_id, user_id, problem_id, code, language, result, submitted_at FROM submissions")
//    List<SubmissionDTO> findAll();

    // 제출 단일 조회
//    @Select("SELECT submission_id, user_id, problem_id, code, language, result, submitted_at FROM submissions WHERE submission_id = #{submissionId}")
//    SubmissionDTO findById(int submissionId);

    // 문제 제출
//    @Insert("INSERT INTO submissions (user_id, problem_id, code, language, result, submitted_at) VALUES (#{userId}, #{problemId}, #{code}, #{language}, #{result}, now())")
//    int submit(SubmissionDTO submissionDTO);

}
