package net.overwatchapi.services.ability;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AbilityService {

	@Autowired
	private AbilityRepository dao;

	@Autowired
	private AbilityMapper mapper;

	@Transactional
	public AbilityDTO save(AbilityDTO dto) {
		Ability entity = mapper.toEntity(dto);
		entity = dao.save(entity);
		return mapper.toDTO(entity);
	}

	@Transactional
	public AbilityDTO update(AbilityDTO dto) {
		Ability entity = dao.save(mapper.toEntity(dto));
		return mapper.toDTO(entity);
	}

	@Transactional
	public void delete(AbilityDTO dto) {
		Ability entity = mapper.toEntity(dto);
		dao.delete(entity);
	}

	public Optional<AbilityDTO> findById(Long id) {
		Optional<Ability> optional = dao.findById(id);
		return optional.map(entity -> mapper.toDTO(entity));
	}

	public List<AbilityDTO> findAll() {
		return dao.findAll().stream()
				.map(entity -> mapper.toDTO(entity))
				.collect(Collectors.toList());
	}

	public Page<AbilityDTO> findAllAbilitiesByHeroId(Long heroId, Pageable pageable) {
		return dao.findByHeroId(heroId, pageable).map(ability -> mapper.toDTO(ability));
	}

}