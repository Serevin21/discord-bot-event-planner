package org.serevin.event_planer.discord_bot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.serevin.event_planer.discord_bot.entity.Server;

@Mapper(componentModel = "spring")
public interface ServerMapper {

    @Mapping(target = "serverId", source = "serverId")
    @Mapping(target = "serverName", source = "serverName")
    Server map(Long serverId, String serverName);

}
