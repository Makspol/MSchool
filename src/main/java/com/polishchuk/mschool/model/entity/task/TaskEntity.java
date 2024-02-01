package com.polishchuk.mschool.model.entity.task;

import com.polishchuk.mschool.model.entity.base.BaseEntity;
import com.polishchuk.mschool.model.entity.base.BaseTaskItemEntity;
import com.polishchuk.mschool.model.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "task")
public class TaskEntity extends BaseTaskItemEntity {

//	@Column(nullable = false)
//	private Long user_id;

	@ManyToOne
	@JoinColumn(name = "p_item_id", nullable = false)
	private UserEntity user;

//	@Column(nullable = false)
//	private String title;

	private String description;

	@Column(nullable = false)
	private String subject;

	private byte class_number;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_created;

	@Column(nullable = false)
	private Boolean isPrivate;

	@OneToMany
	@JoinColumn(name = "task_id")
	private List<QuestionEntity> questions;

	@ManyToMany(mappedBy = "access_tasks")
	@OrderBy("surname, name")
	private List<UserEntity> users;

	@OneToMany(mappedBy = "task")
//	@OrderBy("user.surname, user.name")
//	@OrderBy("user")
	private Set<PassedTestingEntity> passed_testing_by_users;

	@PrePersist
	protected void onCreate() {
		date_created = new Date();
	}

	public static final Comparator<TaskEntity> DATE_COMPARATOR = new Comparator<TaskEntity>() {
		@Override
		public int compare(TaskEntity o1, TaskEntity o2) {
			return o1.date_created.compareTo(o2.date_created);
		}
	};

}
