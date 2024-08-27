package com.grepp.model.service;

import com.grepp.model.dto.BoardDTO;
import com.grepp.model.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

// SQL 실행은 Repository가 담당하고 Service는 뭘 검사하고 판단하고 조작해내는 비즈니스 로직에 대한 책임만 구현함.
@Service
public class BoardService {
//    private BoardService(){}
//    private static final BoardService instance = new BoardService();
//    public static BoardService getInstance() {
//        return instance;
//    }

    @Autowired
    private BoardRepository repo;// = BoardRepositoryMysql.getInstance();

    public BoardDTO read(int bno) throws SQLException {
        return repo.selectOne(bno);
    }

    public int write(BoardDTO board) throws SQLException {
        return repo.insert(board);
    }

    public int delete(BoardDTO board) throws SQLException {
        return repo.delete(board);
    }

    public List<BoardDTO> getBoards() throws SQLException {
        return repo.selectAll();
    }

}