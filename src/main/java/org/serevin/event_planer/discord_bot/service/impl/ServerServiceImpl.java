package org.serevin.event_planer.discord_bot.service.impl;

import lombok.AllArgsConstructor;
import org.serevin.event_planer.discord_bot.entity.Server;
import org.serevin.event_planer.discord_bot.repository.ServerRepository;
import org.serevin.event_planer.discord_bot.service.ServerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServerServiceImpl implements ServerService {

    private final ServerRepository serverRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Server> getServerById(Long serverId) {
        return serverRepository.findById(serverId);
    }

    @Override
    @Transactional
    public Server saveServer(Server server) {
        return serverRepository.save(server);
    }

    @Override
    @Transactional
    public void deleteServer(Long serverId) {
        serverRepository.deleteById(serverId);
    }

}
