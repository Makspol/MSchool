package com.polishchuk.mschool.model.object;

import com.polishchuk.mschool.model.entity.task.PassedTestingEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Task {

	private Long id;

	@NotNull
	private User user;

	@NotNull
	private String title;

	private String description;
	private String subject;
	private byte class_number;
	private Date date_created;
	private Boolean isPrivate;
	private List<Question> questions;
	private List<User> users;
	private Set<PassedTestingEntity> passedTestingEntities;
}
