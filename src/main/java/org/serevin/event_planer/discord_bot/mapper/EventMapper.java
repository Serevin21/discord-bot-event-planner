package org.serevin.event_planer.discord_bot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.serevin.event_planer.discord_bot.entity.Event;
import org.serevin.event_planer.discord_bot.entity.Server;

import java.time.LocalDateTime;

//@Mapper(componentModel = "spring")
//public interface EventMapper {
//
//    @Mapping(target = "eventId", ignore = true)
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "description", source = "description")
//    @Mapping(target = "server", source = "server")
//    @Mapping(target = "eventIntervalHours", source = "eventIntervalHours")
//    @Mapping(target = "eventExecutionTime", source = "")
//    Event map(String name,
//              String description,
//              int eventIntervalHours,
//              LocalDateTime eventExecutionTime,
//              Server server);
//}
