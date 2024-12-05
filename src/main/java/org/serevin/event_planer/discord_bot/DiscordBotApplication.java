package org.serevin.event_planer.discord_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscordBotApplication.class, args);
	}

} // в будущем сделать шедулер который проверяет лишние сервера в дб и удаляет
