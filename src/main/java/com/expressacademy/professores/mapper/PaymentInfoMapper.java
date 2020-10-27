package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.PaymentInfoEntity;
import com.expressacademy.professores.request.PaymentInfoRequest;
import com.expressacademy.professores.response.PaymentInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentInfoMapper {

    PaymentInfoEntity toEntity(PaymentInfoRequest request);

    @Mapping(target = "type", expression = "java(entity.getType().getName())")
    @Mapping(target = "bank", expression = "java(entity.getBank().getName())")
    PaymentInfoResponse toResponse(PaymentInfoEntity entity);

}
