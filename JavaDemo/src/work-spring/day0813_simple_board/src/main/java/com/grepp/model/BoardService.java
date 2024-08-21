package com.grepp.model;

import java.sql.SQLException;

public class BoardService {
    private BoardRepository repo = BoardRepositoryMysql.getInstance();

    private BoardService(){}
    private static BoardService instance = new BoardService();
    public static BoardService getInstance() {
        return instance;
    }

    // 글 읽기 기능에서 작성자와 읽는 사용자가 일치하는지 검사해서 조회수 증가 update 여부를 판단하거나
    // 이미 이 글을 읽은 사용자는 조회수가 중복해서 증가하지 않도록 검사하거나
//    public BoardDTO read(int bno, String loginId) throws SQLException {
//        BoardDTO board = repo.selectOne(bno);
//        if (!board.getWriter().equals(loginId)) {   // 작성자와 현재 로그인 아이디가 일치하지 않을 때만 조회수 증가시키기
//            repo.updateReadCount(bno);
//        }
//        return board;
//    }
    // 위에처럼 로직을 수행하는 메소드. 지금은 처리하지 않았음.
    public BoardDTO read(int bno) throws SQLException {

        return repo.selectOne(bno);
    }
}
