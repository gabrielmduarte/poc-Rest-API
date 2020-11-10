package com.expressacademy.professores.request;

import java.time.LocalDate;

public class MonthlyPaymentRequest {

    private String description;

    private boolean paid;

    private Long enrollmentId;

    private LocalDate dueDate;
}
