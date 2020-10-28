package com.expressacademy.professores.service;

import com.expressacademy.professores.domain.LanguageEntity;
import com.expressacademy.professores.exception.LanguageNotFoundException;
import com.expressacademy.professores.mapper.LanguageMapper;
import com.expressacademy.professores.repository.LanguageRepository;
import com.expressacademy.professores.request.LanguageRequest;
import com.expressacademy.professores.response.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private LanguageMapper languageMapper;

    public List<LanguageResponse> findAll() {
        return languageRepository.findAll()
                .stream().map(languageMapper::toResponse)
                .collect(Collectors.toList());
    }

    public LanguageResponse findOne(Long id) {
        LanguageEntity languageEntity = languageRepository
                .findByIdAndActiveTrue(id)
                .orElseThrow(LanguageNotFoundException::new);

        return languageMapper.toResponse(languageEntity);
    }

    public void create(LanguageRequest languageRequest) {
        LanguageEntity languageEntity = languageMapper.toEntity(languageRequest);
        languageEntity.setActive(true);
        languageRepository.save(languageEntity);
    }

    public LanguageEntity findByIdAndReturnEntity(Long id) {
        return languageRepository.findByIdAndActiveTrue(id)
                                  .orElseThrow(LanguageNotFoundException::new);
    }

}
