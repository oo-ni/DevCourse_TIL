package com.grepp.model.repository;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class MemberRepositoryMysql implements MemberRepository {
//    private MemberRepositoryMysql(){}
//    private static final MemberRepositoryMysql instance = new MemberRepositoryMysql();
//    public static MemberRepository getInstance() {
//        return instance;
//    }

    @Override
    public String selectOne(String userId, String password) throws SQLException {
        if ("programmers".equals(userId) && "1234".equals(password)) {
            return userId;
        }
        return null;
    }
}
