package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.EnrollmentEntity;
import com.expressacademy.professores.request.EnrollmentRequest;
import com.expressacademy.professores.response.EnrollmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {CourseMapper.class, TeachersMapper.class})
public interface EnrollmentMapper {

    EnrollmentEntity toEntity(EnrollmentRequest enrollmentRequest);

    @Mapping(target = "studentName", expression = "java(entity.getStudentName())")
    @Mapping(target = "courseInfos", expression = "java(entity.getCourseInfos())")
    EnrollmentResponse toResponse(EnrollmentEntity entity);
}
