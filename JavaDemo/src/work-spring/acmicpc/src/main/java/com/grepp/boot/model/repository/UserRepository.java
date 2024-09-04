package com.grepp.boot.model.repository;

import com.grepp.boot.model.dto.UserDTO;
import com.grepp.boot.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Mapper
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

//    @Select("SELECT user_id, user_pw FROM users")
//    List<UserDTO> findAll();

//    @Select("SELECT user_id, user_pw FROM users WHERE user_id = #{userId}")
//    UserDTO findById(String userId);

    // 유저 등록
//    @Insert("INSERT INTO users (user_id, user_pw) VALUES (#{userId}, #{userPw})")
//    int register(UserDTO userDTO);

    // 유저 가져오기 (userId)
    Optional<UserEntity> findByUserId(String userId);

}
