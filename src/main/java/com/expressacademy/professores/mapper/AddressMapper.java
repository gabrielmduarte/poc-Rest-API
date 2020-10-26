package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.AddressEntity;
import com.expressacademy.professores.request.AddressRequest;
import com.expressacademy.professores.response.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressEntity toEntity(AddressRequest request);

    AddressResponse toResponse(AddressEntity entity);

}
