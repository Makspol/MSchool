package com.polishchuk.mschool.model.entity.task;

import com.polishchuk.mschool.model.entity.key.PassedTestingKey;
import com.polishchuk.mschool.model.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "passed_testing")
public class PassedTestingEntity {

	@EmbeddedId
	private PassedTestingKey id;

	@ManyToOne
	@MapsId("task_id")
	@JoinColumn(name = "task_id")
	private TaskEntity task;

	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(nullable = false)
	private Integer score;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_passed;
}
