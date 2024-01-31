package com.polishchuk.mschool.model.object;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {

	private Long id;

	@Size(min = 5)
	@NotNull
	private String userName;

	@NotNull
	private String name;

	@NotNull
	private String surname;

	@Size(min = 8)
	@NotNull
	private String password;

	private List<Task> tasks;
	private List<Task> access_tasks;
	private Set<PassedTesting> passed_testing;
}
