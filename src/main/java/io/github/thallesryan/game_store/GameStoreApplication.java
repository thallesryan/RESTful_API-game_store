package io.github.thallesryan.game_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GameStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStoreApplication.class, args);
//		System.out.println(new BCryptPasswordEncoder().encode("12345"));
	}


}
