package com.expressacademy.professores.repository;

import com.expressacademy.professores.domain.MonthlyPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyPaymentRepository extends JpaRepository<MonthlyPaymentEntity, Long> {
}
