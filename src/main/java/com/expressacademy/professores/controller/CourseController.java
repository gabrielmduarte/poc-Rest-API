package com.expressacademy.professores.controller;

import com.expressacademy.professores.request.CourseRequest;
import com.expressacademy.professores.response.CourseResponse;
import com.expressacademy.professores.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResponse> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public CourseResponse findOne(@PathVariable Long id) {
        log.info("M=listById, I=Buscando curso por id, id={}", id);
        return courseService.findOne(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody CourseRequest courseRequest) {
        log.info("M=create, I=Criando curso, teacherId={}, languageId={}, level={}",
                courseRequest.getTeacherId(),
                courseRequest.getLanguageId(),
                courseRequest.getLevel());
        courseService.create(courseRequest);
    }

    @PutMapping("/{id}")
    public void update(@Valid @PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        log.info("M=update, I=Atualizando curso, id={}", id);
        courseService.update(id, courseRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("M=delete, I=desativando curso, id={}", id);
        courseService.delete(id);
    }
}
