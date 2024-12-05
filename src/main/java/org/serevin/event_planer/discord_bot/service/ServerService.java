package org.serevin.event_planer.discord_bot.service;

import org.serevin.event_planer.discord_bot.entity.Server;

import java.util.List;
import java.util.Optional;

public interface ServerService {

    List<Server> getAllServers();
    Optional<Server> getServerById(Long serverId);
    Server saveServer(Server server);
    void deleteServer(Long serverId);
}
