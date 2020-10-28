//package com.expressacademy.professores.service;
//
//import com.expressacademy.professores.domain.CourseEntity;
//import com.expressacademy.professores.domain.EnrollmentEntity;
//import com.expressacademy.professores.domain.StudentEntity;
//import com.expressacademy.professores.exception.CourseNotFoundException;
//import com.expressacademy.professores.exception.StudentNotFoundException;
//import com.expressacademy.professores.mapper.EnrollmentMapper;
//import com.expressacademy.professores.repository.CourseRepository;
//import com.expressacademy.professores.repository.EnrollmentRepository;
//import com.expressacademy.professores.repository.MonthlyPaymentRepository;
//import com.expressacademy.professores.repository.StudentRepository;
//import com.expressacademy.professores.request.EnrollmentRequest;
//import com.expressacademy.professores.response.EnrollmentResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class EnrollmentService {
//
//    @Autowired
//    private EnrollmentMapper enrollmentMapper;
//
//    @Autowired
//    private EnrollmentRepository enrollmentRepository;
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private MonthlyPaymentRepository monthlyPaymentRepository;
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    public void create(EnrollmentRequest enrollmentRequest) {
//        EnrollmentEntity enrollmentEntity = enrollmentMapper.toEntity(enrollmentRequest);
//
//        enrollmentEntity.setActive(true);
//
//
//        //pegando e setando estudante
//        StudentEntity studentEntity = studentRepository.findByIdAndActiveTrue(enrollmentRequest.getStudentId())
//                                                        .orElseThrow(StudentNotFoundException::new);
//
//        enrollmentEntity.setStudent(studentEntity);
//
//
//        //pegando e setando curso
//        CourseEntity courseEntity = courseRepository.findByIdAndActiveTrue(enrollmentRequest.getCourseId())
//                .orElseThrow(CourseNotFoundException::new);
//
//        enrollmentEntity.setCourse(courseEntity);
//
//
//        //pegando e setando porcentagem de desconto
//        BigDecimal percentualDiscount = new BigDecimal(0.01).multiply(enrollmentEntity.getDiscount());
//
//        enrollmentEntity.setDiscountPercentage(percentualDiscount);
//
//
//        //pegando e setando preço com desconto
//        BigDecimal totalMonthlyFee = enrollmentEntity.getCourse().getMonthlyPrice();
//        BigDecimal monthlyFee = totalMonthlyFee.subtract(totalMonthlyFee.multiply(percentualDiscount));
//
//        enrollmentEntity.setMonthlyFee(monthlyFee);
//
//        //atualizando lista de inscricoes na entidade curso e salvando
//        courseEntity.getEnrollments().add(enrollmentEntity);
////        courseEntity.setTotalEnrollments(courseEntity.getEnrollments().size());
//
//        courseRepository.save(courseEntity);
//
//        enrollmentRepository.save(enrollmentEntity);
//
//
////        LocalDate firstPaymentDate = courseEntity.getFirstPaymentDate();
////        int numberOfMonthlyPayments = courseEntity.getNumberOfMonthlyPayments();
//
//
////            service.createFromEnrollment(xxx yyyy );
//
//    }
//
//    public List<EnrollmentResponse> findAll() {
//        return enrollmentRepository.findByActiveTrue()
//                .stream()
//                .map(enrollmentMapper::toResponse)
//                .collect(Collectors.toList());
//    }
//}
//
//
////    public void create(EnrollmentRequest enrollmentRequest) {
////        EnrollmentEntity enrollmentEntity = enrollmentMapper.toEntity(enrollmentRequest);
////
////        StudentEntity studentEntity = getStudentEntity(enrollmentRequest);
////        CourseEntity courseEntity = getCourseEntity(enrollmentRequest);
////        BigDecimal monthlyFee = getMonthlyFee(enrollmentRequest, courseEntity);
////
////        enrollmentEntity.setStudent(studentEntity);
////        enrollmentEntity.setCourse(courseEntity);
////        enrollmentEntity.setActive(true);
////        enrollmentEntity.setMonthlyFee(monthlyFee);
////
////        enrollmentRepository.save(enrollmentEntity);
////
////        int numberOfMensalPayments = courseEntity.getNumberOfMensalPayments();
////        LocalDate firstPayment = courseEntity.getFirstPaymentDate();
////
////        //criando mensalidades
////        for (int i = 0; i < numberOfMensalPayments; i++) {
////            MonthlyPaymentEntity paymentEntity = new MonthlyPaymentEntity();
////            paymentEntity.setDescription("Blank");
////            paymentEntity.setEnrollment(enrollmentEntity);
////            paymentEntity.setPaid(false);
////            paymentEntity.setDueDate(firstPayment.plusMonths(i));
////            paymentEntity.setDiscount(new BigDecimal(0));
////            paymentEntity.setPrice(enrollmentEntity.getMonthlyFee().subtract(paymentEntity.getDiscount()));
////
////            boolean monthlyPaymentIsDue = findIfMonthlyPaymentIsDue(paymentEntity,
////                                                                    paymentEntity.getDueDate());
////            paymentEntity.setPastDue(monthlyPaymentIsDue);
////
////            System.out.println("descricao = " + paymentEntity.getDescription());
////            System.out.println("enrollment = " + paymentEntity.getEnrollment());
////            System.out.println("paid = " + paymentEntity.isPaid());
////            System.out.println("due date = " + paymentEntity.getDueDate());
////            System.out.println("discount = " + paymentEntity.getDiscount());
////            System.out.println("price = " + paymentEntity.getPrice());
////            System.out.println("id = " + paymentEntity.getId());
////
////            enrollmentEntity.getPayments().add(paymentEntity);
////
////            monthlyPaymentRepository.save(paymentEntity);
////        }
////
////    }
////
////    public EnrollmentResponse findById(Long id) {
////        EnrollmentEntity enrollmentEntity = enrollmentRepository.findByIdAndActiveTrue(id)
////                .orElseThrow(RuntimeException::new);
////
////        return enrollmentMapper.toResponse(enrollmentEntity);
////    }
////
////    private BigDecimal getMonthlyFee(EnrollmentRequest enrollmentRequest, CourseEntity courseEntity) {
////        BigDecimal discount = enrollmentRequest.getDiscount();
////        BigDecimal discountPercentage = discount.multiply(new BigDecimal("0.01"));
////        BigDecimal monthlyPrice = courseEntity.getMonthlyPrice();
////        return monthlyPrice.multiply(discountPercentage);
////    }
////
////    private CourseEntity getCourseEntity(EnrollmentRequest enrollmentRequest) {
////        return courseRepository.findByIdAndActiveTrue(enrollmentRequest.getCourseId())
////                .orElseThrow(CourseNotFoundException::new);
////    }
////
////    private StudentEntity getStudentEntity(EnrollmentRequest enrollmentRequest) {
////        return studentRepository
////                .findByIdAndActiveTrue(enrollmentRequest.getStudentId())
////                .orElseThrow(StudentNotFoundException::new);
////    }
////
////    private boolean findIfMonthlyPaymentIsDue(MonthlyPaymentEntity paymentEntity,
////                                              LocalDate dueDate) {
////        if (paymentEntity.isPaid()) {
////            return false;
////        } else {
////            LocalDate now = LocalDate.now();
////            int i = dueDate.compareTo(now);
////
////            if (i >= 0) {
////                return false;
////            } else {
////                return true;
////            }
////        }
////    }
////
////    public List<EnrollmentResponse> findAll() {
////        return enrollmentRepository.findAll().stream()
////                .map(enrollmentEntity -> enrollmentMapper.toResponse(enrollmentEntity))
////                .collect(Collectors.toList());
////    }
////}
