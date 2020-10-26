package com.expressacademy.professores.repository;

import com.expressacademy.professores.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findByActiveTrue();

    Optional<StudentEntity> findByIdAndActiveTrue(Long id);
}
