package br.com.manager.controller;

import br.com.manager.dto.CreateUserDTO;
import br.com.manager.dto.UserListDTO;
import br.com.manager.dto.UserResponseDTO;
import br.com.manager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid CreateUserDTO createUserDTO) {
        var user = userService.create(createUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<Page<UserListDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = userService.list(pageable);
        return ResponseEntity.ok(page);
    }
}
