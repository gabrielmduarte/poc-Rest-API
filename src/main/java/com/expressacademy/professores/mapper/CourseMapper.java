package com.expressacademy.professores.mapper;

import com.expressacademy.professores.domain.CourseEntity;
import com.expressacademy.professores.request.CourseRequest;
import com.expressacademy.professores.response.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {TeachersMapper.class, LanguageMapper.class})

public interface CourseMapper {

    CourseEntity toEntity(CourseRequest request);

    @Mapping(target = "status", expression = "java(entity.getStatusDescription())")
    @Mapping(target = "level", expression = "java(entity.getLevelName())")
    @Mapping(target = "classDay", expression = "java(entity.getClassDayName())")
    @Mapping(target = "totalEnrollments", expression = "java(entity.getEnrollments().size())")
    @Mapping(target = "teacher", expression = "java(entity.getTeacherName())")
    @Mapping(target = "language", expression = "java(entity.getLanguageName())")
    CourseResponse toResponse(CourseEntity entity);


//outro modo de fazer o mapping
//    @Mapping(target = "totalEnrollments", qualifiedByName = "getTotalEnrollments")
//    CourseResponse toResponse(CourseEntity entity);
//    @Named("getTotalEnrollments")
//    default int getTotalEnrollments(CourseEntity entity) {
//        return entity.getEnrollments().size();
//    }
}
