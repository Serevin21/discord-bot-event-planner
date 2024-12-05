CREATE TABLE servers (
    server_id BIGINT NOT NULL PRIMARY KEY,
    server_name VARCHAR(255) NOT NULL
);

-- Создание таблицы events
CREATE TABLE events (
    event_id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    event_execution_time TIMESTAMP NOT NULL,
    event_interval_hours INT NOT NULL,
    server_id BIGINT NOT NULL,
    CONSTRAINT fk_server FOREIGN KEY (server_id) REFERENCES servers (server_id) ON DELETE CASCADE
);