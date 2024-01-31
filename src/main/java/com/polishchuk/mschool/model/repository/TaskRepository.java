package com.polishchuk.mschool.model.repository;

import com.polishchuk.mschool.model.entity.task.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
