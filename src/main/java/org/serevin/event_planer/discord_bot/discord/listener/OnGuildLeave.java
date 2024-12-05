package org.serevin.event_planer.discord_bot.discord.listener;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.serevin.event_planer.discord_bot.service.ServerService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OnGuildLeave extends ListenerAdapter {

    private final ServerService serverService;
    private final JDA jda;

    @PostConstruct
    public void init(){
        this.jda.addEventListener(this);
    }

    @Override
    public void onGuildLeave(GuildLeaveEvent event) {
        Long serverId = event.getGuild().getIdLong();

        if (serverService.existsById(serverId)) {
            serverService.deleteById(serverId);
            System.out.println("Bot removed from server and data deleted: " + serverId);
        } else {
            System.out.println("Server not found in database: " + serverId);
        }
    }
}
