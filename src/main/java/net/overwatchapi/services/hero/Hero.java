package net.overwatchapi.services.hero;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "hero")
public class Hero {

	@Id
	@Column (nullable = false, unique = true, updatable = false)
	private Long id;

	@Column (nullable = false)
	private String name;

	@Column (nullable = false)
	private String realName;

	@Column
	private int health;

	@Column
	private int armour;

	@Column
	private int shield;
}
