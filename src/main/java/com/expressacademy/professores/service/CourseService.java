package com.expressacademy.professores.service;

import com.expressacademy.professores.domain.CourseEntity;
import com.expressacademy.professores.domain.LanguageEntity;
import com.expressacademy.professores.domain.TeacherEntity;
import com.expressacademy.professores.exception.CourseNotFoundException;
import com.expressacademy.professores.exception.LanguageNotFoundException;
import com.expressacademy.professores.exception.TeacherNotFoundException;
import com.expressacademy.professores.mapper.CourseMapper;
import com.expressacademy.professores.mapper.LanguageMapper;
import com.expressacademy.professores.repository.CourseRepository;
import com.expressacademy.professores.repository.LanguageRepository;
import com.expressacademy.professores.repository.TeachersRepository;
import com.expressacademy.professores.request.CourseRequest;
import com.expressacademy.professores.response.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeachersRepository teacherRepository;

    @Autowired
    private LanguageMapper languageMapper;

    @Autowired
    private LanguageRepository languageRepository;

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
        courseEntity.setActive(true);
        courseEntity.setAllMonthlyFeePaid(true);
//        courseEntity.setTotalEnrollments(courseEntity.getEnrollments().size());

        TeacherEntity teacherEntity = teacherRepository
                .findByIdAndActiveTrue(courseRequest.getTeacherId())
                .orElseThrow(TeacherNotFoundException::new);

        LanguageEntity languageEntity = languageRepository
                .findByIdAndActiveTrue(courseRequest.getLanguageId())
                .orElseThrow(LanguageNotFoundException::new);

        //        List<CourseEntity> courses = new ArrayList<>();
//        courses.add(courseEntity);
//        teacherEntity.setCourses(courses);

//        teacherEntity.setCourses(List.of(courseEntity));

//        List<CourseEntity> courseEntities = Arrays.asList(courseEntity);

        courseEntity.setLanguage(languageEntity);
        courseEntity.setTeacher(teacherEntity);

        teacherEntity.getCourses().add(courseEntity); //errado vai virar linha 72

        teacherRepository.save(teacherEntity);
        courseRepository.save(courseEntity);
    }

    public void update(Long id, CourseRequest courseRequest) {
        CourseEntity courseEntity = courseRepository.findByIdAndActiveTrue(id)
                                                    .orElseThrow(CourseNotFoundException::new);

        courseEntity.setClassDay(courseRequest.getClassDay());
        courseEntity.setClassesGiven(courseRequest.getClassesGiven());
        courseEntity.setFirstMonth(courseRequest.getFirstMonth());
        courseEntity.setHour(courseRequest.getHour());
        courseEntity.setLastMonth(courseRequest.getLastMonth());
        courseEntity.setLevel(courseRequest.getLevel());
        courseEntity.setMonthlyPrice(courseRequest.getMonthlyPrice());
        courseEntity.setNote(courseRequest.getNote());
        courseEntity.setNumberOfClasses(courseRequest.getNumberOfClasses());
//        courseEntity.setTotalEnrollments(courseEntity.getEnrollments().size());

        if (courseEntity.getTeacher().getId() != courseRequest.getTeacherId()) {
            courseEntity.getTeacher().getCourses().remove(courseEntity);

            TeacherEntity newTeacherEntity = teacherRepository
                    .findByIdAndActiveTrue(courseRequest.getTeacherId())
                    .orElseThrow(TeacherNotFoundException::new);

            newTeacherEntity.getCourses().add(courseEntity);

            teacherRepository.save(newTeacherEntity);

            courseEntity.setTeacher(newTeacherEntity);
        }

        if (courseEntity.getLanguage().getId() != courseRequest.getLanguageId()) {
            LanguageEntity languageEntity = languageRepository
                    .findByIdAndActiveTrue(courseRequest.getLanguageId())
                    .orElseThrow(LanguageNotFoundException::new);

            courseEntity.setLanguage(languageEntity);
        }

        courseRepository.save(courseEntity);
    }

    public void delete(Long id) {
        CourseEntity courseEntity = courseRepository.findByIdAndActiveTrue(id)
                                                    .orElseThrow(CourseNotFoundException::new);
        courseEntity.setActive(false);

        courseRepository.save(courseEntity);
    }
}
