package com.grepp.model.repository;

import java.sql.SQLException;

public class MemberRepositoryMysql implements MemberRepository {
    private MemberRepositoryMysql(){}
    private static MemberRepositoryMysql instance = new MemberRepositoryMysql();
    public static MemberRepository getInstance() {
        return instance;
    }

    @Override
    public String selectOne(String userid, String userpw) throws SQLException {
        if ("programmers".equals(userid) && "1234".equals(userpw)) {
            return userid;
        }
        return null;
    }
}
