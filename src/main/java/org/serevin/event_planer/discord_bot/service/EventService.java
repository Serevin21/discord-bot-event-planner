package org.serevin.event_planer.discord_bot.service;

import org.serevin.event_planer.discord_bot.entity.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {


    Event createEventForServer(Long serverId,
                               String name,
                               String description,
                               LocalDateTime eventExecutionTime,
                               int intervalHours);

    List<Event> getAllEvents();
    Optional<Event> getEventById(UUID eventId);
    Event saveEvent(Event event);
    void deleteEvent(UUID eventId);

}
