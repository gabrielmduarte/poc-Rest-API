package com.expressacademy.professores.service;

import com.expressacademy.professores.domain.CourseEntity;
import com.expressacademy.professores.domain.LanguageEntity;
import com.expressacademy.professores.domain.TeacherEntity;
import com.expressacademy.professores.exception.CourseNotFoundException;
import com.expressacademy.professores.mapper.CourseMapper;
import com.expressacademy.professores.repository.CourseRepository;
import com.expressacademy.professores.request.CourseRequest;
import com.expressacademy.professores.response.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private LanguageService languageService;

    public List<CourseResponse> findAll() {
        return courseRepository.findByActiveTrue()
                .stream()
                .map(entity -> courseMapper.toResponse(entity))
                .collect(Collectors.toList());
    }

    public CourseResponse findOne(Long id) {
        CourseEntity courseEntity = courseRepository.findByIdAndActiveTrue(id)
                                                    .orElseThrow(CourseNotFoundException::new);

        return courseMapper.toResponse(courseEntity);
    }

    public void create(CourseRequest courseRequest) {
        CourseEntity courseEntity = courseMapper.toEntity(courseRequest);
        TeacherEntity teacherEntity = teachersService
                                        .findByIdAndReturnEntity(courseRequest.getTeacherId());
        LanguageEntity languageEntity = languageService
                                        .findByIdAndReturnEntity(courseRequest.getLanguageId());

        LocalTime time = LocalTime.of(courseRequest.getHour(),courseRequest.getMinutes());

        courseEntity.setLanguage(languageEntity);
        courseEntity.setTeacher(teacherEntity);
        courseEntity.setEnrollments(new ArrayList<>());
        courseEntity.setTime(time);
        courseEntity.setActive(true);

        teachersService.addCourseInTeacherList(courseEntity, teacherEntity);

        courseRepository.save(courseEntity);
    }

    public void update(Long id, CourseRequest courseRequest) {
        CourseEntity courseEntity = courseRepository.findByIdAndActiveTrue(id)
                                                    .orElseThrow(CourseNotFoundException::new);

        updateAllAtributes(courseRequest, courseEntity);

        courseRepository.save(courseEntity);
    }

    private void updateAllAtributes(CourseRequest courseRequest, CourseEntity courseEntity) {
        LocalTime time = LocalTime.of(courseRequest.getHour(), courseRequest.getMinutes());

        courseEntity.setTime(time);
        courseEntity.setNumberOfClasses(courseRequest.getNumberOfClasses());
        courseEntity.setStatus(courseRequest.getStatus());
        courseEntity.setLevel(courseRequest.getLevel());
        courseEntity.setClassDay(courseRequest.getClassDay());
        courseEntity.setClassesGiven(courseRequest.getClassesGiven());
        courseEntity.setNumberOfClasses(courseRequest.getNumberOfClasses());
        courseEntity.setNote(courseRequest.getNote());
        courseEntity.setMonthlyPrice(courseRequest.getMonthlyPrice());

        if(courseEntity.getTeacher().getId() != courseRequest.getTeacherId()) {
            TeacherEntity newTeacher = teachersService
                    .findByIdAndReturnEntity(courseRequest.getTeacherId());
            TeacherEntity oldTeacher = courseEntity.getTeacher();

            teachersService.addCourseInTeacherList(courseEntity, newTeacher);
            teachersService.removeCourseOfTeacherList(courseEntity, oldTeacher);

            courseEntity.setTeacher(newTeacher);
        }

        if(courseEntity.getLanguage().getId() != courseRequest.getLanguageId()) {
            LanguageEntity languageEntity = languageService
                                            .findByIdAndReturnEntity(courseRequest.getLanguageId());

            courseEntity.setLanguage(languageEntity);
        }
    }

    public void delete(Long id) {
        CourseEntity courseEntity = courseRepository.findByIdAndActiveTrue(id)
                                                    .orElseThrow(CourseNotFoundException::new);
        courseEntity.setActive(false);

        courseRepository.save(courseEntity);
    }
}
