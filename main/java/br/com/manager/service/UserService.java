package br.com.manager.service;

import br.com.manager.domain.model.Users;
import br.com.manager.dto.CreateUserDTO;
import br.com.manager.dto.UserListDTO;
import br.com.manager.dto.UserResponseDTO;
import br.com.manager.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDTO create(CreateUserDTO createUserDTO) {
        var user = userRepository.save(new Users(createUserDTO));
        return new UserResponseDTO(user);
    }

    @Transactional
    public Page<UserListDTO> list(Pageable pageable) {
         return userRepository.findAllByActiveTrue(pageable).map(UserListDTO::new);
    }
}