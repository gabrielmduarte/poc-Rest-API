package com.expressacademy.professores.request;

import com.expressacademy.professores.domain.Level;
import com.expressacademy.professores.domain.Month;
import com.expressacademy.professores.domain.Weekday;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

//como validar enum?

@Data
public class CourseRequest {

    @NotNull
    private Long languageId;

    @NotNull
    private Level level;

    @NotNull
    private int numberOfClasses;

    @NotNull
    private int classesGiven;

    @NotNull
    private Month firstMonth;

    @NotNull
    private Month lastMonth;

    @NotNull
    private Weekday classDay;

    @NotBlank
    private String hour;

    private String note;

    @NotNull
    private BigDecimal monthlyPrice;

    @NotNull
    private Long teacherId;

    @NotNull
    private LocalDate firstPaymentDate;

}
