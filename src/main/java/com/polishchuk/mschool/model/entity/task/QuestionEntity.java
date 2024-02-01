package com.polishchuk.mschool.model.entity.task;

import com.polishchuk.mschool.enums.QuestionType;
import com.polishchuk.mschool.model.entity.base.BaseEntity;
import com.polishchuk.mschool.model.entity.base.BaseTaskItemEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "question")
public class QuestionEntity extends BaseTaskItemEntity {

//	@Column(nullable = false)
//	private Long task_id;
//
//	@Column(nullable = false)
//	private String question;

	private String description;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private QuestionType type;

	private Long parent_id;

	@OneToMany
	@JoinColumn(name = "question_id")
	@OrderBy("sort ASC")
	private List<AnswerEntity> answers;
}
