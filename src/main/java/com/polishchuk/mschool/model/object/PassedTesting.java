package com.polishchuk.mschool.model.object;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PassedTesting {

	@NotNull
	private Task task;

	@NotNull
	private User user;

	@NotNull
	@Size(min = 0, max = 12)
	private Integer score;

	@NotNull
	private Date date_passwd;
}
