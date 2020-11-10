package com.expressacademy.professores.service;

import com.expressacademy.professores.domain.CourseEntity;
import com.expressacademy.professores.domain.EnrollmentEntity;
import com.expressacademy.professores.domain.MonthlyPaymentEntity;
import com.expressacademy.professores.repository.MonthlyPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonthlyPaymentService {

    @Autowired
    private MonthlyPaymentRepository paymentRepository;

    @Autowired EnrollmentService enrollmentService;

    public List<MonthlyPaymentEntity> createAllMonthlyFees(BigDecimal price,
                                                           CourseEntity courseEntity) {

        LocalDate dueDate = courseEntity.getFirstPaymentDate();
        int numberOfMonthlyFees = courseEntity.getNumberOfMonthlyPayments();
        ArrayList<MonthlyPaymentEntity> payments = new ArrayList<>();

        for (int i = 0; i < numberOfMonthlyFees; i++) {
            dueDate = dueDate.plusMonths(i);

            MonthlyPaymentEntity paymentEntity = new MonthlyPaymentEntity();
            paymentEntity.setPrice(price);
            paymentEntity.setPaid(false);
            paymentEntity.setDueDate(dueDate);

            payments.add(paymentEntity);
        }

        return payments;
    }

}
