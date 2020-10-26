package com.expressacademy.professores.service;

import com.expressacademy.professores.domain.StudentEntity;
import com.expressacademy.professores.exception.StudentNotFoundException;
import com.expressacademy.professores.mapper.StudentMapper;
import com.expressacademy.professores.repository.StudentRepository;
import com.expressacademy.professores.request.StudentRequest;
import com.expressacademy.professores.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentResponse> findAll() {
        return studentRepository.findByActiveTrue()
                .stream()
                .map(studentEntity -> studentMapper.toResponse(studentEntity))
                .collect(Collectors.toList());
    }

    public StudentResponse findOne(Long id) {
        StudentEntity studentEntity = getStudentEntity(id);

        return studentMapper.toResponse(studentEntity);
    }

    public void create(StudentRequest studentRequest) {
        StudentEntity studentEntity = studentMapper.toEntity(studentRequest);
        studentEntity.setActive(true);

        studentRepository.save(studentEntity);
    }

    public void update(Long id, StudentRequest studentRequest) {
        StudentEntity studentEntity = getStudentEntity(id);

        studentEntity.setEmail(studentRequest.getEmail());
        studentEntity.setName(studentRequest.getName());
        studentEntity.setPhone(studentRequest.getPhone());

        studentRepository.save(studentEntity);
    }

    public void delete(Long id) {
        StudentEntity studentEntity = getStudentEntity(id);
        studentEntity.setActive(false);

        studentRepository.save(studentEntity);
    }

    private StudentEntity getStudentEntity(Long id) {
        return studentRepository.findByIdAndActiveTrue(id)
                .orElseThrow(StudentNotFoundException::new);
    }
}
