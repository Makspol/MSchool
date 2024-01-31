package com.polishchuk.mschool.model.entity.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "task_item")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseTaskItemEntity extends BaseEntity {

	@Column(nullable = false)
	private Long p_item_id;

	@Column(nullable = false)
	private String title;
}
