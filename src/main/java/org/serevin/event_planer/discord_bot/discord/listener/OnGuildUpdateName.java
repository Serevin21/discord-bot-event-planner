package org.serevin.event_planer.discord_bot.discord.listener;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.serevin.event_planer.discord_bot.entity.Server;
import org.serevin.event_planer.discord_bot.service.ServerService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OnGuildUpdateName extends ListenerAdapter {

    private final ServerService serverService;
    private final JDA jda;

    @PostConstruct
    public void init(){
        this.jda.addEventListener(this);
    }

    @EventListener
    public void onGuildUpdateName(GuildUpdateNameEvent event) {
        Long serverId = event.getGuild().getIdLong();

        String oldName = event.getOldName();
        String newName = event.getNewName();

        if (serverService.existsById(serverId)) {
            Server server = serverService.findById(serverId);

            if (!oldName.equals(newName)) {
                server.setServerName(newName);
                serverService.save(server);
                System.out.println("Server name updated from '" + oldName + "' to '" + newName + "' in database.");
            }
        } else {
            System.out.println("Server not found in database for update.");
        }
    }
}
