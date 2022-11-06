package com.example.finalproject.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Room {
    @NotNull
    private Long id;
    // sockets by user names
    private final Map<String, WebSocketSession> clients = new HashMap<>();

    public Room(Long id) {

        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public Map<String, WebSocketSession> getClients() {

        return clients;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        final Room room = (Room) o;

        return Objects.equals(getId(), room.getId()) &&
                Objects.equals(getClients(), room.getClients());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getClients());
    }
}
