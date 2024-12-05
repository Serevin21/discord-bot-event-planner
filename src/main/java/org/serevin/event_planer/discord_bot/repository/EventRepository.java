package org.serevin.event_planer.discord_bot.repository;

import org.serevin.event_planer.discord_bot.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {



}
