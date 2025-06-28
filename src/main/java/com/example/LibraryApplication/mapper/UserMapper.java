package com.example.LibraryApplication.mapper;
import com.example.LibraryApplication.dto.CreateUserDTO;
import com.example.LibraryApplication.model.User;
import com.example.LibraryApplication.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO dto);
    User toEntity(CreateUserDTO dto);
    List<UserDTO> toDTOs(List<User> l);
}
