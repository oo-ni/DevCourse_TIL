package com.grepp.boot.model.service;

import com.grepp.boot.model.dto.ProblemDTO;
import com.grepp.boot.model.dto.SubmissionDTO;
import com.grepp.boot.model.entity.SubmissionEntity;
import com.grepp.boot.model.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Transactional
    public int addSubmission(SubmissionDTO submissionDTO) {
        SubmissionEntity submissionEntity = toEntity(submissionDTO);
        submissionEntity = submissionRepository.save(submissionEntity);
        return submissionEntity.getSubmissionId();   // 저장된 후 생성한 ID 반환
    }

    @Transactional
    public SubmissionDTO getSubmission(int submissionId) {
        Optional<SubmissionEntity> submissionEntity = submissionRepository.findById(submissionId);
        return submissionEntity.map(this::toDTO).orElse(null);
    }

    @Transactional
    public List<SubmissionDTO> getSubmissions() {
        return submissionRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private SubmissionEntity toEntity(SubmissionDTO dto) {
        SubmissionEntity entity = new SubmissionEntity();
        entity.setSubmissionId(dto.getSubmissionId());
        entity.setUserId(dto.getUserId());
        entity.setProblemId(dto.getProblemId());
        entity.setCode(dto.getCode());
        entity.setLanguage(dto.getLanguage());
        entity.setResult(dto.isResult());
        return entity;
    }

    private SubmissionDTO toDTO(SubmissionEntity entity) {
        SubmissionDTO dto = new SubmissionDTO();
        dto.setSubmissionId(entity.getSubmissionId());
        dto.setUserId(entity.getUserId());
        dto.setProblemId(entity.getProblemId());
        dto.setCode(entity.getCode());
        dto.setLanguage(entity.getLanguage());
        dto.setResult(entity.isResult());
        return dto;
    }
}
