package com.expressacademy.professores.repository;

import com.expressacademy.professores.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    Optional<CourseEntity> findByIdAndActiveTrue(Long id);

    List<CourseEntity> findByActiveTrue();
}
