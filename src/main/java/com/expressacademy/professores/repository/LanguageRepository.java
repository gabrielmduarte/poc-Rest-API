package com.expressacademy.professores.repository;

import com.expressacademy.professores.domain.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {

    Optional<LanguageEntity> findByIdAndActiveTrue(Long id);
}
