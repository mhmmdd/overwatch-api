package net.overwatchapi.services.hero;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

	@Autowired
	private HeroRepository dao;

	@Autowired
	private HeroMapper mapper;

	public Optional<HeroDTO> findById(Long id) {
		Optional<Hero> optional = dao.findById(id);
		return optional.map(entity -> mapper.toDTO(entity));
	}

	public List<HeroDTO> findAll() {
		return dao.findAll().stream()
				.map(entity -> mapper.toDTO(entity))
				.collect(Collectors.toList());
	}

}
