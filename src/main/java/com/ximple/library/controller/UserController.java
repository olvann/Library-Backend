package com.ximple.library.controller;

import com.ximple.library.model.dto.ResponseDTO;
import com.ximple.library.model.dto.UserDTO;
import com.ximple.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ximple.library.enums.ResponseStatus.SUCCESS;
import static com.ximple.library.utils.ResponseUtils.buildOkResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<UserDTO>>> getAllUsers() {
        return buildOkResponse("Ok", userService.getUserList());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<ResponseDTO<UserDTO>> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(new ResponseDTO<>(SUCCESS,null,
                null, userService.getUserDTOById(userId)));
    }
}
