package org.serevin.event_planer.discord_bot.repository;

import org.serevin.event_planer.discord_bot.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {



}
