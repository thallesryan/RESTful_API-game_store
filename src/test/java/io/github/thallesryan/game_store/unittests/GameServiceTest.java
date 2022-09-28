package io.github.thallesryan.game_store.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.github.thallesryan.game_store.domain.Game;
import io.github.thallesryan.game_store.domain.dto.game.GameRequestDTO;
import io.github.thallesryan.game_store.domain.enums.GameGenre;
import io.github.thallesryan.game_store.repository.GameRepository;
import io.github.thallesryan.game_store.service.GameServiceImpl;

class GameServiceTest {

	Game mockGame;
	
	GameRequestDTO mockGameRequest;
	
	
	@InjectMocks GameServiceImpl service;
	
	@Mock GameRepository repository;
	
	@BeforeEach
	void setUp() throws Exception {
		mockGame = new Game();
		MockitoAnnotations.openMocks(this);
		this.mockGame = mockGame(1);
		
	}
	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		
		Game entity = mockGame;
		when(repository.findById(1)).thenReturn(Optional.of(entity));
		Game result = service.findById(1);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		
		assertEquals("Name Test1", result.getName());
		assertEquals(1.0, result.getPrice());
		assertEquals(1, result.getQuantity());
		assertEquals(GameGenre.ACTION, GameGenre.ACTION);
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAvailableGames() {
		fail("Not yet implemented");
	}

	private Game mockGame(Integer n) {
		mockGame = new Game();
		
		mockGame.setId(n);
		mockGame.setName("Name Test" + n);
		mockGame.setPrice(n.doubleValue());
		mockGame.setQuantity(n);
		mockGame.setGenre(GameGenre.ACTION);
		
		return mockGame;
	}
	

	private GameRequestDTO mockGameRequestDTO(Integer n) {
		mockGameRequest = new GameRequestDTO();
		
		mockGameRequest.setId(n);
		mockGameRequest.setName("Name Test" + n);
		mockGameRequest.setPrice(n.doubleValue());
		mockGameRequest.setQuantity(n);
		mockGameRequest.setGenre(GameGenre.ACTION);
		
		return mockGameRequest;
	}
}
