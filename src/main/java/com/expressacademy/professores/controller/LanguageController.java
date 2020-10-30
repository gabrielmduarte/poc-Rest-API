package com.expressacademy.professores.controller;

import com.expressacademy.professores.request.LanguageRequest;
import com.expressacademy.professores.response.LanguageResponse;
import com.expressacademy.professores.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public List<LanguageResponse> findAll() {
        return languageService.findAll();
    }

    @GetMapping("/{id}")
    public LanguageResponse findById(@PathVariable Long id) {
        log.info("M=findById, I=Buscando idioma pelo Id, Id={}", id);
        return languageService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody LanguageRequest languageRequest) {
        log.info("M=create, I=Criando idioma, Nome={}", languageRequest.getName());
        languageService.create(languageRequest);
    }
}
