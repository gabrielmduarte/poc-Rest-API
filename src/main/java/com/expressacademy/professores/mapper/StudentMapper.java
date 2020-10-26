package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.StudentEntity;
import com.expressacademy.professores.request.StudentRequest;
import com.expressacademy.professores.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentEntity toEntity(StudentRequest request);

    StudentResponse toResponse(StudentEntity studentEntity);
}
