package net.overwatchapi.services.hero;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.overwatchapi.UrlConstants;
import net.overwatchapi.services.ability.AbilityDTO;
import net.overwatchapi.services.ability.AbilityService;

@RestController
@RequestMapping (UrlConstants.API_HERO)
public class HeroController {

	@Autowired
	private HeroService service;

	@Autowired
	private AbilityService abilityService;

	@GetMapping (value = UrlConstants.ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<HeroDTO> findById(@PathVariable ("id") Long id) {
		Optional<HeroDTO> optionalHeroDTO = service.findById(id);
		if(!optionalHeroDTO.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().body(optionalHeroDTO.get());
	}

	@GetMapping (produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<HeroDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping (value = "/{heroId}" + UrlConstants.ABILITY)
	public Page<AbilityDTO> getAllAbilitiesByPostId(@PathVariable (value = "heroId") Long heroId, Pageable pageable) {
		return abilityService.findAllAbilitiesByHeroId(heroId, pageable);
	}
}
