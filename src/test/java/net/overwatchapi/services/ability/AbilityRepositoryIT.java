package net.overwatchapi.services.ability;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import net.overwatchapi.services.hero.Hero;
import net.overwatchapi.services.hero.HeroRepository;

@RunWith (SpringRunner.class)
@DataJpaTest
@TestPropertySource (locations = "classpath:application-test.properties")
public class AbilityRepositoryIT {

	@Autowired
	private AbilityRepository abilityRepository;

	@Autowired
	private HeroRepository heroRepository;

	@Test
	public void findAll() {
		Hero hero = save(1L);
		saveAbility(1L, hero);
		saveAbility(2L, hero);

		List<Ability> abilities = abilityRepository.findAll();
		Assert.assertNotNull(abilities);
		Assert.assertEquals(2, abilities.size());
		Assert.assertFalse(abilities.isEmpty());
	}

	@Test
	public void findById() {
		Long id = 1L;
		Hero hero = save(1L);
		saveAbility(id, hero);

		Optional<Ability> ability = abilityRepository.findById(id);
		Assert.assertTrue(ability.isPresent());
	}

	@Test
	public void findByHeroId() {
		Long id = 1L;
		Hero hero = save(id);
		saveAbility(5L, hero);
		saveAbility(6L, hero);

		Page<Ability> ability = abilityRepository.findByHeroId(id, PageRequest.of(2, 2));
		Assert.assertEquals(ability.getSize(), 2);
	}

	private Hero save(Long id) {
		Hero hero = Hero.builder()
				.id(id)
				.name(RandomStringUtils.randomAlphanumeric(5))
				.realName(RandomStringUtils.randomAlphanumeric(5))
				.build();
		return heroRepository.save(hero);
	}

	private void saveAbility(Long id, Hero hero) {
		Ability ability = Ability.builder()
				.id(id)
				.name(RandomStringUtils.randomAlphanumeric(3))
				.hero(hero)
				.build();
		abilityRepository.save(ability);
	}
}
