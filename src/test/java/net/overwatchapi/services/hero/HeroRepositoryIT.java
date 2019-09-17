package net.overwatchapi.services.hero;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import net.overwatchapi.services.ability.Ability;
import net.overwatchapi.services.ability.AbilityRepository;

@RunWith (SpringRunner.class)
@DataJpaTest
@TestPropertySource (locations = "classpath:application-test.properties")
public class HeroRepositoryIT {

	@Autowired
	private HeroRepository heroRepository;

	@Autowired
	private AbilityRepository abilityRepository;

	@Test
	public void findAll() {
		save(1L);
		save(2L);

		List<Hero> heroes = heroRepository.findAll();
		Assert.assertNotNull(heroes);
		Assert.assertEquals(2, heroes.size());
		Assert.assertFalse(heroes.isEmpty());
	}

	@Test
	public void findById() {
		Long id = 1L;
		save(id);
		Optional<Hero> hero = heroRepository.findById(id);
		Assert.assertTrue(hero.isPresent());
	}

	private void save(Long id) {
		Hero hero = Hero.builder()
				.id(id)
				.name(RandomStringUtils.randomAlphanumeric(5))
				.realName(RandomStringUtils.randomAlphanumeric(5))
				.build();

		Hero hero1 = heroRepository.save(hero);

		Ability ability = Ability.builder()
				.id(RandomUtils.nextLong(5, 100))
				.name(RandomStringUtils.randomAlphanumeric(3))
				.hero(hero1)
				.build();
		abilityRepository.save(ability);
	}
}

