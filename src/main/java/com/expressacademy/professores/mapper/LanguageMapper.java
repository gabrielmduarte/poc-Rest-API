package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.LanguageEntity;
import com.expressacademy.professores.request.LanguageRequest;
import com.expressacademy.professores.response.LanguageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface LanguageMapper {

    LanguageEntity toEntity(LanguageRequest request);

    LanguageResponse toResponse(LanguageEntity entity);
}
