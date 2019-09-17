package net.overwatchapi.services.hero;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.overwatchapi.services.ability.AbilityDTO;

@Data
@EqualsAndHashCode (callSuper = false, of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude (content = JsonInclude.Include.NON_NULL)
public class HeroDTO {

	private static final long serialVersionUID = -9138403886733217423L;

	private Long id;
	private String name;
	private String realName;
	private int health;
	private int armour;
	private int shield;

	private AbilityDTO abilityDTO;
}
