package com.grepp.boot.model.service;

import com.grepp.boot.model.dto.UserDTO;
import com.grepp.boot.model.entity.UserEntity;
import com.grepp.boot.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDTO addUser(UserDTO userDTO) {
        UserEntity userEntity = toEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return toDTO(userEntity);
    }

    @Transactional
    public UserDTO getUser(String userId){
        Optional<UserEntity> userEntity = userRepository.findByUserId(userId);
        return userEntity.map(this::toDTO).orElse(null);
    }

    private UserDTO toDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setUserPw(entity.getUserPw());
        return dto;
    }

    private UserEntity toEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setUserPw(dto.getUserPw());
        return entity;
    }
}
