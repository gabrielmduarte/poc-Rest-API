package com.expressacademy.professores.response;

import com.expressacademy.professores.domain.Level;
import lombok.Data;

@Data
public class CourseIdLevelLanguageAndEnrollmentsResponse {

    private Long id;

    private Level level;

    private LanguageResponse language;

    private int totalEnrollments;

}
