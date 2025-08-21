package com.gameslist.dslist.entities.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
