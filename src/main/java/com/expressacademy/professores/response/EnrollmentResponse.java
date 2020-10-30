package com.expressacademy.professores.response;

import com.expressacademy.professores.domain.MonthlyPaymentEntity;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class EnrollmentResponse {

    private Long id;

    private BigDecimal discount;

    private BigDecimal monthlyFee;

    private List<MonthlyPaymentEntity> payments;

    private String studentName;

    private String courseInfos;

}
