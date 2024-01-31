package com.polishchuk.mschool.model.entity.user;

import com.polishchuk.mschool.model.entity.base.BaseEntity;
import com.polishchuk.mschool.model.entity.task.PassedTestingEntity;
import com.polishchuk.mschool.model.entity.task.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ntable", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("user")
public class UserEntity extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String userName;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy = "user")
//	@JoinColumn(name = "user_id")
	@OrderBy("date_created desc")
	private List<TaskEntity> tasks;

	@ManyToMany
	@JoinTable(name = "acces_tasks", joinColumns = @JoinColumn(name = "task_fk"))
	@OrderBy("date_created desc ")
	private List<TaskEntity> access_tasks;

	@OneToMany(mappedBy = "user")
	@OrderBy("date_passed desc")
	private Set<PassedTestingEntity> passed_testing;
}
