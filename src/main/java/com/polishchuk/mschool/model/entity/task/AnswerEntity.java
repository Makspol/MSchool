package com.polishchuk.mschool.model.entity.task;

import com.polishchuk.mschool.model.entity.base.BaseEntity;
import com.polishchuk.mschool.model.entity.base.BaseTaskItemEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "answer")
public class AnswerEntity extends BaseTaskItemEntity {

//	@Column(nullable = false)
//	private Long question_id;
//
//	@Column(nullable = false)
//	private String answer;

	@Column(nullable = false)
	private Boolean isCorrect;

	@Column(nullable = false)
	private byte sort;
}
