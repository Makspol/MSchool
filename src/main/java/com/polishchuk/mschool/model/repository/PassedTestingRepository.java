package com.polishchuk.mschool.model.repository;

import com.polishchuk.mschool.model.entity.task.PassedTestingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassedTestingRepository extends JpaRepository<PassedTestingEntity, Long> {
}
