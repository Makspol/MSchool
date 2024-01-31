package com.polishchuk.mschool.model.object;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Answer {

	private Long id;

	@NotNull
	private Long question_id;

	@NotNull
	private String answer;

	private Boolean isCorrect;
	private byte sort;
}
