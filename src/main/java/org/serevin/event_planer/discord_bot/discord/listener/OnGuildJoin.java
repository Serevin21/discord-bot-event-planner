package org.serevin.event_planer.discord_bot.discord.listener;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.serevin.event_planer.discord_bot.entity.Server;
import org.serevin.event_planer.discord_bot.mapper.ServerMapper;
import org.serevin.event_planer.discord_bot.service.ServerService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OnGuildJoin extends ListenerAdapter {

    private final ServerService serverService;
    private final JDA jda;
    private ServerMapper serverMapper;

    @PostConstruct
    public void init(){
        this.jda.addEventListener(this);
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Long serverId = event.getGuild().getIdLong();
        String serverName = event.getGuild().getName();

        if(!serverService.existsById(serverId)){
            Server server = serverMapper.map(serverId, serverName);
            serverService.save(server);
            System.out.println("Bot joined server: " + serverName + " (ID: " + serverId + ")");
        } else {
            System.out.println("Server already exists in database: " + serverName);
        }
    }
}
