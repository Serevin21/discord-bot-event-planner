package org.serevin.event_planer.discord_bot.mapper;

import org.junit.jupiter.api.Test;
import org.serevin.event_planer.discord_bot.entity.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@SpringBootTest
//public class ServerMapperTest {
//
//    @Autowired
//    private ServerMapper serverMapper;
//
//    @Test
//    public void testMap() {
//        Long serverId = 123456L;
//        String serverName = "Test Server";
//
//        Server server = serverMapper.map(serverId, serverName);
//
//        assertNotNull(server);
//        assertEquals(serverId, server.getServerId());
//        assertEquals(serverName, server.getServerName());
//    }
//}
