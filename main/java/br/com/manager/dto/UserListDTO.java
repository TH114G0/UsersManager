package br.com.manager.dto;

import br.com.manager.domain.model.Users;

public record UserListDTO(String name, String email, String phone) {
    public UserListDTO(Users users) {
        this(users.getName(), users.getEmail(), users.getPhone());
    }
}
