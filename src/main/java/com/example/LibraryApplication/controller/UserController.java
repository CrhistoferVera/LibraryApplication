package com.example.LibraryApplication.controller;

import com.example.LibraryApplication.dto.CreateUserDTO;
import com.example.LibraryApplication.dto.UserDTO;
import com.example.LibraryApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO dto){
        UserDTO user = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
}
