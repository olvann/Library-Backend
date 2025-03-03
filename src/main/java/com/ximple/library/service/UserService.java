package com.ximple.library.service;

import com.ximple.library.model.dto.UserDTO;
import com.ximple.library.model.entity.User;

import java.util.List;

public interface UserService {
 UserDTO getUserDTOById(Long userId);
 User getUserById(Long userId);
 List<UserDTO> getUserList();
}
