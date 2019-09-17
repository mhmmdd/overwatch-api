package net.overwatchapi.services.ability;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.overwatchapi.UrlConstants;

@RestController
@RequestMapping (UrlConstants.API_ABILITY)
public class AbilityController {
	
	@Autowired
	private AbilityService service;

	@GetMapping (value = UrlConstants.ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AbilityDTO> findById(@PathVariable ("id") Long id) {
		Optional<AbilityDTO> optionalAbilityDTO = service.findById(id);
		if(!optionalAbilityDTO.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().body(optionalAbilityDTO.get());
	}

	@GetMapping (produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AbilityDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
