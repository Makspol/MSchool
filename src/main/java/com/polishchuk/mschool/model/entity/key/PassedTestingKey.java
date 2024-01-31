package com.polishchuk.mschool.model.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Embeddable
public class PassedTestingKey implements Serializable {

	@Column(nullable = false)
	private Long task_id;

	@Column(nullable = false)
	private Long user_id;
}
