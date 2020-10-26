package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.BankDataEntity;
import com.expressacademy.professores.request.BankDataRequest;
import com.expressacademy.professores.response.BankDataResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BankDataMapper {

    BankDataEntity toEntity(BankDataRequest request);

    BankDataResponse toResponse(BankDataEntity entity);

}
