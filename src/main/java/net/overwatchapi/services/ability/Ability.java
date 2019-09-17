package net.overwatchapi.services.ability;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.overwatchapi.services.hero.Hero;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "ability")
public class Ability {

	@Id
	@Column (nullable = false, unique = true, updatable = false)
	private Long id;

	@Column (nullable = false)
	private String name;

	@Column
	private String description;

	@Column
	private boolean isUltimate;

	@ManyToOne (fetch = FetchType.LAZY, optional = false)
	@JoinColumn (name = "hero_id", nullable = false)
	@OnDelete (action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Hero hero;
}