package com.ximple.library.service.impl;

import com.ximple.library.exception.NotFoundException;
import com.ximple.library.mapper.UserMapper;
import com.ximple.library.model.dto.UserDTO;
import com.ximple.library.model.entity.User;
import com.ximple.library.repository.UserRepository;
import com.ximple.library.service.UserService;
import com.ximple.library.utils.MessageBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO getUserDTOById(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(MessageBuilder.userNotFound(userId)));
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(MessageBuilder.userNotFound(userId)));
    }

    @Override
    public List<UserDTO> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }
}
