package net.overwatchapi.services.ability;

import org.springframework.stereotype.Service;

import net.overwatchapi.utils.BaseMapper;

@Service
public class AbilityMapper implements BaseMapper<Ability, AbilityDTO> {

	@Override
	public AbilityDTO toDTO(Ability entity) {
		return AbilityDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.description(entity.getDescription())
				.isUltimate(entity.isUltimate())
				.build();
	}

	@Override
	public Ability toEntity(AbilityDTO dto) {
		return Ability.builder()
				.id(dto.getId())
				.name(dto.getName())
				.description(dto.getDescription())
				.isUltimate(dto.isUltimate())
				.build();
	}
}
