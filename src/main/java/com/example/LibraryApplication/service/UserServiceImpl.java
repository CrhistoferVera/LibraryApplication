package com.example.LibraryApplication.service;


import com.example.LibraryApplication.dto.CreateUserDTO;
import com.example.LibraryApplication.dto.UserDTO;
import com.example.LibraryApplication.exception.ResourceNotFoundException;
import com.example.LibraryApplication.mapper.UserMapper;
import com.example.LibraryApplication.model.User;
import com.example.LibraryApplication.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDTO create(CreateUserDTO dto) {
        User user = userMapper.toEntity(dto);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Id: "+ id));
        userRepository.delete(user);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Id: "+ id));
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO unlockUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Id: "+ id));
        user.setBlockedUser(false);
        return userMapper.toDTO(userRepository.save(user));
    }
}
