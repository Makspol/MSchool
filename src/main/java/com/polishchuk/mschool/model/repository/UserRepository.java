package com.polishchuk.mschool.model.repository;

import com.polishchuk.mschool.model.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
