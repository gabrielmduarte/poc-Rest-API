package com.expressacademy.professores.request;

import com.expressacademy.professores.domain.Level;
import com.expressacademy.professores.domain.Status;
import com.expressacademy.professores.domain.Weekday;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CourseRequest {

    @NotNull
    private Level level;

    @NotNull
    private Status status;

    @NotNull
    private int numberOfClasses;

    @NotNull
    private int classesGiven;

    @NotNull
    private Weekday classDay;

    @NotNull
    @Range(min = 0, max = 24)
    private int hour;

    @NotNull
    @Range(min = 00, max = 60)
    private int minutes;

    private String note;

    @NotNull
    private BigDecimal monthlyPrice;

    @NotNull
    private LocalDate firstPaymentDate;

    @NotNull
    private Long teacherId;

    @NotNull
    private Long languageId;

}
