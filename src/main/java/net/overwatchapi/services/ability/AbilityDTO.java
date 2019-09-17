package net.overwatchapi.services.ability;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (callSuper = false, of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude (content = JsonInclude.Include.NON_NULL)
public class AbilityDTO {

	private static final long serialVersionUID = -9138403886733217423L;

	private Long id;
	private String name;
	private String description;
	private boolean isUltimate;

}
