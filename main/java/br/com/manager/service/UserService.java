package br.com.manager.service;

import br.com.manager.domain.model.Users;
import br.com.manager.dto.CreateUserDTO;
import br.com.manager.dto.UserResponseDTO;
import br.com.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO create(CreateUserDTO createUserDTO) {
        var user = userRepository.save(new Users(createUserDTO));
        return new UserResponseDTO(user);
    }
}