//package com.expressacademy.professores.controller;
//
//import com.expressacademy.professores.request.EnrollmentRequest;
//import com.expressacademy.professores.response.EnrollmentResponse;
//import com.expressacademy.professores.service.EnrollmentService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/enrollments")
//public class EnrollmentController {
//
//    @Autowired
//    private EnrollmentService enrollmentService;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void create(@Valid @RequestBody EnrollmentRequest enrollmentRequest) {
//        log.info("M=, I=, StudentId=, CourseId=",
//                enrollmentRequest.getStudentId(),
//                enrollmentRequest.getCourseId());
//        enrollmentService.create(enrollmentRequest);
//    }
//
////    @GetMapping("/id")
////    public EnrollmentResponse findById(@PathVariable Long id) {
////        return enrollmentService.findById(id);
////    }
////
//    @GetMapping
//    public List<EnrollmentResponse> findAll() {
//        return enrollmentService.findAll();
//    }
//}
//
