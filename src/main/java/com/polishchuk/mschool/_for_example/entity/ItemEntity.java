package com.polishchuk.mschool._for_example.entity;

import com.polishchuk.mschool.model.entity.base.BaseEntity;
import jakarta.persistence.*;
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
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_entity_seq")
	@SequenceGenerator(name = "item_entity_seq", sequenceName = "item_id_seq")
	private Long id;

	private String name;
	private String surname;
	private Integer age;
}
