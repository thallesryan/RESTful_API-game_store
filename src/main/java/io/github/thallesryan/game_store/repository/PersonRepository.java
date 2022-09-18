package io.github.thallesryan.game_store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.thallesryan.game_store.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	Optional<Person> findByEmail(String email);
}
