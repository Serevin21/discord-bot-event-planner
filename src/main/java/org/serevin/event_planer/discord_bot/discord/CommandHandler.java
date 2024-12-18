package org.serevin.event_planer.discord_bot.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface CommandHandler {
    void handle(SlashCommandInteractionEvent event);
    void registerCommands(JDA jda);
}
