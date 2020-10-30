package com.expressacademy.professores.controller;

import com.expressacademy.professores.request.EnrollmentRequest;
import com.expressacademy.professores.response.EnrollmentResponse;
import com.expressacademy.professores.service.EnrollmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/{id}")
    public EnrollmentResponse findById(@PathVariable Long id) {
        return enrollmentService.findById(id);
    }

    @GetMapping
    public List<EnrollmentResponse> findAll() {
        return enrollmentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody EnrollmentRequest enrollmentRequest) {
        log.info("M=, I=, StudentId=, CourseId=",
                enrollmentRequest.getStudentId(),
                enrollmentRequest.getCourseId());
        enrollmentService.create(enrollmentRequest);
    }

    //cancela tudo relacionado a esta matrícula
    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable Long id) {
        enrollmentService.delete(id);
    }

    //cancela a matrícula mas mantém as parcelas pagas em aberto
    //fazer depois que o crud e service do payment estiver pronto
    @DeleteMapping("/cancel/{id}")
    public void cancel(@Valid @PathVariable Long id) {
        //enrollmentService.cancel(id);
    }


}

