package com.expressacademy.professores.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalTime;

@Data
public class CourseResponse {

    private Long id;

    private String status;

    private String level;

    private String classDay;

    private int totalEnrollments;

    private LocalTime time;

    private int classesGiven;

    private int numberOfClasses;

    private String note;

    private BigDecimal monthlyPrice;

    private String teacher;

    private String language;

}
