package org.serevin.event_planer.discord_bot.config;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DiscordConfig {

    @Value("${discord.token}")
    private String botToken;

    @Bean
    public JDA jda() {
        try {
            JDA jda = JDABuilder.createDefault(botToken)
                    .build();
            jda.getPresence().setActivity(Activity.playing("-= Minecraft Galaxy =-"));
            return jda;
        } catch (Exception e) {
            log.error("unable to initialize JDA", e);
            throw new RuntimeException("No create JDA", e);
        }
    }
}
