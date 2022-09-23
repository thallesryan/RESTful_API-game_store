package io.github.thallesryan.game_store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.thallesryan.game_store.domain.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

	Optional<UserModel> findByEmail(String email);
}
