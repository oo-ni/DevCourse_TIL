package com.grepp.jpa.model.repository;

import com.grepp.jpa.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    BoardEntity findByNo(int no);   // 메서드 이름 보고 where 조건 유추해서 sql 생성도 해줌... ㄷㄷ
    List<BoardEntity> findByTitle(String keyword);

    @Modifying
    @Query("update board_tb set readCount=readCount+1 where no=:no")
    public int updateReadCount(int no);
}
