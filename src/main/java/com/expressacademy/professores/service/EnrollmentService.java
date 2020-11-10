package com.expressacademy.professores.service;

import com.expressacademy.professores.domain.CourseEntity;
import com.expressacademy.professores.domain.EnrollmentEntity;
import com.expressacademy.professores.domain.MonthlyPaymentEntity;
import com.expressacademy.professores.domain.StudentEntity;
import com.expressacademy.professores.mapper.EnrollmentMapper;
import com.expressacademy.professores.repository.EnrollmentRepository;
import com.expressacademy.professores.request.EnrollmentRequest;
import com.expressacademy.professores.response.EnrollmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MonthlyPaymentService paymentService;

    public void create(final EnrollmentRequest enrollmentRequest) {
        final EnrollmentEntity enrollmentEntity = enrollmentMapper.toEntity(enrollmentRequest);
        final StudentEntity studentEntity = studentService.getStudentEntity(enrollmentRequest.getStudentId());
        final CourseEntity courseEntity = courseService.getCourseEntity(enrollmentRequest.getCourseId());

        BigDecimal monthlyFee = calculateMonthlyFee(enrollmentEntity.getDiscount(), courseEntity);

        enrollmentEntity.setActive(true);
        enrollmentEntity.setStudent(studentEntity);
        enrollmentEntity.setCourse(courseEntity);
        enrollmentEntity.setMonthlyFee(monthlyFee);
        enrollmentEntity.setPayments(new ArrayList<>());

        courseService.addEnrollmentToList(enrollmentEntity, courseEntity);
        studentService.addEnrollmentToList(enrollmentEntity, studentEntity);
        List<MonthlyPaymentEntity> allMonthlyFees = paymentService.createAllMonthlyFees(monthlyFee, courseEntity);

        enrollmentEntity.setPayments(allMonthlyFees);
        EnrollmentEntity savedEnrollmentEntity = enrollmentRepository.save(enrollmentEntity);

    }

    public List<EnrollmentResponse> findAll() {
        return enrollmentRepository.findByActiveTrue()
                .stream()
                .map(enrollmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    private BigDecimal calculateMonthlyFee(final BigDecimal discount, final CourseEntity course) {
        final BigDecimal percentualDiscount = new BigDecimal(0.01).multiply(discount);
        final BigDecimal discountInMoney = course.getMonthlyPrice().multiply(percentualDiscount);

        return course.getMonthlyPrice().subtract(discountInMoney);
    }

    public EnrollmentResponse findById(Long id) {
        EnrollmentEntity enrollmentEntity = enrollmentRepository.findByIdAndActiveTrue(id)
                .orElseThrow(RuntimeException::new);

        return enrollmentMapper.toResponse(enrollmentEntity);
    }


    public void delete(Long id) {
        EnrollmentEntity enrollmentEntity = enrollmentRepository.findByIdAndActiveTrue(id)
                .orElseThrow(RuntimeException::new);

        enrollmentEntity.setActive(false);
        courseService.removeEnrollment(enrollmentEntity, enrollmentEntity.getCourse());
        //excluir pagamentos
        studentService.removeEnrollment(enrollmentEntity, enrollmentEntity.getStudent());

        enrollmentRepository.save(enrollmentEntity);
    }

    public EnrollmentEntity findByIdAndReturnEntity(Long id) {
        return enrollmentRepository.findByIdAndActiveTrue(id)
                .orElseThrow(RuntimeException::new);
    }
}
