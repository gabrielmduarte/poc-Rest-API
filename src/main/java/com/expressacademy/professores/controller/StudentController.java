package com.expressacademy.professores.controller;

import com.expressacademy.professores.request.StudentRequest;
import com.expressacademy.professores.response.StudentResponse;
import com.expressacademy.professores.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse findOne(@PathVariable Long id) {
        log.info("M=findOne, I=buscando um aluno, Id={}", id);
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody StudentRequest studentRequest) {
        log.info("M=create, I=Criando aluno, Nome={}", studentRequest.getName());
        studentService.create(studentRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody StudentRequest studentRequest) {
        log.info("M=update, I=Atualizando aluno, Id={}", id);
        studentService.update(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("M=delete, I=Desativando aluno, Id={}", id);
        studentService.delete(id);
    }

}
