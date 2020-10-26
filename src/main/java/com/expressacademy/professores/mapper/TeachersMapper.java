package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.TeacherEntity;
import com.expressacademy.professores.request.TeachersRequest;
import com.expressacademy.professores.response.TeacherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = PaymentInfoMapper.class)
public interface TeachersMapper {

    TeacherEntity toEntity(TeachersRequest request);

    TeacherResponse toResponse(TeacherEntity entity);

}
