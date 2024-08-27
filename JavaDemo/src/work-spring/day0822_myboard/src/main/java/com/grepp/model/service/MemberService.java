package com.grepp.model.service;

import com.grepp.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MemberService {
//    private MemberService(){}
//    private static final MemberService instance = new MemberService();
//    public static MemberService getInstance() {
//        return instance;
//    }

    @Autowired
    private MemberRepository repo;// = MemberRepositoryMysql.getInstance();

    public String login(String userId, String password) throws SQLException {
        return repo.selectOne(userId, password);
    }
}
