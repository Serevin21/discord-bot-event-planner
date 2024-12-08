package org.serevin.event_planer.discord_bot.discord.handler;

import lombok.AllArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.serevin.event_planer.discord_bot.discord.CommandHandler;
import org.serevin.event_planer.discord_bot.entity.Event;
import org.serevin.event_planer.discord_bot.service.EventService;
import org.serevin.event_planer.discord_bot.service.ServerService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Component
@AllArgsConstructor
public class AddEventHandler implements CommandHandler {

    private final EventService eventService;
    private final ServerService serverService;

    @Override
    public void handle(SlashCommandInteractionEvent event) {
        if (event.getName().equals("addevent")) {
            addEvent(event);
        }
    }

    @Override
    public void registerCommands(JDA jda) {
        jda.upsertCommand(
                Commands.slash("addevent", "Добавить новое событие на сервер")
                        .addOption(OptionType.STRING, "name", "Название события", true)
                        .addOption(OptionType.STRING, "description", "Описание события", true)
                        .addOption(OptionType.INTEGER, "interval", "Каждые сколько часов выполняется ивент", true)
        ).queue();
    }

    private void addEvent(SlashCommandInteractionEvent event) {

        // Извлекаем параметры команды
        String eventName = event.getOption("name").getAsString();
        String eventDescription = event.getOption("description").getAsString();
        int interval = event.getOption("interval").getAsInt();
        LocalDateTime eventExecutionTime = LocalDateTime.now().plusHours(24);

        String guildId = event.getGuild() != null ? event.getGuild().getId() : null;

        if (guildId == null) {
            event.reply("Эта команда доступна только на серверах!").setEphemeral(true).queue();
            return;
        }



        try {
            Event createdEvent = eventService.createEventForServer(Long.valueOf(guildId),
                    eventName,
                    eventDescription,
                    eventExecutionTime,
                    interval
            );
            event.reply("Событие успешно создано: " + createdEvent.getName()).queue();
        } catch (IllegalArgumentException e) {
            // Ошибка, если сервер не найден
            event.reply("Ошибка: " + e.getMessage()).setEphemeral(true).queue();
        } catch (Exception e) {
            // Общая ошибка
            event.reply("Ошибка при создании события: " + e.getMessage()).setEphemeral(true).queue();
        }
    }
}
