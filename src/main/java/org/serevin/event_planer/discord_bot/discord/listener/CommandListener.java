package org.serevin.event_planer.discord_bot.discord.listener;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.serevin.event_planer.discord_bot.discord.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CommandListener extends ListenerAdapter {

    private final List<CommandHandler> commandHandlers;
    private final JDA jda;

    @PostConstruct
    public void init() {
        jda.addEventListener(this);
        commandHandlers.forEach(commandHandler -> {
            commandHandler.registerCommands(jda);
        });
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        commandHandlers.forEach(commandHandler -> {
            commandHandler.handle(event);
        });
    }
}
