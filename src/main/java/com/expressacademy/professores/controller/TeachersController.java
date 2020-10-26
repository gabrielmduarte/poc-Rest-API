package com.expressacademy.professores.controller;

import com.expressacademy.professores.request.TeachersRequest;
import com.expressacademy.professores.response.TeacherResponse;
import com.expressacademy.professores.service.TeachersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @GetMapping
    public List<TeacherResponse> findAll() {
        return teachersService.findAll();
    }

    @GetMapping("/{id}")
    public TeacherResponse findById(@PathVariable Long id) {
        log.info("M=findById, I=Buscando teacher, Id={}",id);
        return teachersService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody TeachersRequest request) {
        log.info("M=create, I=Criando teacher, Nome={}",request.getName());
        teachersService.create(request);
    }

    @PutMapping("/{id}")
    public void update(@Valid @PathVariable Long id,
                       @RequestBody TeachersRequest request) {
        log.info("M=update, I=Atualizando teacher, Id={}",id);
        teachersService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("M=delete, I=Deletando teacher, Id={}",id);
        teachersService.delete(id);
    }
}
