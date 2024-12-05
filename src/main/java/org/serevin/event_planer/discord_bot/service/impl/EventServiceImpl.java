package org.serevin.event_planer.discord_bot.service.impl;

import lombok.AllArgsConstructor;
import org.serevin.event_planer.discord_bot.entity.Event;
import org.serevin.event_planer.discord_bot.repository.EventRepository;
import org.serevin.event_planer.discord_bot.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Event> getEventById(UUID eventId) {
        return eventRepository.findById(eventId);
    }

    @Override
    @Transactional
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public void deleteEvent(UUID eventId) {
        eventRepository.deleteById(eventId);
    }

}
