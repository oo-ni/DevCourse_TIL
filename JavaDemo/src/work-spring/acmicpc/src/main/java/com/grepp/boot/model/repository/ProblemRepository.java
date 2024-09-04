package com.grepp.boot.model.repository;

import com.grepp.boot.model.dto.ProblemDTO;
import com.grepp.boot.model.entity.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface ProblemRepository extends JpaRepository<ProblemEntity, Integer> {
    // 문제 목록 조회
//    @Select("SELECT problem_id, problem_name, description, created_at FROM problems")
//    List<ProblemDTO> findAll();

    // 문제 단일 조회
//    @Select("SELECT problem_id, problem_name, description, created_at FROM problems WHERE problem_id = #{problemId}")
//    ProblemDTO findById(int problemId);

    // 문제 생성
//    @Insert("INSERT INTO problems(problem_name, description, created_at) VALUES(#{problemName}, #{description}, now())")
//    int insert(ProblemDTO problemDTO);

    // 문제 수정
//    @Update("UPDATE problems SET problem_name = #{problemName}, description = #{description} WHERE problem_id = #{problemId}")
//    int update(ProblemDTO problemDTO);

    // 문제 삭제
//    @Delete("DELETE FROM problems WHERE problem_id = #{problemId}")
//    void delete(int problemId);
}
