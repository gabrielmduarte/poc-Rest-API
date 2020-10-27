package com.expressacademy.professores.response;

import com.expressacademy.professores.domain.EnrollmentEntity;
import com.expressacademy.professores.domain.Level;
import com.expressacademy.professores.domain.Month;
import com.expressacademy.professores.domain.Weekday;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CourseResponse {

    private Long id;

    private TeacherResponse teacher;

    private LanguageResponse language;

    private Level level;

    private int numberOfClasses;

    private int classesGiven;

    private Month firstMonth;

    private Month lastMonth;

    private Weekday classDay;

    private String hour;

    private String note;

    private BigDecimal monthlyPrice;

    private boolean AllMonthlyFeePaid;

    private List<EnrollmentEntity> enrollments;

    private int totalEnrollments;

}
