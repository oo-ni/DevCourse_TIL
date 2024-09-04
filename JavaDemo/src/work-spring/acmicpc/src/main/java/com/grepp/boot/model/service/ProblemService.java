package com.grepp.boot.model.service;

import com.grepp.boot.model.dto.ProblemDTO;
import com.grepp.boot.model.entity.ProblemEntity;
import com.grepp.boot.model.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Transactional
    public void addProblem(ProblemDTO problemDTO) {
        ProblemEntity problemEntity = toEntity(problemDTO);
        problemRepository.save(problemEntity);
    }

    @Transactional
    public ProblemDTO getProblem(int problemId) {
        Optional<ProblemEntity> problemEntity = problemRepository.findById(problemId);
        return problemEntity.map(this::toDTO).orElse(null);
    }

    @Transactional
    public List<ProblemDTO> getProblems() {
        return problemRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateProblem(ProblemDTO problemDTO) {
        ProblemEntity problemEntity = toEntity(problemDTO);
        problemRepository.save(problemEntity);
    }

    @Transactional
    public void deleteProblem(int problemId) {
        problemRepository.deleteById(problemId);
    }

    private ProblemDTO toDTO(ProblemEntity entity) {
        ProblemDTO dto = new ProblemDTO();
        dto.setProblemId(entity.getProblemId());
        dto.setProblemName(entity.getProblemName());
        dto.setDescription(entity.getDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUserId(entity.getUserId());
        return dto;
    }

    private ProblemEntity toEntity(ProblemDTO dto) {
        ProblemEntity entity = new ProblemEntity();
        entity.setProblemId(dto.getProblemId());
        entity.setProblemName(dto.getProblemName());
        entity.setDescription(dto.getDescription());
        entity.setUserId(dto.getUserId());
        return entity;
    }
}
