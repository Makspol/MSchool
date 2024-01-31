package com.polishchuk.mschool.model.repository;

import com.polishchuk.mschool.model.entity.task.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
}
