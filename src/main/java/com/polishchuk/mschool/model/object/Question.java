package com.polishchuk.mschool.model.object;

import com.polishchuk.mschool.enums.QuestionType;
import com.polishchuk.mschool.model.entity.task.AnswerEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Question {

	private Long id;

	@NotNull
	private Long task_id;

	@NotNull
	private String question;

	private String description;
	private QuestionType type;
	private Long parent_id;
	private List<Answer> answers;
}
