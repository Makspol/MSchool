package com.polishchuk.mschool.model.repository;

import com.polishchuk.mschool.model.entity.task.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
}
