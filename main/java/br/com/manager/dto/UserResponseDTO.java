package br.com.manager.dto;

import br.com.manager.domain.model.Address;
import br.com.manager.domain.model.Users;

public record UserResponseDTO(String name, String email, String phone, Address address) {
    public UserResponseDTO(Users users) {
        this(users.getName(), users.getEmail(), users.getPhone(), users.getAddress());
    }
}