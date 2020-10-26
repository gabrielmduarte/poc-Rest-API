package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.PaymentInfoEntity;
import com.expressacademy.professores.request.PaymentInfoRequest;
import com.expressacademy.professores.response.PaymentInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {AddressMapper.class, BankDataMapper.class})
public interface PaymentInfoMapper {

    PaymentInfoEntity toEntity(PaymentInfoRequest request);

    PaymentInfoResponse toResponse(PaymentInfoEntity entity);

}
