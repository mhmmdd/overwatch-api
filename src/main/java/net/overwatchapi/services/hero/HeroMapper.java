package net.overwatchapi.services.hero;

import org.springframework.stereotype.Service;

import net.overwatchapi.utils.BaseMapper;

@Service
public class HeroMapper implements BaseMapper<Hero, HeroDTO> {

	@Override
	public HeroDTO toDTO(Hero entity) {
		return HeroDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.realName(entity.getRealName())
				.health(entity.getHealth())
				.armour(entity.getArmour())
				.shield(entity.getShield())
				.build();
	}

	@Override
	public Hero toEntity(HeroDTO dto) {
		return Hero.builder()
				.id(dto.getId())
				.name(dto.getName())
				.realName(dto.getRealName())
				.health(dto.getHealth())
				.armour(dto.getArmour())
				.shield(dto.getShield())
				.build();
	}
}
