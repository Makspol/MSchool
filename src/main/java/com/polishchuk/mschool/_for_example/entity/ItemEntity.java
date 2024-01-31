package com.polishchuk.mschool._for_example.entity;

import com.polishchuk.mschool.model.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "example_item")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ItemEntity extends BaseEntity {

	private String name;
	private String surname;
	private Integer age;
}
