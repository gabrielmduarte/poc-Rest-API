package com.expressacademy.professores.request;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class EnrollmentRequest {

    @NotNull
    private Long studentId;

    @NotNull
    private Long courseId;

    @NotNull
    @Range(min = 0, max = 100)
    private BigDecimal discount;

}
