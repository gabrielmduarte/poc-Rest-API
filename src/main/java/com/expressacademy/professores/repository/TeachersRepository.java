package com.expressacademy.professores.repository;

import com.expressacademy.professores.domain.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TeachersRepository extends JpaRepository<TeacherEntity, Long> {
    List<TeacherEntity> findByActiveTrue();

    Optional<TeacherEntity> findByIdAndActiveTrue(Long id);
}
