package com.example.LibraryApplication.service;


import com.example.LibraryApplication.dto.CreateUserDTO;
import com.example.LibraryApplication.dto.UserDTO;


import java.util.List;


public interface UserService {
    UserDTO create(CreateUserDTO dto);
    void delete(Long id);
    UserDTO findById(Long id);
    List<UserDTO>  findAll();

}
